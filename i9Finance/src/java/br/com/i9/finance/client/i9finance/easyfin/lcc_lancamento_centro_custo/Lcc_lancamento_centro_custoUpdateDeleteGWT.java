package br.com.i9.finance.client.i9finance.easyfin.lcc_lancamento_centro_custo;

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
public class Lcc_lancamento_centro_custoUpdateDeleteGWT extends Lcc_lancamento_centro_custoInsertGWT {
    private Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT;

    public Lcc_lancamento_centro_custoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Lcc_lancamento_centro_custo");
    }

    public void load(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) {
	this.lcc_lancamento_centro_custoT = lcc_lancamento_centro_custoT;
		lcc_nr_id.setValue(lcc_lancamento_centro_custoT.getLcc_nr_id() + "");
		cen_nr_id.setValue(lcc_lancamento_centro_custoT.getCen_nr_id() + "");
		lcc_dt_lancamento.setValue(lcc_lancamento_centro_custoT.getLcc_dt_lancamento());
		lcc_valor.setValue(lcc_lancamento_centro_custoT.getLcc_valor() + "");
		plc_nr_id.setValue(lcc_lancamento_centro_custoT.getPlc_nr_id() + "");
		lan_nr_id.setValue(lcc_lancamento_centro_custoT.getLan_nr_id() + "");
		loj_nr_id.setValue(lcc_lancamento_centro_custoT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		lcc_lancamento_centro_custoT.setLcc_nr_id( Integer.parseInt(lcc_nr_id.getValue()));
		lcc_lancamento_centro_custoT.setCen_nr_id( Integer.parseInt(cen_nr_id.getValue()));
		lcc_lancamento_centro_custoT.setLcc_dt_lancamento(lcc_dt_lancamento.getValue());
		lcc_lancamento_centro_custoT.setLcc_valor( Double.parseDouble(lcc_valor.getValue()));
		lcc_lancamento_centro_custoT.setPlc_nr_id( Integer.parseInt(plc_nr_id.getValue()));
		lcc_lancamento_centro_custoT.setLan_nr_id( Integer.parseInt(lan_nr_id.getValue()));
		lcc_lancamento_centro_custoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (lcc_lancamento_centro_custoConsult != null) {
	  lcc_lancamento_centro_custoConsult.load();
        }
        setVisible(false);
      }
    };

    Lcc_lancamento_centro_custoServiceAsync lcc_lancamento_centro_custoAsync = GWT.create(Lcc_lancamento_centro_custoService.class);
    lcc_lancamento_centro_custoAsync.update(lcc_lancamento_centro_custoT, callback);	
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
              if (lcc_lancamento_centro_custoConsult != null) {
	        lcc_lancamento_centro_custoConsult.load();
              }
              setVisible(false);
           }  
         };  

        Lcc_lancamento_centro_custoServiceAsync lcc_lancamento_centro_custoAsync = GWT.create(Lcc_lancamento_centro_custoService.class);
        lcc_lancamento_centro_custoAsync.delete(lcc_lancamento_centro_custoT, callback);	
      }
    }
  });
 }


   /**
     * @return the lcc_lancamento_centro_custoConsult
     */
    public Lcc_lancamento_centro_custoConsultGWT getLcc_lancamento_centro_custoConsult() {
        return lcc_lancamento_centro_custoConsult;
    }

    /**
     * @param lcc_lancamento_centro_custoConsult the lcc_lancamento_centro_custoConsult to set
     */
    public void setLcc_lancamento_centro_custoConsult(Lcc_lancamento_centro_custoConsultGWT lcc_lancamento_centro_custoConsult) {
        this.lcc_lancamento_centro_custoConsult = lcc_lancamento_centro_custoConsult;
    }

}

