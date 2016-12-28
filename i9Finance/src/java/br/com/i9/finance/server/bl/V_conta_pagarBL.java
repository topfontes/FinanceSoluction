package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import java.util.Date;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class V_conta_pagarBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(V_conta_pagarT v_conta_pagarT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      V_conta_pagarDAO v_conta_pagarDAO =  getV_conta_pagarDAO();
      v_conta_pagarDAO.insert(v_conta_pagarT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("V_conta_pagar"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<V_conta_pagarT> consult(Date dt_inicio, Date dt_final, String pago) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      V_conta_pagarDAO v_conta_pagarDAO = getV_conta_pagarDAO();
      return v_conta_pagarDAO.getAll(convertDateForSql(dt_inicio), convertDateForSql(dt_final),pago);	 
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
  public boolean delete(V_conta_pagarT v_conta_pagarT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(v_conta_pagarT)) {
        V_conta_pagarDAO v_conta_pagarDAO = getV_conta_pagarDAO();
        v_conta_pagarDAO.delete(v_conta_pagarT);	 
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
  public boolean exist(V_conta_pagarT v_conta_pagarT) throws Exception {
   try {
      V_conta_pagarDAO v_conta_pagarDAO = getV_conta_pagarDAO();
      List<V_conta_pagarT> listTemp  = v_conta_pagarDAO.getByPK(v_conta_pagarT);	 

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
  public boolean update(V_conta_pagarT v_conta_pagarT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(v_conta_pagarT)) {
        V_conta_pagarDAO v_conta_pagarDAO = getV_conta_pagarDAO();
        v_conta_pagarDAO.update(v_conta_pagarT);	 
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
  public V_conta_pagarT findbyid(V_conta_pagarT v_conta_pagarT) throws Exception {
    try {
      V_conta_pagarDAO v_conta_pagarDAO = getV_conta_pagarDAO();
      List<V_conta_pagarT> listTemp  = v_conta_pagarDAO.getByPK( v_conta_pagarT);	 
      return listTemp.size()>0?listTemp.get(0):new V_conta_pagarT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
