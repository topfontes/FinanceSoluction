package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Cen_centro_custoDAO extends ObjectDAOCluster { 
	 public Cen_centro_custoDAO(DAOFactoryCluster dao) throws Exception {
		 setdAOFactoryCluster(dao);
 	 }

	 public void insert(Cen_centro_custoT cen_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyfin.cen_centro_custo  ( cen_tx_status, cen_tx_nome, loj_nr_id, cen_nr_id) values ( ?, ? , ? , ? )";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_tx_status());
			 pStmt.setObject(2, cen_centro_custoT.getCen_tx_nome());
			 pStmt.setObject(3, cen_centro_custoT.getLoj_nr_id());
                         pStmt.setObject(4, cen_centro_custoT.getCen_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Cen_centro_custoT cen_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyfin.cen_centro_custo set  cen_tx_status=?, cen_tx_nome=?, loj_nr_id=?  where  cen_nr_id=?";
 			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_tx_status());
			 pStmt.setObject(2, cen_centro_custoT.getCen_tx_nome());
			 pStmt.setObject(3, cen_centro_custoT.getLoj_nr_id());
			 pStmt.setObject(4, cen_centro_custoT.getCen_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Cen_centro_custoT cen_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyfin.cen_centro_custo where  cen_nr_id=?";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Cen_centro_custoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Cen_centro_custoT> objs = new Vector();
		 while (rs.next()) { 
 			 Cen_centro_custoT cen_centro_custoT = new Cen_centro_custoT();
			 cen_centro_custoT.setCen_nr_id(rs.getInt("cen_nr_id"));
			 cen_centro_custoT.setCen_tx_status(rs.getString("cen_tx_status"));
			 cen_centro_custoT.setCen_tx_nome(rs.getString("cen_tx_nome"));
			 cen_centro_custoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
			 objs.add(cen_centro_custoT);
 		 }
 		 return objs; 
 	 }
	 public List<Cen_centro_custoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cen_centro_custo"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 List<Cen_centro_custoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cen_centro_custoT> getByPK(Cen_centro_custoT cen_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cen_centro_custo where  cen_nr_id=?"; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cen_centro_custoT> getByCen_nr_id(Cen_centro_custoT cen_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cen_centro_custo where  cen_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cen_centro_custoT> getByCen_tx_status(Cen_centro_custoT cen_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cen_centro_custo where  Upper(cen_tx_status) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + cen_centro_custoT.getCen_tx_status()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cen_centro_custoT> getByCen_tx_nome(Cen_centro_custoT cen_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cen_centro_custo where  Upper(cen_tx_nome) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + cen_centro_custoT.getCen_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cen_centro_custoT> getByLoj_nr_id(Cen_centro_custoT cen_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.cen_centro_custo where  loj_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, cen_centro_custoT.getLoj_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 

 }