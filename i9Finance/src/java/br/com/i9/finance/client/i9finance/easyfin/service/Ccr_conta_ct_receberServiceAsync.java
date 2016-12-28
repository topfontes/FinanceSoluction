package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Ccr_conta_ct_receberServiceAsync  {

	public void insert(Ccr_conta_ct_receberT ccr_conta_ct_receberT, AsyncCallback<Void> asyncCallback );
        public void findById(Ccr_conta_ct_receberT ccr_conta_ct_receberT, AsyncCallback<Ccr_conta_ct_receberT> asyncCallback);
    	public void getAll(AsyncCallback<List<Ccr_conta_ct_receberT>> asyncCallback);
	public void delete(Ccr_conta_ct_receberT ccr_conta_ct_receberT, AsyncCallback<Void> asyncCallback);
	public void update(Ccr_conta_ct_receberT ccr_conta_ct_receberT, AsyncCallback<Void> asyncCallback);
}
