package br.com.i9.finance.client.i9finance.easyfin.par_parcelamento;

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
public class Par_parcelamentoUpdateDeleteGWT extends Par_parcelamentoInsertGWT {
    private Par_parcelamentoT par_parcelamentoT;

    public Par_parcelamentoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Par_parcelamento");
    }

    public void load(Par_parcelamentoT par_parcelamentoT) {
	this.par_parcelamentoT = par_parcelamentoT;
		par_nr_id.setValue(par_parcelamentoT.getPar_nr_id() + "");
		par_nr_parcela.setValue(par_parcelamentoT.getPar_nr_parcela() + "");
		par_tx_status.setValue(par_parcelamentoT.getPar_tx_status());
		par_tx_nome.setValue(par_parcelamentoT.getPar_tx_nome());
		loj_nr_id.setValue(par_parcelamentoT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		par_parcelamentoT.setPar_nr_id( Integer.parseInt(par_nr_id.getValue()));
		par_parcelamentoT.setPar_nr_parcela( Integer.parseInt(par_nr_parcela.getValue()));
		par_parcelamentoT.setPar_tx_status(par_tx_status.getValue());
		par_parcelamentoT.setPar_tx_nome(par_tx_nome.getValue());
		par_parcelamentoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (par_parcelamentoConsult != null) {
	  par_parcelamentoConsult.load();
        }
        setVisible(false);
      }
    };

    Par_parcelamentoServiceAsync par_parcelamentoAsync = GWT.create(Par_parcelamentoService.class);
    par_parcelamentoAsync.update(par_parcelamentoT, callback);	
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
              if (par_parcelamentoConsult != null) {
	        par_parcelamentoConsult.load();
              }
              setVisible(false);
           }  
         };  

        Par_parcelamentoServiceAsync par_parcelamentoAsync = GWT.create(Par_parcelamentoService.class);
        par_parcelamentoAsync.delete(par_parcelamentoT, callback);	
      }
    }
  });
 }


   /**
     * @return the par_parcelamentoConsult
     */
    public Par_parcelamentoConsultGWT getPar_parcelamentoConsult() {
        return par_parcelamentoConsult;
    }

    /**
     * @param par_parcelamentoConsult the par_parcelamentoConsult to set
     */
    public void setPar_parcelamentoConsult(Par_parcelamentoConsultGWT par_parcelamentoConsult) {
        this.par_parcelamentoConsult = par_parcelamentoConsult;
    }

}

