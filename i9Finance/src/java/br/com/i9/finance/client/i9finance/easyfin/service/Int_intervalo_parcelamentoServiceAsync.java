package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Int_intervalo_parcelamentoServiceAsync  {

	public void insert(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT, AsyncCallback<Void> asyncCallback );
        public void findById(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT, AsyncCallback<Int_intervalo_parcelamentoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Int_intervalo_parcelamentoT>> asyncCallback);
	public void delete(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT, AsyncCallback<Void> asyncCallback);
	public void update(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT, AsyncCallback<Void> asyncCallback);
}
