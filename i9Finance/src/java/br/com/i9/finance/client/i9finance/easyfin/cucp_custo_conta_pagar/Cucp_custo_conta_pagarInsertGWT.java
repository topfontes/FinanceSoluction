/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.cucp_custo_conta_pagar;

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
public class Cucp_custo_conta_pagarInsertGWT extends CRUDBaseGWT  {
    protected Cucp_custo_conta_pagarConsultGWT cucp_custo_conta_pagarConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> cucp_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> cen_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> cucp_valor = new EasyTextField<String>();
    protected EasyTextField<String> ccp_nr_id = new EasyTextField<String>();


    public Cucp_custo_conta_pagarInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Cucp_custo_conta_pagar");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfcucp_nr_id = new LabelField("cucp_nr_id:");
        lfcucp_nr_id.setId("lfcucp_nr_id");
	getCpMaster().add(lfcucp_nr_id);
        cucp_nr_id.setId("cucp_nr_id");
        cucp_nr_id.setMaxLength(10);
        getCpMaster().add(cucp_nr_id);

	LabelField lfcen_nr_id = new LabelField("cen_nr_id:");
        lfcen_nr_id.setId("lfcen_nr_id");
	getCpMaster().add(lfcen_nr_id);
        cen_nr_id.setId("cen_nr_id");
        cen_nr_id.setMaxLength(10);
        getCpMaster().add(cen_nr_id);

	LabelField lfcucp_valor = new LabelField("cucp_valor:");
        lfcucp_valor.setId("lfcucp_valor");
	getCpMaster().add(lfcucp_valor);
        cucp_valor.setId("cucp_valor");
        cucp_valor.setMaxLength(8);
        getCpMaster().add(cucp_valor);

	LabelField lfccp_nr_id = new LabelField("ccp_nr_id:");
        lfccp_nr_id.setId("lfccp_nr_id");
	getCpMaster().add(lfccp_nr_id);
        ccp_nr_id.setId("ccp_nr_id");
        ccp_nr_id.setMaxLength(10);
        getCpMaster().add(ccp_nr_id);


    }

    public boolean valide() {
        return true;
    }

  public void btnInsertAction(ButtonEvent ce){
    if (valide()) {
      Cucp_custo_conta_pagarT cucp_custo_conta_pagarT = new Cucp_custo_conta_pagarT();
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
	btnClearAction(null);
        if (cucp_custo_conta_pagarConsult != null) {
	  cucp_custo_conta_pagarConsult.load();
        }
	setVisible(false);
      }
    };

    Cucp_custo_conta_pagarServiceAsync cucp_custo_conta_pagarAsync = GWT.create(Cucp_custo_conta_pagarService.class);
    cucp_custo_conta_pagarAsync.insert(cucp_custo_conta_pagarT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			cucp_nr_id.setValue("");
		cen_nr_id.setValue("");
		cucp_valor.setValue("");
		ccp_nr_id.setValue("");

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

