package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Lan_lancamentoDAO extends ObjectDAOCluster {

    public Lan_lancamentoDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.lan_lancamento  ( ctr_nr_id, ctp_nr_id, lan_plc_nr_id_deb, lan_plc_nr_id_cred, lan_dt_lancamento, lan_tx_historico, lan_valor, loj_nr_id, lan_nr_id_super, lan_nr_id) values ( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtr_nr_id() == 0 ? null : lan_lancamentoT.getCtr_nr_id());
            pStmt.setObject(2, lan_lancamentoT.getCtp_nr_id() == 0 ? null : lan_lancamentoT.getCtp_nr_id());
            pStmt.setObject(3, lan_lancamentoT.getLan_plc_nr_id_deb());
            pStmt.setObject(4, lan_lancamentoT.getLan_plc_nr_id_cred());
            java.sql.Date dt5 = lan_lancamentoT.getLan_dt_lancamento() == null ? null : new java.sql.Date(lan_lancamentoT.getLan_dt_lancamento().getTime());
            pStmt.setObject(5, dt5);
            pStmt.setObject(6, lan_lancamentoT.getLan_tx_historico());
            pStmt.setObject(7, lan_lancamentoT.getLan_valor());
            pStmt.setObject(8, lan_lancamentoT.getLoj_nr_id());
            pStmt.setObject(9, lan_lancamentoT.getLan_nr_id_super());
            pStmt.setObject(10, lan_lancamentoT.getLan_nr_id());
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

    public void update(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.lan_lancamento set  ctr_nr_id=?, ctp_nr_id=?, lan_plc_nr_id_deb=?, lan_plc_nr_id_cred=?, lan_dt_lancamento=?, lan_tx_historico=?, lan_valor=?, loj_nr_id=?, lan_nr_id_super=?  where  lan_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtr_nr_id() == 0 ? null : lan_lancamentoT.getCtr_nr_id());
            pStmt.setObject(2, lan_lancamentoT.getCtp_nr_id() == 0 ? null : lan_lancamentoT.getCtp_nr_id());
            pStmt.setObject(3, lan_lancamentoT.getLan_plc_nr_id_deb());
            pStmt.setObject(4, lan_lancamentoT.getLan_plc_nr_id_cred());
            java.sql.Date dt5 = lan_lancamentoT.getLan_dt_lancamento() == null ? null : new java.sql.Date(lan_lancamentoT.getLan_dt_lancamento().getTime());
            pStmt.setObject(5, dt5);
            pStmt.setObject(6, lan_lancamentoT.getLan_tx_historico());
            pStmt.setObject(7, lan_lancamentoT.getLan_valor());
            pStmt.setObject(8, lan_lancamentoT.getLoj_nr_id());
            pStmt.setObject(9, lan_lancamentoT.getLan_nr_id_super());
            pStmt.setObject(10, lan_lancamentoT.getLan_nr_id());
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

    public void delete(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.lan_lancamento where  lan_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_nr_id());
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

    private List<Lan_lancamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Lan_lancamentoT> objs = new Vector();
        while (rs.next()) {
            Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();
            lan_lancamentoT.setLan_nr_id(rs.getInt("lan_nr_id"));
            lan_lancamentoT.setCtr_nr_id(rs.getInt("ctr_nr_id"));
            lan_lancamentoT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            lan_lancamentoT.setLan_plc_nr_id_deb(rs.getInt("lan_plc_nr_id_deb"));
            lan_lancamentoT.setLan_plc_nr_id_cred(rs.getInt("lan_plc_nr_id_cred"));
            lan_lancamentoT.setLan_dt_lancamento(rs.getDate("lan_dt_lancamento"));
            lan_lancamentoT.setLan_tx_historico(rs.getString("lan_tx_historico"));
            lan_lancamentoT.setLan_valor(rs.getDouble("lan_valor"));
            lan_lancamentoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            lan_lancamentoT.setLan_nr_id_super(rs.getDouble("lan_nr_id_super"));
            objs.add(lan_lancamentoT);
        }
        return objs;
    }

    public List<Lan_lancamentoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Lan_lancamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Lan_lancamentoT> getByPK(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  lan_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_nr_id());
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

    public List<Lan_lancamentoT> getByLan_nr_id(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  lan_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_nr_id());
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

    public List<Lan_lancamentoT> getByCtr_nr_id(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  ctr_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtr_nr_id());
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

    public double getByLanContaReceber(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(lan_valor) total from easyfin.lan_lancamento where  ctr_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_nr_id());
            rs = pStmt.executeQuery();
            return rs.next() ? rs.getDouble("total") : 0;
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

    public double getByLanContaPagar(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(lan_valor) total from easyfin.lan_lancamento where  ctp_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
            rs = pStmt.executeQuery();
            return rs.next() ? rs.getDouble("total") : 0;
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

    public List<Lan_lancamentoT> getByCtp_nr_id(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  ctp_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtp_nr_id());
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

    public List<Lan_lancamentoT> getByLan_plc_nr_id_deb(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  lan_plc_nr_id_deb = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_plc_nr_id_deb());
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

    public List<Lan_lancamentoT> getByLan_plc_nr_id_cred(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  lan_plc_nr_id_cred = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_plc_nr_id_cred());
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

    public double getBySaldoAnteriorDeb(java.sql.Date dt_inicio, int plc_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(lan_valor) valor from easyfin.lan_lancamento where  lan_dt_lancamento < ? and lan_plc_nr_id_deb = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, dt_inicio);
            pStmt.setObject(2, plc_nr_id);
            rs = pStmt.executeQuery();
            return rs.next() ? rs.getDouble("valor") : 0;
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

    public double getBySaldoAnteriorCred(java.sql.Date dt_inicio, int plc_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(lan_valor) valor from easyfin.lan_lancamento where  lan_dt_lancamento < ? and lan_plc_nr_id_cred = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, dt_inicio);
            pStmt.setObject(2, plc_nr_id);
            rs = pStmt.executeQuery();
            return rs.next() ? rs.getDouble("valor") : 0;
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

    public List<Lan_lancamentoT> getByLan_dt_lancamento(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  lan_dt_lancamento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(lan_lancamentoT.getLan_dt_lancamento().getTime());
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

    public List<Lan_lancamentoT> getByLan_tx_historico(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  Upper(lan_tx_historico) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + lan_lancamentoT.getLan_tx_historico() + '%');
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

    public List<Lan_lancamentoT> getByLan_valor(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  lan_valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_valor());
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

    public List<Lan_lancamentoT> getByLoj_nr_id(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLoj_nr_id());
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

    public List<Lan_lancamentoT> getByLan_nr_id_super(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where  lan_nr_id_super = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_nr_id_super());
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
    public List<Lan_lancamentoT> getByCtr_conta_recebe(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where ctr_conta_recebe.ctr_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtr_nr_id());
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
    public List<Lan_lancamentoT> getByCtp_conta_pagar(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where ctp_conta_pagar.ctp_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtp_nr_id());
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
    public List<Lan_lancamentoT> getByPlc_plano_contas(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where plc_plano_contas.lan_plc_nr_id_deb=? and plc_plano_contas.lan_plc_nr_id_cred=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_plc_nr_id_deb());
            pStmt.setObject(2, lan_lancamentoT.getLan_plc_nr_id_cred());
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
    public List<Lan_lancamentoT> getByLoj_loja(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.lan_lancamento where loj_loja.loj_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, lan_lancamentoT.getLoj_nr_id());
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
