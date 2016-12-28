package br.com.i9.finance.client.i9finance.easyfin.fop_forma_pagamento;

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
public class Fop_forma_pagamentoUpdateDeleteGWT extends Fop_forma_pagamentoInsertGWT {
    private Fop_forma_pagamentoT fop_forma_pagamentoT;

    public Fop_forma_pagamentoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Fop_forma_pagamento");
    }

    public void load(Fop_forma_pagamentoT fop_forma_pagamentoT) {
	this.fop_forma_pagamentoT = fop_forma_pagamentoT;
		fop_nr_id.setValue(fop_forma_pagamentoT.getFop_nr_id() + "");
		fop_tx_avista.setValue(fop_forma_pagamentoT.getFop_tx_avista());
		fop_tx_status.setValue(fop_forma_pagamentoT.getFop_tx_status());
		fop_tx_nome.setValue(fop_forma_pagamentoT.getFop_tx_nome());
		loj_nr_id.setValue(fop_forma_pagamentoT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		fop_forma_pagamentoT.setFop_nr_id( Integer.parseInt(fop_nr_id.getValue()));
		fop_forma_pagamentoT.setFop_tx_avista(fop_tx_avista.getValue());
		fop_forma_pagamentoT.setFop_tx_status(fop_tx_status.getValue());
		fop_forma_pagamentoT.setFop_tx_nome(fop_tx_nome.getValue());
		fop_forma_pagamentoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (fop_forma_pagamentoConsult != null) {
	  fop_forma_pagamentoConsult.load();
        }
        setVisible(false);
      }
    };

    Fop_forma_pagamentoServiceAsync fop_forma_pagamentoAsync = GWT.create(Fop_forma_pagamentoService.class);
    fop_forma_pagamentoAsync.update(fop_forma_pagamentoT, callback);	
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
              if (fop_forma_pagamentoConsult != null) {
	        fop_forma_pagamentoConsult.load();
              }
              setVisible(false);
           }  
         };  

        Fop_forma_pagamentoServiceAsync fop_forma_pagamentoAsync = GWT.create(Fop_forma_pagamentoService.class);
        fop_forma_pagamentoAsync.delete(fop_forma_pagamentoT, callback);	
      }
    }
  });
 }


   /**
     * @return the fop_forma_pagamentoConsult
     */
    public Fop_forma_pagamentoConsultGWT getFop_forma_pagamentoConsult() {
        return fop_forma_pagamentoConsult;
    }

    /**
     * @param fop_forma_pagamentoConsult the fop_forma_pagamentoConsult to set
     */
    public void setFop_forma_pagamentoConsult(Fop_forma_pagamentoConsultGWT fop_forma_pagamentoConsult) {
        this.fop_forma_pagamentoConsult = fop_forma_pagamentoConsult;
    }

}

