package br.com.i9.finance.server.bl;

import br.com.easynet.easyportal.bl.EasyPortalBusinessBase;
import br.com.easynet.database.ConnectionRPL;
import br.com.easynet.easyportal.cluster.ConfigI9Cluster;
import br.com.easynet.easyportal.transfer.Par_parametroT;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import java.util.Date;
import java.util.List;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

public class SystemBusinessBase extends EasyPortalBusinessBase {

    public static final String SISTEMA_i9finance = "I9FINANCE";
    public static String filei9financeCluster = "/i9financecluster.xml";
    private int typeDatabase = DAOFactory.POSTGRESQL;
    private String url = "jdbc:postgresql://127.0.0.1:5432/i9fin";
    private String user = "postgres";
    private String pass = "postgres";

    private DAOFactoryCluster dao;
    private static I9Cluster i9Cluster = null;
    private Usu_usuarioT usu_usuarioT = new Usu_usuarioT();

    //private String datasourceName = "java:comp/env/jdbc/i9financeds1";
    private String datasourceName = "jdbc/i9financeds1";

    public DAOFactoryCluster getDAO() throws Exception {
        if (dao == null) {
            if (i9Cluster == null) {
                String path = ConfigI9Cluster.REAL_PATH_BASE + filei9financeCluster;
                i9Cluster = I9Cluster.getI9Cluster(path);
            }
            List<DefinitionConnectionCluster> list = i9Cluster.getListConnectionClusters();
            dao = new DAOFactoryCluster();
            for (int i = 0; i < list.size(); i++) {
                DefinitionConnectionCluster dcc = list.get(i);
                dao.addConnectionRPL(getConnectionRpl(dcc.getName(), dcc.getDatasourceName()));
            }
        }
        return dao;
    }
    
        public String getParametro(String nomeParam) throws Exception {
        Par_parametroT parT = getParametro(SISTEMA_i9finance, nomeParam);
        return parT != null ? parT.getPar_tx_valor() : null;
    }    
    

    public java.sql.Date convertDateForSql(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public int getIdLojaUsuarioLogado(Usu_usuarioT usu_usuarioT) {
        try {
            Usu_loj_usuario_lojaT usu_loj_usuario_lojaT = new Usu_loj_usuario_lojaT();
            usu_loj_usuario_lojaT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
            usu_loj_usuario_lojaT = getUsu_loj_usuario_lojaDAO().getByUsu_nr_id(usu_loj_usuario_lojaT).get(0);
            return usu_loj_usuario_lojaT.getLoj_nr_id();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Obtem a conexao para o I9Cluster
     *
     * @param nameConnection
     * @param datasourceName
     * @return
     */
    public ConnectionRPL getConnectionRpl(String nameConnection, String datasourceName) {
        try {
            ConnectionRPL conRPL = new ConnectionRPL();
            conRPL.setPathLog(PATH_LOG_CLUSTER);
            conRPL.setNome(nameConnection); 
            conRPL.setCon(getDAODatasource(datasourceName));
            conRPL.recoverLog();
            return conRPL;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        try {
            if (dao != null) {
                dao.close();
                dao = null;
            }
            //i9Cluster = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeDatasourceEasyPortal();
        }
    }

    /**
     * Método para validar a seguranca
     */
    public boolean valide(String metodo) throws Exception {
        // Logica da seguranca
        return true;
    }

    public int getIncBan_banco() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "ban_banco", "ban_nr_id");
    }

    public int getIncCar_cartao() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "car_cartao", "car_nr_id");
    }

