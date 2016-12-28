package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/for_fornecedorservice")
public interface For_fornecedorService  extends RemoteService {

	public void insert(For_fornecedorT for_fornecedorT) throws Exception;
        public For_fornecedorT findById(For_fornecedorT for_fornecedorT) throws Exception;
    	public List<For_fornecedorT> getAll() throws Exception;
	public void delete(For_fornecedorT for_fornecedorT) throws Exception;
	public void update(For_fornecedorT for_fornecedorT) throws Exception;
}
