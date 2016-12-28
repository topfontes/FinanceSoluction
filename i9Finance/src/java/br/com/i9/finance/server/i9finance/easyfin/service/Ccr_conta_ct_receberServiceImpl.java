package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Ccr_conta_ct_receberService", urlPatterns = {"/br.com.i9.finance.Main/rpc/ccr_conta_ct_receberservice"})
public class Ccr_conta_ct_receberServiceImpl extends RemoteServiceServlet implements Ccr_conta_ct_receberService {

	public void insert(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
	  Ccr_conta_ct_receberBL ccr_conta_ct_receberBL = new Ccr_conta_ct_receberBL();
	  ccr_conta_ct_receberBL.insert(ccr_conta_ct_receberT); 
	}

        public Ccr_conta_ct_receberT findById(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
	  Ccr_conta_ct_receberBL ccr_conta_ct_receberBL = new Ccr_conta_ct_receberBL();
	  return ccr_conta_ct_receberBL.findbyid(ccr_conta_ct_receberT); 
	}

    	public List<Ccr_conta_ct_receberT> getAll() throws Exception {
	  Ccr_conta_ct_receberBL ccr_conta_ct_receberBL = new Ccr_conta_ct_receberBL();
	  return ccr_conta_ct_receberBL.consult(); 
	}

	public void delete(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
	  Ccr_conta_ct_receberBL ccr_conta_ct_receberBL = new Ccr_conta_ct_receberBL();
	  ccr_conta_ct_receberBL.delete(ccr_conta_ct_receberT); 
	}

	public void update(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception {
	  Ccr_conta_ct_receberBL ccr_conta_ct_receberBL = new Ccr_conta_ct_receberBL();
	  ccr_conta_ct_receberBL.update(ccr_conta_ct_receberT); 
	}
}
