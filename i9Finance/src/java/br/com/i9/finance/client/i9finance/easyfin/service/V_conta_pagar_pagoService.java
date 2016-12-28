package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/v_conta_pagar_pagoservice")
public interface V_conta_pagar_pagoService  extends RemoteService {

	public void insert(V_conta_pagar_pagoT v_conta_pagar_pagoT) throws Exception;
        public V_conta_pagar_pagoT findById(V_conta_pagar_pagoT v_conta_pagar_pagoT) throws Exception;
    	public List<V_conta_pagar_pagoT> getAll() throws Exception;
	public void delete(V_conta_pagar_pagoT v_conta_pagar_pagoT) throws Exception;
	public void update(V_conta_pagar_pagoT v_conta_pagar_pagoT) throws Exception;
}
