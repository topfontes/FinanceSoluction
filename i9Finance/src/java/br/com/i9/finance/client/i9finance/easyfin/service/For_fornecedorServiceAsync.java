package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface For_fornecedorServiceAsync  {

	public void insert(For_fornecedorT for_fornecedorT, AsyncCallback<Void> asyncCallback );
        public void findById(For_fornecedorT for_fornecedorT, AsyncCallback<For_fornecedorT> asyncCallback);
    	public void getAll(AsyncCallback<List<For_fornecedorT>> asyncCallback);
	public void delete(For_fornecedorT for_fornecedorT, AsyncCallback<Void> asyncCallback);
	public void update(For_fornecedorT for_fornecedorT, AsyncCallback<Void> asyncCallback);
}
