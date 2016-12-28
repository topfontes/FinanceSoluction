package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Por_previsao_orcamentoDAO extends ObjectDAOCluster {

    public Por_previsao_orcamentoDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.por_previsao_orcamento  ( por_nr_ano, plc_nr_id, por_vl_jan, por_vl_fev, por_vl_mar, por_vl_abr, por_vl_mai, por_vl_jun, por_vl_jul, por_vl_ago, por_vl_set, por_vl_out, por_vl_nov, por_vl_dez, loj_nr_id, por_nr_id) values ( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_nr_ano());
            pStmt.setObject(2, por_previsao_orcamentoT.getPlc_nr_id());
            pStmt.setObject(3, por_previsao_orcamentoT.getPor_vl_jan());
            pStmt.setObject(4, por_previsao_orcamentoT.getPor_vl_fev());
            pStmt.setObject(5, por_previsao_orcamentoT.getPor_vl_mar());
            pStmt.setObject(6, por_previsao_orcamentoT.getPor_vl_abr());
            pStmt.setObject(7, por_previsao_orcamentoT.getPor_vl_mai());
            pStmt.setObject(8, por_previsao_orcamentoT.getPor_vl_jun());
            pStmt.setObject(9, por_previsao_orcamentoT.getPor_vl_jul());
            pStmt.setObject(10, por_previsao_orcamentoT.getPor_vl_ago());
            pStmt.setObject(11, por_previsao_orcamentoT.getPor_vl_set());
            pStmt.setObject(12, por_previsao_orcamentoT.getPor_vl_out());
            pStmt.setObject(13, por_previsao_orcamentoT.getPor_vl_nov());
            pStmt.setObject(14, por_previsao_orcamentoT.getPor_vl_dez());
            pStmt.setObject(15, por_previsao_orcamentoT.getLoj_nr_id());
            pStmt.setObject(16, por_previsao_orcamentoT.getPor_nr_id());
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

    public void update(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.por_previsao_orcamento set  por_nr_ano=?, plc_nr_id=?, por_vl_jan=?, por_vl_fev=?, por_vl_mar=?, por_vl_abr=?, por_vl_mai=?, por_vl_jun=?, por_vl_jul=?, por_vl_ago=?, por_vl_set=?, por_vl_out=?, por_vl_nov=?, por_vl_dez=?, loj_nr_id=?  where  por_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_nr_ano());
            pStmt.setObject(2, por_previsao_orcamentoT.getPlc_nr_id());
            pStmt.setObject(3, por_previsao_orcamentoT.getPor_vl_jan());
            pStmt.setObject(4, por_previsao_orcamentoT.getPor_vl_fev());
            pStmt.setObject(5, por_previsao_orcamentoT.getPor_vl_mar());
            pStmt.setObject(6, por_previsao_orcamentoT.getPor_vl_abr());
            pStmt.setObject(7, por_previsao_orcamentoT.getPor_vl_mai());
            pStmt.setObject(8, por_previsao_orcamentoT.getPor_vl_jun());
            pStmt.setObject(9, por_previsao_orcamentoT.getPor_vl_jul());
            pStmt.setObject(10, por_previsao_orcamentoT.getPor_vl_ago());
            pStmt.setObject(11, por_previsao_orcamentoT.getPor_vl_set());
            pStmt.setObject(12, por_previsao_orcamentoT.getPor_vl_out());
            pStmt.setObject(13, por_previsao_orcamentoT.getPor_vl_nov());
            pStmt.setObject(14, por_previsao_orcamentoT.getPor_vl_dez());
            pStmt.setObject(15, por_previsao_orcamentoT.getLoj_nr_id());
            pStmt.setObject(16, por_previsao_orcamentoT.getPor_nr_id());
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

    public void delete(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.por_previsao_orcamento where  por_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_nr_id());
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

    private List<Por_previsao_orcamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Por_previsao_orcamentoT> objs = new Vector();
        while (rs.next()) {
            Por_previsao_orcamentoT por_previsao_orcamentoT = new Por_previsao_orcamentoT();
            por_previsao_orcamentoT.setPor_nr_id(rs.getInt("por_nr_id"));
            por_previsao_orcamentoT.setPor_nr_ano(rs.getInt("por_nr_ano"));
            por_previsao_orcamentoT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            por_previsao_orcamentoT.setPor_vl_jan(rs.getDouble("por_vl_jan"));
            por_previsao_orcamentoT.setPor_vl_fev(rs.getDouble("por_vl_fev"));
            por_previsao_orcamentoT.setPor_vl_mar(rs.getDouble("por_vl_mar"));
            por_previsao_orcamentoT.setPor_vl_abr(rs.getDouble("por_vl_abr"));
            por_previsao_orcamentoT.setPor_vl_mai(rs.getDouble("por_vl_mai"));
            por_previsao_orcamentoT.setPor_vl_jun(rs.getDouble("por_vl_jun"));
            por_previsao_orcamentoT.setPor_vl_jul(rs.getDouble("por_vl_jul"));
            por_previsao_orcamentoT.setPor_vl_ago(rs.getDouble("por_vl_ago"));
            por_previsao_orcamentoT.setPor_vl_set(rs.getDouble("por_vl_set"));
            por_previsao_orcamentoT.setPor_vl_out(rs.getDouble("por_vl_out"));
            por_previsao_orcamentoT.setPor_vl_nov(rs.getDouble("por_vl_nov"));
            por_previsao_orcamentoT.setPor_vl_dez(rs.getDouble("por_vl_dez"));
            por_previsao_orcamentoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(por_previsao_orcamentoT);
        }
        return objs;
    }

    public List<Por_previsao_orcamentoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Por_previsao_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Por_previsao_orcamentoT> getByPK(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_nr_id());
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

    public List<Por_previsao_orcamentoT> getByPor_nr_id(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_nr_id());
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

    public List<Por_previsao_orcamentoT> getByPor_nr_ano(int ano, int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_nr_ano = ? and loj_nr_id =? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ano);
            pStmt.setObject(2, loj_nr_id);
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

    public List<Por_previsao_orcamentoT> getByPlc_nr_id(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  plc_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPlc_nr_id());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_jan(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_jan = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_jan());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_fev(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_fev = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_fev());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_mar(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_mar = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_mar());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_abr(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_abr = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_abr());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_mai(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_mai = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_mai());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_jun(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_jun = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_jun());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_jul(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_jul = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_jul());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_ago(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_ago = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_ago());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_set(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_set = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_set());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_out(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_out = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_out());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_nov(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_nov = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_nov());
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

    public List<Por_previsao_orcamentoT> getByPor_vl_dez(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  por_vl_dez = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPor_vl_dez());
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

    public List<Por_previsao_orcamentoT> getByLoj_nr_id(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getLoj_nr_id());
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
    public List<Por_previsao_orcamentoT> getByPlc_plano_contas(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.por_previsao_orcamento where plc_plano_contas.plc_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, por_previsao_orcamentoT.getPlc_nr_id());
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
