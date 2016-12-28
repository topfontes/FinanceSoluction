package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/usu_loj_usuario_lojaservice")
public interface Usu_loj_usuario_lojaService  extends RemoteService {

	public void insert(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception;
        public Usu_loj_usuario_lojaT findById(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception;
    	public List<Usu_loj_usuario_lojaT> getAll() throws Exception;
	public void delete(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception;
	public void update(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) throws Exception;
}
