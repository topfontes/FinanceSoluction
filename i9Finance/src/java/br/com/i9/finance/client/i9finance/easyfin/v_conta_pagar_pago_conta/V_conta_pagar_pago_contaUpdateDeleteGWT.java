package br.com.i9.finance.client.i9finance.easyfin.v_conta_pagar_pago_conta;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.Dialog;

import br.com.i9.finance.client.i9finance.easyfin.service.*;

/**
 *
 * @author geoleite
 */
public class V_conta_pagar_pago_contaUpdateDeleteGWT extends V_conta_pagar_pago_contaInsertGWT {
    private V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT;

    public V_conta_pagar_pago_contaUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar V_conta_pagar_pago_conta");
    }

    public void load(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) {
	this.v_conta_pagar_pago_contaT = v_conta_pagar_pago_contaT;
		dt_pagamento.setValue(v_conta_pagar_pago_contaT.getDt_pagamento());
		valor.setValue(v_conta_pagar_pago_contaT.getValor() + "");
		id_cli_fab.setValue(v_conta_pagar_pago_contaT.getId_cli_fab() + "");
		nome.setValue(v_conta_pagar_pago_contaT.getNome());
		fop_nr_id.setValue(v_conta_pagar_pago_contaT.getFop_nr_id() + "");
		forma.setValue(v_conta_pagar_pago_contaT.getForma());
		ban_nr_id.setValue(v_conta_pagar_pago_contaT.getBan_nr_id() + "");
		banco.setValue(v_conta_pagar_pago_contaT.getBanco());
		pago.setValue(v_conta_pagar_pago_contaT.getPago());
		parcela.setValue(v_conta_pagar_pago_contaT.getParcela());
		documento.setValue(v_conta_pagar_pago_contaT.getDocumento() + "");
		dt_emissao.setValue(v_conta_pagar_pago_contaT.getDt_emissao());
		vencimento.setValue(v_conta_pagar_pago_contaT.getVencimento());
		obs.setValue(v_conta_pagar_pago_contaT.getObs());
		car_nr_id.setValue(v_conta_pagar_pago_contaT.getCar_nr_id() + "");
		cartao.setValue(v_conta_pagar_pago_contaT.getCartao());
		plc_nr_id.setValue(v_conta_pagar_pago_contaT.getPlc_nr_id() + "");
		conta.setValue(v_conta_pagar_pago_contaT.getConta());
		loj_nr_id.setValue(v_conta_pagar_pago_contaT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		v_conta_pagar_pago_contaT.setDt_pagamento(dt_pagamento.getValue());
		v_conta_pagar_pago_contaT.setValor( Double.parseDouble(valor.getValue()));
		v_conta_pagar_pago_contaT.setId_cli_fab( Integer.parseInt(id_cli_fab.getValue()));
		v_conta_pagar_pago_contaT.setNome(nome.getValue());
		v_conta_pagar_pago_contaT.setFop_nr_id( Integer.parseInt(fop_nr_id.getValue()));
		v_conta_pagar_pago_contaT.setForma(forma.getValue());
		v_conta_pagar_pago_contaT.setBan_nr_id( Integer.parseInt(ban_nr_id.getValue()));
		v_conta_pagar_pago_contaT.setBanco(banco.getValue());
		v_conta_pagar_pago_contaT.setPago(pago.getValue());
		v_conta_pagar_pago_contaT.setParcela(parcela.getValue());
		v_conta_pagar_pago_contaT.setDocumento( Integer.parseInt(documento.getValue()));
		v_conta_pagar_pago_contaT.setDt_emissao(dt_emissao.getValue());
		v_conta_pagar_pago_contaT.setVencimento(vencimento.getValue());
		v_conta_pagar_pago_contaT.setObs(obs.getValue());
		v_conta_pagar_pago_contaT.setCar_nr_id( Integer.parseInt(car_nr_id.getValue()));
		v_conta_pagar_pago_contaT.setCartao(cartao.getValue());
		v_conta_pagar_pago_contaT.setPlc_nr_id( Integer.parseInt(plc_nr_id.getValue()));
		v_conta_pagar_pago_contaT.setConta(conta.getValue());
		v_conta_pagar_pago_contaT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (v_conta_pagar_pago_contaConsult != null) {
	  v_conta_pagar_pago_contaConsult.load();
        }
        setVisible(false);
      }
    };

    V_conta_pagar_pago_contaServiceAsync v_conta_pagar_pago_contaAsync = GWT.create(V_conta_pagar_pago_contaService.class);
    v_conta_pagar_pago_contaAsync.update(v_conta_pagar_pago_contaT, callback);	
  }
 }

  public void btnDeletetAction(ButtonEvent ce) {

    MessageBox.confirm(EASY_LABELS.warning(), EASY_LABELS.messageDeleteConfirm(), new Listener<MessageBoxEvent>() {

      public void handleEvent(MessageBoxEvent be) {

        if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {

          AsyncCallback<Void> callback = new AsyncCallback<Void>() {

            public void onFailure(Throwable caught) {
      	      MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(Void result) {
              Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
              if (v_conta_pagar_pago_contaConsult != null) {
	        v_conta_pagar_pago_contaConsult.load();
              }
              setVisible(false);
           }  
         };  

        V_conta_pagar_pago_contaServiceAsync v_conta_pagar_pago_contaAsync = GWT.create(V_conta_pagar_pago_contaService.class);
        v_conta_pagar_pago_contaAsync.delete(v_conta_pagar_pago_contaT, callback);	
      }
    }
  });
 }


   /**
     * @return the v_conta_pagar_pago_contaConsult
     */
    public V_conta_pagar_pago_contaConsultGWT getV_conta_pagar_pago_contaConsult() {
        return v_conta_pagar_pago_contaConsult;
    }

    /**
     * @param v_conta_pagar_pago_contaConsult the v_conta_pagar_pago_contaConsult to set
     */
    public void setV_conta_pagar_pago_contaConsult(V_conta_pagar_pago_contaConsultGWT v_conta_pagar_pago_contaConsult) {
        this.v_conta_pagar_pago_contaConsult = v_conta_pagar_pago_contaConsult;
    }

}

