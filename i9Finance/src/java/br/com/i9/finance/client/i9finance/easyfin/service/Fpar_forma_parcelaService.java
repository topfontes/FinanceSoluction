package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/fpar_forma_parcelaservice")
public interface Fpar_forma_parcelaService  extends RemoteService {

	public void insert(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception;
        public Fpar_forma_parcelaT findById(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception;
    	public List<Fpar_forma_parcelaT> getAll() throws Exception;
	public void delete(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception;
	public void update(Fpar_forma_parcelaT fpar_forma_parcelaT) throws Exception;
}
