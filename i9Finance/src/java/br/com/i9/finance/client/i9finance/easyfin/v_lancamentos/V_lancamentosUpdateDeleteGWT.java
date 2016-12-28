package br.com.i9.finance.client.i9finance.easyfin.v_lancamentos;

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
public class V_lancamentosUpdateDeleteGWT extends V_lancamentosInsertGWT {
    private V_lancamentosT v_lancamentosT;

    public V_lancamentosUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar V_lancamentos");
    }

    public void load(V_lancamentosT v_lancamentosT) {
	this.v_lancamentosT = v_lancamentosT;
		lan_nr_id.setValue(v_lancamentosT.getLan_nr_id() + "");
		ctr_nr_id.setValue(v_lancamentosT.getCtr_nr_id() + "");
		ctp_nr_id.setValue(v_lancamentosT.getCtp_nr_id() + "");
		lan_plc_nr_id_deb.setValue(v_lancamentosT.getLan_plc_nr_id_deb() + "");
		lan_plc_nr_id_cred.setValue(v_lancamentosT.getLan_plc_nr_id_cred() + "");
		lan_dt_lancamento.setValue(v_lancamentosT.getLan_dt_lancamento());
		lan_tx_historico.setValue(v_lancamentosT.getLan_tx_historico());
		lan_valor.setValue(v_lancamentosT.getLan_valor() + "");
		loj_nr_id.setValue(v_lancamentosT.getLoj_nr_id() + "");
		lan_nr_id_super.setValue(v_lancamentosT.getLan_nr_id_super() + "");
		plc_tx_credito.setValue(v_lancamentosT.getPlc_tx_credito());
		plc_tx_debito.setValue(v_lancamentosT.getPlc_tx_debito());

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		v_lancamentosT.setLan_nr_id( Integer.parseInt(lan_nr_id.getValue()));
		v_lancamentosT.setCtr_nr_id( Integer.parseInt(ctr_nr_id.getValue()));
		v_lancamentosT.setCtp_nr_id( Integer.parseInt(ctp_nr_id.getValue()));
		v_lancamentosT.setLan_plc_nr_id_deb( Integer.parseInt(lan_plc_nr_id_deb.getValue()));
		v_lancamentosT.setLan_plc_nr_id_cred( Integer.parseInt(lan_plc_nr_id_cred.getValue()));
		v_lancamentosT.setLan_dt_lancamento(lan_dt_lancamento.getValue());
		v_lancamentosT.setLan_tx_historico(lan_tx_historico.getValue());
		v_lancamentosT.setLan_valor( Double.parseDouble(lan_valor.getValue()));
		v_lancamentosT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));
		v_lancamentosT.setLan_nr_id_super( Double.parseDouble(lan_nr_id_super.getValue()));
		v_lancamentosT.setPlc_tx_credito(plc_tx_credito.getValue());
		v_lancamentosT.setPlc_tx_debito(plc_tx_debito.getValue());


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (v_lancamentosConsult != null) {
	  v_lancamentosConsult.load();
        }
        setVisible(false);
      }
    };

    V_lancamentosServiceAsync v_lancamentosAsync = GWT.create(V_lancamentosService.class);
    v_lancamentosAsync.update(v_lancamentosT, callback);	
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
              if (v_lancamentosConsult != null) {
	        v_lancamentosConsult.load();
              }
              setVisible(false);
           }  
         };  

        V_lancamentosServiceAsync v_lancamentosAsync = GWT.create(V_lancamentosService.class);
        v_lancamentosAsync.delete(v_lancamentosT, callback);	
      }
    }
  });
 }


   /**
     * @return the v_lancamentosConsult
     */
    public V_lancamentosConsultGWT getV_lancamentosConsult() {
        return v_lancamentosConsult;
    }

    /**
     * @param v_lancamentosConsult the v_lancamentosConsult to set
     */
    public void setV_lancamentosConsult(V_lancamentosConsultGWT v_lancamentosConsult) {
        this.v_lancamentosConsult = v_lancamentosConsult;
    }

}

