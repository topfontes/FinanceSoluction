package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class V_conta_pagarDAO extends ObjectDAOCluster {

    public V_conta_pagarDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.v_conta_pagar  ( dt_pagamento, valor, id_cli_fab, nome, fop_nr_id, forma, ban_nr_id, banco, pago, parcela, documento, dt_emissao, vencimento, obs, car_nr_id, cartao, loj_nr_id) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_pagarT.getDt_pagamento().getTime());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, v_conta_pagarT.getValor());
            pStmt.setObject(3, v_conta_pagarT.getId_cli_fab());
            pStmt.setObject(4, v_conta_pagarT.getNome());
            pStmt.setObject(5, v_conta_pagarT.getFop_nr_id());
            pStmt.setObject(6, v_conta_pagarT.getForma());
            pStmt.setObject(7, v_conta_pagarT.getBan_nr_id());
            pStmt.setObject(8, v_conta_pagarT.getBanco());
            pStmt.setObject(9, v_conta_pagarT.getPago());
            pStmt.setObject(10, v_conta_pagarT.getParcela());
            pStmt.setObject(11, v_conta_pagarT.getDocumento());
            java.sql.Date dt12 = new java.sql.Date(v_conta_pagarT.getDt_emissao().getTime());
            pStmt.setObject(12, dt12);
            java.sql.Date dt13 = new java.sql.Date(v_conta_pagarT.getVencimento().getTime());
            pStmt.setObject(13, dt13);
            pStmt.setObject(14, v_conta_pagarT.getObs());
            pStmt.setObject(15, v_conta_pagarT.getCar_nr_id());
            pStmt.setObject(16, v_conta_pagarT.getCartao());
            pStmt.setObject(17, v_conta_pagarT.getLoj_nr_id());
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

    public void update(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.v_conta_pagar set  dt_pagamento=?, valor=?, id_cli_fab=?, nome=?, fop_nr_id=?, forma=?, ban_nr_id=?, banco=?, pago=?, parcela=?, documento=?, dt_emissao=?, vencimento=?, obs=?, car_nr_id=?, cartao=?, loj_nr_id=?  where -";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_pagarT.getDt_pagamento().getTime());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, v_conta_pagarT.getValor());
            pStmt.setObject(3, v_conta_pagarT.getId_cli_fab());
            pStmt.setObject(4, v_conta_pagarT.getNome());
            pStmt.setObject(5, v_conta_pagarT.getFop_nr_id());
            pStmt.setObject(6, v_conta_pagarT.getForma());
            pStmt.setObject(7, v_conta_pagarT.getBan_nr_id());
            pStmt.setObject(8, v_conta_pagarT.getBanco());
            pStmt.setObject(9, v_conta_pagarT.getPago());
            pStmt.setObject(10, v_conta_pagarT.getParcela());
            pStmt.setObject(11, v_conta_pagarT.getDocumento());
            java.sql.Date dt12 = new java.sql.Date(v_conta_pagarT.getDt_emissao().getTime());
            pStmt.setObject(12, dt12);
            java.sql.Date dt13 = new java.sql.Date(v_conta_pagarT.getVencimento().getTime());
            pStmt.setObject(13, dt13);
            pStmt.setObject(14, v_conta_pagarT.getObs());
            pStmt.setObject(15, v_conta_pagarT.getCar_nr_id());
            pStmt.setObject(16, v_conta_pagarT.getCartao());
            pStmt.setObject(17, v_conta_pagarT.getLoj_nr_id());
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

    public void delete(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.v_conta_pagar where -";
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

    private List<V_conta_pagarT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<V_conta_pagarT> objs = new Vector();
        while (rs.next()) {
            V_conta_pagarT v_conta_pagarT = new V_conta_pagarT();
            v_conta_pagarT.setDt_pagamento(rs.getDate("dt_pagamento"));
            v_conta_pagarT.setValor(rs.getDouble("valor"));
            v_conta_pagarT.setVl_pago(rs.getDouble("vl_pago"));
            v_conta_pagarT.setSaldo(v_conta_pagarT.getValor() - v_conta_pagarT.getVl_pago());
            v_conta_pagarT.setId_cli_fab(rs.getInt("id_cli_fab"));
            v_conta_pagarT.setNome(rs.getString("nome"));
            v_conta_pagarT.setFop_nr_id(rs.getInt("fop_nr_id"));
            v_conta_pagarT.setForma(rs.getString("forma"));
            v_conta_pagarT.setBan_nr_id(rs.getInt("ban_nr_id"));
            v_conta_pagarT.setBanco(rs.getString("banco"));
            v_conta_pagarT.setPago(rs.getString("pago"));
            v_conta_pagarT.setParcela(rs.getString("parcela"));
            v_conta_pagarT.setDocumento(rs.getInt("documento"));
            v_conta_pagarT.setDt_emissao(rs.getDate("dt_emissao"));
            v_conta_pagarT.setVencimento(rs.getDate("vencimento"));
            v_conta_pagarT.setObs(rs.getString("obs"));
            v_conta_pagarT.setCar_nr_id(rs.getInt("car_nr_id"));
            v_conta_pagarT.setCartao(rs.getString("cartao"));
            v_conta_pagarT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            v_conta_pagarT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            objs.add(v_conta_pagarT);
        }
        return objs;
    }

    public List<V_conta_pagarT> getAll(java.sql.Date dt_inicio, java.sql.Date dt_final, String pago) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where vencimento between ? and ? and pago =?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, dt_inicio);
            pStmt.setObject(2, dt_final);
            pStmt.setObject(3, pago);
            rs = pStmt.executeQuery();
            List<V_conta_pagarT> list = resultSetToObjectTransfer(rs);
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

    public List<V_conta_pagarT> getByPK(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where -";
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

    public List<V_conta_pagarT> getByDt_pagamento(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  dt_pagamento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_pagarT.getDt_pagamento().getTime());
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

    public List<V_conta_pagarT> getByValor(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_pagarT.getValor());
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

    public List<V_conta_pagarT> getById_cli_fab(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  id_cli_fab = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_pagarT.getId_cli_fab());
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

    public List<V_conta_pagarT> getByNome(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  Upper(nome) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_pagarT.getNome() + '%');
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

    public List<V_conta_pagarT> getByFop_nr_id(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  fop_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_pagarT.getFop_nr_id());
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

    public List<V_conta_pagarT> getByForma(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  Upper(forma) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_pagarT.getForma() + '%');
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

    public List<V_conta_pagarT> getByBan_nr_id(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  ban_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_pagarT.getBan_nr_id());
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

    public List<V_conta_pagarT> getByBanco(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  Upper(banco) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_pagarT.getBanco() + '%');
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

    public List<V_conta_pagarT> getByPago(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  Upper(pago) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_pagarT.getPago() + '%');
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

    public List<V_conta_pagarT> getByParcela(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  Upper(parcela) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_pagarT.getParcela() + '%');
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

    public List<V_conta_pagarT> getByDocumento(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  documento = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_pagarT.getDocumento());
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

    public List<V_conta_pagarT> getByDt_emissao(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  dt_emissao = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_pagarT.getDt_emissao().getTime());
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

    public List<V_conta_pagarT> getByVencimento(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  vencimento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_pagarT.getVencimento().getTime());
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

    public List<V_conta_pagarT> getByObs(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  Upper(obs) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_pagarT.getObs() + '%');
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

    public List<V_conta_pagarT> getByCar_nr_id(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  car_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_pagarT.getCar_nr_id());
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

    public List<V_conta_pagarT> getByCartao(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  Upper(cartao) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_pagarT.getCartao() + '%');
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

    public List<V_conta_pagarT> getByLoj_nr_id(V_conta_pagarT v_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_pagar where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_pagarT.getLoj_nr_id());
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
