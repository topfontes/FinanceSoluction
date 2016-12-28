package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Par_parcelamentoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/par_parcelamentoservice"})
public class Par_parcelamentoServiceImpl extends RemoteServiceServlet implements Par_parcelamentoService {

	public void insert(Par_parcelamentoT par_parcelamentoT) throws Exception {
	  Par_parcelamentoBL par_parcelamentoBL = new Par_parcelamentoBL();
	  par_parcelamentoBL.insert(par_parcelamentoT); 
	}

        public Par_parcelamentoT findById(Par_parcelamentoT par_parcelamentoT) throws Exception {
	  Par_parcelamentoBL par_parcelamentoBL = new Par_parcelamentoBL();
	  return par_parcelamentoBL.findbyid(par_parcelamentoT); 
	}

    	public List<Par_parcelamentoT> getAll() throws Exception {
	  Par_parcelamentoBL par_parcelamentoBL = new Par_parcelamentoBL();
	  return par_parcelamentoBL.consult(); 
	}

	public void delete(Par_parcelamentoT par_parcelamentoT) throws Exception {
	  Par_parcelamentoBL par_parcelamentoBL = new Par_parcelamentoBL();
	  par_parcelamentoBL.delete(par_parcelamentoT); 
	}

	public void update(Par_parcelamentoT par_parcelamentoT) throws Exception {
	  Par_parcelamentoBL par_parcelamentoBL = new Par_parcelamentoBL();
	  par_parcelamentoBL.update(par_parcelamentoT); 
	}
}
