package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ccp_conta_ct_pagarBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Ccp_conta_ct_pagarDAO ccp_conta_ct_pagarDAO =  getCcp_conta_ct_pagarDAO();
      ccp_conta_ct_pagarT.setCcp_nr_id(getIncCcp_conta_ct_pagar());
      ccp_conta_ct_pagarDAO.insert(ccp_conta_ct_pagarT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Ccp_conta_ct_pagar"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Ccp_conta_ct_pagarT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Ccp_conta_ct_pagarDAO ccp_conta_ct_pagarDAO = getCcp_conta_ct_pagarDAO();
      return ccp_conta_ct_pagarDAO.getAll();	 
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
  public boolean delete(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(ccp_conta_ct_pagarT)) {
        Ccp_conta_ct_pagarDAO ccp_conta_ct_pagarDAO = getCcp_conta_ct_pagarDAO();
        ccp_conta_ct_pagarDAO.delete(ccp_conta_ct_pagarT);	 
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
  public boolean exist(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
   try {
      Ccp_conta_ct_pagarDAO ccp_conta_ct_pagarDAO = getCcp_conta_ct_pagarDAO();
      List<Ccp_conta_ct_pagarT> listTemp  = ccp_conta_ct_pagarDAO.getByPK(ccp_conta_ct_pagarT);	 

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
  public boolean update(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(ccp_conta_ct_pagarT)) {
        Ccp_conta_ct_pagarDAO ccp_conta_ct_pagarDAO = getCcp_conta_ct_pagarDAO();
        ccp_conta_ct_pagarDAO.update(ccp_conta_ct_pagarT);	 
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
  public Ccp_conta_ct_pagarT findbyid(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
    try {
      Ccp_conta_ct_pagarDAO ccp_conta_ct_pagarDAO = getCcp_conta_ct_pagarDAO();
      List<Ccp_conta_ct_pagarT> listTemp  = ccp_conta_ct_pagarDAO.getByPK( ccp_conta_ct_pagarT);	 
      return listTemp.size()>0?listTemp.get(0):new Ccp_conta_ct_pagarT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
