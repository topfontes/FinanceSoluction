package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Cli_clienteServiceAsync  {

	public void insert(Cli_clienteT cli_clienteT, AsyncCallback<Void> asyncCallback );
        public void findById(Cli_clienteT cli_clienteT, AsyncCallback<Cli_clienteT> asyncCallback);
    	public void getAll(AsyncCallback<List<Cli_clienteT>> asyncCallback);
	public void delete(Cli_clienteT cli_clienteT, AsyncCallback<Void> asyncCallback);
	public void update(Cli_clienteT cli_clienteT, AsyncCallback<Void> asyncCallback);
}
