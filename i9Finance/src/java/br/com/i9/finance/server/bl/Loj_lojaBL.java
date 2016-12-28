package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Loj_lojaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Loj_lojaT loj_lojaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Loj_lojaDAO loj_lojaDAO =  getLoj_lojaDAO();
      loj_lojaT.setLoj_nr_id(getIncLoj_loja());
      loj_lojaDAO.insert(loj_lojaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Loj_loja"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Loj_lojaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Loj_lojaDAO loj_lojaDAO = getLoj_lojaDAO();
      return loj_lojaDAO.getAll();	 
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
  public boolean delete(Loj_lojaT loj_lojaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(loj_lojaT)) {
        Loj_lojaDAO loj_lojaDAO = getLoj_lojaDAO();
        loj_lojaDAO.delete(loj_lojaT);	 
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
  public boolean exist(Loj_lojaT loj_lojaT) throws Exception {
   try {
      Loj_lojaDAO loj_lojaDAO = getLoj_lojaDAO();
      List<Loj_lojaT> listTemp  = loj_lojaDAO.getByPK(loj_lojaT);	 

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
  public boolean update(Loj_lojaT loj_lojaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(loj_lojaT)) {
        Loj_lojaDAO loj_lojaDAO = getLoj_lojaDAO();
        loj_lojaDAO.update(loj_lojaT);	 
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
  public Loj_lojaT findbyid(Loj_lojaT loj_lojaT) throws Exception {
    try {
      Loj_lojaDAO loj_lojaDAO = getLoj_lojaDAO();
      List<Loj_lojaT> listTemp  = loj_lojaDAO.getByPK( loj_lojaT);	 
      return listTemp.size()>0?listTemp.get(0):new Loj_lojaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
