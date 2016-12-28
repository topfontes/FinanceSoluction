package br.com.i9.finance.client.i9finance.easyfin.conf_configuracao;

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
public class Conf_configuracaoUpdateDeleteGWT extends Conf_configuracaoInsertGWT {
    private Conf_configuracaoT conf_configuracaoT;

    public Conf_configuracaoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Conf_configuracao");
    }

    public void load(Conf_configuracaoT conf_configuracaoT) {
	this.conf_configuracaoT = conf_configuracaoT;
		conf_plc_nr_id_juros_recebido.setValue(conf_configuracaoT.getConf_plc_nr_id_juros_recebido() + "");
		conf_plc_nr_id_desconto_consedido.setValue(conf_configuracaoT.getConf_plc_nr_id_desconto_consedido() + "");
		conf_plc_nr_id_desconto_recebido.setValue(conf_configuracaoT.getConf_plc_nr_id_desconto_recebido() + "");
		loj_nr_id.setValue(conf_configuracaoT.getLoj_nr_id() + "");
		conf_plc_nr_id_taxa_cartao.setValue(conf_configuracaoT.getConf_plc_nr_id_taxa_cartao() + "");
		conf_tx_lancamento_auto_taxa_cartao.setValue(conf_configuracaoT.getConf_tx_lancamento_auto_taxa_cartao());
		conf_plc_nr_id_juros_consedido.setValue(conf_configuracaoT.getConf_plc_nr_id_juros_consedido() + "");
		conf_tx_baixa_cartao_automatico.setValue(conf_configuracaoT.getConf_tx_baixa_cartao_automatico());
		conf_nr_id.setValue(conf_configuracaoT.getConf_nr_id() + "");
		conf_plc_nr_id_default.setValue(conf_configuracaoT.getConf_plc_nr_id_default() + "");
		conf_plc_nr_id_caixa.setValue(conf_configuracaoT.getConf_plc_nr_id_caixa() + "");
		conf_tx_lan_auto_conta_vinc_ctr.setValue(conf_configuracaoT.getConf_tx_lan_auto_conta_vinc_ctr());
		conf_tx_lan_auto_conta_vinc_ctp.setValue(conf_configuracaoT.getConf_tx_lan_auto_conta_vinc_ctp());

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		conf_configuracaoT.setConf_plc_nr_id_juros_recebido( Integer.parseInt(conf_plc_nr_id_juros_recebido.getValue()));
		conf_configuracaoT.setConf_plc_nr_id_desconto_consedido( Integer.parseInt(conf_plc_nr_id_desconto_consedido.getValue()));
		conf_configuracaoT.setConf_plc_nr_id_desconto_recebido( Integer.parseInt(conf_plc_nr_id_desconto_recebido.getValue()));
		conf_configuracaoT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));
		conf_configuracaoT.setConf_plc_nr_id_taxa_cartao( Integer.parseInt(conf_plc_nr_id_taxa_cartao.getValue()));
		conf_configuracaoT.setConf_tx_lancamento_auto_taxa_cartao(conf_tx_lancamento_auto_taxa_cartao.getValue());
		conf_configuracaoT.setConf_plc_nr_id_juros_consedido( Integer.parseInt(conf_plc_nr_id_juros_consedido.getValue()));
		conf_configuracaoT.setConf_tx_baixa_cartao_automatico(conf_tx_baixa_cartao_automatico.getValue());
		conf_configuracaoT.setConf_nr_id( Integer.parseInt(conf_nr_id.getValue()));
		conf_configuracaoT.setConf_plc_nr_id_default( Integer.parseInt(conf_plc_nr_id_default.getValue()));
		conf_configuracaoT.setConf_plc_nr_id_caixa( Integer.parseInt(conf_plc_nr_id_caixa.getValue()));
		conf_configuracaoT.setConf_tx_lan_auto_conta_vinc_ctr(conf_tx_lan_auto_conta_vinc_ctr.getValue());
		conf_configuracaoT.setConf_tx_lan_auto_conta_vinc_ctp(conf_tx_lan_auto_conta_vinc_ctp.getValue());


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (conf_configuracaoConsult != null) {
	  conf_configuracaoConsult.load();
        }
        setVisible(false);
      }
    };

    Conf_configuracaoServiceAsync conf_configuracaoAsync = GWT.create(Conf_configuracaoService.class);
    conf_configuracaoAsync.update(conf_configuracaoT, callback);	
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
              if (conf_configuracaoConsult != null) {
	        conf_configuracaoConsult.load();
              }
              setVisible(false);
           }  
         };  

        Conf_configuracaoServiceAsync conf_configuracaoAsync = GWT.create(Conf_configuracaoService.class);
        conf_configuracaoAsync.delete(conf_configuracaoT, callback);	
      }
    }
  });
 }


   /**
     * @return the conf_configuracaoConsult
     */
    public Conf_configuracaoConsultGWT getConf_configuracaoConsult() {
        return conf_configuracaoConsult;
    }

    /**
     * @param conf_configuracaoConsult the conf_configuracaoConsult to set
     */
    public void setConf_configuracaoConsult(Conf_configuracaoConsultGWT conf_configuracaoConsult) {
        this.conf_configuracaoConsult = conf_configuracaoConsult;
    }

}

