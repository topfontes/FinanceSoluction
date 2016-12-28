package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Conf_configuracaoDAO extends ObjectDAOCluster {

    public Conf_configuracaoDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.conf_configuracao  ( conf_plc_nr_id_juros_recebido, conf_plc_nr_id_desconto_consedido, conf_plc_nr_id_desconto_recebido, loj_nr_id, conf_plc_nr_id_taxa_cartao, conf_tx_lancamento_auto_taxa_cartao, conf_plc_nr_id_juros_consedido, conf_tx_baixa_cartao_automatico, conf_plc_nr_id_default, conf_plc_nr_id_caixa, conf_tx_lan_auto_conta_vinc_ctr, conf_tx_lan_auto_conta_vinc_ctp) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_juros_recebido());
            pStmt.setObject(2, conf_configuracaoT.getConf_plc_nr_id_desconto_consedido());
            pStmt.setObject(3, conf_configuracaoT.getConf_plc_nr_id_desconto_recebido());
            pStmt.setObject(4, conf_configuracaoT.getLoj_nr_id());
            pStmt.setObject(5, conf_configuracaoT.getConf_plc_nr_id_taxa_cartao());
            pStmt.setObject(6, conf_configuracaoT.getConf_tx_lancamento_auto_taxa_cartao());
            pStmt.setObject(7, conf_configuracaoT.getConf_plc_nr_id_juros_consedido());
            pStmt.setObject(8, conf_configuracaoT.getConf_tx_baixa_cartao_automatico());
            pStmt.setObject(9, conf_configuracaoT.getConf_plc_nr_id_default());
            pStmt.setObject(10, conf_configuracaoT.getConf_plc_nr_id_caixa());
            pStmt.setObject(11, conf_configuracaoT.getConf_tx_lan_auto_conta_vinc_ctr());
            pStmt.setObject(12, conf_configuracaoT.getConf_tx_lan_auto_conta_vinc_ctp());
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

    public void update(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.conf_configuracao set  conf_plc_nr_id_juros_recebido=?, conf_plc_nr_id_desconto_consedido=?, conf_plc_nr_id_desconto_recebido=?, loj_nr_id=?, conf_plc_nr_id_taxa_cartao=?, conf_tx_lancamento_auto_taxa_cartao=?, conf_plc_nr_id_juros_consedido=?, conf_tx_baixa_cartao_automatico=?, conf_plc_nr_id_default=?, conf_plc_nr_id_caixa=?, conf_tx_lan_auto_conta_vinc_ctr=?, conf_tx_lan_auto_conta_vinc_ctp=?  where  conf_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_juros_recebido());
            pStmt.setObject(2, conf_configuracaoT.getConf_plc_nr_id_desconto_consedido());
            pStmt.setObject(3, conf_configuracaoT.getConf_plc_nr_id_desconto_recebido());
            pStmt.setObject(4, conf_configuracaoT.getLoj_nr_id());
            pStmt.setObject(5, conf_configuracaoT.getConf_plc_nr_id_taxa_cartao());
            pStmt.setObject(6, conf_configuracaoT.getConf_tx_lancamento_auto_taxa_cartao());
            pStmt.setObject(7, conf_configuracaoT.getConf_plc_nr_id_juros_consedido());
            pStmt.setObject(8, conf_configuracaoT.getConf_tx_baixa_cartao_automatico());
            pStmt.setObject(9, conf_configuracaoT.getConf_plc_nr_id_default());
            pStmt.setObject(10, conf_configuracaoT.getConf_plc_nr_id_caixa());
            pStmt.setObject(11, conf_configuracaoT.getConf_tx_lan_auto_conta_vinc_ctr());
            pStmt.setObject(12, conf_configuracaoT.getConf_tx_lan_auto_conta_vinc_ctp());
            pStmt.setObject(13, conf_configuracaoT.getConf_nr_id());
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

    public void delete(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.conf_configuracao where  conf_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_nr_id());
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

    private List<Conf_configuracaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Conf_configuracaoT> objs = new Vector();
        while (rs.next()) {
            Conf_configuracaoT conf_configuracaoT = new Conf_configuracaoT();
            conf_configuracaoT.setConf_plc_nr_id_juros_recebido(rs.getInt("conf_plc_nr_id_juros_recebido"));
            conf_configuracaoT.setConf_plc_nr_id_desconto_consedido(rs.getInt("conf_plc_nr_id_desconto_consedido"));
            conf_configuracaoT.setConf_plc_nr_id_desconto_recebido(rs.getInt("conf_plc_nr_id_desconto_recebido"));
            conf_configuracaoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            conf_configuracaoT.setConf_plc_nr_id_taxa_cartao(rs.getInt("conf_plc_nr_id_taxa_cartao"));
            conf_configuracaoT.setConf_tx_lancamento_auto_taxa_cartao(rs.getString("conf_tx_lancamento_auto_taxa_cartao"));
            conf_configuracaoT.setConf_plc_nr_id_juros_consedido(rs.getInt("conf_plc_nr_id_juros_consedido"));
            conf_configuracaoT.setConf_tx_baixa_cartao_automatico(rs.getString("conf_tx_baixa_cartao_automatico"));
            conf_configuracaoT.setConf_nr_id(rs.getInt("conf_nr_id"));
            conf_configuracaoT.setConf_plc_nr_id_default(rs.getInt("conf_plc_nr_id_default"));
            conf_configuracaoT.setConf_plc_nr_id_caixa(rs.getInt("conf_plc_nr_id_caixa"));
            conf_configuracaoT.setConf_tx_lan_auto_conta_vinc_ctr(rs.getString("conf_tx_lan_auto_conta_vinc_ctr"));
            conf_configuracaoT.setConf_tx_lan_auto_conta_vinc_ctp(rs.getString("conf_tx_lan_auto_conta_vinc_ctp"));
            objs.add(conf_configuracaoT);
        }
        return objs;
    }

    public List<Conf_configuracaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Conf_configuracaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Conf_configuracaoT> getByPK(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_nr_id());
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

    public List<Conf_configuracaoT> getByConf_plc_nr_id_juros_recebido(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_plc_nr_id_juros_recebido = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_juros_recebido());
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

    public List<Conf_configuracaoT> getByConf_plc_nr_id_desconto_consedido(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_plc_nr_id_desconto_consedido = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_desconto_consedido());
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

    public List<Conf_configuracaoT> getByConf_plc_nr_id_desconto_recebido(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_plc_nr_id_desconto_recebido = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_desconto_recebido());
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

    public List<Conf_configuracaoT> getByLoj_nr_id(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getLoj_nr_id());
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

    public List<Conf_configuracaoT> getByConf_plc_nr_id_taxa_cartao(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_plc_nr_id_taxa_cartao = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_taxa_cartao());
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

    public List<Conf_configuracaoT> getByConf_tx_lancamento_auto_taxa_cartao(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  Upper(conf_tx_lancamento_auto_taxa_cartao) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + conf_configuracaoT.getConf_tx_lancamento_auto_taxa_cartao() + '%');
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

    public List<Conf_configuracaoT> getByConf_plc_nr_id_juros_consedido(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_plc_nr_id_juros_consedido = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_juros_consedido());
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

    public List<Conf_configuracaoT> getByConf_tx_baixa_cartao_automatico(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  Upper(conf_tx_baixa_cartao_automatico) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + conf_configuracaoT.getConf_tx_baixa_cartao_automatico() + '%');
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

    public List<Conf_configuracaoT> getByConf_nr_id(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_nr_id());
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

    public List<Conf_configuracaoT> getByConf_plc_nr_id_default(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_plc_nr_id_default = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_default());
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

    public List<Conf_configuracaoT> getByConf_plc_nr_id_caixa(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_plc_nr_id_caixa = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_plc_nr_id_caixa());
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

    public List<Conf_configuracaoT> getByConf_tx_lan_auto_conta_vinc_ctr(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_tx_lan_auto_conta_vinc_ctr = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_tx_lan_auto_conta_vinc_ctr());
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

    public List<Conf_configuracaoT> getByConf_tx_lan_auto_conta_vinc_ctp(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where  conf_tx_lan_auto_conta_vinc_ctp = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getConf_tx_lan_auto_conta_vinc_ctp());
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
    public List<Conf_configuracaoT> getByLoj_loja(Conf_configuracaoT conf_configuracaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.conf_configuracao where loj_loja.loj_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, conf_configuracaoT.getLoj_nr_id());
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
