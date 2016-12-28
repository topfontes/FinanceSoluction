package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cucp_custo_conta_pagarBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Cucp_custo_conta_pagarDAO cucp_custo_conta_pagarDAO =  getCucp_custo_conta_pagarDAO();
      cucp_custo_conta_pagarT.setCucp_nr_id(getIncCucp_custo_conta_pagar());
      cucp_custo_conta_pagarDAO.insert(cucp_custo_conta_pagarT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Cucp_custo_conta_pagar"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Cucp_custo_conta_pagarT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Cucp_custo_conta_pagarDAO cucp_custo_conta_pagarDAO = getCucp_custo_conta_pagarDAO();
      return cucp_custo_conta_pagarDAO.getAll();	 
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
  public boolean delete(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(cucp_custo_conta_pagarT)) {
        Cucp_custo_conta_pagarDAO cucp_custo_conta_pagarDAO = getCucp_custo_conta_pagarDAO();
        cucp_custo_conta_pagarDAO.delete(cucp_custo_conta_pagarT);	 
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
  public boolean exist(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
   try {
      Cucp_custo_conta_pagarDAO cucp_custo_conta_pagarDAO = getCucp_custo_conta_pagarDAO();
      List<Cucp_custo_conta_pagarT> listTemp  = cucp_custo_conta_pagarDAO.getByPK(cucp_custo_conta_pagarT);	 

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
  public boolean update(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(cucp_custo_conta_pagarT)) {
        Cucp_custo_conta_pagarDAO cucp_custo_conta_pagarDAO = getCucp_custo_conta_pagarDAO();
        cucp_custo_conta_pagarDAO.update(cucp_custo_conta_pagarT);	 
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
  public Cucp_custo_conta_pagarT findbyid(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
    try {
      Cucp_custo_conta_pagarDAO cucp_custo_conta_pagarDAO = getCucp_custo_conta_pagarDAO();
      List<Cucp_custo_conta_pagarT> listTemp  = cucp_custo_conta_pagarDAO.getByPK( cucp_custo_conta_pagarT);	 
      return listTemp.size()>0?listTemp.get(0):new Cucp_custo_conta_pagarT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
