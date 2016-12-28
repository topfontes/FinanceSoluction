package br.com.i9.finance.client.i9finance.easyfin.loj_loja;

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
public class Loj_lojaUpdateDeleteGWT extends Loj_lojaInsertGWT {
    private Loj_lojaT loj_lojaT;

    public Loj_lojaUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Loj_loja");
    }

    public void load(Loj_lojaT loj_lojaT) {
	this.loj_lojaT = loj_lojaT;
		loj_tx_razao_social.setValue(loj_lojaT.getLoj_tx_razao_social());
		loj_tx_matriz.setValue(loj_lojaT.getLoj_tx_matriz());
		loj_tx_nome_fantasia.setValue(loj_lojaT.getLoj_tx_nome_fantasia());
		loj_tx_cidade.setValue(loj_lojaT.getLoj_tx_cidade());
		loj_tx_status.setValue(loj_lojaT.getLoj_tx_status());
		loj_tx_cnpj.setValue(loj_lojaT.getLoj_tx_cnpj());
		loj_tx_inscricao.setValue(loj_lojaT.getLoj_tx_inscricao());
		loj_tx_estado.setValue(loj_lojaT.getLoj_tx_estado());
		loj_tx_bairro.setValue(loj_lojaT.getLoj_tx_bairro());
		loj_tx_cep.setValue(loj_lojaT.getLoj_tx_cep());
		loj_tx_endereco.setValue(loj_lojaT.getLoj_tx_endereco());
		loj_tx_email.setValue(loj_lojaT.getLoj_tx_email());
		loj_tx_home_page.setValue(loj_lojaT.getLoj_tx_home_page());
		loj_nr_id.setValue(loj_lojaT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		loj_lojaT.setLoj_tx_razao_social(loj_tx_razao_social.getValue());
		loj_lojaT.setLoj_tx_matriz(loj_tx_matriz.getValue());
		loj_lojaT.setLoj_tx_nome_fantasia(loj_tx_nome_fantasia.getValue());
		loj_lojaT.setLoj_tx_cidade(loj_tx_cidade.getValue());
		loj_lojaT.setLoj_tx_status(loj_tx_status.getValue());
		loj_lojaT.setLoj_tx_cnpj(loj_tx_cnpj.getValue());
		loj_lojaT.setLoj_tx_inscricao(loj_tx_inscricao.getValue());
		loj_lojaT.setLoj_tx_estado(loj_tx_estado.getValue());
		loj_lojaT.setLoj_tx_bairro(loj_tx_bairro.getValue());
		loj_lojaT.setLoj_tx_cep(loj_tx_cep.getValue());
		loj_lojaT.setLoj_tx_endereco(loj_tx_endereco.getValue());
		loj_lojaT.setLoj_tx_email(loj_tx_email.getValue());
		loj_lojaT.setLoj_tx_home_page(loj_tx_home_page.getValue());
		loj_lojaT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (loj_lojaConsult != null) {
	  loj_lojaConsult.load();
        }
        setVisible(false);
      }
    };

    Loj_lojaServiceAsync loj_lojaAsync = GWT.create(Loj_lojaService.class);
    loj_lojaAsync.update(loj_lojaT, callback);	
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
              if (loj_lojaConsult != null) {
	        loj_lojaConsult.load();
              }
              setVisible(false);
           }  
         };  

        Loj_lojaServiceAsync loj_lojaAsync = GWT.create(Loj_lojaService.class);
        loj_lojaAsync.delete(loj_lojaT, callback);	
      }
    }
  });
 }


   /**
     * @return the loj_lojaConsult
     */
    public Loj_lojaConsultGWT getLoj_lojaConsult() {
        return loj_lojaConsult;
    }

    /**
     * @param loj_lojaConsult the loj_lojaConsult to set
     */
    public void setLoj_lojaConsult(Loj_lojaConsultGWT loj_lojaConsult) {
        this.loj_lojaConsult = loj_lojaConsult;
    }

}

