package br.com.i9.finance.server.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.finance.server.dao.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Car_cartaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Car_cartaoT car_cartaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Car_cartaoDAO car_cartaoDAO =  getCar_cartaoDAO();
      car_cartaoT.setCar_nr_id(getIncCar_cartao());
      car_cartaoDAO.insert(car_cartaoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Car_cartao"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Car_cartaoT> consult(Usu_usuarioT usu_usuarioT) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Car_cartaoDAO car_cartaoDAO = getCar_cartaoDAO();
      return car_cartaoDAO.getAll(getIdLojaUsuarioLogado(usu_usuarioT));	 
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
  public boolean delete(Car_cartaoT car_cartaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(car_cartaoT)) {
        Car_cartaoDAO car_cartaoDAO = getCar_cartaoDAO();
        car_cartaoDAO.delete(car_cartaoT);	 
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
  public boolean exist(Car_cartaoT car_cartaoT) throws Exception {
   try {
      Car_cartaoDAO car_cartaoDAO = getCar_cartaoDAO();
      List<Car_cartaoT> listTemp  = car_cartaoDAO.getByPK(car_cartaoT);	 

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
  public boolean update(Car_cartaoT car_cartaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(car_cartaoT)) {
        Car_cartaoDAO car_cartaoDAO = getCar_cartaoDAO();
        car_cartaoDAO.update(car_cartaoT);	 
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
  public Car_cartaoT findbyid(Car_cartaoT car_cartaoT) throws Exception {
    try {
      Car_cartaoDAO car_cartaoDAO = getCar_cartaoDAO();
      List<Car_cartaoT> listTemp  = car_cartaoDAO.getByPK( car_cartaoT);	 
      return listTemp.size()>0?listTemp.get(0):new Car_cartaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
