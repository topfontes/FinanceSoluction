package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Loj_lojaService", urlPatterns = {"/br.com.i9.finance.Main/rpc/loj_lojaservice"})
public class Loj_lojaServiceImpl extends RemoteServiceServlet implements Loj_lojaService {

	public void insert(Loj_lojaT loj_lojaT) throws Exception {
	  Loj_lojaBL loj_lojaBL = new Loj_lojaBL();
	  loj_lojaBL.insert(loj_lojaT); 
	}

        public Loj_lojaT findById(Loj_lojaT loj_lojaT) throws Exception {
	  Loj_lojaBL loj_lojaBL = new Loj_lojaBL();
	  return loj_lojaBL.findbyid(loj_lojaT); 
	}

    	public List<Loj_lojaT> getAll() throws Exception {
	  Loj_lojaBL loj_lojaBL = new Loj_lojaBL();
	  return loj_lojaBL.consult(); 
	}

	public void delete(Loj_lojaT loj_lojaT) throws Exception {
	  Loj_lojaBL loj_lojaBL = new Loj_lojaBL();
	  loj_lojaBL.delete(loj_lojaT); 
	}

	public void update(Loj_lojaT loj_lojaT) throws Exception {
	  Loj_lojaBL loj_lojaBL = new Loj_lojaBL();
	  loj_lojaBL.update(loj_lojaT); 
	}
}
