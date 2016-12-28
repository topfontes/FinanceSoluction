package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/lan_lancamentoservice")
public interface Lan_lancamentoService  extends RemoteService {

	public void insert(Lan_lancamentoT lan_lancamentoT) throws Exception;
        public Lan_lancamentoT findById(Lan_lancamentoT lan_lancamentoT) throws Exception;
    	public List<Lan_lancamentoT> getAll() throws Exception;
	public void delete(Lan_lancamentoT lan_lancamentoT) throws Exception;
	public void update(Lan_lancamentoT lan_lancamentoT) throws Exception;
}
