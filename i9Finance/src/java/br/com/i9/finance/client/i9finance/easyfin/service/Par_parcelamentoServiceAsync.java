package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Par_parcelamentoServiceAsync  {

	public void insert(Par_parcelamentoT par_parcelamentoT, AsyncCallback<Void> asyncCallback );
        public void findById(Par_parcelamentoT par_parcelamentoT, AsyncCallback<Par_parcelamentoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Par_parcelamentoT>> asyncCallback);
	public void delete(Par_parcelamentoT par_parcelamentoT, AsyncCallback<Void> asyncCallback);
	public void update(Par_parcelamentoT par_parcelamentoT, AsyncCallback<Void> asyncCallback);
}
