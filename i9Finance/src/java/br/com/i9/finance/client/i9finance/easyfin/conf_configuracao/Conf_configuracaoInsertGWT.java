/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.conf_configuracao;

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
public class Conf_configuracaoInsertGWT extends CRUDBaseGWT  {
    protected Conf_configuracaoConsultGWT conf_configuracaoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> conf_plc_nr_id_juros_recebido = new EasyTextField<String>();
    protected EasyTextField<String> conf_plc_nr_id_desconto_consedido = new EasyTextField<String>();
    protected EasyTextField<String> conf_plc_nr_id_desconto_recebido = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> conf_plc_nr_id_taxa_cartao = new EasyTextField<String>();
    protected EasyTextField<String> conf_tx_lancamento_auto_taxa_cartao = new EasyTextField<String>();
    protected EasyTextField<String> conf_plc_nr_id_juros_consedido = new EasyTextField<String>();
    protected EasyTextField<String> conf_tx_baixa_cartao_automatico = new EasyTextField<String>();
    protected EasyTextField<String> conf_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> conf_plc_nr_id_default = new EasyTextField<String>();
    protected EasyTextField<String> conf_plc_nr_id_caixa = new EasyTextField<String>();
    protected EasyTextField<String> conf_tx_lan_auto_conta_vinc_ctr = new EasyTextField<String>();
    protected EasyTextField<String> conf_tx_lan_auto_conta_vinc_ctp = new EasyTextField<String>();


    public Conf_configuracaoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Conf_configuracao");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfconf_plc_nr_id_juros_recebido = new LabelField("conf_plc_nr_id_juros_recebido:");
        lfconf_plc_nr_id_juros_recebido.setId("lfconf_plc_nr_id_juros_recebido");
	getCpMaster().add(lfconf_plc_nr_id_juros_recebido);
        conf_plc_nr_id_juros_recebido.setId("conf_plc_nr_id_juros_recebido");
        conf_plc_nr_id_juros_recebido.setMaxLength(10);
        getCpMaster().add(conf_plc_nr_id_juros_recebido);

	LabelField lfconf_plc_nr_id_desconto_consedido = new LabelField("conf_plc_nr_id_desconto_consedido:");
        lfconf_plc_nr_id_desconto_consedido.setId("lfconf_plc_nr_id_desconto_consedido");
	getCpMaster().add(lfconf_plc_nr_id_desconto_consedido);
        conf_plc_nr_id_desconto_consedido.setId("conf_plc_nr_id_desconto_consedido");
        conf_plc_nr_id_desconto_consedido.setMaxLength(10);
        getCpMaster().add(conf_plc_nr_id_desconto_consedido);

	LabelField lfconf_plc_nr_id_desconto_recebido = new LabelField("conf_plc_nr_id_desconto_recebido:");
        lfconf_plc_nr_id_desconto_recebido.setId("lfconf_plc_nr_id_desconto_recebido");
	getCpMaster().add(lfconf_plc_nr_id_desconto_recebido);
        conf_plc_nr_id_desconto_recebido.setId("conf_plc_nr_id_desconto_recebido");
        conf_plc_nr_id_desconto_recebido.setMaxLength(10);
        getCpMaster().add(conf_plc_nr_id_desconto_recebido);

	LabelField lfloj_nr_id = new LabelField("loj_nr_id:");
        lfloj_nr_id.setId("lfloj_nr_id");
	getCpMaster().add(lfloj_nr_id);
        loj_nr_id.setId("loj_nr_id");
        loj_nr_id.setMaxLength(10);
        getCpMaster().add(loj_nr_id);

	LabelField lfconf_plc_nr_id_taxa_cartao = new LabelField("conf_plc_nr_id_taxa_cartao:");
        lfconf_plc_nr_id_taxa_cartao.setId("lfconf_plc_nr_id_taxa_cartao");
	getCpMaster().add(lfconf_plc_nr_id_taxa_cartao);
        conf_plc_nr_id_taxa_cartao.setId("conf_plc_nr_id_taxa_cartao");
        conf_plc_nr_id_taxa_cartao.setMaxLength(10);
        getCpMaster().add(conf_plc_nr_id_taxa_cartao);

	LabelField lfconf_tx_lancamento_auto_taxa_cartao = new LabelField("conf_tx_lancamento_auto_taxa_cartao:");
        lfconf_tx_lancamento_auto_taxa_cartao.setId("lfconf_tx_lancamento_auto_taxa_cartao");
	getCpMaster().add(lfconf_tx_lancamento_auto_taxa_cartao);
        conf_tx_lancamento_auto_taxa_cartao.setId("conf_tx_lancamento_auto_taxa_cartao");
        conf_tx_lancamento_auto_taxa_cartao.setMaxLength(1);
        getCpMaster().add(conf_tx_lancamento_auto_taxa_cartao);

