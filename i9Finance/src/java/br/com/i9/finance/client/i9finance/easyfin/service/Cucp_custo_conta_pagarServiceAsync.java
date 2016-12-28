package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Cucp_custo_conta_pagarServiceAsync  {

	public void insert(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT, AsyncCallback<Void> asyncCallback );
        public void findById(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT, AsyncCallback<Cucp_custo_conta_pagarT> asyncCallback);
    	public void getAll(AsyncCallback<List<Cucp_custo_conta_pagarT>> asyncCallback);
	public void delete(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT, AsyncCallback<Void> asyncCallback);
	public void update(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT, AsyncCallback<Void> asyncCallback);
}
