package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/cli_clienteservice")
public interface Cli_clienteService  extends RemoteService {

	public void insert(Cli_clienteT cli_clienteT) throws Exception;
        public Cli_clienteT findById(Cli_clienteT cli_clienteT) throws Exception;
    	public List<Cli_clienteT> getAll() throws Exception;
	public void delete(Cli_clienteT cli_clienteT) throws Exception;
	public void update(Cli_clienteT cli_clienteT) throws Exception;
}
