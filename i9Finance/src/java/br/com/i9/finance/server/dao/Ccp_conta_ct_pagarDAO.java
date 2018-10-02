package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Ccp_conta_ct_pagarDAO extends ObjectDAOCluster {

    public Ccp_conta_ct_pagarDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.ccp_conta_ct_pagar  ( ctp_nr_id, plc_nr_id, ccp_valor,ccp_nr_id) values ( ?, ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getCtp_nr_id());
            pStmt.setObject(2, ccp_conta_ct_pagarT.getPlc_nr_id());
            pStmt.setObject(3, ccp_conta_ct_pagarT.getCcp_valor());
            pStmt.setObject(4, ccp_conta_ct_pagarT.getCcp_nr_id());
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

    public void update(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.ccp_conta_ct_pagar set  ctp_nr_id=?, plc_nr_id=?, ccp_valor=?  where  ccp_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getCtp_nr_id());
            pStmt.setObject(2, ccp_conta_ct_pagarT.getPlc_nr_id());
            pStmt.setObject(3, ccp_conta_ct_pagarT.getCcp_valor());
            pStmt.setObject(4, ccp_conta_ct_pagarT.getCcp_nr_id());
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

    public void delete(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.ccp_conta_ct_pagar where  ccp_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getCcp_nr_id());
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
    
    public void delete(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.ccp_conta_ct_pagar where  ctp_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
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

    private List<Ccp_conta_ct_pagarT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ccp_conta_ct_pagarT> objs = new Vector();
        while (rs.next()) {
            Ccp_conta_ct_pagarT ccp_conta_ct_pagarT = new Ccp_conta_ct_pagarT();
            ccp_conta_ct_pagarT.setCcp_nr_id(rs.getInt("ccp_nr_id"));
            ccp_conta_ct_pagarT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            ccp_conta_ct_pagarT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            ccp_conta_ct_pagarT.setCcp_valor(rs.getDouble("ccp_valor"));
            objs.add(ccp_conta_ct_pagarT);
        }
        return objs;
    }

    public List<Ccp_conta_ct_pagarT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccp_conta_ct_pagar";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Ccp_conta_ct_pagarT> list = resultSetToObjectTransfer(rs);
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

    public List<Ccp_conta_ct_pagarT> getByPK(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccp_conta_ct_pagar where  ccp_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getCcp_nr_id());
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

    public List<Ccp_conta_ct_pagarT> getByCcp_nr_id(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccp_conta_ct_pagar where  ccp_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getCcp_nr_id());
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

    public List<Ccp_conta_ct_pagarT> getByCtp_nr_id(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccp_conta_ct_pagar where  ctp_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getCtp_nr_id());
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

    public List<Ccp_conta_ct_pagarT> getByPlc_nr_id(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccp_conta_ct_pagar where  plc_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getPlc_nr_id());
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

    public List<Ccp_conta_ct_pagarT> getByCcp_valor(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccp_conta_ct_pagar where  ccp_valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getCcp_valor());
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
    public List<Ccp_conta_ct_pagarT> getByCtp_conta_pagar(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccp_conta_ct_pagar where ctp_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
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
    public List<Ccp_conta_ct_pagarT> getByPlc_plano_contas(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ccp_conta_ct_pagar where plc_plano_contas.plc_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ccp_conta_ct_pagarT.getPlc_nr_id());
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
