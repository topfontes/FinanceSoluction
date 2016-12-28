package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Ccr_conta_ct_receberDAO extends ObjectDAOCluster {

    public Ccr_conta_ct_receberDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.ccr_conta_ct_receber  ( ctr_nr_id, plc_nr_id, ccr_valor, ccr_nr_id) values ( ?, ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getCtr_nr_id());
            pStmt.setObject(2, ccr_conta_ct_receberT.getPlc_nr_id());
            pStmt.setObject(3, ccr_conta_ct_receberT.getCcr_valor());
            pStmt.setObject(4, ccr_conta_ct_receberT.getCcr_nr_id());
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

    public void update(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.ccr_conta_ct_receber set  ctr_nr_id=?, plc_nr_id=?, ccr_valor=?  where  ccr_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getCtr_nr_id());
            pStmt.setObject(2, ccr_conta_ct_receberT.getPlc_nr_id());
            pStmt.setObject(3, ccr_conta_ct_receberT.getCcr_valor());
            pStmt.setObject(4, ccr_conta_ct_receberT.getCcr_nr_id());
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

    public void delete(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.ccr_conta_ct_receber where  ccr_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getCcr_nr_id());
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

    private List<Ccr_conta_ct_receberT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ccr_conta_ct_receberT> objs = new Vector();
        while (rs.next()) {
            Ccr_conta_ct_receberT ccr_conta_ct_receberT = new Ccr_conta_ct_receberT();
            ccr_conta_ct_receberT.setCcr_nr_id(rs.getInt("ccr_nr_id"));
            ccr_conta_ct_receberT.setCtr_nr_id(rs.getInt("ctr_nr_id"));
            ccr_conta_ct_receberT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            ccr_conta_ct_receberT.setCcr_valor(rs.getDouble("ccr_valor"));
            objs.add(ccr_conta_ct_receberT);
        }
        return objs;
    }

    public List<Ccr_conta_ct_receberT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccr_conta_ct_receber";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Ccr_conta_ct_receberT> list = resultSetToObjectTransfer(rs);
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

    public List<Ccr_conta_ct_receberT> getByPK(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccr_conta_ct_receber where  ccr_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getCcr_nr_id());
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

    public List<Ccr_conta_ct_receberT> getByCcr_nr_id(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccr_conta_ct_receber where  ccr_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getCcr_nr_id());
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

    public List<Ccr_conta_ct_receberT> getByCtr_nr_id(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccr_conta_ct_receber where  ctr_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getCtr_nr_id());
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

    public List<Ccr_conta_ct_receberT> getByPlc_nr_id(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccr_conta_ct_receber where  plc_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getPlc_nr_id());
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

    public List<Ccr_conta_ct_receberT> getByCcr_valor(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccr_conta_ct_receber where  ccr_valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getCcr_valor());
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
    public List<Ccr_conta_ct_receberT> getByCtr_conta_recebe(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccr_conta_ct_receber where ctr_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_nr_id());
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
    public List<Ccr_conta_ct_receberT> getByPlc_plano_contas(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccr_conta_ct_receber where plc_plano_contas.plc_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccr_conta_ct_receberT.getPlc_nr_id());
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
