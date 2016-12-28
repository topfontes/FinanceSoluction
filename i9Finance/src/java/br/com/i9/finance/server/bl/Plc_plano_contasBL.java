package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Plc_plano_contasBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Plc_plano_contasT plc_plano_contasT, Usu_usuarioT usu_usuarioT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Plc_plano_contasDAO plc_plano_contasDAO =  getPlc_plano_contasDAO();
      plc_plano_contasT.setLoj_nr_id(getIdLojaUsuarioLogado(usu_usuarioT));
      plc_plano_contasT.setPlc_nr_id(getIncPlc_plano_contas());
      plc_plano_contasDAO.insert(plc_plano_contasT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Plc_plano_contas"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Plc_plano_contasT> consult(Usu_usuarioT usu_usuarioT) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      return plc_plano_contasDAO.getAll(getIdLojaUsuarioLogado(usu_usuarioT));	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }  

  public List<Plc_plano_contasT> consultSuper(Usu_usuarioT usu_usuarioT) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      int nivel;
      String nivelStr = getParametro("quantidade_niveis");
        try {
            nivel = Integer.parseInt(nivelStr);
        } catch (Exception e) {
            nivel =3;
            e.printStackTrace();
        }
      return plc_plano_contasDAO.getAllSuper(getIdLojaUsuarioLogado(usu_usuarioT),nivel);	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    
  
  public List<Plc_plano_contasT> consultSub(Usu_usuarioT usu_usuarioT) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      return plc_plano_contasDAO.getAllSub(getIdLojaUsuarioLogado(usu_usuarioT));	 
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
  public boolean delete(Plc_plano_contasT plc_plano_contasT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(plc_plano_contasT)) {
        Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
        plc_plano_contasDAO.delete(plc_plano_contasT);	 
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
  public boolean exist(Plc_plano_contasT plc_plano_contasT) throws Exception {
   try {
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      List<Plc_plano_contasT> listTemp  = plc_plano_contasDAO.getByPK(plc_plano_contasT);	 

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
  public boolean update(Plc_plano_contasT plc_plano_contasT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(plc_plano_contasT)) {
        Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
        plc_plano_contasDAO.update(plc_plano_contasT);	 
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
  public Plc_plano_contasT findbyid(Plc_plano_contasT plc_plano_contasT) throws Exception {
    try {
      Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
      List<Plc_plano_contasT> listTemp  = plc_plano_contasDAO.getByPK( plc_plano_contasT);	 
      return listTemp.size()>0?listTemp.get(0):new Plc_plano_contasT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
