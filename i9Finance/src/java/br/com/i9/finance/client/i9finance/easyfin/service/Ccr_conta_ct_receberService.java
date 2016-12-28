package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/ccr_conta_ct_receberservice")
public interface Ccr_conta_ct_receberService  extends RemoteService {

	public void insert(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception;
        public Ccr_conta_ct_receberT findById(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception;
    	public List<Ccr_conta_ct_receberT> getAll() throws Exception;
	public void delete(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception;
	public void update(Ccr_conta_ct_receberT ccr_conta_ct_receberT) throws Exception;
}
