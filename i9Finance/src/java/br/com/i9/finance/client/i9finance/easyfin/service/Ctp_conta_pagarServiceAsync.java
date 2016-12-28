package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

/**
 * @author EasyNet Generator
 */
public interface Ctp_conta_pagarServiceAsync {

    public void insert(Ctp_conta_pagarT ctp_conta_pagarT, AsyncCallback<Void> asyncCallback);

    public void findById(Ctp_conta_pagarT ctp_conta_pagarT, AsyncCallback<Ctp_conta_pagarT> asyncCallback);

    public void getAll(AsyncCallback<List<Ctp_conta_pagarT>> asyncCallback);

    public void delete(Ctp_conta_pagarT ctp_conta_pagarT, AsyncCallback<Void> asyncCallback);

    public void update(Ctp_conta_pagarT ctp_conta_pagarT, AsyncCallback<Void> asyncCallback);

    public void updateBaixa(Ctp_conta_pagarT ctp_conta_pagarT, int conta_credora, AsyncCallback<Void> asyncCallback);
}
