package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Int_intervalo_parcelamentoDAO extends ObjectDAOCluster { 
	 public Int_intervalo_parcelamentoDAO(DAOFactoryCluster dao) throws Exception {
		 setdAOFactoryCluster(dao);
 	 }

	 public void insert(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyfin.int_intervalo_parcelamento  ( int_nr_dia, int_perc_valor, par_nr_id, int_nr_id) values ( ?, ? , ? , ? )";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, int_intervalo_parcelamentoT.getInt_nr_dia());
			 pStmt.setObject(2, int_intervalo_parcelamentoT.getInt_perc_valor());
			 pStmt.setObject(3, int_intervalo_parcelamentoT.getPar_nr_id());
                         pStmt.setObject(4, int_intervalo_parcelamentoT.getInt_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyfin.int_intervalo_parcelamento set  int_nr_dia=?, int_perc_valor=?, par_nr_id=?  where  int_nr_id=?";
 			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, int_intervalo_parcelamentoT.getInt_nr_dia());
			 pStmt.setObject(2, int_intervalo_parcelamentoT.getInt_perc_valor());
			 pStmt.setObject(3, int_intervalo_parcelamentoT.getPar_nr_id());
			 pStmt.setObject(4, int_intervalo_parcelamentoT.getInt_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyfin.int_intervalo_parcelamento where  int_nr_id=?";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, int_intervalo_parcelamentoT.getInt_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Int_intervalo_parcelamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Int_intervalo_parcelamentoT> objs = new Vector();
		 while (rs.next()) { 
 			 Int_intervalo_parcelamentoT int_intervalo_parcelamentoT = new Int_intervalo_parcelamentoT();
			 int_intervalo_parcelamentoT.setInt_nr_id(rs.getInt("int_nr_id"));
			 int_intervalo_parcelamentoT.setInt_nr_dia(rs.getInt("int_nr_dia"));
			 int_intervalo_parcelamentoT.setInt_perc_valor(rs.getDouble("int_perc_valor"));
			 int_intervalo_parcelamentoT.setPar_nr_id(rs.getInt("par_nr_id"));
			 objs.add(int_intervalo_parcelamentoT);
 		 }
 		 return objs; 
 	 }
	 public List<Int_intervalo_parcelamentoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.int_intervalo_parcelamento"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 List<Int_intervalo_parcelamentoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Int_intervalo_parcelamentoT> getByPK(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.int_intervalo_parcelamento where  int_nr_id=?"; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, int_intervalo_parcelamentoT.getInt_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Int_intervalo_parcelamentoT> getByInt_nr_id(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.int_intervalo_parcelamento where  int_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, int_intervalo_parcelamentoT.getInt_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Int_intervalo_parcelamentoT> getByInt_nr_dia(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.int_intervalo_parcelamento where  int_nr_dia = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, int_intervalo_parcelamentoT.getInt_nr_dia());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Int_intervalo_parcelamentoT> getByInt_perc_valor(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.int_intervalo_parcelamento where  int_perc_valor = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, int_intervalo_parcelamentoT.getInt_perc_valor());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Int_intervalo_parcelamentoT> getByPar_nr_id(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.int_intervalo_parcelamento where  par_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, int_intervalo_parcelamentoT.getPar_nr_id());
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
	 public List<Int_intervalo_parcelamentoT> getByPar_parcelamento(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.int_intervalo_parcelamento where par_parcelamento.par_nr_id=?  ";
			 pStmt = createPrepareStatment(sql);
		 pStmt.setObject(1, int_intervalo_parcelamentoT.getPar_nr_id());
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