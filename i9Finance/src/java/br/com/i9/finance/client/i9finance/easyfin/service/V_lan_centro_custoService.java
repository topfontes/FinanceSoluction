package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/v_lan_centro_custoservice")
public interface V_lan_centro_custoService  extends RemoteService {

	public void insert(V_lan_centro_custoT v_lan_centro_custoT) throws Exception;
        public V_lan_centro_custoT findById(V_lan_centro_custoT v_lan_centro_custoT) throws Exception;
    	public List<V_lan_centro_custoT> getAll() throws Exception;
	public void delete(V_lan_centro_custoT v_lan_centro_custoT) throws Exception;
	public void update(V_lan_centro_custoT v_lan_centro_custoT) throws Exception;
}
