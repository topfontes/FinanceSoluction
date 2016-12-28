package br.com.i9.finance.server.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import java.util.ArrayList;
import java.util.Date;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

/**
 * Classe Criada Automaticamente pelo "EasyNet Generate JDragon"
 */
public class V_lancamentosBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(V_lancamentosT v_lancamentosT) throws Exception {

        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
            
            v_lancamentosDAO.insert(v_lancamentosT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("V_lancamentos"));
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<V_lancamentosT> consult(Date dt_inicio, Date dt_final, int plc_nr_id, Usu_usuarioT usu_usuarioT) throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
                                
            return v_lancamentosDAO.getAll(convertDateForSql(dt_inicio), convertDateForSql(dt_final), plc_nr_id, getIdLojaUsuarioLogado(usu_usuarioT));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<V_lancamentosT> consultSuperAgrupado(Date dt_inicio, Date dt_final, Usu_usuarioT usu_usuarioT) throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
            List<V_lancamentosT> list = v_lancamentosDAO.getAllSuperAgrupado(convertDateForSql(dt_inicio), convertDateForSql(dt_final), getIdLojaUsuarioLogado(usu_usuarioT));
            System.out.println(" qt list bl "+list.size());
            return agruparLista(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<V_lancamentosT> agruparLista(List<V_lancamentosT> list) {
        List<V_lancamentosT> newList = new ArrayList<V_lancamentosT>();
        for (V_lancamentosT obj : list) {
            
            if (obj.getTipo_cred().equalsIgnoreCase("R") || obj.getTipo_cred().equalsIgnoreCase("D")) {
                V_lancamentosT v_lancamentosT = new V_lancamentosT();
                v_lancamentosT.setPlc_tx_credito(obj.getPlc_tx_credito());
                v_lancamentosT.setPlc_super(obj.getPlc_tx_credito_super());
                v_lancamentosT.setLan_valor(obj.getLan_valor());
                newList.add(v_lancamentosT);
            }
            if (obj.getTipo_deb().equalsIgnoreCase("R") || obj.getTipo_deb().equalsIgnoreCase("D")) {
                V_lancamentosT v_lancamentosT = new V_lancamentosT();
                v_lancamentosT.setPlc_tx_credito(obj.getPlc_tx_debito());
                v_lancamentosT.setPlc_super(obj.getplc_tx_debito_super());
                v_lancamentosT.setLan_valor(obj.getLan_valor());
                newList.add(v_lancamentosT);
            }
        }
        return newList;
    }

    public List<V_lancamentosT> consultDebCred(Date dt_inicio, Date dt_final, int plc_nr_id, Usu_usuarioT usu_usuarioT) throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
            return v_lancamentosDAO.getAll(convertDateForSql(dt_inicio), convertDateForSql(dt_final), plc_nr_id, getIdLojaUsuarioLogado(usu_usuarioT));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<V_lancamentosT> consultRecebimento(int ctr_nr_id) throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
            return v_lancamentosDAO.getByRecebimentos(ctr_nr_id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<V_lancamentosT> consultPagamento(int ctp_nr_id) throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
            return v_lancamentosDAO.getByPagamentos(ctp_nr_id);
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
    public boolean delete(V_lancamentosT v_lancamentosT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(v_lancamentosT)) {
                V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
                v_lancamentosDAO.delete(v_lancamentosT);
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
    public boolean exist(V_lancamentosT v_lancamentosT) throws Exception {
        try {
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
            List<V_lancamentosT> listTemp = v_lancamentosDAO.getByPK(v_lancamentosT);

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
    public boolean update(V_lancamentosT v_lancamentosT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(v_lancamentosT)) {
                V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
                v_lancamentosDAO.update(v_lancamentosT);
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
    public V_lancamentosT findbyid(V_lancamentosT v_lancamentosT) throws Exception {
        try {
            V_lancamentosDAO v_lancamentosDAO = getV_lancamentosDAO();
            List<V_lancamentosT> listTemp = v_lancamentosDAO.getByPK(v_lancamentosT);
            return listTemp.size() > 0 ? listTemp.get(0) : new V_lancamentosT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

}
