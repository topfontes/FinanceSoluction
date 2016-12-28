package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Lcc_lancamento_centro_custoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Lcc_lancamento_centro_custoDAO lcc_lancamento_centro_custoDAO =  getLcc_lancamento_centro_custoDAO();
      lcc_lancamento_centro_custoT.setLcc_nr_id(getIncLcc_lancamento_centro_custo());
      lcc_lancamento_centro_custoDAO.insert(lcc_lancamento_centro_custoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Lcc_lancamento_centro_custo"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Lcc_lancamento_centro_custoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Lcc_lancamento_centro_custoDAO lcc_lancamento_centro_custoDAO = getLcc_lancamento_centro_custoDAO();
      return lcc_lancamento_centro_custoDAO.getAll();	 
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
  public boolean delete(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(lcc_lancamento_centro_custoT)) {
        Lcc_lancamento_centro_custoDAO lcc_lancamento_centro_custoDAO = getLcc_lancamento_centro_custoDAO();
        lcc_lancamento_centro_custoDAO.delete(lcc_lancamento_centro_custoT);	 
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
  public boolean exist(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
   try {
      Lcc_lancamento_centro_custoDAO lcc_lancamento_centro_custoDAO = getLcc_lancamento_centro_custoDAO();
      List<Lcc_lancamento_centro_custoT> listTemp  = lcc_lancamento_centro_custoDAO.getByPK(lcc_lancamento_centro_custoT);	 

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
  public boolean update(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(lcc_lancamento_centro_custoT)) {
        Lcc_lancamento_centro_custoDAO lcc_lancamento_centro_custoDAO = getLcc_lancamento_centro_custoDAO();
        lcc_lancamento_centro_custoDAO.update(lcc_lancamento_centro_custoT);	 
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
  public Lcc_lancamento_centro_custoT findbyid(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
    try {
      Lcc_lancamento_centro_custoDAO lcc_lancamento_centro_custoDAO = getLcc_lancamento_centro_custoDAO();
      List<Lcc_lancamento_centro_custoT> listTemp  = lcc_lancamento_centro_custoDAO.getByPK( lcc_lancamento_centro_custoT);	 
      return listTemp.size()>0?listTemp.get(0):new Lcc_lancamento_centro_custoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
