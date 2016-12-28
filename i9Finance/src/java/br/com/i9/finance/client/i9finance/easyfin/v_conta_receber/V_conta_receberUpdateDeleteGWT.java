package br.com.i9.finance.client.i9finance.easyfin.v_conta_receber;

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
public class V_conta_receberUpdateDeleteGWT extends V_conta_receberInsertGWT {
    private V_conta_receberT v_conta_receberT;

    public V_conta_receberUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar V_conta_receber");
    }

    public void load(V_conta_receberT v_conta_receberT) {
	this.v_conta_receberT = v_conta_receberT;
		dt_pagamento.setValue(v_conta_receberT.getDt_pagamento());
		valor.setValue(v_conta_receberT.getValor() + "");
		id_cli_fab.setValue(v_conta_receberT.getId_cli_fab() + "");
		nome.setValue(v_conta_receberT.getNome());
		fop_nr_id.setValue(v_conta_receberT.getFop_nr_id() + "");
		forma.setValue(v_conta_receberT.getForma());
		ban_nr_id.setValue(v_conta_receberT.getBan_nr_id() + "");
		banco.setValue(v_conta_receberT.getBanco());
		pago.setValue(v_conta_receberT.getPago());
		parcela.setValue(v_conta_receberT.getParcela());
		documento.setValue(v_conta_receberT.getDocumento() + "");
		dt_emissao.setValue(v_conta_receberT.getDt_emissao());
		vencimento.setValue(v_conta_receberT.getVencimento());
		obs.setValue(v_conta_receberT.getObs());
		car_nr_id.setValue(v_conta_receberT.getCar_nr_id() + "");
		cartao.setValue(v_conta_receberT.getCartao());
		loj_nr_id.setValue(v_conta_receberT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		v_conta_receberT.setDt_pagamento(dt_pagamento.getValue());
		v_conta_receberT.setValor( Double.parseDouble(valor.getValue()));
		v_conta_receberT.setId_cli_fab( Integer.parseInt(id_cli_fab.getValue()));
		v_conta_receberT.setNome(nome.getValue());
		v_conta_receberT.setFop_nr_id( Integer.parseInt(fop_nr_id.getValue()));
		v_conta_receberT.setForma(forma.getValue());
		v_conta_receberT.setBan_nr_id( Integer.parseInt(ban_nr_id.getValue()));
		v_conta_receberT.setBanco(banco.getValue());
		v_conta_receberT.setPago(pago.getValue());
		v_conta_receberT.setParcela(parcela.getValue());
		v_conta_receberT.setDocumento( Integer.parseInt(documento.getValue()));
		v_conta_receberT.setDt_emissao(dt_emissao.getValue());
		v_conta_receberT.setVencimento(vencimento.getValue());
		v_conta_receberT.setObs(obs.getValue());
		v_conta_receberT.setCar_nr_id( Integer.parseInt(car_nr_id.getValue()));
		v_conta_receberT.setCartao(cartao.getValue());
		v_conta_receberT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (v_conta_receberConsult != null) {
	  v_conta_receberConsult.load();
        }
        setVisible(false);
      }
    };

    V_conta_receberServiceAsync v_conta_receberAsync = GWT.create(V_conta_receberService.class);
    v_conta_receberAsync.update(v_conta_receberT, callback);	
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
              if (v_conta_receberConsult != null) {
	        v_conta_receberConsult.load();
              }
              setVisible(false);
           }  
         };  

        V_conta_receberServiceAsync v_conta_receberAsync = GWT.create(V_conta_receberService.class);
        v_conta_receberAsync.delete(v_conta_receberT, callback);	
      }
    }
  });
 }


   /**
     * @return the v_conta_receberConsult
     */
    public V_conta_receberConsultGWT getV_conta_receberConsult() {
        return v_conta_receberConsult;
    }

    /**
     * @param v_conta_receberConsult the v_conta_receberConsult to set
     */
    public void setV_conta_receberConsult(V_conta_receberConsultGWT v_conta_receberConsult) {
        this.v_conta_receberConsult = v_conta_receberConsult;
    }

}

