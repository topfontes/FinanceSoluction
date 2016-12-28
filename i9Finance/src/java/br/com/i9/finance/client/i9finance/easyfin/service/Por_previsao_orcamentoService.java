package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/por_previsao_orcamentoservice")
public interface Por_previsao_orcamentoService  extends RemoteService {

	public void insert(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception;
        public Por_previsao_orcamentoT findById(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception;
    	public List<Por_previsao_orcamentoT> getAll(int ano) throws Exception;
	public void delete(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception;
	public void update(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception;
}
