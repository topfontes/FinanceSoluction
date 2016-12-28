package br.com.i9.finance.server.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

/**
 * Classe Criada Automaticamente pelo "EasyNet Generate JDragon"
 */
public class Por_previsao_orcamentoBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Por_previsao_orcamentoT por_previsao_orcamentoT, Usu_usuarioT usu_usuarioT) throws Exception {

        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            Por_previsao_orcamentoDAO por_previsao_orcamentoDAO = getPor_previsao_orcamentoDAO();
            por_previsao_orcamentoT.setPor_nr_id(getIncPor_previsao_orcamento());
            por_previsao_orcamentoT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
            por_previsao_orcamentoDAO.insert(por_previsao_orcamentoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Por_previsao_orcamento"));
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Por_previsao_orcamentoT> consult(int ano, Usu_usuarioT usu_usuarioT) throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Por_previsao_orcamentoDAO por_previsao_orcamentoDAO = getPor_previsao_orcamentoDAO();
            return por_previsao_orcamentoDAO.getByPor_nr_ano(ano,getIdLojaUsuarioLogado(usu_usuarioT));
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
    public boolean delete(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(por_previsao_orcamentoT)) {
                Por_previsao_orcamentoDAO por_previsao_orcamentoDAO = getPor_previsao_orcamentoDAO();
                por_previsao_orcamentoDAO.delete(por_previsao_orcamentoT);
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
    public boolean exist(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        try {
            Por_previsao_orcamentoDAO por_previsao_orcamentoDAO = getPor_previsao_orcamentoDAO();
            List<Por_previsao_orcamentoT> listTemp = por_previsao_orcamentoDAO.getByPK(por_previsao_orcamentoT);

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
    public boolean update(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(por_previsao_orcamentoT)) {
                Por_previsao_orcamentoDAO por_previsao_orcamentoDAO = getPor_previsao_orcamentoDAO();
                por_previsao_orcamentoDAO.update(por_previsao_orcamentoT);
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
     * Obt�m os dados de um registro
     */
    public Por_previsao_orcamentoT findbyid(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        try {
            Por_previsao_orcamentoDAO por_previsao_orcamentoDAO = getPor_previsao_orcamentoDAO();
            List<Por_previsao_orcamentoT> listTemp = por_previsao_orcamentoDAO.getByPK(por_previsao_orcamentoT);
            return listTemp.size() > 0 ? listTemp.get(0) : new Por_previsao_orcamentoT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

}
