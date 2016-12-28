package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/v_lancamentosservice")
public interface V_lancamentosService  extends RemoteService {

	public void insert(V_lancamentosT v_lancamentosT) throws Exception;
        public V_lancamentosT findById(V_lancamentosT v_lancamentosT) throws Exception;
    	public List<V_lancamentosT> getAll(Date dt_inicio, Date dt_final, int plc_nr_id) throws Exception;
	public void delete(V_lancamentosT v_lancamentosT) throws Exception;
	public void update(V_lancamentosT v_lancamentosT) throws Exception;
        public List<V_lancamentosT> getAllContaReceber(int ctr_nr_id) throws Exception;
        public List<V_lancamentosT> getAllContaPagar(int ctp_nr_id) throws Exception;
}
