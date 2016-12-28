package br.com.i9.finance.client.i9finance.easyfin.cen_centro_custo;

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
public class Cen_centro_custoUpdateDeleteGWT extends Cen_centro_custoInsertGWT {
    private Cen_centro_custoT cen_centro_custoT;

    public Cen_centro_custoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Cen_centro_custo");
    }

    public void load(Cen_centro_custoT cen_centro_custoT) {
	this.cen_centro_custoT = cen_centro_custoT;
		cen_nr_id.setValue(cen_centro_custoT.getCen_nr_id() + "");
		cen_tx_status.setValue(cen_centro_custoT.getCen_tx_status());
		cen_tx_nome.setValue(cen_centro_custoT.getCen_tx_nome());
		loj_nr_id.setValue(cen_centro_custoT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		cen_centro_custoT.setCen_nr_id( Integer.parseInt(cen_nr_id.getValue()));
		cen_centro_custoT.setCen_tx_status(cen_tx_status.getValue());
		cen_centro_custoT.setCen_tx_nome(cen_tx_nome.getValue());
		cen_centro_custoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (cen_centro_custoConsult != null) {
	  cen_centro_custoConsult.load();
        }
        setVisible(false);
      }
    };

    Cen_centro_custoServiceAsync cen_centro_custoAsync = GWT.create(Cen_centro_custoService.class);
    cen_centro_custoAsync.update(cen_centro_custoT, callback);	
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
              if (cen_centro_custoConsult != null) {
	        cen_centro_custoConsult.load();
              }
              setVisible(false);
           }  
         };  

        Cen_centro_custoServiceAsync cen_centro_custoAsync = GWT.create(Cen_centro_custoService.class);
        cen_centro_custoAsync.delete(cen_centro_custoT, callback);	
      }
    }
  });
 }


   /**
     * @return the cen_centro_custoConsult
     */
    public Cen_centro_custoConsultGWT getCen_centro_custoConsult() {
        return cen_centro_custoConsult;
    }

    /**
     * @param cen_centro_custoConsult the cen_centro_custoConsult to set
     */
    public void setCen_centro_custoConsult(Cen_centro_custoConsultGWT cen_centro_custoConsult) {
        this.cen_centro_custoConsult = cen_centro_custoConsult;
    }

}

