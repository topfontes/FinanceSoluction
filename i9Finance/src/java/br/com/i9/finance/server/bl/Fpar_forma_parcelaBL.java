package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fpar_forma_parcelaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Fpar_forma_parcelaDAO fpar_forma_parcelaDAO =  getFpar_forma_parcelaDAO();
      fpar_forma_parcelaT.setFpar_nr_id(getIncFpar_forma_parcela());
      fpar_forma_parcelaDAO.insert(fpar_forma_parcelaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Fpar_forma_parcela"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Fpar_forma_parcelaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Fpar_forma_parcelaDAO fpar_forma_parcelaDAO = getFpar_forma_parcelaDAO();
      return fpar_forma_parcelaDAO.getAll();	 
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
  public boolean delete(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(fpar_forma_parcelaT)) {
        Fpar_forma_parcelaDAO fpar_forma_parcelaDAO = getFpar_forma_parcelaDAO();
        fpar_forma_parcelaDAO.delete(fpar_forma_parcelaT);	 
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
  public boolean exist(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
   try {
      Fpar_forma_parcelaDAO fpar_forma_parcelaDAO = getFpar_forma_parcelaDAO();
      List<Fpar_forma_parcelaT> listTemp  = fpar_forma_parcelaDAO.getByPK(fpar_forma_parcelaT);	 

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
  public boolean update(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(fpar_forma_parcelaT)) {
        Fpar_forma_parcelaDAO fpar_forma_parcelaDAO = getFpar_forma_parcelaDAO();
        fpar_forma_parcelaDAO.update(fpar_forma_parcelaT);	 
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
  public Fpar_forma_parcelaT findbyid(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
    try {
      Fpar_forma_parcelaDAO fpar_forma_parcelaDAO = getFpar_forma_parcelaDAO();
      List<Fpar_forma_parcelaT> listTemp  = fpar_forma_parcelaDAO.getByPK( fpar_forma_parcelaT);	 
      return listTemp.size()>0?listTemp.get(0):new Fpar_forma_parcelaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
