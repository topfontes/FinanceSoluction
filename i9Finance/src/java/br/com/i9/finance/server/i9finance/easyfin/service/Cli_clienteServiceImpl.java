package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "Cli_clienteService", urlPatterns = {"/br.com.i9.finance.Main/rpc/cli_clienteservice"})
public class Cli_clienteServiceImpl extends RemoteServiceServlet implements Cli_clienteService {

    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }       
    
	public void insert(Cli_clienteT cli_clienteT) throws Exception {
	  Cli_clienteBL cli_clienteBL = new Cli_clienteBL();
	  cli_clienteBL.insert(cli_clienteT,getUsuarioLogado()); 
	}

        public Cli_clienteT findById(Cli_clienteT cli_clienteT) throws Exception {
	  Cli_clienteBL cli_clienteBL = new Cli_clienteBL();
	  return cli_clienteBL.findbyid(cli_clienteT); 
	}

    	public List<Cli_clienteT> getAll() throws Exception {
	  Cli_clienteBL cli_clienteBL = new Cli_clienteBL();
	  return cli_clienteBL.consult(getUsuarioLogado()); 
	}

	public void delete(Cli_clienteT cli_clienteT) throws Exception {
	  Cli_clienteBL cli_clienteBL = new Cli_clienteBL();
	  cli_clienteBL.delete(cli_clienteT); 
	}

	public void update(Cli_clienteT cli_clienteT) throws Exception {
	  Cli_clienteBL cli_clienteBL = new Cli_clienteBL();
	  cli_clienteBL.update(cli_clienteT); 
	}
}
