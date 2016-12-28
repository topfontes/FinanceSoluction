package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Usu_loj_usuario_lojaDAO extends ObjectDAOCluster {

    public Usu_loj_usuario_lojaDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.usu_loj_usuario_loja  ( usu_nr_id, loj_nr_id) values ( ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, usu_loj_usuario_lojaT.getUsu_nr_id());
            pStmt.setObject(2, usu_loj_usuario_lojaT.getLoj_nr_id());
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

    public void update(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.usu_loj_usuario_loja set - where  usu_nr_id=? and loj_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, usu_loj_usuario_lojaT.getUsu_nr_id());
            pStmt.setObject(2, usu_loj_usuario_lojaT.getLoj_nr_id());
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

    public void delete(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.usu_loj_usuario_loja where  usu_nr_id=? and loj_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, usu_loj_usuario_lojaT.getUsu_nr_id());
            pStmt.setObject(2, usu_loj_usuario_lojaT.getLoj_nr_id());
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

    private List<Usu_loj_usuario_lojaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Usu_loj_usuario_lojaT> objs = new Vector();
        while (rs.next()) {
            Usu_loj_usuario_lojaT usu_loj_usuario_lojaT = new Usu_loj_usuario_lojaT();
            usu_loj_usuario_lojaT.setUsu_nr_id(rs.getInt("usu_nr_id"));
            usu_loj_usuario_lojaT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(usu_loj_usuario_lojaT);
        }
        return objs;
    }

    public List<Usu_loj_usuario_lojaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.usu_loj_usuario_loja";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Usu_loj_usuario_lojaT> list = resultSetToObjectTransfer(rs);
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

    public List<Usu_loj_usuario_lojaT> getByPK(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.usu_loj_usuario_loja where  usu_nr_id=? and loj_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, usu_loj_usuario_lojaT.getUsu_nr_id());
            pStmt.setObject(2, usu_loj_usuario_lojaT.getLoj_nr_id());
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

    public List<Usu_loj_usuario_lojaT> getByUsu_nr_id(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.usu_loj_usuario_loja where  usu_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, usu_loj_usuario_lojaT.getUsu_nr_id());
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

    public List<Usu_loj_usuario_lojaT> getByLoj_nr_id(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.usu_loj_usuario_loja where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, usu_loj_usuario_lojaT.getLoj_nr_id());
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
    public List<Usu_loj_usuario_lojaT> getByLoj_loja(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.usu_loj_usuario_loja where loj_loja.loj_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, usu_loj_usuario_lojaT.getLoj_nr_id());
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
