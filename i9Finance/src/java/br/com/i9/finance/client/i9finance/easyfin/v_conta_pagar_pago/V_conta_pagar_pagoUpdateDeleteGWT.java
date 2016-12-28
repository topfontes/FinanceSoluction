package br.com.i9.finance.client.i9finance.easyfin.v_conta_pagar_pago;

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
public class V_conta_pagar_pagoUpdateDeleteGWT extends V_conta_pagar_pagoInsertGWT {
    private V_conta_pagar_pagoT v_conta_pagar_pagoT;

    public V_conta_pagar_pagoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar V_conta_pagar_pago");
    }

    public void load(V_conta_pagar_pagoT v_conta_pagar_pagoT) {
	this.v_conta_pagar_pagoT = v_conta_pagar_pagoT;
		dt_pagamento.setValue(v_conta_pagar_pagoT.getDt_pagamento());
		valor.setValue(v_conta_pagar_pagoT.getValor() + "");
		id_cli_fab.setValue(v_conta_pagar_pagoT.getId_cli_fab() + "");
		nome.setValue(v_conta_pagar_pagoT.getNome());
		fop_nr_id.setValue(v_conta_pagar_pagoT.getFop_nr_id() + "");
		forma.setValue(v_conta_pagar_pagoT.getForma());
		ban_nr_id.setValue(v_conta_pagar_pagoT.getBan_nr_id() + "");
		banco.setValue(v_conta_pagar_pagoT.getBanco());
		pago.setValue(v_conta_pagar_pagoT.getPago());
		parcela.setValue(v_conta_pagar_pagoT.getParcela());
		documento.setValue(v_conta_pagar_pagoT.getDocumento() + "");
		dt_emissao.setValue(v_conta_pagar_pagoT.getDt_emissao());
		vencimento.setValue(v_conta_pagar_pagoT.getVencimento());
		obs.setValue(v_conta_pagar_pagoT.getObs());
		car_nr_id.setValue(v_conta_pagar_pagoT.getCar_nr_id() + "");
		cartao.setValue(v_conta_pagar_pagoT.getCartao());
		loj_nr_id.setValue(v_conta_pagar_pagoT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
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
        if (v_conta_pagar_pagoConsult != null) {
	  v_conta_pagar_pagoConsult.load();
        }
        setVisible(false);
      }
    };

    V_conta_pagar_pagoServiceAsync v_conta_pagar_pagoAsync = GWT.create(V_conta_pagar_pagoService.class);
    v_conta_pagar_pagoAsync.update(v_conta_pagar_pagoT, callback);	
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
              if (v_conta_pagar_pagoConsult != null) {
	        v_conta_pagar_pagoConsult.load();
              }
              setVisible(false);
           }  
         };  

        V_conta_pagar_pagoServiceAsync v_conta_pagar_pagoAsync = GWT.create(V_conta_pagar_pagoService.class);
        v_conta_pagar_pagoAsync.delete(v_conta_pagar_pagoT, callback);	
      }
    }
  });
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

