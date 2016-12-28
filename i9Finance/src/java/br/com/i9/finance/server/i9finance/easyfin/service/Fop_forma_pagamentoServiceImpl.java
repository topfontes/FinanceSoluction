package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;


@WebServlet(name = "Fop_forma_pagamentoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/fop_forma_pagamentoservice"})
public class Fop_forma_pagamentoServiceImpl extends RemoteServiceServlet implements Fop_forma_pagamentoService {

    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }    
	public void insert(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
	  Fop_forma_pagamentoBL fop_forma_pagamentoBL = new Fop_forma_pagamentoBL();
	  fop_forma_pagamentoBL.insert(fop_forma_pagamentoT); 
	}

        public Fop_forma_pagamentoT findById(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
	  Fop_forma_pagamentoBL fop_forma_pagamentoBL = new Fop_forma_pagamentoBL();
	  return fop_forma_pagamentoBL.findbyid(fop_forma_pagamentoT); 
	}

    	public List<Fop_forma_pagamentoT> getAll() throws Exception {
	  Fop_forma_pagamentoBL fop_forma_pagamentoBL = new Fop_forma_pagamentoBL();
	  return fop_forma_pagamentoBL.consult(getUsuarioLogado()); 
	}

	public void delete(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
	  Fop_forma_pagamentoBL fop_forma_pagamentoBL = new Fop_forma_pagamentoBL();
	  fop_forma_pagamentoBL.delete(fop_forma_pagamentoT); 
	}

	public void update(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
	  Fop_forma_pagamentoBL fop_forma_pagamentoBL = new Fop_forma_pagamentoBL();
	  fop_forma_pagamentoBL.update(fop_forma_pagamentoT); 
	}
}
