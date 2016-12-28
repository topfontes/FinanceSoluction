package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Fpar_forma_parcelaDAO extends ObjectDAOCluster {

    public Fpar_forma_parcelaDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.fpar_forma_parcela  ( fop_nr_id, par_nr_id, fpar_nr_id) values ( ?, ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getFop_nr_id());
            pStmt.setObject(2, fpar_forma_parcelaT.getPar_nr_id());
            pStmt.setObject(3, fpar_forma_parcelaT.getFpar_nr_id());
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

    public void update(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.fpar_forma_parcela set  fop_nr_id=?, par_nr_id=?  where  fpar_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getFop_nr_id());
            pStmt.setObject(2, fpar_forma_parcelaT.getPar_nr_id());
            pStmt.setObject(3, fpar_forma_parcelaT.getFpar_nr_id());
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

    public void delete(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.fpar_forma_parcela where  fpar_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getFpar_nr_id());
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

    private List<Fpar_forma_parcelaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Fpar_forma_parcelaT> objs = new Vector();
        while (rs.next()) {
            Fpar_forma_parcelaT fpar_forma_parcelaT = new Fpar_forma_parcelaT();
            fpar_forma_parcelaT.setFpar_nr_id(rs.getInt("fpar_nr_id"));
            fpar_forma_parcelaT.setFop_nr_id(rs.getInt("fop_nr_id"));
            fpar_forma_parcelaT.setPar_nr_id(rs.getInt("par_nr_id"));
            objs.add(fpar_forma_parcelaT);
        }
        return objs;
    }

    public List<Fpar_forma_parcelaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fpar_forma_parcela";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Fpar_forma_parcelaT> list = resultSetToObjectTransfer(rs);
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

    public List<Fpar_forma_parcelaT> getByPK(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fpar_forma_parcela where  fpar_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getFpar_nr_id());
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

    public List<Fpar_forma_parcelaT> getByFpar_nr_id(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fpar_forma_parcela where  fpar_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getFpar_nr_id());
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

    public List<Fpar_forma_parcelaT> getByFop_nr_id(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fpar_forma_parcela where  fop_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getFop_nr_id());
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

    public List<Fpar_forma_parcelaT> getByPar_nr_id(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fpar_forma_parcela where  par_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getPar_nr_id());
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
    public List<Fpar_forma_parcelaT> getByFop_forma_pagamento(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fpar_forma_parcela where fop_forma_pagamento.fop_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getFop_nr_id());
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
    public List<Fpar_forma_parcelaT> getByPar_parcelamento(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.fpar_forma_parcela where par_parcelamento.par_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, fpar_forma_parcelaT.getPar_nr_id());
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
