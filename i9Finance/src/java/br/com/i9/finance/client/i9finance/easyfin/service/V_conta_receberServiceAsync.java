package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface V_conta_receberServiceAsync  {

	public void insert(V_conta_receberT v_conta_receberT, AsyncCallback<Void> asyncCallback );
        public void findById(V_conta_receberT v_conta_receberT, AsyncCallback<V_conta_receberT> asyncCallback);
	public void delete(V_conta_receberT v_conta_receberT, AsyncCallback<Void> asyncCallback);
	public void update(V_conta_receberT v_conta_receberT, AsyncCallback<Void> asyncCallback);

    public void getAll(Date dt_inicio, Date dt_final, String pago, AsyncCallback<List<V_conta_receberT>> asyncCallback);

}
