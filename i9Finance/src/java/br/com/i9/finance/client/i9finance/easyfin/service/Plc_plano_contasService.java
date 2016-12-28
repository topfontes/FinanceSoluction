package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/plc_plano_contasservice")
public interface Plc_plano_contasService  extends RemoteService {

	public void insert(Plc_plano_contasT plc_plano_contasT) throws Exception;
        public Plc_plano_contasT findById(Plc_plano_contasT plc_plano_contasT) throws Exception;
    	public List<Plc_plano_contasT> getAll() throws Exception;
        public List<Plc_plano_contasT> getAllSuper() throws Exception;
        public List<Plc_plano_contasT> getAllSub() throws Exception;
	public void delete(Plc_plano_contasT plc_plano_contasT) throws Exception;
	public void update(Plc_plano_contasT plc_plano_contasT) throws Exception;
}
