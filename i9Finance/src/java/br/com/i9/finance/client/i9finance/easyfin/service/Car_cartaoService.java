package br.com.i9.finance.client.i9finance.easyfin.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

@RemoteServiceRelativePath("rpc/car_cartaoservice")
public interface Car_cartaoService  extends RemoteService {

	public void insert(Car_cartaoT car_cartaoT) throws Exception;
        public Car_cartaoT findById(Car_cartaoT car_cartaoT) throws Exception;
    	public List<Car_cartaoT> getAll() throws Exception;
	public void delete(Car_cartaoT car_cartaoT) throws Exception;
	public void update(Car_cartaoT car_cartaoT) throws Exception;
}
