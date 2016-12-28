package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Usu_loj_usuario_lojaService", urlPatterns = {"/br.com.i9.finance.Main/rpc/usu_loj_usuario_lojaservice"})
public class Usu_loj_usuario_lojaServiceImpl extends RemoteServiceServlet implements Usu_loj_usuario_lojaService {

	public void insert(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
	  Usu_loj_usuario_lojaBL usu_loj_usuario_lojaBL = new Usu_loj_usuario_lojaBL();
	  usu_loj_usuario_lojaBL.insert(usu_loj_usuario_lojaT); 
	}

        public Usu_loj_usuario_lojaT findById(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
	  Usu_loj_usuario_lojaBL usu_loj_usuario_lojaBL = new Usu_loj_usuario_lojaBL();
	  return usu_loj_usuario_lojaBL.findbyid(usu_loj_usuario_lojaT); 
	}

    	public List<Usu_loj_usuario_lojaT> getAll() throws Exception {
	  Usu_loj_usuario_lojaBL usu_loj_usuario_lojaBL = new Usu_loj_usuario_lojaBL();
	  return usu_loj_usuario_lojaBL.consult(); 
	}

	public void delete(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
	  Usu_loj_usuario_lojaBL usu_loj_usuario_lojaBL = new Usu_loj_usuario_lojaBL();
	  usu_loj_usuario_lojaBL.delete(usu_loj_usuario_lojaT); 
	}

	public void update(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception {
	  Usu_loj_usuario_lojaBL usu_loj_usuario_lojaBL = new Usu_loj_usuario_lojaBL();
	  usu_loj_usuario_lojaBL.update(usu_loj_usuario_lojaT); 
	}
}
