package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Loj_lojaServiceAsync  {

	public void insert(Loj_lojaT loj_lojaT, AsyncCallback<Void> asyncCallback );
        public void findById(Loj_lojaT loj_lojaT, AsyncCallback<Loj_lojaT> asyncCallback);
    	public void getAll(AsyncCallback<List<Loj_lojaT>> asyncCallback);
	public void delete(Loj_lojaT loj_lojaT, AsyncCallback<Void> asyncCallback);
	public void update(Loj_lojaT loj_lojaT, AsyncCallback<Void> asyncCallback);
}