	LabelField lfconf_plc_nr_id_juros_consedido = new LabelField("conf_plc_nr_id_juros_consedido:");
        lfconf_plc_nr_id_juros_consedido.setId("lfconf_plc_nr_id_juros_consedido");
	getCpMaster().add(lfconf_plc_nr_id_juros_consedido);
        conf_plc_nr_id_juros_consedido.setId("conf_plc_nr_id_juros_consedido");
        conf_plc_nr_id_juros_consedido.setMaxLength(10);
        getCpMaster().add(conf_plc_nr_id_juros_consedido);

	LabelField lfconf_tx_baixa_cartao_automatico = new LabelField("conf_tx_baixa_cartao_automatico:");
        lfconf_tx_baixa_cartao_automatico.setId("lfconf_tx_baixa_cartao_automatico");
	getCpMaster().add(lfconf_tx_baixa_cartao_automatico);
        conf_tx_baixa_cartao_automatico.setId("conf_tx_baixa_cartao_automatico");
        conf_tx_baixa_cartao_automatico.setMaxLength(10);
        getCpMaster().add(conf_tx_baixa_cartao_automatico);

	LabelField lfconf_nr_id = new LabelField("conf_nr_id:");
        lfconf_nr_id.setId("lfconf_nr_id");
	getCpMaster().add(lfconf_nr_id);
        conf_nr_id.setId("conf_nr_id");
        conf_nr_id.setMaxLength(10);
        getCpMaster().add(conf_nr_id);

	LabelField lfconf_plc_nr_id_default = new LabelField("conf_plc_nr_id_default:");
        lfconf_plc_nr_id_default.setId("lfconf_plc_nr_id_default");
	getCpMaster().add(lfconf_plc_nr_id_default);
        conf_plc_nr_id_default.setId("conf_plc_nr_id_default");
        conf_plc_nr_id_default.setMaxLength(10);
        getCpMaster().add(conf_plc_nr_id_default);

	LabelField lfconf_plc_nr_id_caixa = new LabelField("conf_plc_nr_id_caixa:");
        lfconf_plc_nr_id_caixa.setId("lfconf_plc_nr_id_caixa");
	getCpMaster().add(lfconf_plc_nr_id_caixa);
        conf_plc_nr_id_caixa.setId("conf_plc_nr_id_caixa");
        conf_plc_nr_id_caixa.setMaxLength(10);
        getCpMaster().add(conf_plc_nr_id_caixa);

	LabelField lfconf_tx_lan_auto_conta_vinc_ctr = new LabelField("conf_tx_lan_auto_conta_vinc_ctr:");
        lfconf_tx_lan_auto_conta_vinc_ctr.setId("lfconf_tx_lan_auto_conta_vinc_ctr");
	getCpMaster().add(lfconf_tx_lan_auto_conta_vinc_ctr);
        conf_tx_lan_auto_conta_vinc_ctr.setId("conf_tx_lan_auto_conta_vinc_ctr");
        conf_tx_lan_auto_conta_vinc_ctr.setMaxLength(1);
        getCpMaster().add(conf_tx_lan_auto_conta_vinc_ctr);

	LabelField lfconf_tx_lan_auto_conta_vinc_ctp = new LabelField("conf_tx_lan_auto_conta_vinc_ctp:");
        lfconf_tx_lan_auto_conta_vinc_ctp.setId("lfconf_tx_lan_auto_conta_vinc_ctp");
	getCpMaster().add(lfconf_tx_lan_auto_conta_vinc_ctp);
        conf_tx_lan_auto_conta_vinc_ctp.setId("conf_tx_lan_auto_conta_vinc_ctp");
        conf_tx_lan_auto_conta_vinc_ctp.setMaxLength(1);
        getCpMaster().add(conf_tx_lan_auto_conta_vinc_ctp);


    }

    public boolean valide() {
        return true;
    }

  public void btnInsertAction(ButtonEvent ce){
    if (valide()) {
      Conf_configuracaoT conf_configuracaoT = new Conf_configuracaoT();
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
	btnClearAction(null);
        if (conf_configuracaoConsult != null) {
	  conf_configuracaoConsult.load();
        }
	setVisible(false);
      }
    };

    Conf_configuracaoServiceAsync conf_configuracaoAsync = GWT.create(Conf_configuracaoService.class);
    conf_configuracaoAsync.insert(conf_configuracaoT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			conf_plc_nr_id_juros_recebido.setValue("");
		conf_plc_nr_id_desconto_consedido.setValue("");
		conf_plc_nr_id_desconto_recebido.setValue("");
		loj_nr_id.setValue("");
		conf_plc_nr_id_taxa_cartao.setValue("");
		conf_tx_lancamento_auto_taxa_cartao.setValue("");
		conf_plc_nr_id_juros_consedido.setValue("");
		conf_tx_baixa_cartao_automatico.setValue("");
		conf_nr_id.setValue("");
		conf_plc_nr_id_default.setValue("");
		conf_plc_nr_id_caixa.setValue("");
		conf_tx_lan_auto_conta_vinc_ctr.setValue("");
		conf_tx_lan_auto_conta_vinc_ctp.setValue("");

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

