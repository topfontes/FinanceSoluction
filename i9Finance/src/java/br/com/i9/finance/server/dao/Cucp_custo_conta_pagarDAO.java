package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Cucp_custo_conta_pagarDAO extends ObjectDAOCluster { 
	 public Cucp_custo_conta_pagarDAO(DAOFactoryCluster dao) throws Exception {
		 setdAOFactoryCluster(dao);
 	 }

	 public void insert(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyfin.cucp_custo_conta_pagar  ( cen_nr_id, cucp_valor, ccp_nr_id,cucp_nr_id ) values ( ?, ? , ? , ? )";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cucp_custo_conta_pagarT.getCen_nr_id());
			 pStmt.setObject(2, cucp_custo_conta_pagarT.getCucp_valor());
			 pStmt.setObject(3, cucp_custo_conta_pagarT.getCcp_nr_id());
                         pStmt.setObject(4, cucp_custo_conta_pagarT.getCucp_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyfin.cucp_custo_conta_pagar set  cen_nr_id=?, cucp_valor=?, ccp_nr_id=?  where  cucp_nr_id=?";
 			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cucp_custo_conta_pagarT.getCen_nr_id());
			 pStmt.setObject(2, cucp_custo_conta_pagarT.getCucp_valor());
			 pStmt.setObject(3, cucp_custo_conta_pagarT.getCcp_nr_id());
			 pStmt.setObject(4, cucp_custo_conta_pagarT.getCucp_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyfin.cucp_custo_conta_pagar where  cucp_nr_id=?";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cucp_custo_conta_pagarT.getCucp_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Cucp_custo_conta_pagarT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Cucp_custo_conta_pagarT> objs = new Vector();
		 while (rs.next()) { 
 			 Cucp_custo_conta_pagarT cucp_custo_conta_pagarT = new Cucp_custo_conta_pagarT();
			 cucp_custo_conta_pagarT.setCucp_nr_id(rs.getInt("cucp_nr_id"));
			 cucp_custo_conta_pagarT.setCen_nr_id(rs.getInt("cen_nr_id"));
			 cucp_custo_conta_pagarT.setCucp_valor(rs.getDouble("cucp_valor"));
			 cucp_custo_conta_pagarT.setCcp_nr_id(rs.getInt("ccp_nr_id"));
			 objs.add(cucp_custo_conta_pagarT);
 		 }
 		 return objs; 
 	 }
	 public List<Cucp_custo_conta_pagarT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cucp_custo_conta_pagar"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 List<Cucp_custo_conta_pagarT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cucp_custo_conta_pagarT> getByPK(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cucp_custo_conta_pagar where  cucp_nr_id=?"; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cucp_custo_conta_pagarT.getCucp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cucp_custo_conta_pagarT> getByCucp_nr_id(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cucp_custo_conta_pagar where  cucp_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cucp_custo_conta_pagarT.getCucp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cucp_custo_conta_pagarT> getByCen_nr_id(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cucp_custo_conta_pagar where  cen_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cucp_custo_conta_pagarT.getCen_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cucp_custo_conta_pagarT> getByCucp_valor(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cucp_custo_conta_pagar where  cucp_valor = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cucp_custo_conta_pagarT.getCucp_valor());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cucp_custo_conta_pagarT> getByCcp_nr_id(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cucp_custo_conta_pagar where  ccp_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cucp_custo_conta_pagarT.getCcp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
	/** Metodos FK */
	 public List<Cucp_custo_conta_pagarT> getByCen_centro_custo(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cucp_custo_conta_pagar where cen_centro_custo.cen_nr_id=?  ";
			 pStmt = createPrepareStatment(sql);
		 pStmt.setObject(1, cucp_custo_conta_pagarT.getCen_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	/** Metodos FK */
	 public List<Cucp_custo_conta_pagarT> getByCcp_conta_ct_pagar(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cucp_custo_conta_pagar where ccp_conta_ct_pagar.ccp_nr_id=?  ";
			 pStmt = createPrepareStatment(sql);
		 pStmt.setObject(1, cucp_custo_conta_pagarT.getCcp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
 }