    public int getIncCcp_conta_ct_pagar() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "ccp_conta_ct_pagar", "ccp_nr_id");
    }

    public int getIncCcr_conta_ct_receber() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "ccr_conta_ct_receber", "ccr_nr_id");
    }

    public int getIncCen_centro_custo() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "cen_centro_custo", "cen_nr_id");
    }

    public int getIncCli_cliente() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "cli_cliente", "cli_nr_id");
    }

    public int getIncConf_configuracao() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "conf_configuracao", "conf_nr_id");
    }

    public int getIncCtp_conta_pagar() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "ctp_conta_pagar", "ctp_nr_id");
    }

    public int getIncCtr_conta_recebe() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "ctr_conta_recebe", "ctr_nr_id");
    }

    public int getIncCucp_custo_conta_pagar() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "cucp_custo_conta_pagar", "cucp_nr_id");
    }

    public int getIncFop_forma_pagamento() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "fop_forma_pagamento", "fop_nr_id");
    }

    public int getIncFor_fornecedor() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "for_fornecedor", "for_nr_id");
    }

    public int getIncFpar_forma_parcela() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "fpar_forma_parcela", "fpar_nr_id");
    }

    public int getIncInt_intervalo_parcelamento() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "int_intervalo_parcelamento", "int_nr_id");
    }

    public int getIncLan_lancamento() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "lan_lancamento", "lan_nr_id");
    }

    public int getIncLcc_lancamento_centro_custo() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "lcc_lancamento_centro_custo", "lcc_nr_id");
    }

    public int getIncLoj_loja() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "loj_loja", "loj_nr_id");
    }

    public int getIncPar_parcelamento() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "par_parcelamento", "par_nr_id");
    }

    public int getIncPlc_plano_contas() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "plc_plano_contas", "plc_nr_id");
    }

    public int getIncPor_previsao_orcamento() throws Exception {
        return getAutoIncremento(SISTEMA_i9finance, "por_previsao_orcamento", "por_nr_id");
    }

    public Ban_bancoDAO getBan_bancoDAO() throws Exception {
        dao = getDAO();
        return new Ban_bancoDAO(dao);
    }

    public Car_cartaoDAO getCar_cartaoDAO() throws Exception {
        dao = getDAO();
        return new Car_cartaoDAO(dao);
    }

    public Ccp_conta_ct_pagarDAO getCcp_conta_ct_pagarDAO() throws Exception {
        dao = getDAO();
        return new Ccp_conta_ct_pagarDAO(dao);
    }

    public Ccr_conta_ct_receberDAO getCcr_conta_ct_receberDAO() throws Exception {
        dao = getDAO();
        return new Ccr_conta_ct_receberDAO(dao);
    }

    public Cen_centro_custoDAO getCen_centro_custoDAO() throws Exception {
        dao = getDAO();
        return new Cen_centro_custoDAO(dao);
    }

    public Cli_clienteDAO getCli_clienteDAO() throws Exception {
        dao = getDAO();
        return new Cli_clienteDAO(dao);
    }

    public Conf_configuracaoDAO getConf_configuracaoDAO() throws Exception {
        dao = getDAO();
        return new Conf_configuracaoDAO(dao);
    }

    public Ctp_conta_pagarDAO getCtp_conta_pagarDAO() throws Exception {
        dao = getDAO();
        return new Ctp_conta_pagarDAO(dao);
    }

    public Ctr_conta_recebeDAO getCtr_conta_recebeDAO() throws Exception {
        dao = getDAO();
        return new Ctr_conta_recebeDAO(dao);
    }

    public Cucp_custo_conta_pagarDAO getCucp_custo_conta_pagarDAO() throws Exception {
        dao = getDAO();
        return new Cucp_custo_conta_pagarDAO(dao);
    }

    public Fop_forma_pagamentoDAO getFop_forma_pagamentoDAO() throws Exception {
        dao = getDAO();
        return new Fop_forma_pagamentoDAO(dao);
    }

    public For_fornecedorDAO getFor_fornecedorDAO() throws Exception {
        dao = getDAO();
        return new For_fornecedorDAO(dao);
    }

    public Fpar_forma_parcelaDAO getFpar_forma_parcelaDAO() throws Exception {
        dao = getDAO();
        return new Fpar_forma_parcelaDAO(dao);
    }

    public Int_intervalo_parcelamentoDAO getInt_intervalo_parcelamentoDAO() throws Exception {
        dao = getDAO();
        return new Int_intervalo_parcelamentoDAO(dao);
    }

    public Lan_lancamentoDAO getLan_lancamentoDAO() throws Exception {
        dao = getDAO();
        return new Lan_lancamentoDAO(dao);
    }

    public Lcc_lancamento_centro_custoDAO getLcc_lancamento_centro_custoDAO() throws Exception {
        dao = getDAO();
        return new Lcc_lancamento_centro_custoDAO(dao);
    }

    public Loj_lojaDAO getLoj_lojaDAO() throws Exception {
        dao = getDAO();
        return new Loj_lojaDAO(dao);
    }

    public Par_parcelamentoDAO getPar_parcelamentoDAO() throws Exception {
        dao = getDAO();
        return new Par_parcelamentoDAO(dao);
    }

    public Plc_plano_contasDAO getPlc_plano_contasDAO() throws Exception {
        dao = getDAO();
        return new Plc_plano_contasDAO(dao);
    }

    public Por_previsao_orcamentoDAO getPor_previsao_orcamentoDAO() throws Exception {
        dao = getDAO();
        return new Por_previsao_orcamentoDAO(dao);
    }

    public Usu_loj_usuario_lojaDAO getUsu_loj_usuario_lojaDAO() throws Exception {
        dao = getDAO();
        return new Usu_loj_usuario_lojaDAO(dao);
    }

    public V_conta_pagarDAO getV_conta_pagarDAO() throws Exception {
        dao = getDAO();
        return new V_conta_pagarDAO(dao);
    }

    public V_conta_pagar_contaDAO getV_conta_pagar_contaDAO() throws Exception {
        dao = getDAO();
        return new V_conta_pagar_contaDAO(dao);
    }

    public V_conta_pagar_pagoDAO getV_conta_pagar_pagoDAO() throws Exception {
        dao = getDAO();
        return new V_conta_pagar_pagoDAO(dao);
    }

    public V_conta_pagar_pago_contaDAO getV_conta_pagar_pago_contaDAO() throws Exception {
        dao = getDAO();
        return new V_conta_pagar_pago_contaDAO(dao);
    }

    public V_conta_receberDAO getV_conta_receberDAO() throws Exception {
        dao = getDAO();
        return new V_conta_receberDAO(dao);
    }

    public V_conta_receber_contaDAO getV_conta_receber_contaDAO() throws Exception {
        dao = getDAO();
        return new V_conta_receber_contaDAO(dao);
    }

    public V_conta_receber_pagoDAO getV_conta_receber_pagoDAO() throws Exception {
        dao = getDAO();
        return new V_conta_receber_pagoDAO(dao);
    }

    public V_conta_receber_pago_contaDAO getV_conta_receber_pago_contaDAO() throws Exception {
        dao = getDAO();
        return new V_conta_receber_pago_contaDAO(dao);
    }

    public V_lan_centro_custoDAO getV_lan_centro_custoDAO() throws Exception {
        dao = getDAO();
        return new V_lan_centro_custoDAO(dao);
    }

    public V_lancamentosDAO getV_lancamentosDAO() throws Exception {
        dao = getDAO();
        return new V_lancamentosDAO(dao);
    }

    public Ban_bancoT findbyIdBan_banco(Ban_bancoT ban_bancoT) throws Exception {
        try {
            Ban_bancoDAO ban_bancoDAO = getBan_bancoDAO();

            List<Ban_bancoT> listTemp = ban_bancoDAO.getByPK(ban_bancoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Car_cartaoT findbyIdCar_cartao(Car_cartaoT car_cartaoT) throws Exception {
        try {
            Car_cartaoDAO car_cartaoDAO = getCar_cartaoDAO();

            List<Car_cartaoT> listTemp = car_cartaoDAO.getByPK(car_cartaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ccp_conta_ct_pagarT findbyIdCcp_conta_ct_pagar(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
        try {
            Ccp_conta_ct_pagarDAO ccp_conta_ct_pagarDAO = getCcp_conta_ct_pagarDAO();

            List<Ccp_conta_ct_pagarT> listTemp = ccp_conta_ct_pagarDAO.getByPK(ccp_conta_ct_pagarT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ccr_conta_ct_receberT findbyIdCcr_conta_ct_receber(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
        try {
            Ccr_conta_ct_receberDAO ccr_conta_ct_receberDAO = getCcr_conta_ct_receberDAO();

            List<Ccr_conta_ct_receberT> listTemp = ccr_conta_ct_receberDAO.getByPK(ccr_conta_ct_receberT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cen_centro_custoT findbyIdCen_centro_custo(Cen_centro_custoT cen_centro_custoT) throws Exception {
        try {
            Cen_centro_custoDAO cen_centro_custoDAO = getCen_centro_custoDAO();

            List<Cen_centro_custoT> listTemp = cen_centro_custoDAO.getByPK(cen_centro_custoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cli_clienteT findbyIdCli_cliente(Cli_clienteT cli_clienteT) throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();

            List<Cli_clienteT> listTemp = cli_clienteDAO.getByPK(cli_clienteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Conf_configuracaoT findbyIdConf_configuracao(Conf_configuracaoT conf_configuracaoT) throws Exception {
        try {
            Conf_configuracaoDAO conf_configuracaoDAO = getConf_configuracaoDAO();

            List<Conf_configuracaoT> listTemp = conf_configuracaoDAO.getByPK(conf_configuracaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ctp_conta_pagarT findbyIdCtp_conta_pagar(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();

            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ctr_conta_recebeT findbyIdCtr_conta_recebe(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        try {
            Ctr_conta_recebeDAO ctr_conta_recebeDAO = getCtr_conta_recebeDAO();

            List<Ctr_conta_recebeT> listTemp = ctr_conta_recebeDAO.getByPK(ctr_conta_recebeT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cucp_custo_conta_pagarT findbyIdCucp_custo_conta_pagar(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
        try {
            Cucp_custo_conta_pagarDAO cucp_custo_conta_pagarDAO = getCucp_custo_conta_pagarDAO();

            List<Cucp_custo_conta_pagarT> listTemp = cucp_custo_conta_pagarDAO.getByPK(cucp_custo_conta_pagarT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Fop_forma_pagamentoT findbyIdFop_forma_pagamento(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        try {
            Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();

            List<Fop_forma_pagamentoT> listTemp = fop_forma_pagamentoDAO.getByPK(fop_forma_pagamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public For_fornecedorT findbyIdFor_fornecedor(For_fornecedorT for_fornecedorT) throws Exception {
        try {
            For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();

            List<For_fornecedorT> listTemp = for_fornecedorDAO.getByPK(for_fornecedorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Fpar_forma_parcelaT findbyIdFpar_forma_parcela(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
        try {
            Fpar_forma_parcelaDAO fpar_forma_parcelaDAO = getFpar_forma_parcelaDAO();

            List<Fpar_forma_parcelaT> listTemp = fpar_forma_parcelaDAO.getByPK(fpar_forma_parcelaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Int_intervalo_parcelamentoT findbyIdInt_intervalo_parcelamento(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
        try {
            Int_intervalo_parcelamentoDAO int_intervalo_parcelamentoDAO = getInt_intervalo_parcelamentoDAO();

            List<Int_intervalo_parcelamentoT> listTemp = int_intervalo_parcelamentoDAO.getByPK(int_intervalo_parcelamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Lan_lancamentoT findbyIdLan_lancamento(Lan_lancamentoT lan_lancamentoT) throws Exception {
        try {
            Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();

            List<Lan_lancamentoT> listTemp = lan_lancamentoDAO.getByPK(lan_lancamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Lcc_lancamento_centro_custoT findbyIdLcc_lancamento_centro_custo(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
        try {
            Lcc_lancamento_centro_custoDAO lcc_lancamento_centro_custoDAO = getLcc_lancamento_centro_custoDAO();

            List<Lcc_lancamento_centro_custoT> listTemp = lcc_lancamento_centro_custoDAO.getByPK(lcc_lancamento_centro_custoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Loj_lojaT findbyIdLoj_loja(Loj_lojaT loj_lojaT) throws Exception {
        try {
            Loj_lojaDAO loj_lojaDAO = getLoj_lojaDAO();

            List<Loj_lojaT> listTemp = loj_lojaDAO.getByPK(loj_lojaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Par_parcelamentoT findbyIdPar_parcelamento(Par_parcelamentoT par_parcelamentoT) throws Exception {
        try {
            Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();

            List<Par_parcelamentoT> listTemp = par_parcelamentoDAO.getByPK(par_parcelamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Plc_plano_contasT findbyIdPlc_plano_contas(Plc_plano_contasT plc_plano_contasT) throws Exception {
        try {
            Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();

            List<Plc_plano_contasT> listTemp = plc_plano_contasDAO.getByPK(plc_plano_contasT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Por_previsao_orcamentoT findbyIdPor_previsao_orcamento(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        try {
            Por_previsao_orcamentoDAO por_previsao_orcamentoDAO = getPor_previsao_orcamentoDAO();

            List<Por_previsao_orcamentoT> listTemp = por_previsao_orcamentoDAO.getByPK(por_previsao_orcamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Usu_loj_usuario_lojaT findbyIdUsu_loj_usuario_loja(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
        try {
            Usu_loj_usuario_lojaDAO usu_loj_usuario_lojaDAO = getUsu_loj_usuario_lojaDAO();

            List<Usu_loj_usuario_lojaT> listTemp = usu_loj_usuario_lojaDAO.getByPK(usu_loj_usuario_lojaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_conta_pagarT findbyIdV_conta_pagar(V_conta_pagarT v_conta_pagarT) throws Exception {
        try {
            V_conta_pagarDAO v_conta_pagarDAO = getV_conta_pagarDAO();

            List<V_conta_pagarT> listTemp = v_conta_pagarDAO.getByPK(v_conta_pagarT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_conta_pagar_contaT findbyIdV_conta_pagar_conta(V_conta_pagar_contaT v_conta_pagar_contaT) throws Exception {
        try {
            V_conta_pagar_contaDAO v_conta_pagar_contaDAO = getV_conta_pagar_contaDAO();

            List<V_conta_pagar_contaT> listTemp = v_conta_pagar_contaDAO.getByPK(v_conta_pagar_contaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_conta_pagar_pagoT findbyIdV_conta_pagar_pago(V_conta_pagar_pagoT v_conta_pagar_pagoT) throws Exception {
        try {
            V_conta_pagar_pagoDAO v_conta_pagar_pagoDAO = getV_conta_pagar_pagoDAO();

            List<V_conta_pagar_pagoT> listTemp = v_conta_pagar_pagoDAO.getByPK(v_conta_pagar_pagoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_conta_pagar_pago_contaT findbyIdV_conta_pagar_pago_conta(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception {
        try {
            V_conta_pagar_pago_contaDAO v_conta_pagar_pago_contaDAO = getV_conta_pagar_pago_contaDAO();

            List<V_conta_pagar_pago_contaT> listTemp = v_conta_pagar_pago_contaDAO.getByPK(v_conta_pagar_pago_contaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_conta_receberT findbyIdV_conta_receber(V_conta_receberT v_conta_receberT) throws Exception {
        try {
            V_conta_receberDAO v_conta_receberDAO = getV_conta_receberDAO();

            List<V_conta_receberT> listTemp = v_conta_receberDAO.getByPK(v_conta_receberT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_conta_receber_contaT findbyIdV_conta_receber_conta(V_conta_receber_contaT v_conta_receber_contaT) throws Exception {
        try {
            V_conta_receber_contaDAO v_conta_receber_contaDAO = getV_conta_receber_contaDAO();

            List<V_conta_receber_contaT> listTemp = v_conta_receber_contaDAO.getByPK(v_conta_receber_contaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_conta_receber_pagoT findbyIdV_conta_receber_pago(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception {
        try {
            V_conta_receber_pagoDAO v_conta_receber_pagoDAO = getV_conta_receber_pagoDAO();

            List<V_conta_receber_pagoT> listTemp = v_conta_receber_pagoDAO.getByPK(v_conta_receber_pagoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_conta_receber_pago_contaT findbyIdV_conta_receber_pago_conta(V_conta_receber_pago_contaT v_conta_receber_pago_contaT) throws Exception {
        try {
            V_conta_receber_pago_contaDAO v_conta_receber_pago_contaDAO = getV_conta_receber_pago_contaDAO();

            List<V_conta_receber_pago_contaT> listTemp = v_conta_receber_pago_contaDAO.getByPK(v_conta_receber_pago_contaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_lan_centro_custoT findbyIdV_lan_centro_custo(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
        try {
            V_lan_centro_custoDAO v_lan_centro_custoDAO = getV_lan_centro_custoDAO();

            List<V_lan_centro_custoT> listTemp = v_lan_centro_custoDAO.getByPK(v_lan_centro_custoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public V_lancamentosT findbyIdV_lancamentos(V_lancamentosT v_lancamentosT) throws Exception {
        try {
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();

            List<V_lancamentosT> listTemp = v_lancamentosDAO.getByPK(v_lancamentosT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    /**
     * @return the usu_usuarioT
     */
    public Usu_usuarioT getUsu_usuarioT() {
        return usu_usuarioT;
    }

    /**
     * @param usu_usuarioT the usu_usuarioT to set
     */
    public void setUsu_usuarioT(Usu_usuarioT usu_usuarioT) {
        this.usu_usuarioT = usu_usuarioT;
    }

}
