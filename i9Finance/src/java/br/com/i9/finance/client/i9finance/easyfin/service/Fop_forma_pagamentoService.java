package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/fop_forma_pagamentoservice")
public interface Fop_forma_pagamentoService  extends RemoteService {

	public void insert(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception;
        public Fop_forma_pagamentoT findById(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception;
    	public List<Fop_forma_pagamentoT> getAll() throws Exception;
	public void delete(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception;
	public void update(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception;
}
