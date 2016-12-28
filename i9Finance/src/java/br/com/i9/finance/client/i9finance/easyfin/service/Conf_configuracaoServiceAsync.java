package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Conf_configuracaoServiceAsync  {

	public void insert(Conf_configuracaoT conf_configuracaoT, AsyncCallback<Void> asyncCallback );
        public void findById(Conf_configuracaoT conf_configuracaoT, AsyncCallback<Conf_configuracaoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Conf_configuracaoT>> asyncCallback);
	public void delete(Conf_configuracaoT conf_configuracaoT, AsyncCallback<Void> asyncCallback);
	public void update(Conf_configuracaoT conf_configuracaoT, AsyncCallback<Void> asyncCallback);
}
