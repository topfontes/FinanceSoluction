package br.com.i9.finance.client.i9finance.easyfin.v_lan_centro_custo;

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
public class V_lan_centro_custoUpdateDeleteGWT extends V_lan_centro_custoInsertGWT {
    private V_lan_centro_custoT v_lan_centro_custoT;

    public V_lan_centro_custoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar V_lan_centro_custo");
    }

    public void load(V_lan_centro_custoT v_lan_centro_custoT) {
	this.v_lan_centro_custoT = v_lan_centro_custoT;
		lcc_nr_id.setValue(v_lan_centro_custoT.getLcc_nr_id() + "");
		cen_nr_id.setValue(v_lan_centro_custoT.getCen_nr_id() + "");
		lan_nr_id.setValue(v_lan_centro_custoT.getLan_nr_id() + "");
		plc_nr_id.setValue(v_lan_centro_custoT.getPlc_nr_id() + "");
		lcc_dt_lancamento.setValue(v_lan_centro_custoT.getLcc_dt_lancamento());
		lcc_valor.setValue(v_lan_centro_custoT.getLcc_valor() + "");
		plc_tx_nome.setValue(v_lan_centro_custoT.getPlc_tx_nome());
		cen_tx_nome.setValue(v_lan_centro_custoT.getCen_tx_nome());
		lan_tx_historico.setValue(v_lan_centro_custoT.getLan_tx_historico());
		loj_nr_id.setValue(v_lan_centro_custoT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		v_lan_centro_custoT.setLcc_nr_id( Integer.parseInt(lcc_nr_id.getValue()));
		v_lan_centro_custoT.setCen_nr_id( Integer.parseInt(cen_nr_id.getValue()));
		v_lan_centro_custoT.setLan_nr_id( Integer.parseInt(lan_nr_id.getValue()));
		v_lan_centro_custoT.setPlc_nr_id( Integer.parseInt(plc_nr_id.getValue()));
		v_lan_centro_custoT.setLcc_dt_lancamento(lcc_dt_lancamento.getValue());
		v_lan_centro_custoT.setLcc_valor( Double.parseDouble(lcc_valor.getValue()));
		v_lan_centro_custoT.setPlc_tx_nome(plc_tx_nome.getValue());
		v_lan_centro_custoT.setCen_tx_nome(cen_tx_nome.getValue());
		v_lan_centro_custoT.setLan_tx_historico(lan_tx_historico.getValue());
		v_lan_centro_custoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (v_lan_centro_custoConsult != null) {
	  v_lan_centro_custoConsult.load();
        }
        setVisible(false);
      }
    };

    V_lan_centro_custoServiceAsync v_lan_centro_custoAsync = GWT.create(V_lan_centro_custoService.class);
    v_lan_centro_custoAsync.update(v_lan_centro_custoT, callback);	
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
              if (v_lan_centro_custoConsult != null) {
	        v_lan_centro_custoConsult.load();
              }
              setVisible(false);
           }  
         };  

        V_lan_centro_custoServiceAsync v_lan_centro_custoAsync = GWT.create(V_lan_centro_custoService.class);
        v_lan_centro_custoAsync.delete(v_lan_centro_custoT, callback);	
      }
    }
  });
 }


   /**
     * @return the v_lan_centro_custoConsult
     */
    public V_lan_centro_custoConsultGWT getV_lan_centro_custoConsult() {
        return v_lan_centro_custoConsult;
    }

    /**
     * @param v_lan_centro_custoConsult the v_lan_centro_custoConsult to set
     */
    public void setV_lan_centro_custoConsult(V_lan_centro_custoConsultGWT v_lan_centro_custoConsult) {
        this.v_lan_centro_custoConsult = v_lan_centro_custoConsult;
    }

}

