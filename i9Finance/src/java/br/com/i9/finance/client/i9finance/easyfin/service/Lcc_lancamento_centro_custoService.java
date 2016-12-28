package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/lcc_lancamento_centro_custoservice")
public interface Lcc_lancamento_centro_custoService  extends RemoteService {

	public void insert(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception;
        public Lcc_lancamento_centro_custoT findById(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception;
    	public List<Lcc_lancamento_centro_custoT> getAll() throws Exception;
	public void delete(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception;
	public void update(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) throws Exception;
}
