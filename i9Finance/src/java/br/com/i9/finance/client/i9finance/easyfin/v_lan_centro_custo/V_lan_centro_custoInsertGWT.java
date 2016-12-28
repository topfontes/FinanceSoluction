/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.v_lan_centro_custo;

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
public class V_lan_centro_custoInsertGWT extends CRUDBaseGWT  {
    protected V_lan_centro_custoConsultGWT v_lan_centro_custoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> lcc_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> cen_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> lan_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> plc_nr_id = new EasyTextField<String>();
    protected DateField lcc_dt_lancamento = new DateField();
    protected EasyTextField<String> lcc_valor = new EasyTextField<String>();
    protected EasyTextField<String> plc_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> cen_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> lan_tx_historico = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();


    public V_lan_centro_custoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar V_lan_centro_custo");
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

	LabelField lflan_nr_id = new LabelField("lan_nr_id:");
        lflan_nr_id.setId("lflan_nr_id");
	getCpMaster().add(lflan_nr_id);
        lan_nr_id.setId("lan_nr_id");
        lan_nr_id.setMaxLength(10);
        getCpMaster().add(lan_nr_id);

	LabelField lfplc_nr_id = new LabelField("plc_nr_id:");
        lfplc_nr_id.setId("lfplc_nr_id");
	getCpMaster().add(lfplc_nr_id);
        plc_nr_id.setId("plc_nr_id");
        plc_nr_id.setMaxLength(10);
        getCpMaster().add(plc_nr_id);

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

	LabelField lfplc_tx_nome = new LabelField("plc_tx_nome:");
        lfplc_tx_nome.setId("lfplc_tx_nome");
	getCpMaster().add(lfplc_tx_nome);
        plc_tx_nome.setId("plc_tx_nome");
        plc_tx_nome.setMaxLength(50);
        getCpMaster().add(plc_tx_nome);

	LabelField lfcen_tx_nome = new LabelField("cen_tx_nome:");
        lfcen_tx_nome.setId("lfcen_tx_nome");
	getCpMaster().add(lfcen_tx_nome);
        cen_tx_nome.setId("cen_tx_nome");
        cen_tx_nome.setMaxLength(50);
        getCpMaster().add(cen_tx_nome);

	LabelField lflan_tx_historico = new LabelField("lan_tx_historico:");
        lflan_tx_historico.setId("lflan_tx_historico");
	getCpMaster().add(lflan_tx_historico);
        lan_tx_historico.setId("lan_tx_historico");
        lan_tx_historico.setMaxLength(200);
        getCpMaster().add(lan_tx_historico);

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
      V_lan_centro_custoT v_lan_centro_custoT = new V_lan_centro_custoT();
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
	btnClearAction(null);
        if (v_lan_centro_custoConsult != null) {
	  v_lan_centro_custoConsult.load();
        }
	setVisible(false);
      }
    };

    V_lan_centro_custoServiceAsync v_lan_centro_custoAsync = GWT.create(V_lan_centro_custoService.class);
    v_lan_centro_custoAsync.insert(v_lan_centro_custoT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			lcc_nr_id.setValue("");
		cen_nr_id.setValue("");
		lan_nr_id.setValue("");
		plc_nr_id.setValue("");
		lcc_dt_lancamento.setValue(null);
		lcc_valor.setValue("");
		plc_tx_nome.setValue("");
		cen_tx_nome.setValue("");
		lan_tx_historico.setValue("");
		loj_nr_id.setValue("");

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

