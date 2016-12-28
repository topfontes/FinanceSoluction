package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class V_lan_centro_custoDAO extends ObjectDAOCluster { 
	 public V_lan_centro_custoDAO(DAOFactoryCluster dao) throws Exception {
		 setdAOFactoryCluster(dao);
 	 }

	 public void insert(V_lan_centro_custoT v_lan_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyfin.v_lan_centro_custo  ( lcc_nr_id, cen_nr_id, lan_nr_id, plc_nr_id, lcc_dt_lancamento, lcc_valor, plc_tx_nome, cen_tx_nome, lan_tx_historico, loj_nr_id) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_lan_centro_custoT.getLcc_nr_id());
			 pStmt.setObject(2, v_lan_centro_custoT.getCen_nr_id());
			 pStmt.setObject(3, v_lan_centro_custoT.getLan_nr_id());
			 pStmt.setObject(4, v_lan_centro_custoT.getPlc_nr_id());
		 java.sql.Date dt5= new java.sql.Date(v_lan_centro_custoT.getLcc_dt_lancamento().getTime());
			 pStmt.setObject(5, dt5);
			 pStmt.setObject(6, v_lan_centro_custoT.getLcc_valor());
			 pStmt.setObject(7, v_lan_centro_custoT.getPlc_tx_nome());
			 pStmt.setObject(8, v_lan_centro_custoT.getCen_tx_nome());
			 pStmt.setObject(9, v_lan_centro_custoT.getLan_tx_historico());
			 pStmt.setObject(10, v_lan_centro_custoT.getLoj_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(V_lan_centro_custoT v_lan_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyfin.v_lan_centro_custo set  lcc_nr_id=?, cen_nr_id=?, lan_nr_id=?, plc_nr_id=?, lcc_dt_lancamento=?, lcc_valor=?, plc_tx_nome=?, cen_tx_nome=?, lan_tx_historico=?, loj_nr_id=?  where -";
 			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_lan_centro_custoT.getLcc_nr_id());
			 pStmt.setObject(2, v_lan_centro_custoT.getCen_nr_id());
			 pStmt.setObject(3, v_lan_centro_custoT.getLan_nr_id());
			 pStmt.setObject(4, v_lan_centro_custoT.getPlc_nr_id());
		 java.sql.Date dt5= new java.sql.Date(v_lan_centro_custoT.getLcc_dt_lancamento().getTime());
			 pStmt.setObject(5, dt5);
			 pStmt.setObject(6, v_lan_centro_custoT.getLcc_valor());
			 pStmt.setObject(7, v_lan_centro_custoT.getPlc_tx_nome());
			 pStmt.setObject(8, v_lan_centro_custoT.getCen_tx_nome());
			 pStmt.setObject(9, v_lan_centro_custoT.getLan_tx_historico());
			 pStmt.setObject(10, v_lan_centro_custoT.getLoj_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(V_lan_centro_custoT v_lan_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyfin.v_lan_centro_custo where -";
			 pStmt = createPrepareStatment(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<V_lan_centro_custoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<V_lan_centro_custoT> objs = new Vector();
		 while (rs.next()) { 
 			 V_lan_centro_custoT v_lan_centro_custoT = new V_lan_centro_custoT();
			 v_lan_centro_custoT.setLcc_nr_id(rs.getInt("lcc_nr_id"));
			 v_lan_centro_custoT.setCen_nr_id(rs.getInt("cen_nr_id"));
			 v_lan_centro_custoT.setLan_nr_id(rs.getInt("lan_nr_id"));
			 v_lan_centro_custoT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 v_lan_centro_custoT.setLcc_dt_lancamento(rs.getDate("lcc_dt_lancamento"));
			 v_lan_centro_custoT.setLcc_valor(rs.getDouble("lcc_valor"));
			 v_lan_centro_custoT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
			 v_lan_centro_custoT.setCen_tx_nome(rs.getString("cen_tx_nome"));
			 v_lan_centro_custoT.setLan_tx_historico(rs.getString("lan_tx_historico"));
			 v_lan_centro_custoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
			 objs.add(v_lan_centro_custoT);
 		 }
 		 return objs; 
 	 }
	 public List<V_lan_centro_custoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 List<V_lan_centro_custoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByPK(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where -"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByLcc_nr_id(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  lcc_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_lan_centro_custoT.getLcc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByCen_nr_id(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  cen_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_lan_centro_custoT.getCen_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByLan_nr_id(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  lan_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_lan_centro_custoT.getLan_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByPlc_nr_id(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  plc_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_lan_centro_custoT.getPlc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByLcc_dt_lancamento(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  lcc_dt_lancamento = ? "; 
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_lan_centro_custoT.getLcc_dt_lancamento().getTime());
			 pStmt.setObject(1,dt1);
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByLcc_valor(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  lcc_valor = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_lan_centro_custoT.getLcc_valor());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByPlc_tx_nome(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  Upper(plc_tx_nome) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_lan_centro_custoT.getPlc_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByCen_tx_nome(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  Upper(cen_tx_nome) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_lan_centro_custoT.getCen_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByLan_tx_historico(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  Upper(lan_tx_historico) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_lan_centro_custoT.getLan_tx_historico()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_lan_centro_custoT> getByLoj_nr_id(V_lan_centro_custoT v_lan_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_lan_centro_custo where  loj_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_lan_centro_custoT.getLoj_nr_id());
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