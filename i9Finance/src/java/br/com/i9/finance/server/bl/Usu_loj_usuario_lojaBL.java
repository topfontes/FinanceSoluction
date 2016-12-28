package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Usu_loj_usuario_lojaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Usu_loj_usuario_lojaDAO usu_loj_usuario_lojaDAO =  getUsu_loj_usuario_lojaDAO();
      
      usu_loj_usuario_lojaDAO.insert(usu_loj_usuario_lojaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Usu_loj_usuario_loja"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Usu_loj_usuario_lojaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Usu_loj_usuario_lojaDAO usu_loj_usuario_lojaDAO = getUsu_loj_usuario_lojaDAO();
      return usu_loj_usuario_lojaDAO.getAll();	 
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
  public boolean delete(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(usu_loj_usuario_lojaT)) {
        Usu_loj_usuario_lojaDAO usu_loj_usuario_lojaDAO = getUsu_loj_usuario_lojaDAO();
        usu_loj_usuario_lojaDAO.delete(usu_loj_usuario_lojaT);	 
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
  public boolean exist(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
   try {
      Usu_loj_usuario_lojaDAO usu_loj_usuario_lojaDAO = getUsu_loj_usuario_lojaDAO();
      List<Usu_loj_usuario_lojaT> listTemp  = usu_loj_usuario_lojaDAO.getByPK(usu_loj_usuario_lojaT);	 

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
  public boolean update(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(usu_loj_usuario_lojaT)) {
        Usu_loj_usuario_lojaDAO usu_loj_usuario_lojaDAO = getUsu_loj_usuario_lojaDAO();
        usu_loj_usuario_lojaDAO.update(usu_loj_usuario_lojaT);	 
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
  public Usu_loj_usuario_lojaT findbyid(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
    try {
      Usu_loj_usuario_lojaDAO usu_loj_usuario_lojaDAO = getUsu_loj_usuario_lojaDAO();
      List<Usu_loj_usuario_lojaT> listTemp  = usu_loj_usuario_lojaDAO.getByPK( usu_loj_usuario_lojaT);	 
      return listTemp.size()>0?listTemp.get(0):new Usu_loj_usuario_lojaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
