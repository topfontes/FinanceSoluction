package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/ctp_conta_pagarservice")
public interface Ctp_conta_pagarService extends RemoteService {

    public void insert(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception;

    public Ctp_conta_pagarT findById(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception;

    public List<Ctp_conta_pagarT> getAll() throws Exception;

    public void delete(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception;

    public void update(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception;

    public void updateBaixa(Ctp_conta_pagarT ctp_conta_pagarT, int conta_credora) throws Exception;
    
            
}
