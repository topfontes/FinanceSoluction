/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.car_cartao;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;

/**
 *
 * @author EasyNet
 */
public class Car_cartaoInsertGWT extends CRUDBaseGWT  {
    protected Car_cartaoConsultGWT car_cartaoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> car_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> car_per_taxa = new EasyTextField<String>();
    protected EasyTextField<String> car_tx_status = new EasyTextField<String>();
    protected EasyTextField<String> car_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();


    public Car_cartaoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Car_cartao");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfcar_nr_id = new LabelField("car_nr_id:");
        lfcar_nr_id.setId("lfcar_nr_id");
	getCpMaster().add(lfcar_nr_id);
        car_nr_id.setId("car_nr_id");
        car_nr_id.setMaxLength(10);
        getCpMaster().add(car_nr_id);

	LabelField lfcar_per_taxa = new LabelField("car_per_taxa:");
        lfcar_per_taxa.setId("lfcar_per_taxa");
	getCpMaster().add(lfcar_per_taxa);
        car_per_taxa.setId("car_per_taxa");
        car_per_taxa.setMaxLength(8);
        getCpMaster().add(car_per_taxa);

	LabelField lfcar_tx_status = new LabelField("car_tx_status:");
        lfcar_tx_status.setId("lfcar_tx_status");
	getCpMaster().add(lfcar_tx_status);
        car_tx_status.setId("car_tx_status");
        car_tx_status.setMaxLength(1);
        getCpMaster().add(car_tx_status);

	LabelField lfcar_tx_nome = new LabelField("car_tx_nome:");
        lfcar_tx_nome.setId("lfcar_tx_nome");
	getCpMaster().add(lfcar_tx_nome);
        car_tx_nome.setId("car_tx_nome");
        car_tx_nome.setMaxLength(50);
        getCpMaster().add(car_tx_nome);

	LabelField lfloj_nr_id = new LabelField("loj_nr_id:");
        lfloj_nr_id.setId("lfloj_nr_id");
	getCpMaster().add(lfloj_nr_id);
        loj_nr_id.setId("loj_nr_id");
        loj_nr_id.setMaxLength(10);
        getCpMaster().add(loj_nr_id);


    }

    public boolean valide() {
        return true;
    }

  public void btnInsertAction(ButtonEvent ce){
    if (valide()) {
      Car_cartaoT car_cartaoT = new Car_cartaoT();
      		car_cartaoT.setCar_nr_id( Integer.parseInt(car_nr_id.getValue()));
		car_cartaoT.setCar_per_taxa( Double.parseDouble(car_per_taxa.getValue()));
		car_cartaoT.setCar_tx_status(car_tx_status.getValue());
		car_cartaoT.setCar_tx_nome(car_tx_nome.getValue());
		car_cartaoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
	btnClearAction(null);
        if (car_cartaoConsult != null) {
	  car_cartaoConsult.load();
        }
	setVisible(false);
      }
    };

    Car_cartaoServiceAsync car_cartaoAsync = GWT.create(Car_cartaoService.class);
    car_cartaoAsync.insert(car_cartaoT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			car_nr_id.setValue("");
		car_per_taxa.setValue("");
		car_tx_status.setValue("");
		car_tx_nome.setValue("");
		loj_nr_id.setValue("");

  }

   /**
     * @return the car_cartaoConsult
     */
    public Car_cartaoConsultGWT getCar_cartaoConsult() {
        return car_cartaoConsult;
    }

    /**
     * @param car_cartaoConsult the car_cartaoConsult to set
     */
    public void setCar_cartaoConsult(Car_cartaoConsultGWT car_cartaoConsult) {
        this.car_cartaoConsult = car_cartaoConsult;
    }
}

