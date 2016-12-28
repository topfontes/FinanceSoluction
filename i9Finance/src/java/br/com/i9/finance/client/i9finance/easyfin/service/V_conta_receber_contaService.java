package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/v_conta_receber_contaservice")
public interface V_conta_receber_contaService  extends RemoteService {

	public void insert(V_conta_receber_contaT v_conta_receber_contaT) throws Exception;
        public V_conta_receber_contaT findById(V_conta_receber_contaT v_conta_receber_contaT) throws Exception;
    	public List<V_conta_receber_contaT> getAll() throws Exception;
	public void delete(V_conta_receber_contaT v_conta_receber_contaT) throws Exception;
	public void update(V_conta_receber_contaT v_conta_receber_contaT) throws Exception;
}
