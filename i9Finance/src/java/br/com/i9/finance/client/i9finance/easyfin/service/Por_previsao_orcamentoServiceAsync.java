package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Por_previsao_orcamentoServiceAsync  {

	public void insert(Por_previsao_orcamentoT por_previsao_orcamentoT, AsyncCallback<Void> asyncCallback );
        public void findById(Por_previsao_orcamentoT por_previsao_orcamentoT, AsyncCallback<Por_previsao_orcamentoT> asyncCallback);
	public void delete(Por_previsao_orcamentoT por_previsao_orcamentoT, AsyncCallback<Void> asyncCallback);
	public void update(Por_previsao_orcamentoT por_previsao_orcamentoT, AsyncCallback<Void> asyncCallback);

    public void getAll(int ano, AsyncCallback<List<Por_previsao_orcamentoT>> asyncCallback);
}
