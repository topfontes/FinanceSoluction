/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.ccr_conta_ct_receber;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;

/**
 *
 * @author EasyNet
 */
public class Ccr_conta_ct_receberInsertGWT extends CRUDBaseGWT  {
    protected Ccr_conta_ct_receberConsultGWT ccr_conta_ct_receberConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> ccr_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctr_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> plc_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ccr_valor = new EasyTextField<String>();


    public Ccr_conta_ct_receberInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Ccr_conta_ct_receber");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfccr_nr_id = new LabelField("ccr_nr_id:");
        lfccr_nr_id.setId("lfccr_nr_id");
	getCpMaster().add(lfccr_nr_id);
        ccr_nr_id.setId("ccr_nr_id");
        ccr_nr_id.setMaxLength(10);
        getCpMaster().add(ccr_nr_id);

	LabelField lfctr_nr_id = new LabelField("ctr_nr_id:");
        lfctr_nr_id.setId("lfctr_nr_id");
	getCpMaster().add(lfctr_nr_id);
        ctr_nr_id.setId("ctr_nr_id");
        ctr_nr_id.setMaxLength(10);
        getCpMaster().add(ctr_nr_id);

	LabelField lfplc_nr_id = new LabelField("plc_nr_id:");
        lfplc_nr_id.setId("lfplc_nr_id");
	getCpMaster().add(lfplc_nr_id);
        plc_nr_id.setId("plc_nr_id");
        plc_nr_id.setMaxLength(10);
        getCpMaster().add(plc_nr_id);

	LabelField lfccr_valor = new LabelField("ccr_valor:");
        lfccr_valor.setId("lfccr_valor");
	getCpMaster().add(lfccr_valor);
        ccr_valor.setId("ccr_valor");
        ccr_valor.setMaxLength(8);
        getCpMaster().add(ccr_valor);


    }

    public boolean valide() {
        return true;
    }

  public void btnInsertAction(ButtonEvent ce){
    if (valide()) {
      Ccr_conta_ct_receberT ccr_conta_ct_receberT = new Ccr_conta_ct_receberT();
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
	btnClearAction(null);
        if (ccr_conta_ct_receberConsult != null) {
	  ccr_conta_ct_receberConsult.load();
        }
	setVisible(false);
      }
    };

    Ccr_conta_ct_receberServiceAsync ccr_conta_ct_receberAsync = GWT.create(Ccr_conta_ct_receberService.class);
    ccr_conta_ct_receberAsync.insert(ccr_conta_ct_receberT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			ccr_nr_id.setValue("");
		ctr_nr_id.setValue("");
		plc_nr_id.setValue("");
		ccr_valor.setValue("");

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

