package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Int_intervalo_parcelamentoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/int_intervalo_parcelamentoservice"})
public class Int_intervalo_parcelamentoServiceImpl extends RemoteServiceServlet implements Int_intervalo_parcelamentoService {

	public void insert(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
	  Int_intervalo_parcelamentoBL int_intervalo_parcelamentoBL = new Int_intervalo_parcelamentoBL();
	  int_intervalo_parcelamentoBL.insert(int_intervalo_parcelamentoT); 
	}

        public Int_intervalo_parcelamentoT findById(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
	  Int_intervalo_parcelamentoBL int_intervalo_parcelamentoBL = new Int_intervalo_parcelamentoBL();
	  return int_intervalo_parcelamentoBL.findbyid(int_intervalo_parcelamentoT); 
	}

    	public List<Int_intervalo_parcelamentoT> getAll() throws Exception {
	  Int_intervalo_parcelamentoBL int_intervalo_parcelamentoBL = new Int_intervalo_parcelamentoBL();
	  return int_intervalo_parcelamentoBL.consult(); 
	}

	public void delete(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
	  Int_intervalo_parcelamentoBL int_intervalo_parcelamentoBL = new Int_intervalo_parcelamentoBL();
	  int_intervalo_parcelamentoBL.delete(int_intervalo_parcelamentoT); 
	}

	public void update(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception {
	  Int_intervalo_parcelamentoBL int_intervalo_parcelamentoBL = new Int_intervalo_parcelamentoBL();
	  int_intervalo_parcelamentoBL.update(int_intervalo_parcelamentoT); 
	}
}
