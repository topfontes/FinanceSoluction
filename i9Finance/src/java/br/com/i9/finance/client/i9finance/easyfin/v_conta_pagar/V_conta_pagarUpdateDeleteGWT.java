package br.com.i9.finance.client.i9finance.easyfin.v_conta_pagar;

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
public class V_conta_pagarUpdateDeleteGWT extends V_conta_pagarInsertGWT {
    private V_conta_pagarT v_conta_pagarT;

    public V_conta_pagarUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar V_conta_pagar");
    }

    public void load(V_conta_pagarT v_conta_pagarT) {
	this.v_conta_pagarT = v_conta_pagarT;
		dt_pagamento.setValue(v_conta_pagarT.getDt_pagamento());
		valor.setValue(v_conta_pagarT.getValor() + "");
		id_cli_fab.setValue(v_conta_pagarT.getId_cli_fab() + "");
		nome.setValue(v_conta_pagarT.getNome());
		fop_nr_id.setValue(v_conta_pagarT.getFop_nr_id() + "");
		forma.setValue(v_conta_pagarT.getForma());
		ban_nr_id.setValue(v_conta_pagarT.getBan_nr_id() + "");
		banco.setValue(v_conta_pagarT.getBanco());
		pago.setValue(v_conta_pagarT.getPago());
		parcela.setValue(v_conta_pagarT.getParcela());
		documento.setValue(v_conta_pagarT.getDocumento() + "");
		dt_emissao.setValue(v_conta_pagarT.getDt_emissao());
		vencimento.setValue(v_conta_pagarT.getVencimento());
		obs.setValue(v_conta_pagarT.getObs());
		car_nr_id.setValue(v_conta_pagarT.getCar_nr_id() + "");
		cartao.setValue(v_conta_pagarT.getCartao());
		loj_nr_id.setValue(v_conta_pagarT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		v_conta_pagarT.setDt_pagamento(dt_pagamento.getValue());
		v_conta_pagarT.setValor( Double.parseDouble(valor.getValue()));
		v_conta_pagarT.setId_cli_fab( Integer.parseInt(id_cli_fab.getValue()));
		v_conta_pagarT.setNome(nome.getValue());
		v_conta_pagarT.setFop_nr_id( Integer.parseInt(fop_nr_id.getValue()));
		v_conta_pagarT.setForma(forma.getValue());
		v_conta_pagarT.setBan_nr_id( Integer.parseInt(ban_nr_id.getValue()));
		v_conta_pagarT.setBanco(banco.getValue());
		v_conta_pagarT.setPago(pago.getValue());
		v_conta_pagarT.setParcela(parcela.getValue());
		v_conta_pagarT.setDocumento( Integer.parseInt(documento.getValue()));
		v_conta_pagarT.setDt_emissao(dt_emissao.getValue());
		v_conta_pagarT.setVencimento(vencimento.getValue());
		v_conta_pagarT.setObs(obs.getValue());
		v_conta_pagarT.setCar_nr_id( Integer.parseInt(car_nr_id.getValue()));
		v_conta_pagarT.setCartao(cartao.getValue());
		v_conta_pagarT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (v_conta_pagarConsult != null) {
	  v_conta_pagarConsult.load();
        }
        setVisible(false);
      }
    };

    V_conta_pagarServiceAsync v_conta_pagarAsync = GWT.create(V_conta_pagarService.class);
    v_conta_pagarAsync.update(v_conta_pagarT, callback);	
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
              if (v_conta_pagarConsult != null) {
	        v_conta_pagarConsult.load();
              }
              setVisible(false);
           }  
         };  

        V_conta_pagarServiceAsync v_conta_pagarAsync = GWT.create(V_conta_pagarService.class);
        v_conta_pagarAsync.delete(v_conta_pagarT, callback);	
      }
    }
  });
 }


   /**
     * @return the v_conta_pagarConsult
     */
    public V_conta_pagarConsultGWT getV_conta_pagarConsult() {
        return v_conta_pagarConsult;
    }

    /**
     * @param v_conta_pagarConsult the v_conta_pagarConsult to set
     */
    public void setV_conta_pagarConsult(V_conta_pagarConsultGWT v_conta_pagarConsult) {
        this.v_conta_pagarConsult = v_conta_pagarConsult;
    }

}

