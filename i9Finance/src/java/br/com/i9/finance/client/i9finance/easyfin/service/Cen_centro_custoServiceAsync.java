package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Cen_centro_custoServiceAsync  {

	public void insert(Cen_centro_custoT cen_centro_custoT, AsyncCallback<Void> asyncCallback );
        public void findById(Cen_centro_custoT cen_centro_custoT, AsyncCallback<Cen_centro_custoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Cen_centro_custoT>> asyncCallback);
	public void delete(Cen_centro_custoT cen_centro_custoT, AsyncCallback<Void> asyncCallback);
	public void update(Cen_centro_custoT cen_centro_custoT, AsyncCallback<Void> asyncCallback);
}
