package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Lcc_lancamento_centro_custoDAO extends ObjectDAOCluster {

    public Lcc_lancamento_centro_custoDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.lcc_lancamento_centro_custo  ( cen_nr_id, lcc_dt_lancamento, lcc_valor, plc_nr_id, lan_nr_id, loj_nr_id, lcc_nr_id) values ( ?, ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getCen_nr_id());
            java.sql.Date dt2 = new java.sql.Date(lcc_lancamento_centro_custoT.getLcc_dt_lancamento().getTime());
            pStmt.setObject(2, dt2);
            pStmt.setObject(3, lcc_lancamento_centro_custoT.getLcc_valor());
            pStmt.setObject(4, lcc_lancamento_centro_custoT.getPlc_nr_id());
            pStmt.setObject(5, lcc_lancamento_centro_custoT.getLan_nr_id());
            pStmt.setObject(6, lcc_lancamento_centro_custoT.getLoj_nr_id());
            pStmt.setObject(7, lcc_lancamento_centro_custoT.getCen_nr_id());
            pStmt.setObject(6, lcc_lancamento_centro_custoT.getLcc_nr_id());
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

    public void update(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.lcc_lancamento_centro_custo set  lcc_dt_lancamento=?, lcc_valor=?, plc_nr_id=?, lan_nr_id=?, loj_nr_id=?,  cen_nr_id=? where  lcc_nr_id=?";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(lcc_lancamento_centro_custoT.getLcc_dt_lancamento().getTime());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, lcc_lancamento_centro_custoT.getLcc_valor());
            pStmt.setObject(3, lcc_lancamento_centro_custoT.getPlc_nr_id());
            pStmt.setObject(4, lcc_lancamento_centro_custoT.getLan_nr_id());
            pStmt.setObject(5, lcc_lancamento_centro_custoT.getLoj_nr_id());

            pStmt.setObject(7, lcc_lancamento_centro_custoT.getCen_nr_id());
            pStmt.setObject(6, lcc_lancamento_centro_custoT.getLcc_nr_id());
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

    public void delete(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.lcc_lancamento_centro_custo where  lcc_nr_id=? and cen_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getLcc_nr_id());
            pStmt.setObject(2, lcc_lancamento_centro_custoT.getCen_nr_id());
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

    private List<Lcc_lancamento_centro_custoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Lcc_lancamento_centro_custoT> objs = new Vector();
        while (rs.next()) {
            Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT = new Lcc_lancamento_centro_custoT();
            lcc_lancamento_centro_custoT.setLcc_nr_id(rs.getInt("lcc_nr_id"));
            lcc_lancamento_centro_custoT.setCen_nr_id(rs.getInt("cen_nr_id"));
            lcc_lancamento_centro_custoT.setLcc_dt_lancamento(rs.getDate("lcc_dt_lancamento"));
            lcc_lancamento_centro_custoT.setLcc_valor(rs.getDouble("lcc_valor"));
            lcc_lancamento_centro_custoT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            lcc_lancamento_centro_custoT.setLan_nr_id(rs.getInt("lan_nr_id"));
            lcc_lancamento_centro_custoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(lcc_lancamento_centro_custoT);
        }
        return objs;
    }

    public List<Lcc_lancamento_centro_custoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Lcc_lancamento_centro_custoT> list = resultSetToObjectTransfer(rs);
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

    public List<Lcc_lancamento_centro_custoT> getByPK(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where  lcc_nr_id=? and cen_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getLcc_nr_id());
            pStmt.setObject(2, lcc_lancamento_centro_custoT.getCen_nr_id());
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

    public List<Lcc_lancamento_centro_custoT> getByLcc_nr_id(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where  lcc_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getLcc_nr_id());
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

    public List<Lcc_lancamento_centro_custoT> getByCen_nr_id(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where  cen_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getCen_nr_id());
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

    public List<Lcc_lancamento_centro_custoT> getByLcc_dt_lancamento(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where  lcc_dt_lancamento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(lcc_lancamento_centro_custoT.getLcc_dt_lancamento().getTime());
            pStmt.setObject(1, dt1);
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

    public List<Lcc_lancamento_centro_custoT> getByLcc_valor(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where  lcc_valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getLcc_valor());
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

    public List<Lcc_lancamento_centro_custoT> getByPlc_nr_id(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where  plc_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getPlc_nr_id());
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

    public List<Lcc_lancamento_centro_custoT> getByLan_nr_id(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where  lan_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getLan_nr_id());
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

    public List<Lcc_lancamento_centro_custoT> getByLoj_nr_id(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getLoj_nr_id());
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

    /**
     * Metodos FK
     */
    public List<Lcc_lancamento_centro_custoT> getByCen_centro_custo(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where cen_centro_custo.cen_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getCen_nr_id());
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

    /**
     * Metodos FK
     */
    public List<Lcc_lancamento_centro_custoT> getByPlc_plano_contas(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where plc_plano_contas.plc_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getPlc_nr_id());
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

    /**
     * Metodos FK
     */
    public List<Lcc_lancamento_centro_custoT> getByLan_lancamento(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lcc_lancamento_centro_custo where lan_lancamento.lan_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lcc_lancamento_centro_custoT.getLan_nr_id());
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
