package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/ban_bancoservice")
public interface Ban_bancoService  extends RemoteService {

	public void insert(Ban_bancoT ban_bancoT) throws Exception;
        public Ban_bancoT findById(Ban_bancoT ban_bancoT) throws Exception;
    	public List<Ban_bancoT> getAll() throws Exception;
	public void delete(Ban_bancoT ban_bancoT) throws Exception;
	public void update(Ban_bancoT ban_bancoT) throws Exception;
}
