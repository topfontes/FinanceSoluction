package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Fop_forma_pagamentoDAO extends ObjectDAOCluster {

    public Fop_forma_pagamentoDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.fop_forma_pagamento  ( fop_tx_avista, fop_tx_status, fop_tx_nome, loj_nr_id, fop_nr_id) values ( ?, ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fop_forma_pagamentoT.getFop_tx_avista());
            pStmt.setObject(2, fop_forma_pagamentoT.getFop_tx_status());
            pStmt.setObject(3, fop_forma_pagamentoT.getFop_tx_nome());
            pStmt.setObject(4, fop_forma_pagamentoT.getLoj_nr_id());
            pStmt.setObject(5, fop_forma_pagamentoT.getFop_nr_id());
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

    public void update(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.fop_forma_pagamento set  fop_tx_avista=?, fop_tx_status=?, fop_tx_nome=?, loj_nr_id=?  where  fop_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fop_forma_pagamentoT.getFop_tx_avista());
            pStmt.setObject(2, fop_forma_pagamentoT.getFop_tx_status());
            pStmt.setObject(3, fop_forma_pagamentoT.getFop_tx_nome());
            pStmt.setObject(4, fop_forma_pagamentoT.getLoj_nr_id());
            pStmt.setObject(5, fop_forma_pagamentoT.getFop_nr_id());
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

    public void delete(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.fop_forma_pagamento where  fop_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fop_forma_pagamentoT.getFop_nr_id());
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

    private List<Fop_forma_pagamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Fop_forma_pagamentoT> objs = new Vector();
        while (rs.next()) {
            Fop_forma_pagamentoT fop_forma_pagamentoT = new Fop_forma_pagamentoT();
            fop_forma_pagamentoT.setFop_nr_id(rs.getInt("fop_nr_id"));
            fop_forma_pagamentoT.setFop_tx_avista(rs.getString("fop_tx_avista"));
            fop_forma_pagamentoT.setFop_tx_status(rs.getString("fop_tx_status"));
            fop_forma_pagamentoT.setFop_tx_nome(rs.getString("fop_tx_nome"));
            fop_forma_pagamentoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(fop_forma_pagamentoT);
        }
        return objs;
    }

    public List<Fop_forma_pagamentoT> getAll(int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fop_forma_pagamento where loj_nr_id =? or loj_nr_id = 0";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, loj_nr_id);
            rs = pStmt.executeQuery();
            List<Fop_forma_pagamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Fop_forma_pagamentoT> getByPK(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fop_forma_pagamento where  fop_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fop_forma_pagamentoT.getFop_nr_id());
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

    public List<Fop_forma_pagamentoT> getByFop_nr_id(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fop_forma_pagamento where  fop_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fop_forma_pagamentoT.getFop_nr_id());
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

    public List<Fop_forma_pagamentoT> getByFop_tx_avista(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fop_forma_pagamento where  Upper(fop_tx_avista) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + fop_forma_pagamentoT.getFop_tx_avista() + '%');
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

    public List<Fop_forma_pagamentoT> getByFop_tx_status(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fop_forma_pagamento where  Upper(fop_tx_status) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + fop_forma_pagamentoT.getFop_tx_status() + '%');
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

    public List<Fop_forma_pagamentoT> getByFop_tx_nome(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fop_forma_pagamento where  Upper(fop_tx_nome) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + fop_forma_pagamentoT.getFop_tx_nome() + '%');
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

    public List<Fop_forma_pagamentoT> getByLoj_nr_id(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fop_forma_pagamento where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fop_forma_pagamentoT.getLoj_nr_id());
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
