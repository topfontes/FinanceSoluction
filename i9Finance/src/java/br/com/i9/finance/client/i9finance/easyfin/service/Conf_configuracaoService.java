package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/conf_configuracaoservice")
public interface Conf_configuracaoService  extends RemoteService {

	public void insert(Conf_configuracaoT conf_configuracaoT) throws Exception;
        public Conf_configuracaoT findById(Conf_configuracaoT conf_configuracaoT) throws Exception;
    	public List<Conf_configuracaoT> getAll() throws Exception;
	public void delete(Conf_configuracaoT conf_configuracaoT) throws Exception;
	public void update(Conf_configuracaoT conf_configuracaoT) throws Exception;
}
