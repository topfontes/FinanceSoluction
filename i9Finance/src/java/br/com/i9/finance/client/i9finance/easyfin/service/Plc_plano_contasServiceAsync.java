package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Plc_plano_contasServiceAsync  {

	public void insert(Plc_plano_contasT plc_plano_contasT, AsyncCallback<Void> asyncCallback );
        public void findById(Plc_plano_contasT plc_plano_contasT, AsyncCallback<Plc_plano_contasT> asyncCallback);
    	public void getAll(AsyncCallback<List<Plc_plano_contasT>> asyncCallback);
	public void delete(Plc_plano_contasT plc_plano_contasT, AsyncCallback<Void> asyncCallback);
	public void update(Plc_plano_contasT plc_plano_contasT, AsyncCallback<Void> asyncCallback);

    public void getAllSuper(AsyncCallback<List<Plc_plano_contasT>> asyncCallback);

    public void getAllSub(AsyncCallback<List<Plc_plano_contasT>> asyncCallback);
}
