package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Int_intervalo_parcelamentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Int_intervalo_parcelamentoDAO int_intervalo_parcelamentoDAO =  getInt_intervalo_parcelamentoDAO();
      int_intervalo_parcelamentoT.setInt_nr_id(getIncInt_intervalo_parcelamento());
      int_intervalo_parcelamentoDAO.insert(int_intervalo_parcelamentoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Int_intervalo_parcelamento"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Int_intervalo_parcelamentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Int_intervalo_parcelamentoDAO int_intervalo_parcelamentoDAO = getInt_intervalo_parcelamentoDAO();
      return int_intervalo_parcelamentoDAO.getAll();	 
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
  public boolean delete(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(int_intervalo_parcelamentoT)) {
        Int_intervalo_parcelamentoDAO int_intervalo_parcelamentoDAO = getInt_intervalo_parcelamentoDAO();
        int_intervalo_parcelamentoDAO.delete(int_intervalo_parcelamentoT);	 
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
  public boolean exist(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
   try {
      Int_intervalo_parcelamentoDAO int_intervalo_parcelamentoDAO = getInt_intervalo_parcelamentoDAO();
      List<Int_intervalo_parcelamentoT> listTemp  = int_intervalo_parcelamentoDAO.getByPK(int_intervalo_parcelamentoT);	 

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
  public boolean update(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(int_intervalo_parcelamentoT)) {
        Int_intervalo_parcelamentoDAO int_intervalo_parcelamentoDAO = getInt_intervalo_parcelamentoDAO();
        int_intervalo_parcelamentoDAO.update(int_intervalo_parcelamentoT);	 
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
  public Int_intervalo_parcelamentoT findbyid(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
    try {
      Int_intervalo_parcelamentoDAO int_intervalo_parcelamentoDAO = getInt_intervalo_parcelamentoDAO();
      List<Int_intervalo_parcelamentoT> listTemp  = int_intervalo_parcelamentoDAO.getByPK( int_intervalo_parcelamentoT);	 
      return listTemp.size()>0?listTemp.get(0):new Int_intervalo_parcelamentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
