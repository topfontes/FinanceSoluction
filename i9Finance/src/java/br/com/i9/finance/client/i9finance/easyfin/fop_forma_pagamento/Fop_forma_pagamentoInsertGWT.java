/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.fop_forma_pagamento;

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
public class Fop_forma_pagamentoInsertGWT extends CRUDBaseGWT  {
    protected Fop_forma_pagamentoConsultGWT fop_forma_pagamentoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> fop_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> fop_tx_avista = new EasyTextField<String>();
    protected EasyTextField<String> fop_tx_status = new EasyTextField<String>();
    protected EasyTextField<String> fop_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();


    public Fop_forma_pagamentoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar forma de pagamento");
        this.setSize("400", "120");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

//	LabelField lffop_tx_avista = new LabelField("fop_tx_avista:");
//        lffop_tx_avista.setId("lffop_tx_avista");
//	getCpMaster().add(lffop_tx_avista);
//        fop_tx_avista.setId("fop_tx_avista");
//        fop_tx_avista.setMaxLength(1);
//        getCpMaster().add(fop_tx_avista);

//	LabelField lffop_tx_status = new LabelField("fop_tx_status:");
//        lffop_tx_status.setId("lffop_tx_status");
//	getCpMaster().add(lffop_tx_status);
//        fop_tx_status.setId("fop_tx_status");
//        fop_tx_status.setMaxLength(1);
//        getCpMaster().add(fop_tx_status);

	LabelField lffop_tx_nome = new LabelField("Nome:");
        lffop_tx_nome.setId("lffop_tx_nome");
	getCpMaster().add(lffop_tx_nome);
        fop_tx_nome.setId("fop_tx_nome");
        fop_tx_nome.setMaxLength(10);
        getCpMaster().add(fop_tx_nome);
        fop_tx_nome.setWidth(Constantes.widthField);

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
      Fop_forma_pagamentoT fop_forma_pagamentoT = new Fop_forma_pagamentoT();
      		fop_forma_pagamentoT.setFop_nr_id( Integer.parseInt(fop_nr_id.getValue()));
		fop_forma_pagamentoT.setFop_tx_avista(fop_tx_avista.getValue());
		fop_forma_pagamentoT.setFop_tx_status(fop_tx_status.getValue());
		fop_forma_pagamentoT.setFop_tx_nome(fop_tx_nome.getValue());
		fop_forma_pagamentoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
	btnClearAction(null);
        if (fop_forma_pagamentoConsult != null) {
	  fop_forma_pagamentoConsult.load();
        }
	setVisible(false);
      }
    };

    Fop_forma_pagamentoServiceAsync fop_forma_pagamentoAsync = GWT.create(Fop_forma_pagamentoService.class);
    fop_forma_pagamentoAsync.insert(fop_forma_pagamentoT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			fop_nr_id.setValue("");
		fop_tx_avista.setValue("");
		fop_tx_status.setValue("");
		fop_tx_nome.setValue("");
		loj_nr_id.setValue("");

  }

   /**
     * @return the fop_forma_pagamentoConsult
     */
    public Fop_forma_pagamentoConsultGWT getFop_forma_pagamentoConsult() {
        return fop_forma_pagamentoConsult;
    }

    /**
     * @param fop_forma_pagamentoConsult the fop_forma_pagamentoConsult to set
     */
    public void setFop_forma_pagamentoConsult(Fop_forma_pagamentoConsultGWT fop_forma_pagamentoConsult) {
        this.fop_forma_pagamentoConsult = fop_forma_pagamentoConsult;
    }
}

