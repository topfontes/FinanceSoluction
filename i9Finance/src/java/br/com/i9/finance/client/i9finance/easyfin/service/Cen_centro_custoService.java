package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/cen_centro_custoservice")
public interface Cen_centro_custoService  extends RemoteService {

	public void insert(Cen_centro_custoT cen_centro_custoT) throws Exception;
        public Cen_centro_custoT findById(Cen_centro_custoT cen_centro_custoT) throws Exception;
    	public List<Cen_centro_custoT> getAll() throws Exception;
	public void delete(Cen_centro_custoT cen_centro_custoT) throws Exception;
	public void update(Cen_centro_custoT cen_centro_custoT) throws Exception;
}
