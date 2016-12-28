package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/par_parcelamentoservice")
public interface Par_parcelamentoService  extends RemoteService {

	public void insert(Par_parcelamentoT par_parcelamentoT) throws Exception;
        public Par_parcelamentoT findById(Par_parcelamentoT par_parcelamentoT) throws Exception;
    	public List<Par_parcelamentoT> getAll() throws Exception;
	public void delete(Par_parcelamentoT par_parcelamentoT) throws Exception;
	public void update(Par_parcelamentoT par_parcelamentoT) throws Exception;
}
