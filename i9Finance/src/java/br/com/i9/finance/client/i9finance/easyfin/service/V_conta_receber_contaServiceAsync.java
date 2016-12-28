package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface V_conta_receber_contaServiceAsync  {

	public void insert(V_conta_receber_contaT v_conta_receber_contaT, AsyncCallback<Void> asyncCallback );
        public void findById(V_conta_receber_contaT v_conta_receber_contaT, AsyncCallback<V_conta_receber_contaT> asyncCallback);
    	public void getAll(AsyncCallback<List<V_conta_receber_contaT>> asyncCallback);
	public void delete(V_conta_receber_contaT v_conta_receber_contaT, AsyncCallback<Void> asyncCallback);
	public void update(V_conta_receber_contaT v_conta_receber_contaT, AsyncCallback<Void> asyncCallback);
}
