/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.v_lancamentos;

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
public class V_lancamentosInsertGWT extends CRUDBaseGWT  {
    protected V_lancamentosConsultGWT v_lancamentosConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> lan_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctr_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctp_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> lan_plc_nr_id_deb = new EasyTextField<String>();
    protected EasyTextField<String> lan_plc_nr_id_cred = new EasyTextField<String>();
    protected DateField lan_dt_lancamento = new DateField();
    protected EasyTextField<String> lan_tx_historico = new EasyTextField<String>();
    protected EasyTextField<String> lan_valor = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> lan_nr_id_super = new EasyTextField<String>();
    protected EasyTextField<String> plc_tx_credito = new EasyTextField<String>();
    protected EasyTextField<String> plc_tx_debito = new EasyTextField<String>();


    public V_lancamentosInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar V_lancamentos");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lflan_nr_id = new LabelField("lan_nr_id:");
        lflan_nr_id.setId("lflan_nr_id");
	getCpMaster().add(lflan_nr_id);
        lan_nr_id.setId("lan_nr_id");
        lan_nr_id.setMaxLength(10);
        getCpMaster().add(lan_nr_id);

	LabelField lfctr_nr_id = new LabelField("ctr_nr_id:");
        lfctr_nr_id.setId("lfctr_nr_id");
	getCpMaster().add(lfctr_nr_id);
        ctr_nr_id.setId("ctr_nr_id");
        ctr_nr_id.setMaxLength(10);
        getCpMaster().add(ctr_nr_id);

	LabelField lfctp_nr_id = new LabelField("ctp_nr_id:");
        lfctp_nr_id.setId("lfctp_nr_id");
	getCpMaster().add(lfctp_nr_id);
        ctp_nr_id.setId("ctp_nr_id");
        ctp_nr_id.setMaxLength(10);
        getCpMaster().add(ctp_nr_id);

	LabelField lflan_plc_nr_id_deb = new LabelField("lan_plc_nr_id_deb:");
        lflan_plc_nr_id_deb.setId("lflan_plc_nr_id_deb");
	getCpMaster().add(lflan_plc_nr_id_deb);
        lan_plc_nr_id_deb.setId("lan_plc_nr_id_deb");
        lan_plc_nr_id_deb.setMaxLength(10);
        getCpMaster().add(lan_plc_nr_id_deb);

	LabelField lflan_plc_nr_id_cred = new LabelField("lan_plc_nr_id_cred:");
        lflan_plc_nr_id_cred.setId("lflan_plc_nr_id_cred");
	getCpMaster().add(lflan_plc_nr_id_cred);
        lan_plc_nr_id_cred.setId("lan_plc_nr_id_cred");
        lan_plc_nr_id_cred.setMaxLength(10);
        getCpMaster().add(lan_plc_nr_id_cred);

	LabelField lflan_dt_lancamento = new LabelField("lan_dt_lancamento:");
        lflan_dt_lancamento.setId("lflan_dt_lancamento");
	getCpMaster().add(lflan_dt_lancamento);
        lan_dt_lancamento.setId("lan_dt_lancamento");
        lan_dt_lancamento.setMaxLength(13);
        getCpMaster().add(lan_dt_lancamento);

	LabelField lflan_tx_historico = new LabelField("lan_tx_historico:");
        lflan_tx_historico.setId("lflan_tx_historico");
	getCpMaster().add(lflan_tx_historico);
        lan_tx_historico.setId("lan_tx_historico");
        lan_tx_historico.setMaxLength(200);
        getCpMaster().add(lan_tx_historico);

	LabelField lflan_valor = new LabelField("lan_valor:");
        lflan_valor.setId("lflan_valor");
	getCpMaster().add(lflan_valor);
        lan_valor.setId("lan_valor");
        lan_valor.setMaxLength(8);
        getCpMaster().add(lan_valor);

	LabelField lfloj_nr_id = new LabelField("loj_nr_id:");
        lfloj_nr_id.setId("lfloj_nr_id");
	getCpMaster().add(lfloj_nr_id);
        loj_nr_id.setId("loj_nr_id");
        loj_nr_id.setMaxLength(10);
        getCpMaster().add(loj_nr_id);

	LabelField lflan_nr_id_super = new LabelField("lan_nr_id_super:");
        lflan_nr_id_super.setId("lflan_nr_id_super");
	getCpMaster().add(lflan_nr_id_super);
        lan_nr_id_super.setId("lan_nr_id_super");
        lan_nr_id_super.setMaxLength(8);
        getCpMaster().add(lan_nr_id_super);

	LabelField lfplc_tx_credito = new LabelField("plc_tx_credito:");
        lfplc_tx_credito.setId("lfplc_tx_credito");
	getCpMaster().add(lfplc_tx_credito);
        plc_tx_credito.setId("plc_tx_credito");
        plc_tx_credito.setMaxLength(50);
        getCpMaster().add(plc_tx_credito);

	LabelField lfplc_tx_debito = new LabelField("plc_tx_debito:");
        lfplc_tx_debito.setId("lfplc_tx_debito");
	getCpMaster().add(lfplc_tx_debito);
        plc_tx_debito.setId("plc_tx_debito");
        plc_tx_debito.setMaxLength(50);
        getCpMaster().add(plc_tx_debito);


    }

    public boolean valide() {
        return true;
    }

  public void btnInsertAction(ButtonEvent ce){
    if (valide()) {
      V_lancamentosT v_lancamentosT = new V_lancamentosT();
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
	btnClearAction(null);
        if (v_lancamentosConsult != null) {
	  v_lancamentosConsult.load();
        }
	setVisible(false);
      }
    };

    V_lancamentosServiceAsync v_lancamentosAsync = GWT.create(V_lancamentosService.class);
    v_lancamentosAsync.insert(v_lancamentosT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			lan_nr_id.setValue("");
		ctr_nr_id.setValue("");
		ctp_nr_id.setValue("");
		lan_plc_nr_id_deb.setValue("");
		lan_plc_nr_id_cred.setValue("");
		lan_dt_lancamento.setValue(null);
		lan_tx_historico.setValue("");
		lan_valor.setValue("");
		loj_nr_id.setValue("");
		lan_nr_id_super.setValue("");
		plc_tx_credito.setValue("");
		plc_tx_debito.setValue("");

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

