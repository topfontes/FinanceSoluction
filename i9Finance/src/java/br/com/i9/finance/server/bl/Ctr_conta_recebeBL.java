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
public class Ctr_conta_recebeBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Ctr_conta_recebeT ctr_conta_recebeT, Usu_usuarioT usu_usuarioT) throws Exception {
        DAOFactoryCluster cluster = null;
        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            Ctr_conta_recebeDAO ctr_conta_recebeDAO = getCtr_conta_recebeDAO();
            cluster = ctr_conta_recebeDAO.getdAOFactoryCluster();
            cluster.beginTransaction();
            ctr_conta_recebeT.setCtr_nr_id(getIncCtr_conta_recebe());
            ctr_conta_recebeT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
            ctr_conta_recebeDAO.insert(ctr_conta_recebeT);

            for (Ccr_conta_ct_receberT ccr_conta_ct_receberT : ctr_conta_recebeT.getListContas()) {
                ccr_conta_ct_receberT.setCcr_nr_id(getIncCcr_conta_ct_receber());
                ccr_conta_ct_receberT.setCtr_nr_id(ctr_conta_recebeT.getCtr_nr_id());
                getCcr_conta_ct_receberDAO().insert(ccr_conta_ct_receberT);
            }
            cluster.commitTransaction();
            return true;
        } catch (Exception e) {
            cluster.rollbackTransaction();
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Ctr_conta_recebe"));
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Ctr_conta_recebeT> consult() throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Ctr_conta_recebeDAO ctr_conta_recebeDAO = getCtr_conta_recebeDAO();
            return ctr_conta_recebeDAO.getAll();
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
    public boolean delete(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(ctr_conta_recebeT)) {
                Ctr_conta_recebeDAO ctr_conta_recebeDAO = getCtr_conta_recebeDAO();
                ctr_conta_recebeDAO.delete(ctr_conta_recebeT);
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
    public boolean exist(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        try {
            Ctr_conta_recebeDAO ctr_conta_recebeDAO = getCtr_conta_recebeDAO();
            List<Ctr_conta_recebeT> listTemp = ctr_conta_recebeDAO.getByPK(ctr_conta_recebeT);

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
    public boolean update(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(ctr_conta_recebeT)) {
                Ctr_conta_recebeDAO ctr_conta_recebeDAO = getCtr_conta_recebeDAO();
                ctr_conta_recebeDAO.update(ctr_conta_recebeT);
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

    public boolean updateBaixa(Ctr_conta_recebeT ctr_conta_recebeT, int conta_credora, Usu_usuarioT usu_usuarioT) throws Exception {
        DAOFactoryCluster cluster = null;
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(ctr_conta_recebeT)) {

                Ctr_conta_recebeT ctrFInd = getCtr_conta_recebeDAO().getByCtr_nr_id(ctr_conta_recebeT).get(0);
                double Valor_parcela = ctrFInd.getCtr_valor();
                
                Ctr_conta_recebeDAO ctr_conta_recebeDAO = getCtr_conta_recebeDAO();
                cluster = ctr_conta_recebeDAO.getdAOFactoryCluster();
                cluster.beginTransaction();

                double valorPago = getLan_lancamentoDAO().getByLanContaReceber(ctr_conta_recebeT) + ctr_conta_recebeT.getCtr_vl_pago();
                
                String strValorPago = Funcoes.formatoMoedaDouble(valorPago);
                String strValorAPagar = Funcoes.formatoMoedaDouble(Valor_parcela);
                
                double percentualPago = 100;
                if (strValorAPagar.equalsIgnoreCase(strValorPago)) {
                    ctr_conta_recebeT.setCtr_tx_pago("T");
                } else {
                    ctr_conta_recebeT.setCtr_tx_pago("F");
                    percentualPago = 100 - ((Valor_parcela - ctr_conta_recebeT.getCtr_vl_pago()) * 100) / Valor_parcela;
                }

                ctr_conta_recebeDAO.updateBaixa(ctr_conta_recebeT);

                List<Ccr_conta_ct_receberT> list = getCcr_conta_ct_receberDAO().getByCtr_conta_recebe(ctr_conta_recebeT);
                Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();
                lan_lancamentoT.setLan_nr_id(getIncLan_lancamento());
                lan_lancamentoT.setCtr_nr_id(ctr_conta_recebeT.getCtr_nr_id());
                lan_lancamentoT.setLan_dt_lancamento(ctr_conta_recebeT.getCtr_dt_pagamento());
                lan_lancamentoT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
                lan_lancamentoT.setLan_plc_nr_id_deb(conta_credora);
                for (Ccr_conta_ct_receberT ccrT : list) {
                    lan_lancamentoT.setLan_valor(ccrT.getCcr_valor() * percentualPago / 100);
                    lan_lancamentoT.setLan_plc_nr_id_cred(ccrT.getPlc_nr_id());
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

    /**
     * Obt�m os dados de um registro
     */
    public Ctr_conta_recebeT findbyid(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        try {
            Ctr_conta_recebeDAO ctr_conta_recebeDAO = getCtr_conta_recebeDAO();
            List<Ctr_conta_recebeT> listTemp = ctr_conta_recebeDAO.getByPK(ctr_conta_recebeT);
            Ctr_conta_recebeT ct = listTemp.size() > 0 ? listTemp.get(0) : new Ctr_conta_recebeT();

            if (ct.getCtr_nr_id() > 0) {
                ct.setListContas(getCcr_conta_ct_receberDAO().getByCtr_conta_recebe(ct));
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
