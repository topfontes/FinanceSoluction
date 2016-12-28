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
public class Fop_forma_pagamentoBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {

        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
            fop_forma_pagamentoT.setFop_nr_id(getIncFop_forma_pagamento());
            fop_forma_pagamentoDAO.insert(fop_forma_pagamentoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Fop_forma_pagamento"));
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Fop_forma_pagamentoT> consult(Usu_usuarioT usu_usuarioT) throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
            return fop_forma_pagamentoDAO.getAll(getIdLojaUsuarioLogado(usu_usuarioT));
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
    public boolean delete(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(fop_forma_pagamentoT)) {
                Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
                fop_forma_pagamentoDAO.delete(fop_forma_pagamentoT);
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
    public boolean exist(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        try {
            Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
            List<Fop_forma_pagamentoT> listTemp = fop_forma_pagamentoDAO.getByPK(fop_forma_pagamentoT);

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
    public boolean update(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(fop_forma_pagamentoT)) {
                Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
                fop_forma_pagamentoDAO.update(fop_forma_pagamentoT);
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
    public Fop_forma_pagamentoT findbyid(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        try {
            Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();
            List<Fop_forma_pagamentoT> listTemp = fop_forma_pagamentoDAO.getByPK(fop_forma_pagamentoT);
            return listTemp.size() > 0 ? listTemp.get(0) : new Fop_forma_pagamentoT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

}
