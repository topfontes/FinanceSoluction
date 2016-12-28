package br.com.i9.finance.client.i9finance.easyfin.cucp_custo_conta_pagar;

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
public class Cucp_custo_conta_pagarUpdateDeleteGWT extends Cucp_custo_conta_pagarInsertGWT {
    private Cucp_custo_conta_pagarT cucp_custo_conta_pagarT;

    public Cucp_custo_conta_pagarUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Cucp_custo_conta_pagar");
    }

    public void load(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) {
	this.cucp_custo_conta_pagarT = cucp_custo_conta_pagarT;
		cucp_nr_id.setValue(cucp_custo_conta_pagarT.getCucp_nr_id() + "");
		cen_nr_id.setValue(cucp_custo_conta_pagarT.getCen_nr_id() + "");
		cucp_valor.setValue(cucp_custo_conta_pagarT.getCucp_valor() + "");
		ccp_nr_id.setValue(cucp_custo_conta_pagarT.getCcp_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		cucp_custo_conta_pagarT.setCucp_nr_id( Integer.parseInt(cucp_nr_id.getValue()));
		cucp_custo_conta_pagarT.setCen_nr_id( Integer.parseInt(cen_nr_id.getValue()));
		cucp_custo_conta_pagarT.setCucp_valor( Double.parseDouble(cucp_valor.getValue()));
		cucp_custo_conta_pagarT.setCcp_nr_id( Integer.parseInt(ccp_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (cucp_custo_conta_pagarConsult != null) {
	  cucp_custo_conta_pagarConsult.load();
        }
        setVisible(false);
      }
    };

    Cucp_custo_conta_pagarServiceAsync cucp_custo_conta_pagarAsync = GWT.create(Cucp_custo_conta_pagarService.class);
    cucp_custo_conta_pagarAsync.update(cucp_custo_conta_pagarT, callback);	
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
              if (cucp_custo_conta_pagarConsult != null) {
	        cucp_custo_conta_pagarConsult.load();
              }
              setVisible(false);
           }  
         };  

        Cucp_custo_conta_pagarServiceAsync cucp_custo_conta_pagarAsync = GWT.create(Cucp_custo_conta_pagarService.class);
        cucp_custo_conta_pagarAsync.delete(cucp_custo_conta_pagarT, callback);	
      }
    }
  });
 }


   /**
     * @return the cucp_custo_conta_pagarConsult
     */
    public Cucp_custo_conta_pagarConsultGWT getCucp_custo_conta_pagarConsult() {
        return cucp_custo_conta_pagarConsult;
    }

    /**
     * @param cucp_custo_conta_pagarConsult the cucp_custo_conta_pagarConsult to set
     */
    public void setCucp_custo_conta_pagarConsult(Cucp_custo_conta_pagarConsultGWT cucp_custo_conta_pagarConsult) {
        this.cucp_custo_conta_pagarConsult = cucp_custo_conta_pagarConsult;
    }

}

