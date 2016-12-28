/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.v_conta_pagar_pago;

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
public class V_conta_pagar_pagoInsertGWT extends CRUDBaseGWT  {
    protected V_conta_pagar_pagoConsultGWT v_conta_pagar_pagoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected DateField dt_pagamento = new DateField();
    protected EasyTextField<String> valor = new EasyTextField<String>();
    protected EasyTextField<String> id_cli_fab = new EasyTextField<String>();
    protected EasyTextField<String> nome = new EasyTextField<String>();
    protected EasyTextField<String> fop_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> forma = new EasyTextField<String>();
    protected EasyTextField<String> ban_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> banco = new EasyTextField<String>();
    protected EasyTextField<String> pago = new EasyTextField<String>();
    protected EasyTextField<String> parcela = new EasyTextField<String>();
    protected EasyTextField<String> documento = new EasyTextField<String>();
    protected DateField dt_emissao = new DateField();
    protected DateField vencimento = new DateField();
    protected EasyTextField<String> obs = new EasyTextField<String>();
    protected EasyTextField<String> car_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> cartao = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();


    public V_conta_pagar_pagoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar V_conta_pagar_pago");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfdt_pagamento = new LabelField("dt_pagamento:");
        lfdt_pagamento.setId("lfdt_pagamento");
	getCpMaster().add(lfdt_pagamento);
        dt_pagamento.setId("dt_pagamento");
        dt_pagamento.setMaxLength(13);
        getCpMaster().add(dt_pagamento);

	LabelField lfvalor = new LabelField("valor:");
        lfvalor.setId("lfvalor");
	getCpMaster().add(lfvalor);
        valor.setId("valor");
        valor.setMaxLength(8);
        getCpMaster().add(valor);

	LabelField lfid_cli_fab = new LabelField("id_cli_fab:");
        lfid_cli_fab.setId("lfid_cli_fab");
	getCpMaster().add(lfid_cli_fab);
        id_cli_fab.setId("id_cli_fab");
        id_cli_fab.setMaxLength(10);
        getCpMaster().add(id_cli_fab);

	LabelField lfnome = new LabelField("nome:");
        lfnome.setId("lfnome");
	getCpMaster().add(lfnome);
        nome.setId("nome");
        nome.setMaxLength(100);
        getCpMaster().add(nome);

	LabelField lffop_nr_id = new LabelField("fop_nr_id:");
        lffop_nr_id.setId("lffop_nr_id");
	getCpMaster().add(lffop_nr_id);
        fop_nr_id.setId("fop_nr_id");
        fop_nr_id.setMaxLength(10);
        getCpMaster().add(fop_nr_id);

	LabelField lfforma = new LabelField("forma:");
        lfforma.setId("lfforma");
	getCpMaster().add(lfforma);
        forma.setId("forma");
        forma.setMaxLength(10);
        getCpMaster().add(forma);

	LabelField lfban_nr_id = new LabelField("ban_nr_id:");
        lfban_nr_id.setId("lfban_nr_id");
	getCpMaster().add(lfban_nr_id);
        ban_nr_id.setId("ban_nr_id");
        ban_nr_id.setMaxLength(10);
        getCpMaster().add(ban_nr_id);

	LabelField lfbanco = new LabelField("banco:");
        lfbanco.setId("lfbanco");
	getCpMaster().add(lfbanco);
        banco.setId("banco");
        banco.setMaxLength(50);
        getCpMaster().add(banco);

	LabelField lfpago = new LabelField("pago:");
        lfpago.setId("lfpago");
	getCpMaster().add(lfpago);
        pago.setId("pago");
        pago.setMaxLength(1);
        getCpMaster().add(pago);

	LabelField lfparcela = new LabelField("parcela:");
        lfparcela.setId("lfparcela");
	getCpMaster().add(lfparcela);
        parcela.setId("parcela");
        parcela.setMaxLength(6);
        getCpMaster().add(parcela);

	LabelField lfdocumento = new LabelField("documento:");
        lfdocumento.setId("lfdocumento");
	getCpMaster().add(lfdocumento);
        documento.setId("documento");
        documento.setMaxLength(10);
        getCpMaster().add(documento);

	LabelField lfdt_emissao = new LabelField("dt_emissao:");
        lfdt_emissao.setId("lfdt_emissao");
	getCpMaster().add(lfdt_emissao);
        dt_emissao.setId("dt_emissao");
        dt_emissao.setMaxLength(13);
        getCpMaster().add(dt_emissao);

