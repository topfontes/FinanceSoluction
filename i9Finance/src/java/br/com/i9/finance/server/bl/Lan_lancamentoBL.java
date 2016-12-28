package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Lan_lancamentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Lan_lancamentoT lan_lancamentoT, Usu_usuarioT usu_usuarioT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Lan_lancamentoDAO lan_lancamentoDAO =  getLan_lancamentoDAO();
      lan_lancamentoT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
      lan_lancamentoT.setLan_nr_id(getIncLan_lancamento());
      lan_lancamentoDAO.insert(lan_lancamentoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Lan_lancamento"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Lan_lancamentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
      return lan_lancamentoDAO.getAll();	 
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
  public boolean delete(Lan_lancamentoT lan_lancamentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(lan_lancamentoT)) {
        Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
        lan_lancamentoDAO.delete(lan_lancamentoT);	 
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
  public boolean exist(Lan_lancamentoT lan_lancamentoT) throws Exception {
   try {
      Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
      List<Lan_lancamentoT> listTemp  = lan_lancamentoDAO.getByPK(lan_lancamentoT);	 

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
  public boolean update(Lan_lancamentoT lan_lancamentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(lan_lancamentoT)) {
        Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
        lan_lancamentoDAO.update(lan_lancamentoT);	 
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
  public Lan_lancamentoT findbyid(Lan_lancamentoT lan_lancamentoT) throws Exception {
    try {
      Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
      List<Lan_lancamentoT> listTemp  = lan_lancamentoDAO.getByPK( lan_lancamentoT);	 
      return listTemp.size()>0?listTemp.get(0):new Lan_lancamentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
