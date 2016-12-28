package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Loj_lojaDAO extends ObjectDAOCluster { 
	 public Loj_lojaDAO(DAOFactoryCluster dao) throws Exception {
		 setdAOFactoryCluster(dao);
 	 }

	 public void insert(Loj_lojaT loj_lojaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyfin.loj_loja  ( loj_tx_razao_social, loj_tx_matriz, loj_tx_nome_fantasia, loj_tx_cidade, loj_tx_status, loj_tx_cnpj, loj_tx_inscricao, loj_tx_estado, loj_tx_bairro, loj_tx_cep, loj_tx_endereco, loj_tx_email, loj_tx_home_page) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, loj_lojaT.getLoj_tx_razao_social());
			 pStmt.setObject(2, loj_lojaT.getLoj_tx_matriz());
			 pStmt.setObject(3, loj_lojaT.getLoj_tx_nome_fantasia());
			 pStmt.setObject(4, loj_lojaT.getLoj_tx_cidade());
			 pStmt.setObject(5, loj_lojaT.getLoj_tx_status());
			 pStmt.setObject(6, loj_lojaT.getLoj_tx_cnpj());
			 pStmt.setObject(7, loj_lojaT.getLoj_tx_inscricao());
			 pStmt.setObject(8, loj_lojaT.getLoj_tx_estado());
			 pStmt.setObject(9, loj_lojaT.getLoj_tx_bairro());
			 pStmt.setObject(10, loj_lojaT.getLoj_tx_cep());
			 pStmt.setObject(11, loj_lojaT.getLoj_tx_endereco());
			 pStmt.setObject(12, loj_lojaT.getLoj_tx_email());
			 pStmt.setObject(13, loj_lojaT.getLoj_tx_home_page());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Loj_lojaT loj_lojaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyfin.loj_loja set  loj_tx_razao_social=?, loj_tx_matriz=?, loj_tx_nome_fantasia=?, loj_tx_cidade=?, loj_tx_status=?, loj_tx_cnpj=?, loj_tx_inscricao=?, loj_tx_estado=?, loj_tx_bairro=?, loj_tx_cep=?, loj_tx_endereco=?, loj_tx_email=?, loj_tx_home_page=?  where  loj_nr_id=?";
 			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, loj_lojaT.getLoj_tx_razao_social());
			 pStmt.setObject(2, loj_lojaT.getLoj_tx_matriz());
			 pStmt.setObject(3, loj_lojaT.getLoj_tx_nome_fantasia());
			 pStmt.setObject(4, loj_lojaT.getLoj_tx_cidade());
			 pStmt.setObject(5, loj_lojaT.getLoj_tx_status());
			 pStmt.setObject(6, loj_lojaT.getLoj_tx_cnpj());
			 pStmt.setObject(7, loj_lojaT.getLoj_tx_inscricao());
			 pStmt.setObject(8, loj_lojaT.getLoj_tx_estado());
			 pStmt.setObject(9, loj_lojaT.getLoj_tx_bairro());
			 pStmt.setObject(10, loj_lojaT.getLoj_tx_cep());
			 pStmt.setObject(11, loj_lojaT.getLoj_tx_endereco());
			 pStmt.setObject(12, loj_lojaT.getLoj_tx_email());
			 pStmt.setObject(13, loj_lojaT.getLoj_tx_home_page());
			 pStmt.setObject(14, loj_lojaT.getLoj_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Loj_lojaT loj_lojaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyfin.loj_loja where  loj_nr_id=?";
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, loj_lojaT.getLoj_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Loj_lojaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Loj_lojaT> objs = new Vector();
		 while (rs.next()) { 
 			 Loj_lojaT loj_lojaT = new Loj_lojaT();
			 loj_lojaT.setLoj_tx_razao_social(rs.getString("loj_tx_razao_social"));
			 loj_lojaT.setLoj_tx_matriz(rs.getString("loj_tx_matriz"));
			 loj_lojaT.setLoj_tx_nome_fantasia(rs.getString("loj_tx_nome_fantasia"));
			 loj_lojaT.setLoj_tx_cidade(rs.getString("loj_tx_cidade"));
			 loj_lojaT.setLoj_tx_status(rs.getString("loj_tx_status"));
			 loj_lojaT.setLoj_tx_cnpj(rs.getString("loj_tx_cnpj"));
			 loj_lojaT.setLoj_tx_inscricao(rs.getString("loj_tx_inscricao"));
			 loj_lojaT.setLoj_tx_estado(rs.getString("loj_tx_estado"));
			 loj_lojaT.setLoj_tx_bairro(rs.getString("loj_tx_bairro"));
			 loj_lojaT.setLoj_tx_cep(rs.getString("loj_tx_cep"));
			 loj_lojaT.setLoj_tx_endereco(rs.getString("loj_tx_endereco"));
			 loj_lojaT.setLoj_tx_email(rs.getString("loj_tx_email"));
			 loj_lojaT.setLoj_tx_home_page(rs.getString("loj_tx_home_page"));
			 loj_lojaT.setLoj_nr_id(rs.getInt("loj_nr_id"));
			 objs.add(loj_lojaT);
 		 }
 		 return objs; 
 	 }
	 public List<Loj_lojaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja"; 
			 pStmt = createPrepareStatment(sql);
			 rs = pStmt.executeQuery();
 			 List<Loj_lojaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByPK(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  loj_nr_id=?"; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, loj_lojaT.getLoj_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_razao_social(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_razao_social) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_razao_social()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_matriz(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_matriz) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_matriz()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_nome_fantasia(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_nome_fantasia) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_nome_fantasia()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_cidade(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_cidade) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_cidade()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_status(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_status) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_status()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_cnpj(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_cnpj) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_cnpj()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_inscricao(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_inscricao) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_inscricao()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_estado(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_estado) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_estado()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_bairro(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_bairro) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_bairro()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_cep(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_cep) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_cep()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_endereco(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_endereco) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_endereco()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_email(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_email) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_email()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_tx_home_page(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  Upper(loj_tx_home_page) like Upper(?) "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, '%' + loj_lojaT.getLoj_tx_home_page()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Loj_lojaT> getByLoj_nr_id(Loj_lojaT loj_lojaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyfin.loj_loja where  loj_nr_id = ? "; 
			 pStmt = createPrepareStatment(sql);
			 pStmt.setObject(1, loj_lojaT.getLoj_nr_id());
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