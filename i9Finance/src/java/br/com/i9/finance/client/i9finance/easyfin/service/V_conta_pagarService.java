package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/v_conta_pagarservice")
public interface V_conta_pagarService  extends RemoteService {

	public void insert(V_conta_pagarT v_conta_pagarT) throws Exception;
        public V_conta_pagarT findById(V_conta_pagarT v_conta_pagarT) throws Exception;
    	public List<V_conta_pagarT> getAll(Date dt_inicio, Date dt_final, String pago) throws Exception;
	public void delete(V_conta_pagarT v_conta_pagarT) throws Exception;
	public void update(V_conta_pagarT v_conta_pagarT) throws Exception;
}
