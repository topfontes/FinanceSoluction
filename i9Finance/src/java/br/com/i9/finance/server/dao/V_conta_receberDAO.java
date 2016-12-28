package br.com.i9.finance.server.dao;

import br.com.easynet.convesion.ConvertDate;
import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class V_conta_receberDAO extends ObjectDAOCluster {

    public V_conta_receberDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.v_conta_receber  ( dt_pagamento, valor, id_cli_fab, nome, fop_nr_id, forma, ban_nr_id, banco, pago, parcela, documento, dt_emissao, vencimento, obs, car_nr_id, cartao, loj_nr_id) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_receberT.getDt_pagamento().getTime());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, v_conta_receberT.getValor());
            pStmt.setObject(3, v_conta_receberT.getId_cli_fab());
            pStmt.setObject(4, v_conta_receberT.getNome());
            pStmt.setObject(5, v_conta_receberT.getFop_nr_id());
            pStmt.setObject(6, v_conta_receberT.getForma());
            pStmt.setObject(7, v_conta_receberT.getBan_nr_id());
            pStmt.setObject(8, v_conta_receberT.getBanco());
            pStmt.setObject(9, v_conta_receberT.getPago());
            pStmt.setObject(10, v_conta_receberT.getParcela());
            pStmt.setObject(11, v_conta_receberT.getDocumento());
            java.sql.Date dt12 = new java.sql.Date(v_conta_receberT.getDt_emissao().getTime());
            pStmt.setObject(12, dt12);
            java.sql.Date dt13 = new java.sql.Date(v_conta_receberT.getVencimento().getTime());
            pStmt.setObject(13, dt13);
            pStmt.setObject(14, v_conta_receberT.getObs());
            pStmt.setObject(15, v_conta_receberT.getCar_nr_id());
            pStmt.setObject(16, v_conta_receberT.getCartao());
            pStmt.setObject(17, v_conta_receberT.getLoj_nr_id());
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

    public void update(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.v_conta_receber set  dt_pagamento=?, valor=?, id_cli_fab=?, nome=?, fop_nr_id=?, forma=?, ban_nr_id=?, banco=?, pago=?, parcela=?, documento=?, dt_emissao=?, vencimento=?, obs=?, car_nr_id=?, cartao=?, loj_nr_id=?  where -";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_receberT.getDt_pagamento().getTime());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, v_conta_receberT.getValor());
            pStmt.setObject(3, v_conta_receberT.getId_cli_fab());
            pStmt.setObject(4, v_conta_receberT.getNome());
            pStmt.setObject(5, v_conta_receberT.getFop_nr_id());
            pStmt.setObject(6, v_conta_receberT.getForma());
            pStmt.setObject(7, v_conta_receberT.getBan_nr_id());
            pStmt.setObject(8, v_conta_receberT.getBanco());
            pStmt.setObject(9, v_conta_receberT.getPago());
            pStmt.setObject(10, v_conta_receberT.getParcela());
            pStmt.setObject(11, v_conta_receberT.getDocumento());
            java.sql.Date dt12 = new java.sql.Date(v_conta_receberT.getDt_emissao().getTime());
            pStmt.setObject(12, dt12);
            java.sql.Date dt13 = new java.sql.Date(v_conta_receberT.getVencimento().getTime());
            pStmt.setObject(13, dt13);
            pStmt.setObject(14, v_conta_receberT.getObs());
            pStmt.setObject(15, v_conta_receberT.getCar_nr_id());
            pStmt.setObject(16, v_conta_receberT.getCartao());
            pStmt.setObject(17, v_conta_receberT.getLoj_nr_id());
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

    public void delete(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.v_conta_receber where -";
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

    private List<V_conta_receberT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<V_conta_receberT> objs = new Vector();
        while (rs.next()) {
            V_conta_receberT v_conta_receberT = new V_conta_receberT();
            v_conta_receberT.setDt_pagamento(rs.getDate("dt_pagamento"));
            v_conta_receberT.setValor(rs.getDouble("valor"));
            v_conta_receberT.setVl_pago(rs.getDouble("vl_pago"));
            v_conta_receberT.setSaldo(v_conta_receberT.getValor() - v_conta_receberT.getVl_pago());            
            v_conta_receberT.setId_cli_fab(rs.getInt("id_cli_fab"));
            v_conta_receberT.setNome(rs.getString("nome"));
            v_conta_receberT.setFop_nr_id(rs.getInt("fop_nr_id"));
            v_conta_receberT.setForma(rs.getString("forma"));
            v_conta_receberT.setBan_nr_id(rs.getInt("ban_nr_id"));
            v_conta_receberT.setBanco(rs.getString("banco"));
            v_conta_receberT.setPago(rs.getString("pago"));
            v_conta_receberT.setParcela(rs.getString("parcela"));
            v_conta_receberT.setDocumento(rs.getInt("documento"));
            v_conta_receberT.setDt_emissao(rs.getDate("dt_emissao"));
            v_conta_receberT.setVencimento(rs.getDate("vencimento"));
            v_conta_receberT.setObs(rs.getString("obs"));
            v_conta_receberT.setCar_nr_id(rs.getInt("car_nr_id"));
            v_conta_receberT.setCartao(rs.getString("cartao"));
            v_conta_receberT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            v_conta_receberT.setCtr_nr_id(rs.getInt("ctr_nr_id"));
            objs.add(v_conta_receberT);
        }
        return objs;
    }

    public List<V_conta_receberT> getAll(java.sql.Date dt_inicio, java.sql.Date dt_final, String pago) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where vencimento between ? and ? and pago =? order by dt_pagamento desc";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1,dt_inicio);
            pStmt.setObject(2,dt_final);
            pStmt.setObject(3,pago);
            rs = pStmt.executeQuery();
            List<V_conta_receberT> list = resultSetToObjectTransfer(rs);
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

    public List<V_conta_receberT> getByPK(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where -";
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

    public List<V_conta_receberT> getByDt_pagamento(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  dt_pagamento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_receberT.getDt_pagamento().getTime());
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

    public List<V_conta_receberT> getByValor(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_receberT.getValor());
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

    public List<V_conta_receberT> getById_cli_fab(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  id_cli_fab = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_receberT.getId_cli_fab());
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

    public List<V_conta_receberT> getByNome(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  Upper(nome) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_receberT.getNome() + '%');
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

    public List<V_conta_receberT> getByFop_nr_id(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  fop_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_receberT.getFop_nr_id());
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

    public List<V_conta_receberT> getByForma(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  Upper(forma) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_receberT.getForma() + '%');
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

    public List<V_conta_receberT> getByBan_nr_id(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  ban_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_receberT.getBan_nr_id());
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

    public List<V_conta_receberT> getByBanco(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  Upper(banco) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_receberT.getBanco() + '%');
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

    public List<V_conta_receberT> getByPago(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  Upper(pago) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_receberT.getPago() + '%');
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

    public List<V_conta_receberT> getByParcela(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  Upper(parcela) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_receberT.getParcela() + '%');
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

    public List<V_conta_receberT> getByDocumento(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  documento = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_receberT.getDocumento());
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

    public List<V_conta_receberT> getByDt_emissao(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  dt_emissao = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_receberT.getDt_emissao().getTime());
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

    public List<V_conta_receberT> getByVencimento(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  vencimento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(v_conta_receberT.getVencimento().getTime());
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

    public List<V_conta_receberT> getByObs(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  Upper(obs) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_receberT.getObs() + '%');
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

    public List<V_conta_receberT> getByCar_nr_id(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  car_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_receberT.getCar_nr_id());
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

    public List<V_conta_receberT> getByCartao(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  Upper(cartao) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + v_conta_receberT.getCartao() + '%');
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

    public List<V_conta_receberT> getByLoj_nr_id(V_conta_receberT v_conta_receberT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.v_conta_receber where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, v_conta_receberT.getLoj_nr_id());
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
