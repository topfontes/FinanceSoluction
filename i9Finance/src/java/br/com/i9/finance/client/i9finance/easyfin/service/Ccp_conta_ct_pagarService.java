package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/ccp_conta_ct_pagarservice")
public interface Ccp_conta_ct_pagarService  extends RemoteService {

	public void insert(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception;
        public Ccp_conta_ct_pagarT findById(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception;
    	public List<Ccp_conta_ct_pagarT> getAll() throws Exception;
	public void delete(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception;
	public void update(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) throws Exception;
}
