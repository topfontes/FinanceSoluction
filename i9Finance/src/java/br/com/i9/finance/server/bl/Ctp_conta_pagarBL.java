package br.com.i9.finance.server.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.i9.finance.client.util.Funcoes;
import br.com.jdragon.dao.cluster.DAOFactoryCluster;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

/**
 * Classe Criada Automaticamente pelo "EasyNet Generate JDragon"
 */
public class Ctp_conta_pagarBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Ctp_conta_pagarT ctp_conta_pagarT, Usu_usuarioT usu_usuarioT) throws Exception {
        DAOFactoryCluster cluster = null;
        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            cluster = ctp_conta_pagarDAO.getdAOFactoryCluster();
            cluster.beginTransaction();
            ctp_conta_pagarT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
            ctp_conta_pagarT.setCtp_nr_id(getIncCtp_conta_pagar());

            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);

            if (ctp_conta_pagarT.getList() != null) {
                for (Ccp_conta_ct_pagarT ccp_conta_ct_pagarT : ctp_conta_pagarT.getList()) {
                    ccp_conta_ct_pagarT.setCcp_nr_id(getIncCcp_conta_ct_pagar());
                    ccp_conta_ct_pagarT.setCtp_nr_id(ctp_conta_pagarT.getCtp_nr_id());
                    getCcp_conta_ct_pagarDAO().insert(ccp_conta_ct_pagarT);
                }
            }

            cluster.commitTransaction();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Ctp_conta_pagar"));
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Ctp_conta_pagarT> consult() throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            return ctp_conta_pagarDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

    }

    /**
     * Deletar um registro
     */
    public boolean delete(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(ctp_conta_pagarT)) {
                Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
                ctp_conta_pagarDAO.delete(ctp_conta_pagarT);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Verifica se o objeto existe na base
     */
    public boolean exist(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

    }

    /**
     * Realiza uma alterac�o na tabela
     */
    public boolean update(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        DAOFactoryCluster cluster = null;
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(ctp_conta_pagarT)) {
                Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
                cluster = ctp_conta_pagarDAO.getdAOFactoryCluster();
                ctp_conta_pagarDAO.update(ctp_conta_pagarT);

                List<Ccp_conta_ct_pagarT> list = getCcp_conta_ct_pagarDAO().getByCtp_conta_pagar(ctp_conta_pagarT);
                if (list.size() == 0) {
                    if (ctp_conta_pagarT.getList() != null) {
                        getCcp_conta_ct_pagarDAO().delete(ctp_conta_pagarT);
                        for (Ccp_conta_ct_pagarT ccp_conta_ct_pagarT : ctp_conta_pagarT.getList()) {
                            ccp_conta_ct_pagarT.setCcp_nr_id(getIncCcp_conta_ct_pagar());
                            ccp_conta_ct_pagarT.setCtp_nr_id(ctp_conta_pagarT.getCtp_nr_id());
                            getCcp_conta_ct_pagarDAO().insert(ccp_conta_ct_pagarT);
                        }
                    }
                }
                cluster.commitTransaction();
                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public boolean updateBaixa(Ctp_conta_pagarT ctp_conta_pagarT, int conta_credora, Usu_usuarioT usu_usuarioT) throws Exception {
        DAOFactoryCluster cluster = null;
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(ctp_conta_pagarT)) {

                Ctp_conta_pagarT ctpFInd = getCtp_conta_pagarDAO().getByCtp_nr_id(ctp_conta_pagarT).get(0);
                double Valor_parcela = ctpFInd.getCtp_valor();

                Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
                cluster = ctp_conta_pagarDAO.getdAOFactoryCluster();
                cluster.beginTransaction();

                double valorPago = getLan_lancamentoDAO().getByLanContaPagar(ctp_conta_pagarT) + ctp_conta_pagarT.getCtp_vl_pago();

                String strValorPago = Funcoes.formatoMoedaDouble(valorPago);
                String strValorAPagar = Funcoes.formatoMoedaDouble(Valor_parcela);

                double percentualPago = 100;
                if (strValorAPagar.equalsIgnoreCase(strValorPago)) {
                    ctp_conta_pagarT.setCtp_tx_pago("T");
                } else {
                    ctp_conta_pagarT.setCtp_tx_pago("F");
                    percentualPago = 100 - ((Valor_parcela - ctp_conta_pagarT.getCtp_vl_pago()) * 100) / Valor_parcela;
                }

                setBaixa(ctp_conta_pagarDAO, ctp_conta_pagarT);

                List<Ccp_conta_ct_pagarT> list = getCcp_conta_ct_pagarDAO().getByCtp_conta_pagar(ctp_conta_pagarT);
                Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();

                lan_lancamentoT.setCtp_nr_id(ctp_conta_pagarT.getCtp_nr_id());
                lan_lancamentoT.setLan_dt_lancamento(ctp_conta_pagarT.getCtp_dt_pagamento());
                lan_lancamentoT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
                lan_lancamentoT.setLan_plc_nr_id_cred(conta_credora);
                for (Ccp_conta_ct_pagarT ccpT : list) {
                    lan_lancamentoT.setLan_nr_id(getIncLan_lancamento());
                    lan_lancamentoT.setLan_valor(ccpT.getCcp_valor() * percentualPago / 100);
                    lan_lancamentoT.setLan_plc_nr_id_deb(ccpT.getPlc_nr_id());
                    getLan_lancamentoDAO().insert(lan_lancamentoT);
                }

                cluster.commitTransaction();

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            cluster.rollbackTransaction();
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public void setBaixa(Ctp_conta_pagarDAO ctp_conta_pagarDAO, Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {

        ctp_conta_pagarDAO.updateBaixa(ctp_conta_pagarT);
    }

    /**
     * Obt�m os dados de um registro
     */
    public Ctp_conta_pagarT findbyid(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            Ctp_conta_pagarT ct = listTemp.size() > 0 ? listTemp.get(0) : new Ctp_conta_pagarT();

            if (ct.getCtp_nr_id() > 0) {
                ct.setList(getCcp_conta_ct_pagarDAO().getByCtp_conta_pagar(ct));
            }

            return ct;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

}
