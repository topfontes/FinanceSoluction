package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Fpar_forma_parcelaServiceAsync  {

	public void insert(Fpar_forma_parcelaT fpar_forma_parcelaT, AsyncCallback<Void> asyncCallback );
        public void findById(Fpar_forma_parcelaT fpar_forma_parcelaT, AsyncCallback<Fpar_forma_parcelaT> asyncCallback);
    	public void getAll(AsyncCallback<List<Fpar_forma_parcelaT>> asyncCallback);
	public void delete(Fpar_forma_parcelaT fpar_forma_parcelaT, AsyncCallback<Void> asyncCallback);
	public void update(Fpar_forma_parcelaT fpar_forma_parcelaT, AsyncCallback<Void> asyncCallback);
}
