package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class V_conta_receber_pago_contaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(V_conta_receber_pago_contaT v_conta_receber_pago_contaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      V_conta_receber_pago_contaDAO v_conta_receber_pago_contaDAO =  getV_conta_receber_pago_contaDAO();
      v_conta_receber_pago_contaDAO.insert(v_conta_receber_pago_contaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("V_conta_receber_pago_conta"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<V_conta_receber_pago_contaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      V_conta_receber_pago_contaDAO v_conta_receber_pago_contaDAO = getV_conta_receber_pago_contaDAO();
      return v_conta_receber_pago_contaDAO.getAll();	 
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
  public boolean delete(V_conta_receber_pago_contaT v_conta_receber_pago_contaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(v_conta_receber_pago_contaT)) {
        V_conta_receber_pago_contaDAO v_conta_receber_pago_contaDAO = getV_conta_receber_pago_contaDAO();
        v_conta_receber_pago_contaDAO.delete(v_conta_receber_pago_contaT);	 
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
  public boolean exist(V_conta_receber_pago_contaT v_conta_receber_pago_contaT) throws Exception {
   try {
      V_conta_receber_pago_contaDAO v_conta_receber_pago_contaDAO = getV_conta_receber_pago_contaDAO();
      List<V_conta_receber_pago_contaT> listTemp  = v_conta_receber_pago_contaDAO.getByPK(v_conta_receber_pago_contaT);	 

      return listTemp.size()>0;      
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
  public boolean update(V_conta_receber_pago_contaT v_conta_receber_pago_contaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(v_conta_receber_pago_contaT)) {
        V_conta_receber_pago_contaDAO v_conta_receber_pago_contaDAO = getV_conta_receber_pago_contaDAO();
        v_conta_receber_pago_contaDAO.update(v_conta_receber_pago_contaT);	 
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
  public V_conta_receber_pago_contaT findbyid(V_conta_receber_pago_contaT v_conta_receber_pago_contaT) throws Exception {
    try {
      V_conta_receber_pago_contaDAO v_conta_receber_pago_contaDAO = getV_conta_receber_pago_contaDAO();
      List<V_conta_receber_pago_contaT> listTemp  = v_conta_receber_pago_contaDAO.getByPK( v_conta_receber_pago_contaT);	 
      return listTemp.size()>0?listTemp.get(0):new V_conta_receber_pago_contaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
