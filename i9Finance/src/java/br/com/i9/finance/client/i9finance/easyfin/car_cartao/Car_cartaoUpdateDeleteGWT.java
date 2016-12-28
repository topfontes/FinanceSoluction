package br.com.i9.finance.client.i9finance.easyfin.car_cartao;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.Dialog;

import br.com.i9.finance.client.i9finance.easyfin.service.*;

/**
 *
 * @author geoleite
 */
public class Car_cartaoUpdateDeleteGWT extends Car_cartaoInsertGWT {
    private Car_cartaoT car_cartaoT;

    public Car_cartaoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Car_cartao");
    }

    public void load(Car_cartaoT car_cartaoT) {
	this.car_cartaoT = car_cartaoT;
		car_nr_id.setValue(car_cartaoT.getCar_nr_id() + "");
		car_per_taxa.setValue(car_cartaoT.getCar_per_taxa() + "");
		car_tx_status.setValue(car_cartaoT.getCar_tx_status());
		car_tx_nome.setValue(car_cartaoT.getCar_tx_nome());
		loj_nr_id.setValue(car_cartaoT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
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
        if (car_cartaoConsult != null) {
	  car_cartaoConsult.load();
        }
        setVisible(false);
      }
    };

    Car_cartaoServiceAsync car_cartaoAsync = GWT.create(Car_cartaoService.class);
    car_cartaoAsync.update(car_cartaoT, callback);	
  }
 }

  public void btnDeletetAction(ButtonEvent ce) {

    MessageBox.confirm(EASY_LABELS.warning(), EASY_LABELS.messageDeleteConfirm(), new Listener<MessageBoxEvent>() {

      public void handleEvent(MessageBoxEvent be) {

        if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {

          AsyncCallback<Void> callback = new AsyncCallback<Void>() {

            public void onFailure(Throwable caught) {
      	      MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(Void result) {
              Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
              if (car_cartaoConsult != null) {
	        car_cartaoConsult.load();
              }
              setVisible(false);
           }  
         };  

        Car_cartaoServiceAsync car_cartaoAsync = GWT.create(Car_cartaoService.class);
        car_cartaoAsync.delete(car_cartaoT, callback);	
      }
    }
  });
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

