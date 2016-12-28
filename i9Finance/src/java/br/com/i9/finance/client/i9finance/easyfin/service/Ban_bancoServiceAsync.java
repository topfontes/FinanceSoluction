package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Ban_bancoServiceAsync  {

	public void insert(Ban_bancoT ban_bancoT, AsyncCallback<Void> asyncCallback );
        public void findById(Ban_bancoT ban_bancoT, AsyncCallback<Ban_bancoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Ban_bancoT>> asyncCallback);
	public void delete(Ban_bancoT ban_bancoT, AsyncCallback<Void> asyncCallback);
	public void update(Ban_bancoT ban_bancoT, AsyncCallback<Void> asyncCallback);
}
