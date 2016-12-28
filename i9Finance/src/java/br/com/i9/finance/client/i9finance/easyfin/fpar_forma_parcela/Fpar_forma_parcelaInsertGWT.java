/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.fpar_forma_parcela;

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
public class Fpar_forma_parcelaInsertGWT extends CRUDBaseGWT  {
    protected Fpar_forma_parcelaConsultGWT fpar_forma_parcelaConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> fpar_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> fop_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> par_nr_id = new EasyTextField<String>();


    public Fpar_forma_parcelaInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Fpar_forma_parcela");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lffpar_nr_id = new LabelField("fpar_nr_id:");
        lffpar_nr_id.setId("lffpar_nr_id");
	getCpMaster().add(lffpar_nr_id);
        fpar_nr_id.setId("fpar_nr_id");
        fpar_nr_id.setMaxLength(10);
        getCpMaster().add(fpar_nr_id);

	LabelField lffop_nr_id = new LabelField("fop_nr_id:");
        lffop_nr_id.setId("lffop_nr_id");
	getCpMaster().add(lffop_nr_id);
        fop_nr_id.setId("fop_nr_id");
        fop_nr_id.setMaxLength(10);
        getCpMaster().add(fop_nr_id);

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
      Fpar_forma_parcelaT fpar_forma_parcelaT = new Fpar_forma_parcelaT();
      		fpar_forma_parcelaT.setFpar_nr_id( Integer.parseInt(fpar_nr_id.getValue()));
		fpar_forma_parcelaT.setFop_nr_id( Integer.parseInt(fop_nr_id.getValue()));
		fpar_forma_parcelaT.setPar_nr_id( Integer.parseInt(par_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
	btnClearAction(null);
        if (fpar_forma_parcelaConsult != null) {
	  fpar_forma_parcelaConsult.load();
        }
	setVisible(false);
      }
    };

    Fpar_forma_parcelaServiceAsync fpar_forma_parcelaAsync = GWT.create(Fpar_forma_parcelaService.class);
    fpar_forma_parcelaAsync.insert(fpar_forma_parcelaT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			fpar_nr_id.setValue("");
		fop_nr_id.setValue("");
		par_nr_id.setValue("");

  }

   /**
     * @return the fpar_forma_parcelaConsult
     */
    public Fpar_forma_parcelaConsultGWT getFpar_forma_parcelaConsult() {
        return fpar_forma_parcelaConsult;
    }

    /**
     * @param fpar_forma_parcelaConsult the fpar_forma_parcelaConsult to set
     */
    public void setFpar_forma_parcelaConsult(Fpar_forma_parcelaConsultGWT fpar_forma_parcelaConsult) {
        this.fpar_forma_parcelaConsult = fpar_forma_parcelaConsult;
    }
}

