package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "Car_cartaoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/car_cartaoservice"})
public class Car_cartaoServiceImpl extends RemoteServiceServlet implements Car_cartaoService {

    public void insert(Car_cartaoT car_cartaoT) throws Exception {
        Car_cartaoBL car_cartaoBL = new Car_cartaoBL();
        car_cartaoBL.insert(car_cartaoT);
    }

    public Car_cartaoT findById(Car_cartaoT car_cartaoT) throws Exception {
        Car_cartaoBL car_cartaoBL = new Car_cartaoBL();
        return car_cartaoBL.findbyid(car_cartaoT);
    }

    public List<Car_cartaoT> getAll() throws Exception {
        Car_cartaoBL car_cartaoBL = new Car_cartaoBL();
        return car_cartaoBL.consult(getUsuarioLogado());
    }

    public void delete(Car_cartaoT car_cartaoT) throws Exception {
        Car_cartaoBL car_cartaoBL = new Car_cartaoBL();
        car_cartaoBL.delete(car_cartaoT);
    }

    public void update(Car_cartaoT car_cartaoT) throws Exception {
        Car_cartaoBL car_cartaoBL = new Car_cartaoBL();
        car_cartaoBL.update(car_cartaoT);
    }

    public Usu_usuarioT getUsuarioLogado() {

        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }

}
