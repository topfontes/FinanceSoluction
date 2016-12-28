package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/int_intervalo_parcelamentoservice")
public interface Int_intervalo_parcelamentoService  extends RemoteService {

	public void insert(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception;
        public Int_intervalo_parcelamentoT findById(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception;
    	public List<Int_intervalo_parcelamentoT> getAll() throws Exception;
	public void delete(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception;
	public void update(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) throws Exception;
}
