package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Ccp_conta_ct_pagarService", urlPatterns = {"/br.com.i9.finance.Main/rpc/ccp_conta_ct_pagarservice"})
public class Ccp_conta_ct_pagarServiceImpl extends RemoteServiceServlet implements Ccp_conta_ct_pagarService {

	public void insert(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
	  Ccp_conta_ct_pagarBL ccp_conta_ct_pagarBL = new Ccp_conta_ct_pagarBL();
	  ccp_conta_ct_pagarBL.insert(ccp_conta_ct_pagarT); 
	}

        public Ccp_conta_ct_pagarT findById(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
	  Ccp_conta_ct_pagarBL ccp_conta_ct_pagarBL = new Ccp_conta_ct_pagarBL();
	  return ccp_conta_ct_pagarBL.findbyid(ccp_conta_ct_pagarT); 
	}

    	public List<Ccp_conta_ct_pagarT> getAll() throws Exception {
	  Ccp_conta_ct_pagarBL ccp_conta_ct_pagarBL = new Ccp_conta_ct_pagarBL();
	  return ccp_conta_ct_pagarBL.consult(); 
	}

	public void delete(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
	  Ccp_conta_ct_pagarBL ccp_conta_ct_pagarBL = new Ccp_conta_ct_pagarBL();
	  ccp_conta_ct_pagarBL.delete(ccp_conta_ct_pagarT); 
	}

	public void update(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception {
	  Ccp_conta_ct_pagarBL ccp_conta_ct_pagarBL = new Ccp_conta_ct_pagarBL();
	  ccp_conta_ct_pagarBL.update(ccp_conta_ct_pagarT); 
	}
}
