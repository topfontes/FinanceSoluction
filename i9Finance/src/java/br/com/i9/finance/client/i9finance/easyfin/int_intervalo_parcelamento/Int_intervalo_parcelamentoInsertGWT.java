/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.int_intervalo_parcelamento;

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
public class Int_intervalo_parcelamentoInsertGWT extends CRUDBaseGWT  {
    protected Int_intervalo_parcelamentoConsultGWT int_intervalo_parcelamentoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> int_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> int_nr_dia = new EasyTextField<String>();
    protected EasyTextField<String> int_perc_valor = new EasyTextField<String>();
    protected EasyTextField<String> par_nr_id = new EasyTextField<String>();


    public Int_intervalo_parcelamentoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Int_intervalo_parcelamento");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfint_nr_id = new LabelField("int_nr_id:");
        lfint_nr_id.setId("lfint_nr_id");
	getCpMaster().add(lfint_nr_id);
        int_nr_id.setId("int_nr_id");
        int_nr_id.setMaxLength(10);
        getCpMaster().add(int_nr_id);

	LabelField lfint_nr_dia = new LabelField("int_nr_dia:");
        lfint_nr_dia.setId("lfint_nr_dia");
	getCpMaster().add(lfint_nr_dia);
        int_nr_dia.setId("int_nr_dia");
        int_nr_dia.setMaxLength(10);
        getCpMaster().add(int_nr_dia);

	LabelField lfint_perc_valor = new LabelField("int_perc_valor:");
        lfint_perc_valor.setId("lfint_perc_valor");
	getCpMaster().add(lfint_perc_valor);
        int_perc_valor.setId("int_perc_valor");
        int_perc_valor.setMaxLength(8);
        getCpMaster().add(int_perc_valor);

	LabelField lfpar_nr_id = new LabelField("par_nr_id:");
        lfpar_nr_id.setId("lfpar_nr_id");
	getCpMaster().add(lfpar_nr_id);
        par_nr_id.setId("par_nr_id");
        par_nr_id.setMaxLength(10);
        getCpMaster().add(par_nr_id);


    }

    public boolean valide() {
        return true;
    }

  public void btnInsertAction(ButtonEvent ce){
    if (valide()) {
      Int_intervalo_parcelamentoT int_intervalo_parcelamentoT = new Int_intervalo_parcelamentoT();
      		int_intervalo_parcelamentoT.setInt_nr_id( Integer.parseInt(int_nr_id.getValue()));
		int_intervalo_parcelamentoT.setInt_nr_dia( Integer.parseInt(int_nr_dia.getValue()));
		int_intervalo_parcelamentoT.setInt_perc_valor( Double.parseDouble(int_perc_valor.getValue()));
		int_intervalo_parcelamentoT.setPar_nr_id( Integer.parseInt(par_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
	btnClearAction(null);
        if (int_intervalo_parcelamentoConsult != null) {
	  int_intervalo_parcelamentoConsult.load();
        }
	setVisible(false);
      }
    };

    Int_intervalo_parcelamentoServiceAsync int_intervalo_parcelamentoAsync = GWT.create(Int_intervalo_parcelamentoService.class);
    int_intervalo_parcelamentoAsync.insert(int_intervalo_parcelamentoT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			int_nr_id.setValue("");
		int_nr_dia.setValue("");
		int_perc_valor.setValue("");
		par_nr_id.setValue("");

  }

   /**
     * @return the int_intervalo_parcelamentoConsult
     */
    public Int_intervalo_parcelamentoConsultGWT getInt_intervalo_parcelamentoConsult() {
        return int_intervalo_parcelamentoConsult;
    }

    /**
     * @param int_intervalo_parcelamentoConsult the int_intervalo_parcelamentoConsult to set
     */
    public void setInt_intervalo_parcelamentoConsult(Int_intervalo_parcelamentoConsultGWT int_intervalo_parcelamentoConsult) {
        this.int_intervalo_parcelamentoConsult = int_intervalo_parcelamentoConsult;
    }
}

