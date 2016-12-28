package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Lcc_lancamento_centro_custoServiceAsync  {

	public void insert(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT, AsyncCallback<Void> asyncCallback );
        public void findById(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT, AsyncCallback<Lcc_lancamento_centro_custoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Lcc_lancamento_centro_custoT>> asyncCallback);
	public void delete(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT, AsyncCallback<Void> asyncCallback);
	public void update(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT, AsyncCallback<Void> asyncCallback);
}
