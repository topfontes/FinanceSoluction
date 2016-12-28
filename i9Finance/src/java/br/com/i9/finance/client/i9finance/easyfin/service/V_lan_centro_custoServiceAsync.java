package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface V_lan_centro_custoServiceAsync  {

	public void insert(V_lan_centro_custoT v_lan_centro_custoT, AsyncCallback<Void> asyncCallback );
        public void findById(V_lan_centro_custoT v_lan_centro_custoT, AsyncCallback<V_lan_centro_custoT> asyncCallback);
    	public void getAll(AsyncCallback<List<V_lan_centro_custoT>> asyncCallback);
	public void delete(V_lan_centro_custoT v_lan_centro_custoT, AsyncCallback<Void> asyncCallback);
	public void update(V_lan_centro_custoT v_lan_centro_custoT, AsyncCallback<Void> asyncCallback);
}
