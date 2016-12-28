package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Ccp_conta_ct_pagarServiceAsync  {

	public void insert(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT, AsyncCallback<Void> asyncCallback );
        public void findById(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT, AsyncCallback<Ccp_conta_ct_pagarT> asyncCallback);
    	public void getAll(AsyncCallback<List<Ccp_conta_ct_pagarT>> asyncCallback);
	public void delete(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT, AsyncCallback<Void> asyncCallback);
	public void update(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT, AsyncCallback<Void> asyncCallback);
}
