package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/v_conta_receberservice")
public interface V_conta_receberService  extends RemoteService {

	public void insert(V_conta_receberT v_conta_receberT) throws Exception;
        public V_conta_receberT findById(V_conta_receberT v_conta_receberT) throws Exception;
    	public List<V_conta_receberT> getAll(Date dt_inicio, Date dt_final, String pago) throws Exception;
	public void delete(V_conta_receberT v_conta_receberT) throws Exception;
	public void update(V_conta_receberT v_conta_receberT) throws Exception;
}
