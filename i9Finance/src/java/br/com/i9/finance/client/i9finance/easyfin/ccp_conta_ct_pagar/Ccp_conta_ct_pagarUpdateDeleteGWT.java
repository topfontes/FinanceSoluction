package br.com.i9.finance.client.i9finance.easyfin.ccp_conta_ct_pagar;

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
public class Ccp_conta_ct_pagarUpdateDeleteGWT extends Ccp_conta_ct_pagarInsertGWT {
    private Ccp_conta_ct_pagarT ccp_conta_ct_pagarT;

    public Ccp_conta_ct_pagarUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Ccp_conta_ct_pagar");
    }

    public void load(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) {
	this.ccp_conta_ct_pagarT = ccp_conta_ct_pagarT;
		ccp_nr_id.setValue(ccp_conta_ct_pagarT.getCcp_nr_id() + "");
		ctp_nr_id.setValue(ccp_conta_ct_pagarT.getCtp_nr_id() + "");
		plc_nr_id.setValue(ccp_conta_ct_pagarT.getPlc_nr_id() + "");
		ccp_valor.setValue(ccp_conta_ct_pagarT.getCcp_valor() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		ccp_conta_ct_pagarT.setCcp_nr_id( Integer.parseInt(ccp_nr_id.getValue()));
		ccp_conta_ct_pagarT.setCtp_nr_id( Integer.parseInt(ctp_nr_id.getValue()));
		ccp_conta_ct_pagarT.setPlc_nr_id( Integer.parseInt(plc_nr_id.getValue()));
		ccp_conta_ct_pagarT.setCcp_valor( Double.parseDouble(ccp_valor.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (ccp_conta_ct_pagarConsult != null) {
	  ccp_conta_ct_pagarConsult.load();
        }
        setVisible(false);
      }
    };

    Ccp_conta_ct_pagarServiceAsync ccp_conta_ct_pagarAsync = GWT.create(Ccp_conta_ct_pagarService.class);
    ccp_conta_ct_pagarAsync.update(ccp_conta_ct_pagarT, callback);	
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
              if (ccp_conta_ct_pagarConsult != null) {
	        ccp_conta_ct_pagarConsult.load();
              }
              setVisible(false);
           }  
         };  

        Ccp_conta_ct_pagarServiceAsync ccp_conta_ct_pagarAsync = GWT.create(Ccp_conta_ct_pagarService.class);
        ccp_conta_ct_pagarAsync.delete(ccp_conta_ct_pagarT, callback);	
      }
    }
  });
 }


   /**
     * @return the ccp_conta_ct_pagarConsult
     */
    public Ccp_conta_ct_pagarConsultGWT getCcp_conta_ct_pagarConsult() {
        return ccp_conta_ct_pagarConsult;
    }

    /**
     * @param ccp_conta_ct_pagarConsult the ccp_conta_ct_pagarConsult to set
     */
    public void setCcp_conta_ct_pagarConsult(Ccp_conta_ct_pagarConsultGWT ccp_conta_ct_pagarConsult) {
        this.ccp_conta_ct_pagarConsult = ccp_conta_ct_pagarConsult;
    }

}

