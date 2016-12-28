package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Ctp_conta_pagarDAO extends ObjectDAOCluster {

    public Ctp_conta_pagarDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.ctp_conta_pagar  ( ctp_nr_doc, ctp_dt_emissao, ctp_dt_vencimento, ctp_tx_pago, ban_nr_id, ctp_valor, ctp_tx_parcela, ctp_dt_pagamento, car_nr_id, ctp_vl_pago, ctp_saldo, for_nr_id, fop_nr_id, loj_nr_id, ctp_tx_obs, ctp_tx_tipo_vinculo, ctp_nr_id_vinculo, ctp_nr_id) values ( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_doc());
            java.sql.Date dt2 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_emissao().getTime());
            pStmt.setObject(2, dt2);
            java.sql.Date dt3 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
            pStmt.setObject(3, dt3);
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_tx_pago());
            pStmt.setObject(5, ctp_conta_pagarT.getBan_nr_id() == 0 ? null : ctp_conta_pagarT.getBan_nr_id());
            pStmt.setObject(6, ctp_conta_pagarT.getCtp_valor());
            pStmt.setObject(7, ctp_conta_pagarT.getCtp_tx_parcela());
            java.sql.Date dt8 = ctp_conta_pagarT.getCtp_dt_pagamento() == null ? null : new java.sql.Date(ctp_conta_pagarT.getCtp_dt_pagamento().getTime());
            pStmt.setObject(8, dt8);
            pStmt.setObject(9, ctp_conta_pagarT.getCar_nr_id() == 0 ? null : ctp_conta_pagarT.getCar_nr_id());
            pStmt.setObject(10, ctp_conta_pagarT.getCtp_vl_pago());
            pStmt.setObject(11, ctp_conta_pagarT.getCtp_saldo());
            pStmt.setObject(12, ctp_conta_pagarT.getFor_nr_id());
            pStmt.setObject(13, ctp_conta_pagarT.getFop_nr_id());
            pStmt.setObject(14, ctp_conta_pagarT.getLoj_nr_id());
            pStmt.setObject(15, ctp_conta_pagarT.getCtp_tx_obs());
            pStmt.setObject(16, ctp_conta_pagarT.getCtp_tx_tipo_vinculo());
            pStmt.setObject(17, ctp_conta_pagarT.getCtp_nr_id_vinculo());
            pStmt.setObject(18, ctp_conta_pagarT.getCtp_nr_id());
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

    public void update(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.ctp_conta_pagar set  ctp_nr_doc=?, ctp_dt_emissao=?, ctp_dt_vencimento=?, ctp_tx_pago=?, ban_nr_id=?, ctp_valor=?, ctp_tx_parcela=?, ctp_dt_pagamento=?, car_nr_id=?, ctp_vl_pago=?, ctp_saldo=?, for_nr_id=?, fop_nr_id=?, loj_nr_id=?, ctp_tx_obs=?, ctp_tx_tipo_vinculo=?, ctp_nr_id_vinculo=?  where  ctp_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_doc());
            java.sql.Date dt2 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_emissao().getTime());
            pStmt.setObject(2, dt2);
            java.sql.Date dt3 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
            pStmt.setObject(3, dt3);
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_tx_pago());
            pStmt.setObject(5, ctp_conta_pagarT.getBan_nr_id() == 0 ? null : ctp_conta_pagarT.getBan_nr_id());
            pStmt.setObject(6, ctp_conta_pagarT.getCtp_valor());
            pStmt.setObject(7, ctp_conta_pagarT.getCtp_tx_parcela());
            java.sql.Date dt8 = ctp_conta_pagarT.getCtp_dt_pagamento() == null ? null : new java.sql.Date(ctp_conta_pagarT.getCtp_dt_pagamento().getTime());
            pStmt.setObject(8, dt8);
            pStmt.setObject(9, ctp_conta_pagarT.getCar_nr_id() == 0 ? null : ctp_conta_pagarT.getCar_nr_id());
            pStmt.setObject(10, ctp_conta_pagarT.getCtp_vl_pago());
            pStmt.setObject(11, ctp_conta_pagarT.getCtp_saldo());
            pStmt.setObject(12, ctp_conta_pagarT.getFor_nr_id());
            pStmt.setObject(13, ctp_conta_pagarT.getFop_nr_id());
            pStmt.setObject(14, ctp_conta_pagarT.getLoj_nr_id());
            pStmt.setObject(15, ctp_conta_pagarT.getCtp_tx_obs());
            pStmt.setObject(16, ctp_conta_pagarT.getCtp_tx_tipo_vinculo());
            pStmt.setObject(17, ctp_conta_pagarT.getCtp_nr_id_vinculo());
            pStmt.setObject(18, ctp_conta_pagarT.getCtp_nr_id());
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

    public void updateBaixa(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.ctp_conta_pagar set  ctp_tx_pago=?, ctp_dt_pagamento=?, ctp_vl_pago=?, ctp_saldo=?  where  ctp_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_tx_pago());
            java.sql.Date dt10 = ctp_conta_pagarT.getCtp_dt_pagamento() == null ? null : new java.sql.Date(ctp_conta_pagarT.getCtp_dt_pagamento().getTime());
            pStmt.setObject(2, dt10);
            pStmt.setObject(3, ctp_conta_pagarT.getCtp_vl_pago());
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_saldo());
            pStmt.setObject(5, ctp_conta_pagarT.getCtp_nr_id());
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
            String sql = "delete from easyfin.ctp_conta_pagar where  ctp_nr_id=?";
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

    private List<Ctp_conta_pagarT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ctp_conta_pagarT> objs = new Vector();
        while (rs.next()) {
            Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
            ctp_conta_pagarT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            ctp_conta_pagarT.setCtp_nr_doc(rs.getInt("ctp_nr_doc"));
            ctp_conta_pagarT.setCtp_dt_emissao(rs.getDate("ctp_dt_emissao"));
            ctp_conta_pagarT.setCtp_dt_vencimento(rs.getDate("ctp_dt_vencimento"));
            ctp_conta_pagarT.setCtp_tx_pago(rs.getString("ctp_tx_pago"));
            ctp_conta_pagarT.setBan_nr_id(rs.getInt("ban_nr_id"));
            ctp_conta_pagarT.setCtp_valor(rs.getDouble("ctp_valor"));
            ctp_conta_pagarT.setCtp_tx_parcela(rs.getString("ctp_tx_parcela"));
            ctp_conta_pagarT.setCtp_dt_pagamento(rs.getDate("ctp_dt_pagamento"));
            ctp_conta_pagarT.setCar_nr_id(rs.getInt("car_nr_id"));
            ctp_conta_pagarT.setCtp_vl_pago(rs.getDouble("ctp_vl_pago"));
            ctp_conta_pagarT.setCtp_saldo(rs.getDouble("ctp_saldo"));
            ctp_conta_pagarT.setFor_nr_id(rs.getInt("for_nr_id"));
            ctp_conta_pagarT.setFop_nr_id(rs.getInt("fop_nr_id"));
            ctp_conta_pagarT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            ctp_conta_pagarT.setCtp_tx_obs(rs.getString("ctp_tx_obs"));
            ctp_conta_pagarT.setCtp_tx_tipo_vinculo(rs.getString("ctp_tx_tipo_vinculo"));
            ctp_conta_pagarT.setCtp_nr_id_vinculo(rs.getInt("ctp_nr_id_vinculo"));
            objs.add(ctp_conta_pagarT);
        }
        return objs;
    }

    public List<Ctp_conta_pagarT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Ctp_conta_pagarT> list = resultSetToObjectTransfer(rs);
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

    public List<Ctp_conta_pagarT> getByPK(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_nr_id=?";
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

    public List<Ctp_conta_pagarT> getByCtp_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_nr_id = ? ";
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

    public List<Ctp_conta_pagarT> getByCtp_nr_doc(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_nr_doc = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_doc());
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

    public List<Ctp_conta_pagarT> getByCtp_dt_emissao(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_dt_emissao = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_emissao().getTime());
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

    public List<Ctp_conta_pagarT> getByCtp_dt_vencimento(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_dt_vencimento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
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

    public List<Ctp_conta_pagarT> getByCtp_tx_pago(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  Upper(ctp_tx_pago) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_tx_pago() + '%');
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

    public List<Ctp_conta_pagarT> getByBan_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ban_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getBan_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_valor(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_valor());
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

    public List<Ctp_conta_pagarT> getByCtp_tx_parcela(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  Upper(ctp_tx_parcela) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_tx_parcela() + '%');
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

    public List<Ctp_conta_pagarT> getByCtp_dt_pagamento(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_dt_pagamento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_pagamento().getTime());
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

    public List<Ctp_conta_pagarT> getByCar_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  car_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCar_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_vl_pago(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_vl_pago = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_vl_pago());
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

    public List<Ctp_conta_pagarT> getByCtp_saldo(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_saldo = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_saldo());
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

    public List<Ctp_conta_pagarT> getByFor_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  for_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getFor_nr_id());
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

    public List<Ctp_conta_pagarT> getByFop_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  fop_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getFop_nr_id());
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

    public List<Ctp_conta_pagarT> getByLoj_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getLoj_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_tx_obs(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  Upper(ctp_tx_obs) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_tx_obs() + '%');
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

    public List<Ctp_conta_pagarT> getByCtp_tx_tipo_vinculo(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_tx_tipo_vinculo = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_tx_tipo_vinculo());
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

    public List<Ctp_conta_pagarT> getByCtp_nr_id_vinculo(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where  ctp_nr_id_vinculo = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id_vinculo());
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
    public List<Ctp_conta_pagarT> getByBan_banco(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where ban_banco.ban_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getBan_nr_id());
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
    public List<Ctp_conta_pagarT> getByCar_cartao(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where car_cartao.car_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCar_nr_id());
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
    public List<Ctp_conta_pagarT> getByFor_fornecedor(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where for_fornecedor.for_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getFor_nr_id());
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
    public List<Ctp_conta_pagarT> getByFop_forma_pagamento(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where fop_forma_pagamento.fop_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getFop_nr_id());
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
    public List<Ctp_conta_pagarT> getByLoj_loja(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctp_conta_pagar where loj_loja.loj_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getLoj_nr_id());
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
