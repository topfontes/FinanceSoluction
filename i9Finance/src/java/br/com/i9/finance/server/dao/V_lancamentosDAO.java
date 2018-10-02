package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.client.util.Funcoes;

public class V_lancamentosDAO extends ObjectDAOCluster {

    public V_lancamentosDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.v_lancamentos  ( lan_nr_id, ctr_nr_id, ctp_nr_id, lan_plc_nr_id_deb, lan_plc_nr_id_cred, lan_dt_lancamento, lan_tx_historico, lan_valor, loj_nr_id, lan_nr_id_super, plc_tx_credito, plc_tx_debito) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_lancamentosT.getLan_nr_id());
            pStmt.setObject(2, v_lancamentosT.getCtr_nr_id());
            pStmt.setObject(3, v_lancamentosT.getCtp_nr_id());
            pStmt.setObject(4, v_lancamentosT.getLan_plc_nr_id_deb());
            pStmt.setObject(5, v_lancamentosT.getLan_plc_nr_id_cred());
            java.sql.Date dt6 = new java.sql.Date(v_lancamentosT.getLan_dt_lancamento().getTime());
            pStmt.setObject(6, dt6);
            pStmt.setObject(7, v_lancamentosT.getLan_tx_historico());
            pStmt.setObject(8, v_lancamentosT.getLan_valor());
            pStmt.setObject(9, v_lancamentosT.getLoj_nr_id());
            pStmt.setObject(10, v_lancamentosT.getLan_nr_id_super());
            pStmt.setObject(11, v_lancamentosT.getPlc_tx_credito());
            pStmt.setObject(12, v_lancamentosT.getPlc_tx_debito());
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

    public void update(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.v_lancamentos set  lan_nr_id=?, ctr_nr_id=?, ctp_nr_id=?, lan_plc_nr_id_deb=?, lan_plc_nr_id_cred=?, lan_dt_lancamento=?, lan_tx_historico=?, lan_valor=?, loj_nr_id=?, lan_nr_id_super=?, plc_tx_credito=?, plc_tx_debito=?  where -";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_lancamentosT.getLan_nr_id());
            pStmt.setObject(2, v_lancamentosT.getCtr_nr_id());
            pStmt.setObject(3, v_lancamentosT.getCtp_nr_id());
            pStmt.setObject(4, v_lancamentosT.getLan_plc_nr_id_deb());
            pStmt.setObject(5, v_lancamentosT.getLan_plc_nr_id_cred());
            java.sql.Date dt6 = new java.sql.Date(v_lancamentosT.getLan_dt_lancamento().getTime());
            pStmt.setObject(6, dt6);
            pStmt.setObject(7, v_lancamentosT.getLan_tx_historico());
            pStmt.setObject(8, v_lancamentosT.getLan_valor());
            pStmt.setObject(9, v_lancamentosT.getLoj_nr_id());
            pStmt.setObject(10, v_lancamentosT.getLan_nr_id_super());
            pStmt.setObject(11, v_lancamentosT.getPlc_tx_credito());
            pStmt.setObject(12, v_lancamentosT.getPlc_tx_debito());
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

    public void delete(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.v_lancamentos where -";
            pStmt = createPrepareStatment(sql);
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

    private List<V_lancamentosT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        //..
        List<V_lancamentosT> objs = new Vector();
        while (rs.next()) {
            V_lancamentosT v_lancamentosT = new V_lancamentosT();
            v_lancamentosT.setLan_nr_id(rs.getInt("lan_nr_id"));
            v_lancamentosT.setCtr_nr_id(rs.getInt("ctr_nr_id"));
            v_lancamentosT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            v_lancamentosT.setLan_plc_nr_id_deb(rs.getInt("lan_plc_nr_id_deb"));
            v_lancamentosT.setLan_plc_nr_id_cred(rs.getInt("lan_plc_nr_id_cred"));
            v_lancamentosT.setLan_dt_lancamento(rs.getDate("lan_dt_lancamento"));
            v_lancamentosT.setLan_tx_historico(rs.getString("lan_tx_historico"));
            v_lancamentosT.setLan_valor(rs.getDouble("lan_valor"));
            v_lancamentosT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            v_lancamentosT.setLan_nr_id_super(rs.getDouble("lan_nr_id_super"));
            v_lancamentosT.setPlc_tx_credito(rs.getString("plc_tx_credito"));
            v_lancamentosT.setPlc_tx_debito(rs.getString("plc_tx_debito"));
            v_lancamentosT.setplc_tx_debito_super(rs.getString("plc_tx_debito_super"));
            v_lancamentosT.setPlc_tx_credito_super(rs.getString("plc_tx_credito_super"));

            v_lancamentosT.setTipo_cred(rs.getString("tipo_cred"));
            v_lancamentosT.setTipo_deb(rs.getString("tipo_deb"));
            objs.add(v_lancamentosT);
        }
        return objs;
    }

    private List<V_lancamentosT> resultSetToObjectTransferGroup(ResultSet rs) throws Exception {
        List<V_lancamentosT> objs = new Vector();
        while (rs.next()) {
            V_lancamentosT v_lancamentosT = new V_lancamentosT();
            v_lancamentosT.setLan_plc_nr_id_deb(rs.getInt("lan_plc_nr_id_deb"));
            v_lancamentosT.setLan_plc_nr_id_cred(rs.getInt("lan_plc_nr_id_cred"));
            v_lancamentosT.setLan_valor(rs.getDouble("lan_valor"));
            v_lancamentosT.setPlc_tx_credito(rs.getString("plc_tx_credito"));
            v_lancamentosT.setPlc_tx_debito(rs.getString("plc_tx_debito"));
            v_lancamentosT.setplc_tx_debito_super(rs.getString("plc_tx_debito_super"));
            v_lancamentosT.setPlc_tx_credito_super(rs.getString("plc_tx_credito_super"));
            v_lancamentosT.setTipo_cred(rs.getString("tipo_cred"));
            v_lancamentosT.setTipo_deb(rs.getString("tipo_deb"));
            objs.add(v_lancamentosT);
        }
        return objs;
    }

    public List<V_lancamentosT> getAll(java.sql.Date dt_inicio, java.sql.Date dt_final, int plc_nr_id, int loj_nr_id, String ordenar) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            
            StringBuffer sql = new StringBuffer().append("select * from easyfin.v_lancamentos where loj_nr_id =? and lan_dt_lancamento >= ? and lan_dt_lancamento <=? ");
            if (plc_nr_id > 0) {
                sql.append(" and  (lan_plc_nr_id_deb =? or lan_plc_nr_id_cred =?)");
            }
            sql.append(" order by lan_dt_lancamento ").append(ordenar);

            pStmt = createPrepareStatment(sql.toString());
            pStmt.setObject(1, loj_nr_id);
            pStmt.setObject(2, dt_inicio);
            pStmt.setObject(3, dt_final);
            if (plc_nr_id > 0) {
                pStmt.setObject(4, plc_nr_id);
                pStmt.setObject(5, plc_nr_id);
            }

            rs = pStmt.executeQuery();
            List<V_lancamentosT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {

                pStmt.close();
            } catch (Exception e) {
            }
        }
    }
