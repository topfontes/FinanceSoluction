package br.com.i9.finance.client.i9finance.easyfin.service;


import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;


/**
* @author EasyNet Generator
*/
public interface Car_cartaoServiceAsync  {

	public void insert(Car_cartaoT car_cartaoT, AsyncCallback<Void> asyncCallback );
        public void findById(Car_cartaoT car_cartaoT, AsyncCallback<Car_cartaoT> asyncCallback);
    	public void getAll(AsyncCallback<List<Car_cartaoT>> asyncCallback);
	public void delete(Car_cartaoT car_cartaoT, AsyncCallback<Void> asyncCallback);
	public void update(Car_cartaoT car_cartaoT, AsyncCallback<Void> asyncCallback);
}
