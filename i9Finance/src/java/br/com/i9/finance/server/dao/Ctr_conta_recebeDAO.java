package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Ctr_conta_recebeDAO extends ObjectDAOCluster {

    public Ctr_conta_recebeDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.ctr_conta_recebe  ( cli_nr_id, ctr_nr_doc, ctr_dt_emissao, ctr_dt_vencimento, fop_nr_id, ctr_tx_pago, ban_nr_id, ctr_valor, ctr_tx_parcela, ctr_dt_pagamento, car_nr_id, ctr_vl_pago, ctr_saldo, loj_nr_id, ctr_tx_obs, ctr_tx_tipo_vinculo, ctr_nr_id_vinculo, ctr_nr_id) values ( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCli_nr_id());
            pStmt.setObject(2, ctr_conta_recebeT.getCtr_nr_doc());
            java.sql.Date dt3 = new java.sql.Date(ctr_conta_recebeT.getCtr_dt_emissao().getTime());
            pStmt.setObject(3, dt3);
            java.sql.Date dt4 = new java.sql.Date(ctr_conta_recebeT.getCtr_dt_vencimento().getTime());
            pStmt.setObject(4, dt4);
            pStmt.setObject(5, ctr_conta_recebeT.getFop_nr_id());
            pStmt.setObject(6, ctr_conta_recebeT.getCtr_tx_pago());
            pStmt.setObject(7, ctr_conta_recebeT.getBan_nr_id()== 0 ?null:ctr_conta_recebeT.getBan_nr_id());
            pStmt.setObject(8, ctr_conta_recebeT.getCtr_valor());
            pStmt.setObject(9, ctr_conta_recebeT.getCtr_tx_parcela());
            java.sql.Date dt10 = ctr_conta_recebeT.getCtr_dt_pagamento() == null ? null : new java.sql.Date(ctr_conta_recebeT.getCtr_dt_pagamento().getTime());
            pStmt.setObject(10, dt10);
            pStmt.setObject(11, ctr_conta_recebeT.getCar_nr_id()== 0?null:ctr_conta_recebeT.getCar_nr_id());
            pStmt.setObject(12, ctr_conta_recebeT.getCtr_vl_pago());
            pStmt.setObject(13, ctr_conta_recebeT.getCtr_saldo());
            pStmt.setObject(14, ctr_conta_recebeT.getLoj_nr_id());
            pStmt.setObject(15, ctr_conta_recebeT.getCtr_tx_obs());
            pStmt.setObject(16, ctr_conta_recebeT.getCtr_tx_tipo_vinculo());
            pStmt.setObject(17, ctr_conta_recebeT.getCtr_nr_id_vinculo());
            pStmt.setObject(18, ctr_conta_recebeT.getCtr_nr_id());
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

    public void update(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.ctr_conta_recebe set  cli_nr_id=?, ctr_nr_doc=?, ctr_dt_emissao=?, ctr_dt_vencimento=?, fop_nr_id=?, ctr_tx_pago=?, ban_nr_id=?, ctr_valor=?, ctr_tx_parcela=?, ctr_dt_pagamento=?, car_nr_id=?, ctr_vl_pago=?, ctr_saldo=?, loj_nr_id=?, ctr_tx_obs=?, ctr_tx_tipo_vinculo=?, ctr_nr_id_vinculo=?  where  ctr_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCli_nr_id());
            pStmt.setObject(2, ctr_conta_recebeT.getCtr_nr_doc());
            java.sql.Date dt3 = new java.sql.Date(ctr_conta_recebeT.getCtr_dt_emissao().getTime());
            pStmt.setObject(3, dt3);
            java.sql.Date dt4 = new java.sql.Date(ctr_conta_recebeT.getCtr_dt_vencimento().getTime());
            pStmt.setObject(4, dt4);
            pStmt.setObject(5, ctr_conta_recebeT.getFop_nr_id());
            pStmt.setObject(6, ctr_conta_recebeT.getCtr_tx_pago());
            pStmt.setObject(7, ctr_conta_recebeT.getBan_nr_id());
            pStmt.setObject(8, ctr_conta_recebeT.getCtr_valor());
            pStmt.setObject(9, ctr_conta_recebeT.getCtr_tx_parcela());
            java.sql.Date dt10 = ctr_conta_recebeT.getCtr_dt_pagamento() == null ? null : new java.sql.Date(ctr_conta_recebeT.getCtr_dt_pagamento().getTime());
            pStmt.setObject(10, dt10);
            pStmt.setObject(11, ctr_conta_recebeT.getCar_nr_id());
            pStmt.setObject(12, ctr_conta_recebeT.getCtr_vl_pago());
            pStmt.setObject(13, ctr_conta_recebeT.getCtr_saldo());
            pStmt.setObject(14, ctr_conta_recebeT.getLoj_nr_id());
            pStmt.setObject(15, ctr_conta_recebeT.getCtr_tx_obs());
            pStmt.setObject(16, ctr_conta_recebeT.getCtr_tx_tipo_vinculo());
            pStmt.setObject(17, ctr_conta_recebeT.getCtr_nr_id_vinculo());
            pStmt.setObject(18, ctr_conta_recebeT.getCtr_nr_id());
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

    public void updateBaixa(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.ctr_conta_recebe set  ctr_tx_pago=?, ctr_dt_pagamento=?, ctr_vl_pago=?, ctr_saldo=?  where  ctr_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_tx_pago());
            java.sql.Date dt10 = ctr_conta_recebeT.getCtr_dt_pagamento() == null ? null : new java.sql.Date(ctr_conta_recebeT.getCtr_dt_pagamento().getTime());
            pStmt.setObject(2, dt10);
            pStmt.setObject(3, ctr_conta_recebeT.getCtr_vl_pago());
            pStmt.setObject(4, ctr_conta_recebeT.getCtr_saldo());
            pStmt.setObject(5, ctr_conta_recebeT.getCtr_nr_id());
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
    
    
    public void delete(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.ctr_conta_recebe where  ctr_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_nr_id());
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

    private List<Ctr_conta_recebeT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ctr_conta_recebeT> objs = new Vector();
        while (rs.next()) {
            Ctr_conta_recebeT ctr_conta_recebeT = new Ctr_conta_recebeT();
            ctr_conta_recebeT.setCtr_nr_id(rs.getInt("ctr_nr_id"));
            ctr_conta_recebeT.setCli_nr_id(rs.getInt("cli_nr_id"));
            ctr_conta_recebeT.setCtr_nr_doc(rs.getInt("ctr_nr_doc"));
            ctr_conta_recebeT.setCtr_dt_emissao(rs.getDate("ctr_dt_emissao"));
            ctr_conta_recebeT.setCtr_dt_vencimento(rs.getDate("ctr_dt_vencimento"));
            ctr_conta_recebeT.setFop_nr_id(rs.getInt("fop_nr_id"));
            ctr_conta_recebeT.setCtr_tx_pago(rs.getString("ctr_tx_pago"));
            ctr_conta_recebeT.setBan_nr_id(rs.getInt("ban_nr_id"));
            ctr_conta_recebeT.setCtr_valor(rs.getDouble("ctr_valor"));
            ctr_conta_recebeT.setCtr_tx_parcela(rs.getString("ctr_tx_parcela"));
            ctr_conta_recebeT.setCtr_dt_pagamento(rs.getDate("ctr_dt_pagamento"));
            ctr_conta_recebeT.setCar_nr_id(rs.getInt("car_nr_id"));
            ctr_conta_recebeT.setCtr_vl_pago(rs.getDouble("ctr_vl_pago"));
            ctr_conta_recebeT.setCtr_saldo(rs.getDouble("ctr_saldo"));
            ctr_conta_recebeT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            ctr_conta_recebeT.setCtr_tx_obs(rs.getString("ctr_tx_obs"));
            ctr_conta_recebeT.setCtr_tx_tipo_vinculo(rs.getString("ctr_tx_tipo_vinculo"));
            ctr_conta_recebeT.setCtr_nr_id_vinculo(rs.getInt("ctr_nr_id_vinculo"));
            objs.add(ctr_conta_recebeT);
        }
        return objs;
    }

    public List<Ctr_conta_recebeT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Ctr_conta_recebeT> list = resultSetToObjectTransfer(rs);
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

    public List<Ctr_conta_recebeT> getByPK(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_nr_id());
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

    public List<Ctr_conta_recebeT> getByCtr_nr_id(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_nr_id());
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

    public List<Ctr_conta_recebeT> getByCli_nr_id(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  cli_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCli_nr_id());
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

    public List<Ctr_conta_recebeT> getByCtr_nr_doc(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_nr_doc = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_nr_doc());
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

    public List<Ctr_conta_recebeT> getByCtr_dt_emissao(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_dt_emissao = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(ctr_conta_recebeT.getCtr_dt_emissao().getTime());
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

    public List<Ctr_conta_recebeT> getByCtr_dt_vencimento(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_dt_vencimento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(ctr_conta_recebeT.getCtr_dt_vencimento().getTime());
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

    public List<Ctr_conta_recebeT> getByFop_nr_id(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  fop_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getFop_nr_id());
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

    public List<Ctr_conta_recebeT> getByCtr_tx_pago(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  Upper(ctr_tx_pago) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + ctr_conta_recebeT.getCtr_tx_pago() + '%');
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

    public List<Ctr_conta_recebeT> getByBan_nr_id(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ban_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getBan_nr_id());
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

    public List<Ctr_conta_recebeT> getByCtr_valor(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_valor = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_valor());
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

    public List<Ctr_conta_recebeT> getByCtr_tx_parcela(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  Upper(ctr_tx_parcela) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + ctr_conta_recebeT.getCtr_tx_parcela() + '%');
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

    public List<Ctr_conta_recebeT> getByCtr_dt_pagamento(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_dt_pagamento = ? ";
            pStmt = createPrepareStatment(sql);
            java.sql.Date dt1 = new java.sql.Date(ctr_conta_recebeT.getCtr_dt_pagamento().getTime());
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

    public List<Ctr_conta_recebeT> getByCar_nr_id(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  car_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCar_nr_id());
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

    public List<Ctr_conta_recebeT> getByCtr_vl_pago(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_vl_pago = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_vl_pago());
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

    public List<Ctr_conta_recebeT> getByCtr_saldo(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_saldo = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_saldo());
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

    public List<Ctr_conta_recebeT> getByLoj_nr_id(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getLoj_nr_id());
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

    public List<Ctr_conta_recebeT> getByCtr_tx_obs(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  Upper(ctr_tx_obs) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + ctr_conta_recebeT.getCtr_tx_obs() + '%');
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

    public List<Ctr_conta_recebeT> getByCtr_tx_tipo_vinculo(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_tx_tipo_vinculo = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_tx_tipo_vinculo());
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

    public List<Ctr_conta_recebeT> getByCtr_nr_id_vinculo(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where  ctr_nr_id_vinculo = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCtr_nr_id_vinculo());
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
    public List<Ctr_conta_recebeT> getByCli_cliente(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where cli_cliente.cli_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCli_nr_id());
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
    public List<Ctr_conta_recebeT> getByFop_forma_pagamento(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where fop_forma_pagamento.fop_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getFop_nr_id());
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
    public List<Ctr_conta_recebeT> getByBan_banco(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where ban_banco.ban_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getBan_nr_id());
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
    public List<Ctr_conta_recebeT> getByCar_cartao(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where car_cartao.car_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getCar_nr_id());
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
    public List<Ctr_conta_recebeT> getByLoj_loja(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.ctr_conta_recebe where loj_loja.loj_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, ctr_conta_recebeT.getLoj_nr_id());
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
