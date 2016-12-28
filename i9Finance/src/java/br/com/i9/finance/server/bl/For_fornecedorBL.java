package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class For_fornecedorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(For_fornecedorT for_fornecedorT, Usu_usuarioT usu_usuarioT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      For_fornecedorDAO for_fornecedorDAO =  getFor_fornecedorDAO();
      for_fornecedorT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
      for_fornecedorT.setFor_nr_id(getIncFor_fornecedor());
      for_fornecedorDAO.insert(for_fornecedorT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("For_fornecedor"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<For_fornecedorT> consult(Usu_usuarioT usu_usuarioT) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
      return for_fornecedorDAO.getAll(getIdLojaUsuarioLogado(usu_usuarioT));	 
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
  public boolean delete(For_fornecedorT for_fornecedorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(for_fornecedorT)) {
        For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
        for_fornecedorDAO.delete(for_fornecedorT);	 
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
  public boolean exist(For_fornecedorT for_fornecedorT) throws Exception {
   try {
      For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
      List<For_fornecedorT> listTemp  = for_fornecedorDAO.getByPK(for_fornecedorT);	 

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
  public boolean update(For_fornecedorT for_fornecedorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(for_fornecedorT)) {
        For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
        for_fornecedorDAO.update(for_fornecedorT);	 
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
  public For_fornecedorT findbyid(For_fornecedorT for_fornecedorT) throws Exception {
    try {
      For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
      List<For_fornecedorT> listTemp  = for_fornecedorDAO.getByPK( for_fornecedorT);	 
      return listTemp.size()>0?listTemp.get(0):new For_fornecedorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
