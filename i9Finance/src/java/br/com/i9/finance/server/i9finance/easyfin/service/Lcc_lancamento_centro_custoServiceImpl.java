package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Lcc_lancamento_centro_custoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/lcc_lancamento_centro_custoservice"})
public class Lcc_lancamento_centro_custoServiceImpl extends RemoteServiceServlet implements Lcc_lancamento_centro_custoService {

	public void insert(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
	  Lcc_lancamento_centro_custoBL lcc_lancamento_centro_custoBL = new Lcc_lancamento_centro_custoBL();
	  lcc_lancamento_centro_custoBL.insert(lcc_lancamento_centro_custoT); 
	}

        public Lcc_lancamento_centro_custoT findById(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
	  Lcc_lancamento_centro_custoBL lcc_lancamento_centro_custoBL = new Lcc_lancamento_centro_custoBL();
	  return lcc_lancamento_centro_custoBL.findbyid(lcc_lancamento_centro_custoT); 
	}

    	public List<Lcc_lancamento_centro_custoT> getAll() throws Exception {
	  Lcc_lancamento_centro_custoBL lcc_lancamento_centro_custoBL = new Lcc_lancamento_centro_custoBL();
	  return lcc_lancamento_centro_custoBL.consult(); 
	}

	public void delete(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
	  Lcc_lancamento_centro_custoBL lcc_lancamento_centro_custoBL = new Lcc_lancamento_centro_custoBL();
	  lcc_lancamento_centro_custoBL.delete(lcc_lancamento_centro_custoT); 
	}

	public void update(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception {
	  Lcc_lancamento_centro_custoBL lcc_lancamento_centro_custoBL = new Lcc_lancamento_centro_custoBL();
	  lcc_lancamento_centro_custoBL.update(lcc_lancamento_centro_custoT); 
	}
}
