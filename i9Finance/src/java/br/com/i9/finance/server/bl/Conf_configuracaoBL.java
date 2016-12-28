package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Conf_configuracaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Conf_configuracaoT conf_configuracaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Conf_configuracaoDAO conf_configuracaoDAO =  getConf_configuracaoDAO();
      conf_configuracaoT.setConf_nr_id(getIncConf_configuracao());
      conf_configuracaoDAO.insert(conf_configuracaoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Conf_configuracao"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Conf_configuracaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Conf_configuracaoDAO conf_configuracaoDAO = getConf_configuracaoDAO();
      return conf_configuracaoDAO.getAll();	 
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
  public boolean delete(Conf_configuracaoT conf_configuracaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(conf_configuracaoT)) {
        Conf_configuracaoDAO conf_configuracaoDAO = getConf_configuracaoDAO();
        conf_configuracaoDAO.delete(conf_configuracaoT);	 
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
  public boolean exist(Conf_configuracaoT conf_configuracaoT) throws Exception {
   try {
      Conf_configuracaoDAO conf_configuracaoDAO = getConf_configuracaoDAO();
      List<Conf_configuracaoT> listTemp  = conf_configuracaoDAO.getByPK(conf_configuracaoT);	 

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
  public boolean update(Conf_configuracaoT conf_configuracaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(conf_configuracaoT)) {
        Conf_configuracaoDAO conf_configuracaoDAO = getConf_configuracaoDAO();
        conf_configuracaoDAO.update(conf_configuracaoT);	 
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
  public Conf_configuracaoT findbyid(Conf_configuracaoT conf_configuracaoT) throws Exception {
    try {
      Conf_configuracaoDAO conf_configuracaoDAO = getConf_configuracaoDAO();
      List<Conf_configuracaoT> listTemp  = conf_configuracaoDAO.getByPK( conf_configuracaoT);	 
      return listTemp.size()>0?listTemp.get(0):new Conf_configuracaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
