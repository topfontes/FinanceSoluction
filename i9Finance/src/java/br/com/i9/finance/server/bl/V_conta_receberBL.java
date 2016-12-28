package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import java.util.Date;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class V_conta_receberBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(V_conta_receberT v_conta_receberT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      V_conta_receberDAO v_conta_receberDAO =  getV_conta_receberDAO();
      v_conta_receberDAO.insert(v_conta_receberT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("V_conta_receber"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<V_conta_receberT> consult(Date dt_inicio, Date dt_final, String pago) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      V_conta_receberDAO v_conta_receberDAO = getV_conta_receberDAO();
      return v_conta_receberDAO.getAll(convertDateForSql(dt_inicio), convertDateForSql(dt_final),pago);	 
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
  public boolean delete(V_conta_receberT v_conta_receberT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(v_conta_receberT)) {
        V_conta_receberDAO v_conta_receberDAO = getV_conta_receberDAO();
        v_conta_receberDAO.delete(v_conta_receberT);	 
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
  public boolean exist(V_conta_receberT v_conta_receberT) throws Exception {
   try {
      V_conta_receberDAO v_conta_receberDAO = getV_conta_receberDAO();
      List<V_conta_receberT> listTemp  = v_conta_receberDAO.getByPK(v_conta_receberT);	 

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
  public boolean update(V_conta_receberT v_conta_receberT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(v_conta_receberT)) {
        V_conta_receberDAO v_conta_receberDAO = getV_conta_receberDAO();
        v_conta_receberDAO.update(v_conta_receberT);	 
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
  public V_conta_receberT findbyid(V_conta_receberT v_conta_receberT) throws Exception {
    try {
      V_conta_receberDAO v_conta_receberDAO = getV_conta_receberDAO();
      List<V_conta_receberT> listTemp  = v_conta_receberDAO.getByPK( v_conta_receberT);	 
      return listTemp.size()>0?listTemp.get(0):new V_conta_receberT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
