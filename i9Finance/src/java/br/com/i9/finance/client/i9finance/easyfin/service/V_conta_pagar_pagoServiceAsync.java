package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface V_conta_pagar_pagoServiceAsync  {

	public void insert(V_conta_pagar_pagoT v_conta_pagar_pagoT, AsyncCallback<Void> asyncCallback );
        public void findById(V_conta_pagar_pagoT v_conta_pagar_pagoT, AsyncCallback<V_conta_pagar_pagoT> asyncCallback);
    	public void getAll(AsyncCallback<List<V_conta_pagar_pagoT>> asyncCallback);
	public void delete(V_conta_pagar_pagoT v_conta_pagar_pagoT, AsyncCallback<Void> asyncCallback);
	public void update(V_conta_pagar_pagoT v_conta_pagar_pagoT, AsyncCallback<Void> asyncCallback);
}
