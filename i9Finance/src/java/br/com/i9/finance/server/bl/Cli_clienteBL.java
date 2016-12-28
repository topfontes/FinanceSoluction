package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cli_clienteBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cli_clienteT cli_clienteT, Usu_usuarioT usu_usuarioT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Cli_clienteDAO cli_clienteDAO =  getCli_clienteDAO();
      cli_clienteT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
      cli_clienteT.setCli_nr_id(getIncCli_cliente());
      cli_clienteDAO.insert(cli_clienteT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Cli_cliente"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Cli_clienteT> consult(Usu_usuarioT usu_usuarioT) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
      return cli_clienteDAO.getByLoj_loja(getIdLojaUsuarioLogado(usu_usuarioT));	 
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
  public boolean delete(Cli_clienteT cli_clienteT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(cli_clienteT)) {
        Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
        cli_clienteDAO.delete(cli_clienteT);	 
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
  public boolean exist(Cli_clienteT cli_clienteT) throws Exception {
   try {
      Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
      List<Cli_clienteT> listTemp  = cli_clienteDAO.getByPK(cli_clienteT);	 

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
  public boolean update(Cli_clienteT cli_clienteT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(cli_clienteT)) {
        Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
        cli_clienteDAO.update(cli_clienteT);	 
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
  public Cli_clienteT findbyid(Cli_clienteT cli_clienteT) throws Exception {
    try {
      Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
      List<Cli_clienteT> listTemp  = cli_clienteDAO.getByPK( cli_clienteT);	 
      return listTemp.size()>0?listTemp.get(0):new Cli_clienteT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
