package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Par_parcelamentoDAO extends ObjectDAOCluster {

    public Par_parcelamentoDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.par_parcelamento  ( par_nr_parcela, par_tx_status, par_tx_nome, loj_nr_id, par_nr_id) values ( ?, ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, par_parcelamentoT.getPar_nr_parcela());
            pStmt.setObject(2, par_parcelamentoT.getPar_tx_status());
            pStmt.setObject(3, par_parcelamentoT.getPar_tx_nome());
            pStmt.setObject(4, par_parcelamentoT.getLoj_nr_id());
            pStmt.setObject(5, par_parcelamentoT.getPar_nr_id());
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

    public void update(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.par_parcelamento set  par_nr_parcela=?, par_tx_status=?, par_tx_nome=?, loj_nr_id=?  where  par_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, par_parcelamentoT.getPar_nr_parcela());
            pStmt.setObject(2, par_parcelamentoT.getPar_tx_status());
            pStmt.setObject(3, par_parcelamentoT.getPar_tx_nome());
            pStmt.setObject(4, par_parcelamentoT.getLoj_nr_id());
            pStmt.setObject(5, par_parcelamentoT.getPar_nr_id());
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

    public void delete(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.par_parcelamento where  par_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, par_parcelamentoT.getPar_nr_id());
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

    private List<Par_parcelamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Par_parcelamentoT> objs = new Vector();
        while (rs.next()) {
            Par_parcelamentoT par_parcelamentoT = new Par_parcelamentoT();
            par_parcelamentoT.setPar_nr_id(rs.getInt("par_nr_id"));
            par_parcelamentoT.setPar_nr_parcela(rs.getInt("par_nr_parcela"));
            par_parcelamentoT.setPar_tx_status(rs.getString("par_tx_status"));
            par_parcelamentoT.setPar_tx_nome(rs.getString("par_tx_nome"));
            par_parcelamentoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(par_parcelamentoT);
        }
        return objs;
    }

    public List<Par_parcelamentoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.par_parcelamento";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Par_parcelamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Par_parcelamentoT> getByPK(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.par_parcelamento where  par_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, par_parcelamentoT.getPar_nr_id());
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

    public List<Par_parcelamentoT> getByPar_nr_id(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.par_parcelamento where  par_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, par_parcelamentoT.getPar_nr_id());
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

    public List<Par_parcelamentoT> getByPar_nr_parcela(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.par_parcelamento where  par_nr_parcela = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, par_parcelamentoT.getPar_nr_parcela());
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

    public List<Par_parcelamentoT> getByPar_tx_status(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.par_parcelamento where  Upper(par_tx_status) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + par_parcelamentoT.getPar_tx_status() + '%');
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

    public List<Par_parcelamentoT> getByPar_tx_nome(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.par_parcelamento where  Upper(par_tx_nome) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + par_parcelamentoT.getPar_tx_nome() + '%');
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

    public List<Par_parcelamentoT> getByLoj_nr_id(Par_parcelamentoT par_parcelamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.par_parcelamento where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, par_parcelamentoT.getLoj_nr_id());
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
