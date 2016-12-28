package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Usu_loj_usuario_lojaServiceAsync  {

	public void insert(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT, AsyncCallback<Void> asyncCallback );
        public void findById(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT, AsyncCallback<Usu_loj_usuario_lojaT> asyncCallback);
    	public void getAll(AsyncCallback<List<Usu_loj_usuario_lojaT>> asyncCallback);
	public void delete(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT, AsyncCallback<Void> asyncCallback);
	public void update(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT, AsyncCallback<Void> asyncCallback);
}
