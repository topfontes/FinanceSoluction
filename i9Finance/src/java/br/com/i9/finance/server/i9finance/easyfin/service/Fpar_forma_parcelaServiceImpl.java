package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Fpar_forma_parcelaService", urlPatterns = {"/br.com.i9.finance.Main/rpc/fpar_forma_parcelaservice"})
public class Fpar_forma_parcelaServiceImpl extends RemoteServiceServlet implements Fpar_forma_parcelaService {

	public void insert(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
	  Fpar_forma_parcelaBL fpar_forma_parcelaBL = new Fpar_forma_parcelaBL();
	  fpar_forma_parcelaBL.insert(fpar_forma_parcelaT); 
	}

        public Fpar_forma_parcelaT findById(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
	  Fpar_forma_parcelaBL fpar_forma_parcelaBL = new Fpar_forma_parcelaBL();
	  return fpar_forma_parcelaBL.findbyid(fpar_forma_parcelaT); 
	}

    	public List<Fpar_forma_parcelaT> getAll() throws Exception {
	  Fpar_forma_parcelaBL fpar_forma_parcelaBL = new Fpar_forma_parcelaBL();
	  return fpar_forma_parcelaBL.consult(); 
	}

	public void delete(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
	  Fpar_forma_parcelaBL fpar_forma_parcelaBL = new Fpar_forma_parcelaBL();
	  fpar_forma_parcelaBL.delete(fpar_forma_parcelaT); 
	}

	public void update(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception {
	  Fpar_forma_parcelaBL fpar_forma_parcelaBL = new Fpar_forma_parcelaBL();
	  fpar_forma_parcelaBL.update(fpar_forma_parcelaT); 
	}
}
