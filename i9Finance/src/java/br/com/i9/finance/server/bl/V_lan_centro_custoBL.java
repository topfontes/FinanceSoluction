package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class V_lan_centro_custoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      V_lan_centro_custoDAO v_lan_centro_custoDAO =  getV_lan_centro_custoDAO();
      v_lan_centro_custoDAO.insert(v_lan_centro_custoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("V_lan_centro_custo"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<V_lan_centro_custoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      V_lan_centro_custoDAO v_lan_centro_custoDAO = getV_lan_centro_custoDAO();
      return v_lan_centro_custoDAO.getAll();	 
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
  public boolean delete(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(v_lan_centro_custoT)) {
        V_lan_centro_custoDAO v_lan_centro_custoDAO = getV_lan_centro_custoDAO();
        v_lan_centro_custoDAO.delete(v_lan_centro_custoT);	 
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
  public boolean exist(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
   try {
      V_lan_centro_custoDAO v_lan_centro_custoDAO = getV_lan_centro_custoDAO();
      List<V_lan_centro_custoT> listTemp  = v_lan_centro_custoDAO.getByPK(v_lan_centro_custoT);	 

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
  public boolean update(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(v_lan_centro_custoT)) {
        V_lan_centro_custoDAO v_lan_centro_custoDAO = getV_lan_centro_custoDAO();
        v_lan_centro_custoDAO.update(v_lan_centro_custoT);	 
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
  public V_lan_centro_custoT findbyid(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
    try {
      V_lan_centro_custoDAO v_lan_centro_custoDAO = getV_lan_centro_custoDAO();
      List<V_lan_centro_custoT> listTemp  = v_lan_centro_custoDAO.getByPK( v_lan_centro_custoT);	 
      return listTemp.size()>0?listTemp.get(0):new V_lan_centro_custoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