public List<V_lancamentosT> getAll_ASC(java.sql.Date dt_inicio, java.sql.Date dt_final, int plc_nr_id, int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            
            StringBuffer sql = new StringBuffer().append("select * from easyfin.v_lancamentos where loj_nr_id =? and lan_dt_lancamento >= ? and lan_dt_lancamento <=? ");
            if (plc_nr_id > 0) {
                sql.append(" and  (lan_plc_nr_id_deb =? or lan_plc_nr_id_cred =?)");
            }
            sql.append(" order by lan_dt_lancamento asc");

            pStmt = createPrepareStatment(sql.toString());
            pStmt.setObject(1, loj_nr_id);
            pStmt.setObject(2, dt_inicio);
            pStmt.setObject(3, dt_final);
            if (plc_nr_id > 0) {
                pStmt.setObject(4, plc_nr_id);
                pStmt.setObject(5, plc_nr_id);
            }

            rs = pStmt.executeQuery();
            List<V_lancamentosT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {

                pStmt.close();
            } catch (Exception e) {
            }
        }
    }
    public List<V_lancamentosT> getAllSuperAgrupado(java.sql.Date dt_inicio, java.sql.Date dt_final, int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {

            StringBuffer sql = new StringBuffer().append("select sum(lan_valor) as lan_valor, lan_plc_nr_id_deb, lan_plc_nr_id_cred,");
            sql.append(" lan_nr_id_super,  plc_tx_credito,plc_tx_debito, plc_tx_credito_super, plc_tx_debito_super, tipo_deb, tipo_cred ");
            sql.append(" from easyfin.v_lancamentos where loj_nr_id =? and lan_dt_lancamento between ? and ? ");
            sql.append(" group by lan_plc_nr_id_deb, lan_plc_nr_id_cred,  lan_nr_id_super,  plc_tx_credito,plc_tx_debito,");
            sql.append(" plc_tx_credito_super, plc_tx_debito_super,tipo_deb, tipo_cred ");
            sql.append("order by plc_tx_credito_super, plc_tx_debito_super");

            pStmt = createPrepareStatment(sql.toString());
            pStmt.setObject(1, loj_nr_id);
            pStmt.setObject(2, dt_inicio);
            pStmt.setObject(3, dt_final);

            rs = pStmt.executeQuery();
            List<V_lancamentosT> list = resultSetToObjectTransferGroup(rs);
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

    public List<V_lancamentosT> getByPK(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where -";
            pStmt = createPrepareStatment(sql);
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

    public List<V_lancamentosT> getByLan_nr_id(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  lan_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_lancamentosT.getLan_nr_id());
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

    public List<V_lancamentosT> getByCtr_nr_id(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  ctr_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_lancamentosT.getCtr_nr_id());
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

    public List<V_lancamentosT> getByRecebimentos(int ctr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  ctr_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_nr_id);
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

    public List<V_lancamentosT> getByCtp_nr_id(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  ctp_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_lancamentosT.getCtp_nr_id());
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

    public List<V_lancamentosT> getByPagamentos(int ctp_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  ctp_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_nr_id);
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
    public List<V_lancamentosT> getByLan_plc_nr_id_deb(java.sql.Date dt_inicio, java.sql.Date dt_final, int plc_debito, int loj_nr_id, String orderby) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  lan_dt_lancamento >= ? and lan_dt_lancamento <= ? and lan_plc_nr_id_deb = ? and loj_nr_id = ? order by lan_dt_lancamento "+orderby;
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, dt_inicio);
            pStmt.setObject(2, dt_final);
            pStmt.setObject(3, plc_debito);
            pStmt.setObject(4, loj_nr_id);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<V_lancamentosT> getByLan_plc_nr_id_cred(java.sql.Date dt_inicio, java.sql.Date dt_final, int plc_credito, int loj_nr_id, String orderby) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  lan_dt_lancamento >= ? and lan_dt_lancamento <= ? and lan_plc_nr_id_cred = ? and loj_nr_id =? order by lan_dt_lancamento "+orderby;

            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, dt_inicio);
            pStmt.setObject(2, dt_final);
            pStmt.setObject(3, plc_credito);
            pStmt.setObject(4, loj_nr_id);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {

                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<V_lancamentosT> getByLan_dt_lancamento(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  lan_dt_lancamento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_lancamentosT.getLan_dt_lancamento().getTime());
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

    public List<V_lancamentosT> getByLan_tx_historico(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  Upper(lan_tx_historico) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_lancamentosT.getLan_tx_historico() + '%');
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

    public List<V_lancamentosT> getByLan_valor(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  lan_valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_lancamentosT.getLan_valor());
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

    public List<V_lancamentosT> getByLoj_nr_id(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_lancamentosT.getLoj_nr_id());
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

    public List<V_lancamentosT> getByLan_nr_id_super(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  lan_nr_id_super = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_lancamentosT.getLan_nr_id_super());
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

    public List<V_lancamentosT> getByPlc_tx_credito(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  Upper(plc_tx_credito) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_lancamentosT.getPlc_tx_credito() + '%');
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

    public List<V_lancamentosT> getByPlc_tx_debito(V_lancamentosT v_lancamentosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_lancamentos where  Upper(plc_tx_debito) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_lancamentosT.getPlc_tx_debito() + '%');
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
