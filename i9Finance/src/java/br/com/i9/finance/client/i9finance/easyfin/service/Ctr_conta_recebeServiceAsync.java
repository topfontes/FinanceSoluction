package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

/**
 * @author EasyNet Generator
 */
public interface Ctr_conta_recebeServiceAsync {

    public void insert(Ctr_conta_recebeT ctr_conta_recebeT, AsyncCallback<Void> asyncCallback);

    public void findById(Ctr_conta_recebeT ctr_conta_recebeT, AsyncCallback<Ctr_conta_recebeT> asyncCallback);

    public void getAll(AsyncCallback<List<Ctr_conta_recebeT>> asyncCallback);

    public void delete(Ctr_conta_recebeT ctr_conta_recebeT, AsyncCallback<Void> asyncCallback);

    public void update(Ctr_conta_recebeT ctr_conta_recebeT, AsyncCallback<Void> asyncCallback);

    public void updateBaixa(Ctr_conta_recebeT ctr_conta_recebeT, int conta_credora, AsyncCallback<Void> asyncCallback);

}
