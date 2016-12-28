package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Conf_configuracaoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/conf_configuracaoservice"})
public class Conf_configuracaoServiceImpl extends RemoteServiceServlet implements Conf_configuracaoService {

	public void insert(Conf_configuracaoT conf_configuracaoT) throws Exception {
	  Conf_configuracaoBL conf_configuracaoBL = new Conf_configuracaoBL();
	  conf_configuracaoBL.insert(conf_configuracaoT); 
	}

        public Conf_configuracaoT findById(Conf_configuracaoT conf_configuracaoT) throws Exception {
	  Conf_configuracaoBL conf_configuracaoBL = new Conf_configuracaoBL();
	  return conf_configuracaoBL.findbyid(conf_configuracaoT); 
	}

    	public List<Conf_configuracaoT> getAll() throws Exception {
	  Conf_configuracaoBL conf_configuracaoBL = new Conf_configuracaoBL();
	  return conf_configuracaoBL.consult(); 
	}

	public void delete(Conf_configuracaoT conf_configuracaoT) throws Exception {
	  Conf_configuracaoBL conf_configuracaoBL = new Conf_configuracaoBL();
	  conf_configuracaoBL.delete(conf_configuracaoT); 
	}

	public void update(Conf_configuracaoT conf_configuracaoT) throws Exception {
	  Conf_configuracaoBL conf_configuracaoBL = new Conf_configuracaoBL();
	  conf_configuracaoBL.update(conf_configuracaoT); 
	}
}