	LabelField lfvencimento = new LabelField("vencimento:");
        lfvencimento.setId("lfvencimento");
	getCpMaster().add(lfvencimento);
        vencimento.setId("vencimento");
        vencimento.setMaxLength(13);
        getCpMaster().add(vencimento);

	LabelField lfobs = new LabelField("obs:");
        lfobs.setId("lfobs");
	getCpMaster().add(lfobs);
        obs.setId("obs");
        obs.setMaxLength(50);
        getCpMaster().add(obs);

	LabelField lfcar_nr_id = new LabelField("car_nr_id:");
        lfcar_nr_id.setId("lfcar_nr_id");
	getCpMaster().add(lfcar_nr_id);
        car_nr_id.setId("car_nr_id");
        car_nr_id.setMaxLength(10);
        getCpMaster().add(car_nr_id);

	LabelField lfcartao = new LabelField("cartao:");
        lfcartao.setId("lfcartao");
	getCpMaster().add(lfcartao);
        cartao.setId("cartao");
        cartao.setMaxLength(50);
        getCpMaster().add(cartao);

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
      V_conta_pagar_pagoT v_conta_pagar_pagoT = new V_conta_pagar_pagoT();
      		v_conta_pagar_pagoT.setDt_pagamento(dt_pagamento.getValue());
		v_conta_pagar_pagoT.setValor( Double.parseDouble(valor.getValue()));
		v_conta_pagar_pagoT.setId_cli_fab( Integer.parseInt(id_cli_fab.getValue()));
		v_conta_pagar_pagoT.setNome(nome.getValue());
		v_conta_pagar_pagoT.setFop_nr_id( Integer.parseInt(fop_nr_id.getValue()));
		v_conta_pagar_pagoT.setForma(forma.getValue());
		v_conta_pagar_pagoT.setBan_nr_id( Integer.parseInt(ban_nr_id.getValue()));
		v_conta_pagar_pagoT.setBanco(banco.getValue());
		v_conta_pagar_pagoT.setPago(pago.getValue());
		v_conta_pagar_pagoT.setParcela(parcela.getValue());
		v_conta_pagar_pagoT.setDocumento( Integer.parseInt(documento.getValue()));
		v_conta_pagar_pagoT.setDt_emissao(dt_emissao.getValue());
		v_conta_pagar_pagoT.setVencimento(vencimento.getValue());
		v_conta_pagar_pagoT.setObs(obs.getValue());
		v_conta_pagar_pagoT.setCar_nr_id( Integer.parseInt(car_nr_id.getValue()));
		v_conta_pagar_pagoT.setCartao(cartao.getValue());
		v_conta_pagar_pagoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
	btnClearAction(null);
        if (v_conta_pagar_pagoConsult != null) {
	  v_conta_pagar_pagoConsult.load();
        }
	setVisible(false);
      }
    };

    V_conta_pagar_pagoServiceAsync v_conta_pagar_pagoAsync = GWT.create(V_conta_pagar_pagoService.class);
    v_conta_pagar_pagoAsync.insert(v_conta_pagar_pagoT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			dt_pagamento.setValue(null);
		valor.setValue("");
		id_cli_fab.setValue("");
		nome.setValue("");
		fop_nr_id.setValue("");
		forma.setValue("");
		ban_nr_id.setValue("");
		banco.setValue("");
		pago.setValue("");
		parcela.setValue("");
		documento.setValue("");
		dt_emissao.setValue(null);
		vencimento.setValue(null);
		obs.setValue("");
		car_nr_id.setValue("");
		cartao.setValue("");
		loj_nr_id.setValue("");

  }

   /**
     * @return the v_conta_pagar_pagoConsult
     */
    public V_conta_pagar_pagoConsultGWT getV_conta_pagar_pagoConsult() {
        return v_conta_pagar_pagoConsult;
    }

    /**
     * @param v_conta_pagar_pagoConsult the v_conta_pagar_pagoConsult to set
     */
    public void setV_conta_pagar_pagoConsult(V_conta_pagar_pagoConsultGWT v_conta_pagar_pagoConsult) {
        this.v_conta_pagar_pagoConsult = v_conta_pagar_pagoConsult;
    }
}

