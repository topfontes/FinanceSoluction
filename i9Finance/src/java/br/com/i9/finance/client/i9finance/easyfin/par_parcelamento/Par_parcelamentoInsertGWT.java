/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.par_parcelamento;

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
public class Par_parcelamentoInsertGWT extends CRUDBaseGWT  {
    protected Par_parcelamentoConsultGWT par_parcelamentoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> par_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> par_nr_parcela = new EasyTextField<String>();
    protected EasyTextField<String> par_tx_status = new EasyTextField<String>();
    protected EasyTextField<String> par_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();


    public Par_parcelamentoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Parcelamento");
        this.setSize("400", "150");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

//	LabelField lfpar_nr_id = new LabelField("par_nr_id:");
//        lfpar_nr_id.setId("lfpar_nr_id");
//	getCpMaster().add(lfpar_nr_id);
//        par_nr_id.setId("par_nr_id");
//        par_nr_id.setMaxLength(10);
//        getCpMaster().add(par_nr_id);

	LabelField lfpar_nr_parcela = new LabelField("N. parcelas:");
        lfpar_nr_parcela.setId("lfpar_nr_parcela");
	getCpMaster().add(lfpar_nr_parcela);
        par_nr_parcela.setId("par_nr_parcela");
        par_nr_parcela.setMaxLength(10);
        getCpMaster().add(par_nr_parcela);

//	LabelField lfpar_tx_status = new LabelField("par_tx_status:");
//        lfpar_tx_status.setId("lfpar_tx_status");
//	getCpMaster().add(lfpar_tx_status);
//        par_tx_status.setId("par_tx_status");
//        par_tx_status.setMaxLength(1);
//        getCpMaster().add(par_tx_status);

	LabelField lfpar_tx_nome = new LabelField("Nome:");
        lfpar_tx_nome.setId("lfpar_tx_nome");
	getCpMaster().add(lfpar_tx_nome);
        par_tx_nome.setId("par_tx_nome");
        par_tx_nome.setMaxLength(50);
        getCpMaster().add(par_tx_nome);

//	LabelField lfloj_nr_id = new LabelField("loj_nr_id:");
//        lfloj_nr_id.setId("lfloj_nr_id");
//	getCpMaster().add(lfloj_nr_id);
//        loj_nr_id.setId("loj_nr_id");
//        loj_nr_id.setMaxLength(10);
//        getCpMaster().add(loj_nr_id);


    }

    public boolean valide() {
        return true;
    }

  public void btnInsertAction(ButtonEvent ce){
    if (valide()) {
      Par_parcelamentoT par_parcelamentoT = new Par_parcelamentoT();
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
	btnClearAction(null);
        if (par_parcelamentoConsult != null) {
	  par_parcelamentoConsult.load();
        }
	setVisible(false);
      }
    };

    Par_parcelamentoServiceAsync par_parcelamentoAsync = GWT.create(Par_parcelamentoService.class);
    par_parcelamentoAsync.insert(par_parcelamentoT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			par_nr_id.setValue("");
		par_nr_parcela.setValue("");
		par_tx_status.setValue("");
		par_tx_nome.setValue("");
		loj_nr_id.setValue("");

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

