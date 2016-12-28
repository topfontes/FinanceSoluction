package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Fop_forma_pagamentoServiceAsync  {

	public void insert(Fop_forma_pagamentoT fop_forma_pagamentoT, AsyncCallback<Void> asyncCallback );
        public void findById(Fop_forma_pagamentoT fop_forma_pagamentoT, AsyncCallback<Fop_forma_pagamentoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Fop_forma_pagamentoT>> asyncCallback);
	public void delete(Fop_forma_pagamentoT fop_forma_pagamentoT, AsyncCallback<Void> asyncCallback);
	public void update(Fop_forma_pagamentoT fop_forma_pagamentoT, AsyncCallback<Void> asyncCallback);
}
