/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.lcc_lancamento_centro_custo;

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
public class Lcc_lancamento_centro_custoInsertGWT extends CRUDBaseGWT  {
    protected Lcc_lancamento_centro_custoConsultGWT lcc_lancamento_centro_custoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> lcc_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> cen_nr_id = new EasyTextField<String>();
    protected DateField lcc_dt_lancamento = new DateField();
    protected EasyTextField<String> lcc_valor = new EasyTextField<String>();
    protected EasyTextField<String> plc_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> lan_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();


    public Lcc_lancamento_centro_custoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Lcc_lancamento_centro_custo");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lflcc_nr_id = new LabelField("lcc_nr_id:");
        lflcc_nr_id.setId("lflcc_nr_id");
	getCpMaster().add(lflcc_nr_id);
        lcc_nr_id.setId("lcc_nr_id");
        lcc_nr_id.setMaxLength(10);
        getCpMaster().add(lcc_nr_id);

	LabelField lfcen_nr_id = new LabelField("cen_nr_id:");
        lfcen_nr_id.setId("lfcen_nr_id");
	getCpMaster().add(lfcen_nr_id);
        cen_nr_id.setId("cen_nr_id");
        cen_nr_id.setMaxLength(10);
        getCpMaster().add(cen_nr_id);

	LabelField lflcc_dt_lancamento = new LabelField("lcc_dt_lancamento:");
        lflcc_dt_lancamento.setId("lflcc_dt_lancamento");
	getCpMaster().add(lflcc_dt_lancamento);
        lcc_dt_lancamento.setId("lcc_dt_lancamento");
        lcc_dt_lancamento.setMaxLength(13);
        getCpMaster().add(lcc_dt_lancamento);

	LabelField lflcc_valor = new LabelField("lcc_valor:");
        lflcc_valor.setId("lflcc_valor");
	getCpMaster().add(lflcc_valor);
        lcc_valor.setId("lcc_valor");
        lcc_valor.setMaxLength(8);
        getCpMaster().add(lcc_valor);

	LabelField lfplc_nr_id = new LabelField("plc_nr_id:");
        lfplc_nr_id.setId("lfplc_nr_id");
	getCpMaster().add(lfplc_nr_id);
        plc_nr_id.setId("plc_nr_id");
        plc_nr_id.setMaxLength(10);
        getCpMaster().add(plc_nr_id);

	LabelField lflan_nr_id = new LabelField("lan_nr_id:");
        lflan_nr_id.setId("lflan_nr_id");
	getCpMaster().add(lflan_nr_id);
        lan_nr_id.setId("lan_nr_id");
        lan_nr_id.setMaxLength(10);
        getCpMaster().add(lan_nr_id);

	LabelField lfloj_nr_id = new LabelField("loj_nr_id:");
        lfloj_nr_id.setId("lfloj_nr_id");
	getCpMaster().add(lfloj_nr_id);
        loj_nr_id.setId("loj_nr_id");
        loj_nr_id.setMaxLength(10);
        getCpMaster().add(loj_nr_id);


    }

    public boolean valide() {
        return true;
    }

  public void btnInsertAction(ButtonEvent ce){
    if (valide()) {
      Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT = new Lcc_lancamento_centro_custoT();
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
	btnClearAction(null);
        if (lcc_lancamento_centro_custoConsult != null) {
	  lcc_lancamento_centro_custoConsult.load();
        }
	setVisible(false);
      }
    };

    Lcc_lancamento_centro_custoServiceAsync lcc_lancamento_centro_custoAsync = GWT.create(Lcc_lancamento_centro_custoService.class);
    lcc_lancamento_centro_custoAsync.insert(lcc_lancamento_centro_custoT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			lcc_nr_id.setValue("");
		cen_nr_id.setValue("");
		lcc_dt_lancamento.setValue(null);
		lcc_valor.setValue("");
		plc_nr_id.setValue("");
		lan_nr_id.setValue("");
		loj_nr_id.setValue("");

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

