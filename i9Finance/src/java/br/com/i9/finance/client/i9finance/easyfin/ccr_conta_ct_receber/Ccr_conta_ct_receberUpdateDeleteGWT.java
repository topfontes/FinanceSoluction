package br.com.i9.finance.client.i9finance.easyfin.ccr_conta_ct_receber;

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
public class Ccr_conta_ct_receberUpdateDeleteGWT extends Ccr_conta_ct_receberInsertGWT {
    private Ccr_conta_ct_receberT ccr_conta_ct_receberT;

    public Ccr_conta_ct_receberUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Ccr_conta_ct_receber");
    }

    public void load(Ccr_conta_ct_receberT ccr_conta_ct_receberT) {
	this.ccr_conta_ct_receberT = ccr_conta_ct_receberT;
		ccr_nr_id.setValue(ccr_conta_ct_receberT.getCcr_nr_id() + "");
		ctr_nr_id.setValue(ccr_conta_ct_receberT.getCtr_nr_id() + "");
		plc_nr_id.setValue(ccr_conta_ct_receberT.getPlc_nr_id() + "");
		ccr_valor.setValue(ccr_conta_ct_receberT.getCcr_valor() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		ccr_conta_ct_receberT.setCcr_nr_id( Integer.parseInt(ccr_nr_id.getValue()));
		ccr_conta_ct_receberT.setCtr_nr_id( Integer.parseInt(ctr_nr_id.getValue()));
		ccr_conta_ct_receberT.setPlc_nr_id( Integer.parseInt(plc_nr_id.getValue()));
		ccr_conta_ct_receberT.setCcr_valor( Double.parseDouble(ccr_valor.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (ccr_conta_ct_receberConsult != null) {
	  ccr_conta_ct_receberConsult.load();
        }
        setVisible(false);
      }
    };

    Ccr_conta_ct_receberServiceAsync ccr_conta_ct_receberAsync = GWT.create(Ccr_conta_ct_receberService.class);
    ccr_conta_ct_receberAsync.update(ccr_conta_ct_receberT, callback);	
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
              if (ccr_conta_ct_receberConsult != null) {
	        ccr_conta_ct_receberConsult.load();
              }
              setVisible(false);
           }  
         };  

        Ccr_conta_ct_receberServiceAsync ccr_conta_ct_receberAsync = GWT.create(Ccr_conta_ct_receberService.class);
        ccr_conta_ct_receberAsync.delete(ccr_conta_ct_receberT, callback);	
      }
    }
  });
 }


   /**
     * @return the ccr_conta_ct_receberConsult
     */
    public Ccr_conta_ct_receberConsultGWT getCcr_conta_ct_receberConsult() {
        return ccr_conta_ct_receberConsult;
    }

    /**
     * @param ccr_conta_ct_receberConsult the ccr_conta_ct_receberConsult to set
     */
    public void setCcr_conta_ct_receberConsult(Ccr_conta_ct_receberConsultGWT ccr_conta_ct_receberConsult) {
        this.ccr_conta_ct_receberConsult = ccr_conta_ct_receberConsult;
    }

}

