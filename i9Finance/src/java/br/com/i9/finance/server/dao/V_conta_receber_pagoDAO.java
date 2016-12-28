package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class V_conta_receber_pagoDAO extends ObjectDAOCluster { 
	 public V_conta_receber_pagoDAO(DAOFactoryCluster dao) throws Exception {
		 setdAOFactoryCluster(dao);
 	 }

	 public void insert(V_conta_receber_pagoT v_conta_receber_pagoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyfin.v_conta_receber_pago  ( dt_pagamento, valor, id_cli_fab, nome, fop_nr_id, forma, ban_nr_id, banco, pago, parcela, documento, dt_emissao, vencimento, obs, car_nr_id, cartao, loj_nr_id) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_receber_pagoT.getDt_pagamento().getTime());
			 pStmt.setObject(1, dt1);
			 pStmt.setObject(2, v_conta_receber_pagoT.getValor());
			 pStmt.setObject(3, v_conta_receber_pagoT.getId_cli_fab());
			 pStmt.setObject(4, v_conta_receber_pagoT.getNome());
			 pStmt.setObject(5, v_conta_receber_pagoT.getFop_nr_id());
			 pStmt.setObject(6, v_conta_receber_pagoT.getForma());
			 pStmt.setObject(7, v_conta_receber_pagoT.getBan_nr_id());
			 pStmt.setObject(8, v_conta_receber_pagoT.getBanco());
			 pStmt.setObject(9, v_conta_receber_pagoT.getPago());
			 pStmt.setObject(10, v_conta_receber_pagoT.getParcela());
			 pStmt.setObject(11, v_conta_receber_pagoT.getDocumento());
		 java.sql.Date dt12= new java.sql.Date(v_conta_receber_pagoT.getDt_emissao().getTime());
			 pStmt.setObject(12, dt12);
		 java.sql.Date dt13= new java.sql.Date(v_conta_receber_pagoT.getVencimento().getTime());
			 pStmt.setObject(13, dt13);
			 pStmt.setObject(14, v_conta_receber_pagoT.getObs());
			 pStmt.setObject(15, v_conta_receber_pagoT.getCar_nr_id());
			 pStmt.setObject(16, v_conta_receber_pagoT.getCartao());
			 pStmt.setObject(17, v_conta_receber_pagoT.getLoj_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(V_conta_receber_pagoT v_conta_receber_pagoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyfin.v_conta_receber_pago set  dt_pagamento=?, valor=?, id_cli_fab=?, nome=?, fop_nr_id=?, forma=?, ban_nr_id=?, banco=?, pago=?, parcela=?, documento=?, dt_emissao=?, vencimento=?, obs=?, car_nr_id=?, cartao=?, loj_nr_id=?  where -";
 			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_receber_pagoT.getDt_pagamento().getTime());
			 pStmt.setObject(1, dt1);
			 pStmt.setObject(2, v_conta_receber_pagoT.getValor());
			 pStmt.setObject(3, v_conta_receber_pagoT.getId_cli_fab());
			 pStmt.setObject(4, v_conta_receber_pagoT.getNome());
			 pStmt.setObject(5, v_conta_receber_pagoT.getFop_nr_id());
			 pStmt.setObject(6, v_conta_receber_pagoT.getForma());
			 pStmt.setObject(7, v_conta_receber_pagoT.getBan_nr_id());
			 pStmt.setObject(8, v_conta_receber_pagoT.getBanco());
			 pStmt.setObject(9, v_conta_receber_pagoT.getPago());
			 pStmt.setObject(10, v_conta_receber_pagoT.getParcela());
			 pStmt.setObject(11, v_conta_receber_pagoT.getDocumento());
		 java.sql.Date dt12= new java.sql.Date(v_conta_receber_pagoT.getDt_emissao().getTime());
			 pStmt.setObject(12, dt12);
		 java.sql.Date dt13= new java.sql.Date(v_conta_receber_pagoT.getVencimento().getTime());
			 pStmt.setObject(13, dt13);
			 pStmt.setObject(14, v_conta_receber_pagoT.getObs());
			 pStmt.setObject(15, v_conta_receber_pagoT.getCar_nr_id());
			 pStmt.setObject(16, v_conta_receber_pagoT.getCartao());
			 pStmt.setObject(17, v_conta_receber_pagoT.getLoj_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(V_conta_receber_pagoT v_conta_receber_pagoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyfin.v_conta_receber_pago where -";
			 pStmt = createPrepareStatment(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<V_conta_receber_pagoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<V_conta_receber_pagoT> objs = new Vector();
		 while (rs.next()) { 
 			 V_conta_receber_pagoT v_conta_receber_pagoT = new V_conta_receber_pagoT();
			 v_conta_receber_pagoT.setDt_pagamento(rs.getDate("dt_pagamento"));
			 v_conta_receber_pagoT.setValor(rs.getDouble("valor"));
			 v_conta_receber_pagoT.setId_cli_fab(rs.getInt("id_cli_fab"));
			 v_conta_receber_pagoT.setNome(rs.getString("nome"));
			 v_conta_receber_pagoT.setFop_nr_id(rs.getInt("fop_nr_id"));
			 v_conta_receber_pagoT.setForma(rs.getString("forma"));
			 v_conta_receber_pagoT.setBan_nr_id(rs.getInt("ban_nr_id"));
			 v_conta_receber_pagoT.setBanco(rs.getString("banco"));
			 v_conta_receber_pagoT.setPago(rs.getString("pago"));
			 v_conta_receber_pagoT.setParcela(rs.getString("parcela"));
			 v_conta_receber_pagoT.setDocumento(rs.getInt("documento"));
			 v_conta_receber_pagoT.setDt_emissao(rs.getDate("dt_emissao"));
			 v_conta_receber_pagoT.setVencimento(rs.getDate("vencimento"));
			 v_conta_receber_pagoT.setObs(rs.getString("obs"));
			 v_conta_receber_pagoT.setCar_nr_id(rs.getInt("car_nr_id"));
			 v_conta_receber_pagoT.setCartao(rs.getString("cartao"));
			 v_conta_receber_pagoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
			 objs.add(v_conta_receber_pagoT);
 		 }
 		 return objs; 
 	 }
	 public List<V_conta_receber_pagoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 List<V_conta_receber_pagoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByPK(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where -"; 
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

 	 public List<V_conta_receber_pagoT> getByDt_pagamento(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  dt_pagamento = ? "; 
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_receber_pagoT.getDt_pagamento().getTime());
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

 	 public List<V_conta_receber_pagoT> getByValor(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  valor = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_receber_pagoT.getValor());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getById_cli_fab(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  id_cli_fab = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_receber_pagoT.getId_cli_fab());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByNome(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  Upper(nome) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_receber_pagoT.getNome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByFop_nr_id(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  fop_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_receber_pagoT.getFop_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByForma(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  Upper(forma) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_receber_pagoT.getForma()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByBan_nr_id(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  ban_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_receber_pagoT.getBan_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByBanco(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  Upper(banco) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_receber_pagoT.getBanco()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByPago(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  Upper(pago) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_receber_pagoT.getPago()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByParcela(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  Upper(parcela) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_receber_pagoT.getParcela()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByDocumento(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  documento = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_receber_pagoT.getDocumento());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByDt_emissao(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  dt_emissao = ? "; 
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_receber_pagoT.getDt_emissao().getTime());
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

 	 public List<V_conta_receber_pagoT> getByVencimento(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  vencimento = ? "; 
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_receber_pagoT.getVencimento().getTime());
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

 	 public List<V_conta_receber_pagoT> getByObs(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  Upper(obs) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_receber_pagoT.getObs()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByCar_nr_id(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  car_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_receber_pagoT.getCar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByCartao(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  Upper(cartao) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_receber_pagoT.getCartao()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_receber_pagoT> getByLoj_nr_id(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_receber_pago where  loj_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_receber_pagoT.getLoj_nr_id());
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