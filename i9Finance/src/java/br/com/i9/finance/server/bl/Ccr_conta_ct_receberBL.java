package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ccr_conta_ct_receberBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Ccr_conta_ct_receberDAO ccr_conta_ct_receberDAO =  getCcr_conta_ct_receberDAO();
      ccr_conta_ct_receberT.setCcr_nr_id(getIncCcr_conta_ct_receber());
      ccr_conta_ct_receberDAO.insert(ccr_conta_ct_receberT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Ccr_conta_ct_receber"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Ccr_conta_ct_receberT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Ccr_conta_ct_receberDAO ccr_conta_ct_receberDAO = getCcr_conta_ct_receberDAO();
      return ccr_conta_ct_receberDAO.getAll();	 
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
  public boolean delete(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(ccr_conta_ct_receberT)) {
        Ccr_conta_ct_receberDAO ccr_conta_ct_receberDAO = getCcr_conta_ct_receberDAO();
        ccr_conta_ct_receberDAO.delete(ccr_conta_ct_receberT);	 
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
  public boolean exist(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
   try {
      Ccr_conta_ct_receberDAO ccr_conta_ct_receberDAO = getCcr_conta_ct_receberDAO();
      List<Ccr_conta_ct_receberT> listTemp  = ccr_conta_ct_receberDAO.getByPK(ccr_conta_ct_receberT);	 

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
  public boolean update(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(ccr_conta_ct_receberT)) {
        Ccr_conta_ct_receberDAO ccr_conta_ct_receberDAO = getCcr_conta_ct_receberDAO();
        ccr_conta_ct_receberDAO.update(ccr_conta_ct_receberT);	 
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
  public Ccr_conta_ct_receberT findbyid(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
    try {
      Ccr_conta_ct_receberDAO ccr_conta_ct_receberDAO = getCcr_conta_ct_receberDAO();
      List<Ccr_conta_ct_receberT> listTemp  = ccr_conta_ct_receberDAO.getByPK( ccr_conta_ct_receberT);	 
      return listTemp.size()>0?listTemp.get(0):new Ccr_conta_ct_receberT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
