package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Ban_bancoDAO extends ObjectDAOCluster { 
	 public Ban_bancoDAO(DAOFactoryCluster dao) throws Exception {
		 setdAOFactoryCluster(dao);
 	 }

	 public void insert(Ban_bancoT ban_bancoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyfin.ban_banco  ( ban_tx_status, ban_tx_nome, loj_nr_id, ban_nr_id) values ( ?, ? , ? , ? )";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, ban_bancoT.getBan_tx_status());
			 pStmt.setObject(2, ban_bancoT.getBan_tx_nome());
			 pStmt.setObject(3, ban_bancoT.getLoj_nr_id());
                         pStmt.setObject(4, ban_bancoT.getBan_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Ban_bancoT ban_bancoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyfin.ban_banco set  ban_tx_status=?, ban_tx_nome=?, loj_nr_id=?  where  ban_nr_id=?";
 			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, ban_bancoT.getBan_tx_status());
			 pStmt.setObject(2, ban_bancoT.getBan_tx_nome());
			 pStmt.setObject(3, ban_bancoT.getLoj_nr_id());
			 pStmt.setObject(4, ban_bancoT.getBan_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Ban_bancoT ban_bancoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyfin.ban_banco where  ban_nr_id=?";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, ban_bancoT.getBan_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Ban_bancoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Ban_bancoT> objs = new Vector();
		 while (rs.next()) { 
 			 Ban_bancoT ban_bancoT = new Ban_bancoT();
			 ban_bancoT.setBan_tx_status(rs.getString("ban_tx_status"));
			 ban_bancoT.setBan_tx_nome(rs.getString("ban_tx_nome"));
			 ban_bancoT.setBan_nr_id(rs.getInt("ban_nr_id"));
			 ban_bancoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
			 objs.add(ban_bancoT);
 		 }
 		 return objs; 
 	 }
	 public List<Ban_bancoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.ban_banco"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 List<Ban_bancoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ban_bancoT> getByPK(Ban_bancoT ban_bancoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.ban_banco where  ban_nr_id=?"; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, ban_bancoT.getBan_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ban_bancoT> getByBan_tx_status(Ban_bancoT ban_bancoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.ban_banco where  Upper(ban_tx_status) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + ban_bancoT.getBan_tx_status()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ban_bancoT> getByBan_tx_nome(Ban_bancoT ban_bancoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.ban_banco where  Upper(ban_tx_nome) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + ban_bancoT.getBan_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ban_bancoT> getByBan_nr_id(Ban_bancoT ban_bancoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.ban_banco where  ban_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, ban_bancoT.getBan_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ban_bancoT> getByLoj_nr_id(Ban_bancoT ban_bancoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.ban_banco where  loj_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, ban_bancoT.getLoj_nr_id());
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