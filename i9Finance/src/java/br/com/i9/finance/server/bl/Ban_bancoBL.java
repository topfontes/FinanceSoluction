package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ban_bancoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ban_bancoT ban_bancoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Ban_bancoDAO ban_bancoDAO =  getBan_bancoDAO();
      ban_bancoT.setBan_nr_id(getIncBan_banco());
      ban_bancoDAO.insert(ban_bancoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Ban_banco"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Ban_bancoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Ban_bancoDAO ban_bancoDAO = getBan_bancoDAO();
      return ban_bancoDAO.getAll();	 
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
  public boolean delete(Ban_bancoT ban_bancoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(ban_bancoT)) {
        Ban_bancoDAO ban_bancoDAO = getBan_bancoDAO();
        ban_bancoDAO.delete(ban_bancoT);	 
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
  public boolean exist(Ban_bancoT ban_bancoT) throws Exception {
   try {
      Ban_bancoDAO ban_bancoDAO = getBan_bancoDAO();
      List<Ban_bancoT> listTemp  = ban_bancoDAO.getByPK(ban_bancoT);	 

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
  public boolean update(Ban_bancoT ban_bancoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(ban_bancoT)) {
        Ban_bancoDAO ban_bancoDAO = getBan_bancoDAO();
        ban_bancoDAO.update(ban_bancoT);	 
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
  public Ban_bancoT findbyid(Ban_bancoT ban_bancoT) throws Exception {
    try {
      Ban_bancoDAO ban_bancoDAO = getBan_bancoDAO();
      List<Ban_bancoT> listTemp  = ban_bancoDAO.getByPK( ban_bancoT);	 
      return listTemp.size()>0?listTemp.get(0):new Ban_bancoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
