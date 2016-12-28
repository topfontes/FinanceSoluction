package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Cen_centro_custoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/cen_centro_custoservice"})
public class Cen_centro_custoServiceImpl extends RemoteServiceServlet implements Cen_centro_custoService {

	public void insert(Cen_centro_custoT cen_centro_custoT) throws Exception {
	  Cen_centro_custoBL cen_centro_custoBL = new Cen_centro_custoBL();
	  cen_centro_custoBL.insert(cen_centro_custoT); 
	}

        public Cen_centro_custoT findById(Cen_centro_custoT cen_centro_custoT) throws Exception {
	  Cen_centro_custoBL cen_centro_custoBL = new Cen_centro_custoBL();
	  return cen_centro_custoBL.findbyid(cen_centro_custoT); 
	}

    	public List<Cen_centro_custoT> getAll() throws Exception {
	  Cen_centro_custoBL cen_centro_custoBL = new Cen_centro_custoBL();
	  return cen_centro_custoBL.consult(); 
	}

	public void delete(Cen_centro_custoT cen_centro_custoT) throws Exception {
	  Cen_centro_custoBL cen_centro_custoBL = new Cen_centro_custoBL();
	  cen_centro_custoBL.delete(cen_centro_custoT); 
	}

	public void update(Cen_centro_custoT cen_centro_custoT) throws Exception {
	  Cen_centro_custoBL cen_centro_custoBL = new Cen_centro_custoBL();
	  cen_centro_custoBL.update(cen_centro_custoT); 
	}
}
