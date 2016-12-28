package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/cucp_custo_conta_pagarservice")
public interface Cucp_custo_conta_pagarService  extends RemoteService {

	public void insert(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception;
        public Cucp_custo_conta_pagarT findById(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception;
    	public List<Cucp_custo_conta_pagarT> getAll() throws Exception;
	public void delete(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception;
	public void update(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception;
}
