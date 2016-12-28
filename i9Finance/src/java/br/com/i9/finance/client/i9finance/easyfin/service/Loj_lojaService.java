package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/loj_lojaservice")
public interface Loj_lojaService  extends RemoteService {

	public void insert(Loj_lojaT loj_lojaT) throws Exception;
        public Loj_lojaT findById(Loj_lojaT loj_lojaT) throws Exception;
    	public List<Loj_lojaT> getAll() throws Exception;
	public void delete(Loj_lojaT loj_lojaT) throws Exception;
	public void update(Loj_lojaT loj_lojaT) throws Exception;
}
