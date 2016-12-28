package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/ctr_conta_recebeservice")
public interface Ctr_conta_recebeService  extends RemoteService {

	public void insert(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception;
        public Ctr_conta_recebeT findById(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception;
    	public List<Ctr_conta_recebeT> getAll() throws Exception;
	public void delete(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception;
        
	public void update(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception;
        public void updateBaixa(Ctr_conta_recebeT ctr_conta_recebeT, int conta_devedora) throws Exception;
        
}
