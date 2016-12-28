package br.com.i9.finance.client.i9finance.easyfin.int_intervalo_parcelamento;

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
public class Int_intervalo_parcelamentoUpdateDeleteGWT extends Int_intervalo_parcelamentoInsertGWT {
    private Int_intervalo_parcelamentoT int_intervalo_parcelamentoT;

    public Int_intervalo_parcelamentoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Int_intervalo_parcelamento");
    }

    public void load(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) {
	this.int_intervalo_parcelamentoT = int_intervalo_parcelamentoT;
		int_nr_id.setValue(int_intervalo_parcelamentoT.getInt_nr_id() + "");
		int_nr_dia.setValue(int_intervalo_parcelamentoT.getInt_nr_dia() + "");
		int_perc_valor.setValue(int_intervalo_parcelamentoT.getInt_perc_valor() + "");
		par_nr_id.setValue(int_intervalo_parcelamentoT.getPar_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		int_intervalo_parcelamentoT.setInt_nr_id( Integer.parseInt(int_nr_id.getValue()));
		int_intervalo_parcelamentoT.setInt_nr_dia( Integer.parseInt(int_nr_dia.getValue()));
		int_intervalo_parcelamentoT.setInt_perc_valor( Double.parseDouble(int_perc_valor.getValue()));
		int_intervalo_parcelamentoT.setPar_nr_id( Integer.parseInt(par_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (int_intervalo_parcelamentoConsult != null) {
	  int_intervalo_parcelamentoConsult.load();
        }
        setVisible(false);
      }
    };

    Int_intervalo_parcelamentoServiceAsync int_intervalo_parcelamentoAsync = GWT.create(Int_intervalo_parcelamentoService.class);
    int_intervalo_parcelamentoAsync.update(int_intervalo_parcelamentoT, callback);	
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
              if (int_intervalo_parcelamentoConsult != null) {
	        int_intervalo_parcelamentoConsult.load();
              }
              setVisible(false);
           }  
         };  

        Int_intervalo_parcelamentoServiceAsync int_intervalo_parcelamentoAsync = GWT.create(Int_intervalo_parcelamentoService.class);
        int_intervalo_parcelamentoAsync.delete(int_intervalo_parcelamentoT, callback);	
      }
    }
  });
 }


   /**
     * @return the int_intervalo_parcelamentoConsult
     */
    public Int_intervalo_parcelamentoConsultGWT getInt_intervalo_parcelamentoConsult() {
        return int_intervalo_parcelamentoConsult;
    }

    /**
     * @param int_intervalo_parcelamentoConsult the int_intervalo_parcelamentoConsult to set
     */
    public void setInt_intervalo_parcelamentoConsult(Int_intervalo_parcelamentoConsultGWT int_intervalo_parcelamentoConsult) {
        this.int_intervalo_parcelamentoConsult = int_intervalo_parcelamentoConsult;
    }

}

