package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Ban_bancoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/ban_bancoservice"})
public class Ban_bancoServiceImpl extends RemoteServiceServlet implements Ban_bancoService {

	public void insert(Ban_bancoT ban_bancoT) throws Exception {
	  Ban_bancoBL ban_bancoBL = new Ban_bancoBL();
	  ban_bancoBL.insert(ban_bancoT); 
	}

        public Ban_bancoT findById(Ban_bancoT ban_bancoT) throws Exception {
	  Ban_bancoBL ban_bancoBL = new Ban_bancoBL();
	  return ban_bancoBL.findbyid(ban_bancoT); 
	}

    	public List<Ban_bancoT> getAll() throws Exception {
	  Ban_bancoBL ban_bancoBL = new Ban_bancoBL();
	  return ban_bancoBL.consult(); 
	}

	public void delete(Ban_bancoT ban_bancoT) throws Exception {
	  Ban_bancoBL ban_bancoBL = new Ban_bancoBL();
	  ban_bancoBL.delete(ban_bancoT); 
	}

	public void update(Ban_bancoT ban_bancoT) throws Exception {
	  Ban_bancoBL ban_bancoBL = new Ban_bancoBL();
	  ban_bancoBL.update(ban_bancoT); 
	}
}
