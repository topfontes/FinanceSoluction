package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

/**
 * @author EasyNet Generator
 */
public interface V_lancamentosServiceAsync {

    public void insert(V_lancamentosT v_lancamentosT, AsyncCallback<Void> asyncCallback);

    public void findById(V_lancamentosT v_lancamentosT, AsyncCallback<V_lancamentosT> asyncCallback);

    public void delete(V_lancamentosT v_lancamentosT, AsyncCallback<Void> asyncCallback);

    public void update(V_lancamentosT v_lancamentosT, AsyncCallback<Void> asyncCallback);


    public void getAllContaReceber(int ctr_nr_id, AsyncCallback<List<V_lancamentosT>> asyncCallback);

    public void getAllContaPagar(int ctp_nr_id, AsyncCallback<List<V_lancamentosT>> asyncCallback);

    public void getAll(Date dt_inicio, Date dt_final, int plc_nr_id, AsyncCallback<List<V_lancamentosT>> asyncCallback);
}
