package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Lan_lancamentoServiceAsync  {

	public void insert(Lan_lancamentoT lan_lancamentoT, AsyncCallback<Void> asyncCallback );
        public void findById(Lan_lancamentoT lan_lancamentoT, AsyncCallback<Lan_lancamentoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Lan_lancamentoT>> asyncCallback);
	public void delete(Lan_lancamentoT lan_lancamentoT, AsyncCallback<Void> asyncCallback);
	public void update(Lan_lancamentoT lan_lancamentoT, AsyncCallback<Void> asyncCallback);
}
