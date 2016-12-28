package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class V_conta_pagar_pago_contaDAO extends ObjectDAOCluster { 
	 public V_conta_pagar_pago_contaDAO(DAOFactoryCluster dao) throws Exception {
		 setdAOFactoryCluster(dao);
 	 }

	 public void insert(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyfin.v_conta_pagar_pago_conta  ( dt_pagamento, valor, id_cli_fab, nome, fop_nr_id, forma, ban_nr_id, banco, pago, parcela, documento, dt_emissao, vencimento, obs, car_nr_id, cartao, plc_nr_id, conta, loj_nr_id) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_pagar_pago_contaT.getDt_pagamento().getTime());
			 pStmt.setObject(1, dt1);
			 pStmt.setObject(2, v_conta_pagar_pago_contaT.getValor());
			 pStmt.setObject(3, v_conta_pagar_pago_contaT.getId_cli_fab());
			 pStmt.setObject(4, v_conta_pagar_pago_contaT.getNome());
			 pStmt.setObject(5, v_conta_pagar_pago_contaT.getFop_nr_id());
			 pStmt.setObject(6, v_conta_pagar_pago_contaT.getForma());
			 pStmt.setObject(7, v_conta_pagar_pago_contaT.getBan_nr_id());
			 pStmt.setObject(8, v_conta_pagar_pago_contaT.getBanco());
			 pStmt.setObject(9, v_conta_pagar_pago_contaT.getPago());
			 pStmt.setObject(10, v_conta_pagar_pago_contaT.getParcela());
			 pStmt.setObject(11, v_conta_pagar_pago_contaT.getDocumento());
		 java.sql.Date dt12= new java.sql.Date(v_conta_pagar_pago_contaT.getDt_emissao().getTime());
			 pStmt.setObject(12, dt12);
		 java.sql.Date dt13= new java.sql.Date(v_conta_pagar_pago_contaT.getVencimento().getTime());
			 pStmt.setObject(13, dt13);
			 pStmt.setObject(14, v_conta_pagar_pago_contaT.getObs());
			 pStmt.setObject(15, v_conta_pagar_pago_contaT.getCar_nr_id());
			 pStmt.setObject(16, v_conta_pagar_pago_contaT.getCartao());
			 pStmt.setObject(17, v_conta_pagar_pago_contaT.getPlc_nr_id());
			 pStmt.setObject(18, v_conta_pagar_pago_contaT.getConta());
			 pStmt.setObject(19, v_conta_pagar_pago_contaT.getLoj_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyfin.v_conta_pagar_pago_conta set  dt_pagamento=?, valor=?, id_cli_fab=?, nome=?, fop_nr_id=?, forma=?, ban_nr_id=?, banco=?, pago=?, parcela=?, documento=?, dt_emissao=?, vencimento=?, obs=?, car_nr_id=?, cartao=?, plc_nr_id=?, conta=?, loj_nr_id=?  where -";
 			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_pagar_pago_contaT.getDt_pagamento().getTime());
			 pStmt.setObject(1, dt1);
			 pStmt.setObject(2, v_conta_pagar_pago_contaT.getValor());
			 pStmt.setObject(3, v_conta_pagar_pago_contaT.getId_cli_fab());
			 pStmt.setObject(4, v_conta_pagar_pago_contaT.getNome());
			 pStmt.setObject(5, v_conta_pagar_pago_contaT.getFop_nr_id());
			 pStmt.setObject(6, v_conta_pagar_pago_contaT.getForma());
			 pStmt.setObject(7, v_conta_pagar_pago_contaT.getBan_nr_id());
			 pStmt.setObject(8, v_conta_pagar_pago_contaT.getBanco());
			 pStmt.setObject(9, v_conta_pagar_pago_contaT.getPago());
			 pStmt.setObject(10, v_conta_pagar_pago_contaT.getParcela());
			 pStmt.setObject(11, v_conta_pagar_pago_contaT.getDocumento());
		 java.sql.Date dt12= new java.sql.Date(v_conta_pagar_pago_contaT.getDt_emissao().getTime());
			 pStmt.setObject(12, dt12);
		 java.sql.Date dt13= new java.sql.Date(v_conta_pagar_pago_contaT.getVencimento().getTime());
			 pStmt.setObject(13, dt13);
			 pStmt.setObject(14, v_conta_pagar_pago_contaT.getObs());
			 pStmt.setObject(15, v_conta_pagar_pago_contaT.getCar_nr_id());
			 pStmt.setObject(16, v_conta_pagar_pago_contaT.getCartao());
			 pStmt.setObject(17, v_conta_pagar_pago_contaT.getPlc_nr_id());
			 pStmt.setObject(18, v_conta_pagar_pago_contaT.getConta());
			 pStmt.setObject(19, v_conta_pagar_pago_contaT.getLoj_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyfin.v_conta_pagar_pago_conta where -";
			 pStmt = createPrepareStatment(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<V_conta_pagar_pago_contaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<V_conta_pagar_pago_contaT> objs = new Vector();
		 while (rs.next()) { 
 			 V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT = new V_conta_pagar_pago_contaT();
			 v_conta_pagar_pago_contaT.setDt_pagamento(rs.getDate("dt_pagamento"));
			 v_conta_pagar_pago_contaT.setValor(rs.getDouble("valor"));
			 v_conta_pagar_pago_contaT.setId_cli_fab(rs.getInt("id_cli_fab"));
			 v_conta_pagar_pago_contaT.setNome(rs.getString("nome"));
			 v_conta_pagar_pago_contaT.setFop_nr_id(rs.getInt("fop_nr_id"));
			 v_conta_pagar_pago_contaT.setForma(rs.getString("forma"));
			 v_conta_pagar_pago_contaT.setBan_nr_id(rs.getInt("ban_nr_id"));
			 v_conta_pagar_pago_contaT.setBanco(rs.getString("banco"));
			 v_conta_pagar_pago_contaT.setPago(rs.getString("pago"));
			 v_conta_pagar_pago_contaT.setParcela(rs.getString("parcela"));
			 v_conta_pagar_pago_contaT.setDocumento(rs.getInt("documento"));
			 v_conta_pagar_pago_contaT.setDt_emissao(rs.getDate("dt_emissao"));
			 v_conta_pagar_pago_contaT.setVencimento(rs.getDate("vencimento"));
			 v_conta_pagar_pago_contaT.setObs(rs.getString("obs"));
			 v_conta_pagar_pago_contaT.setCar_nr_id(rs.getInt("car_nr_id"));
			 v_conta_pagar_pago_contaT.setCartao(rs.getString("cartao"));
			 v_conta_pagar_pago_contaT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 v_conta_pagar_pago_contaT.setConta(rs.getString("conta"));
			 v_conta_pagar_pago_contaT.setLoj_nr_id(rs.getInt("loj_nr_id"));
			 objs.add(v_conta_pagar_pago_contaT);
 		 }
 		 return objs; 
 	 }
	 public List<V_conta_pagar_pago_contaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 List<V_conta_pagar_pago_contaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByPK(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where -"; 
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

 	 public List<V_conta_pagar_pago_contaT> getByDt_pagamento(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  dt_pagamento = ? "; 
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_pagar_pago_contaT.getDt_pagamento().getTime());
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

 	 public List<V_conta_pagar_pago_contaT> getByValor(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  valor = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_pagar_pago_contaT.getValor());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getById_cli_fab(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  id_cli_fab = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_pagar_pago_contaT.getId_cli_fab());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByNome(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  Upper(nome) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_pagar_pago_contaT.getNome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByFop_nr_id(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  fop_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_pagar_pago_contaT.getFop_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByForma(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  Upper(forma) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_pagar_pago_contaT.getForma()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByBan_nr_id(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  ban_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_pagar_pago_contaT.getBan_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByBanco(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  Upper(banco) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_pagar_pago_contaT.getBanco()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByPago(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  Upper(pago) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_pagar_pago_contaT.getPago()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByParcela(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  Upper(parcela) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_pagar_pago_contaT.getParcela()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByDocumento(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  documento = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_pagar_pago_contaT.getDocumento());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByDt_emissao(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  dt_emissao = ? "; 
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_pagar_pago_contaT.getDt_emissao().getTime());
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

 	 public List<V_conta_pagar_pago_contaT> getByVencimento(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  vencimento = ? "; 
			 pStmt = createPrepareStatment(sql);
		 java.sql.Date dt1= new java.sql.Date(v_conta_pagar_pago_contaT.getVencimento().getTime());
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

 	 public List<V_conta_pagar_pago_contaT> getByObs(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  Upper(obs) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_pagar_pago_contaT.getObs()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByCar_nr_id(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  car_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_pagar_pago_contaT.getCar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByCartao(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  Upper(cartao) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_pagar_pago_contaT.getCartao()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByPlc_nr_id(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  plc_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_pagar_pago_contaT.getPlc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByConta(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  Upper(conta) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + v_conta_pagar_pago_contaT.getConta()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<V_conta_pagar_pago_contaT> getByLoj_nr_id(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.v_conta_pagar_pago_conta where  loj_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, v_conta_pagar_pago_contaT.getLoj_nr_id());
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