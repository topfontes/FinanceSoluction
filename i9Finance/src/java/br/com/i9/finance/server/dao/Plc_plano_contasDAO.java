package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Plc_plano_contasDAO extends ObjectDAOCluster {

    public Plc_plano_contasDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.plc_plano_contas  ( plc_nr_id_super, plc_nr_nivel, plc_tx_nome, plc_tx_banco, plc_tx_tipo, plc_tx_centro_custo, plc_nr_reduzido, plc_tx_status, loj_nr_id, plc_nr_id) values ( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id_super());
            pStmt.setObject(2, plc_plano_contasT.getPlc_nr_nivel());
            pStmt.setObject(3, plc_plano_contasT.getPlc_tx_nome());
            pStmt.setObject(4, plc_plano_contasT.getPlc_tx_banco());
            pStmt.setObject(5, plc_plano_contasT.getPlc_tx_tipo());
            pStmt.setObject(6, plc_plano_contasT.getPlc_tx_centro_custo());
            pStmt.setObject(7, plc_plano_contasT.getPlc_nr_reduzido());
            pStmt.setObject(8, plc_plano_contasT.getPlc_tx_status());
            pStmt.setObject(9, plc_plano_contasT.getLoj_nr_id());
            pStmt.setObject(10, plc_plano_contasT.getPlc_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.plc_plano_contas set  plc_nr_id_super=?, plc_nr_nivel=?, plc_tx_nome=?, plc_tx_banco=?, plc_tx_tipo=?, plc_tx_centro_custo=?, plc_nr_reduzido=?, plc_tx_status=?, loj_nr_id=?  where  plc_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id_super());
            pStmt.setObject(2, plc_plano_contasT.getPlc_nr_nivel());
            pStmt.setObject(3, plc_plano_contasT.getPlc_tx_nome());
            pStmt.setObject(4, plc_plano_contasT.getPlc_tx_banco());
            pStmt.setObject(5, plc_plano_contasT.getPlc_tx_tipo());
            pStmt.setObject(6, plc_plano_contasT.getPlc_tx_centro_custo());
            pStmt.setObject(7, plc_plano_contasT.getPlc_nr_reduzido());
            pStmt.setObject(8, plc_plano_contasT.getPlc_tx_status());
            pStmt.setObject(9, plc_plano_contasT.getLoj_nr_id());
            pStmt.setObject(10, plc_plano_contasT.getPlc_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.plc_plano_contas where  plc_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    private List<Plc_plano_contasT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Plc_plano_contasT> objs = new Vector();
        while (rs.next()) {
            Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();
            plc_plano_contasT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            plc_plano_contasT.setPlc_nr_id_super(rs.getInt("plc_nr_id_super"));
            plc_plano_contasT.setPlc_nr_nivel(rs.getInt("plc_nr_nivel"));
            plc_plano_contasT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
            plc_plano_contasT.setPlc_tx_banco(rs.getString("plc_tx_banco"));
            plc_plano_contasT.setPlc_tx_tipo(rs.getString("plc_tx_tipo"));
            plc_plano_contasT.setPlc_tx_centro_custo(rs.getString("plc_tx_centro_custo"));
            plc_plano_contasT.setPlc_nr_reduzido(rs.getInt("plc_nr_reduzido"));
            plc_plano_contasT.setPlc_tx_status(rs.getString("plc_tx_status"));
            plc_plano_contasT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(plc_plano_contasT);
        }
        return objs;
    }


    public List<Plc_plano_contasT> getAllSuper(int loj_nr_id, int nivel) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where (loj_nr_id = 0 or loj_nr_id =? ) and plc_nr_nivel <?   order by plc_tx_nome";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, loj_nr_id);
            pStmt.setObject(2, nivel);
            rs = pStmt.executeQuery();
            List<Plc_plano_contasT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }


public List<Plc_plano_contasT> getAll(int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where loj_nr_id = 0 or loj_nr_id =? order by plc_nr_id";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, loj_nr_id);
            rs = pStmt.executeQuery();
            List<Plc_plano_contasT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
public List<Plc_plano_contasT> getAllSub(int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where (loj_nr_id = 0 or loj_nr_id =? ) and plc_nr_id_super > 0 and plc_nr_id not in(select plc_nr_id_super from easyfin.plc_plano_contas)   order by plc_tx_nome";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, loj_nr_id);
            rs = pStmt.executeQuery();
            List<Plc_plano_contasT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
    public List<Plc_plano_contasT> getByPK(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  plc_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_nr_id(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  plc_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_nr_id_super(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  plc_nr_id_super = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id_super());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_nr_nivel(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  plc_nr_nivel = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_nivel());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_tx_nome(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  Upper(plc_tx_nome) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + plc_plano_contasT.getPlc_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_tx_banco(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  Upper(plc_tx_banco) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + plc_plano_contasT.getPlc_tx_banco() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_tx_tipo(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  Upper(plc_tx_tipo) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + plc_plano_contasT.getPlc_tx_tipo() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_tx_centro_custo(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  Upper(plc_tx_centro_custo) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + plc_plano_contasT.getPlc_tx_centro_custo() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_nr_reduzido(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  plc_nr_reduzido = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_reduzido());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByPlc_tx_status(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  Upper(plc_tx_status) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + plc_plano_contasT.getPlc_tx_status() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Plc_plano_contasT> getByLoj_nr_id(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.plc_plano_contas where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, plc_plano_contasT.getLoj_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

}
