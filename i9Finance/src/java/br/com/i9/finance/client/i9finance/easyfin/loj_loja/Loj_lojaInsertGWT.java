/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.loj_loja;

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
public class Loj_lojaInsertGWT extends CRUDBaseGWT  {
    protected Loj_lojaConsultGWT loj_lojaConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> loj_tx_razao_social = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_matriz = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_nome_fantasia = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_cidade = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_status = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_cnpj = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_inscricao = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_estado = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_bairro = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_cep = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_endereco = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_email = new EasyTextField<String>();
    protected EasyTextField<String> loj_tx_home_page = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();


    public Loj_lojaInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Loj_loja");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfloj_tx_razao_social = new LabelField("loj_tx_razao_social:");
        lfloj_tx_razao_social.setId("lfloj_tx_razao_social");
	getCpMaster().add(lfloj_tx_razao_social);
        loj_tx_razao_social.setId("loj_tx_razao_social");
        loj_tx_razao_social.setMaxLength(100);
        getCpMaster().add(loj_tx_razao_social);

	LabelField lfloj_tx_matriz = new LabelField("loj_tx_matriz:");
        lfloj_tx_matriz.setId("lfloj_tx_matriz");
	getCpMaster().add(lfloj_tx_matriz);
        loj_tx_matriz.setId("loj_tx_matriz");
        loj_tx_matriz.setMaxLength(1);
        getCpMaster().add(loj_tx_matriz);

	LabelField lfloj_tx_nome_fantasia = new LabelField("loj_tx_nome_fantasia:");
        lfloj_tx_nome_fantasia.setId("lfloj_tx_nome_fantasia");
	getCpMaster().add(lfloj_tx_nome_fantasia);
        loj_tx_nome_fantasia.setId("loj_tx_nome_fantasia");
        loj_tx_nome_fantasia.setMaxLength(50);
        getCpMaster().add(loj_tx_nome_fantasia);

	LabelField lfloj_tx_cidade = new LabelField("loj_tx_cidade:");
        lfloj_tx_cidade.setId("lfloj_tx_cidade");
	getCpMaster().add(lfloj_tx_cidade);
        loj_tx_cidade.setId("loj_tx_cidade");
        loj_tx_cidade.setMaxLength(50);
        getCpMaster().add(loj_tx_cidade);

	LabelField lfloj_tx_status = new LabelField("loj_tx_status:");
        lfloj_tx_status.setId("lfloj_tx_status");
	getCpMaster().add(lfloj_tx_status);
        loj_tx_status.setId("loj_tx_status");
        loj_tx_status.setMaxLength(1);
        getCpMaster().add(loj_tx_status);

	LabelField lfloj_tx_cnpj = new LabelField("loj_tx_cnpj:");
        lfloj_tx_cnpj.setId("lfloj_tx_cnpj");
	getCpMaster().add(lfloj_tx_cnpj);
        loj_tx_cnpj.setId("loj_tx_cnpj");
        loj_tx_cnpj.setMaxLength(14);
        getCpMaster().add(loj_tx_cnpj);

	LabelField lfloj_tx_inscricao = new LabelField("loj_tx_inscricao:");
        lfloj_tx_inscricao.setId("lfloj_tx_inscricao");
	getCpMaster().add(lfloj_tx_inscricao);
        loj_tx_inscricao.setId("loj_tx_inscricao");
        loj_tx_inscricao.setMaxLength(20);
        getCpMaster().add(loj_tx_inscricao);

	LabelField lfloj_tx_estado = new LabelField("loj_tx_estado:");
        lfloj_tx_estado.setId("lfloj_tx_estado");
	getCpMaster().add(lfloj_tx_estado);
        loj_tx_estado.setId("loj_tx_estado");
        loj_tx_estado.setMaxLength(2);
        getCpMaster().add(loj_tx_estado);

	LabelField lfloj_tx_bairro = new LabelField("loj_tx_bairro:");
        lfloj_tx_bairro.setId("lfloj_tx_bairro");
	getCpMaster().add(lfloj_tx_bairro);
        loj_tx_bairro.setId("loj_tx_bairro");
        loj_tx_bairro.setMaxLength(50);
        getCpMaster().add(loj_tx_bairro);

	LabelField lfloj_tx_cep = new LabelField("loj_tx_cep:");
        lfloj_tx_cep.setId("lfloj_tx_cep");
	getCpMaster().add(lfloj_tx_cep);
        loj_tx_cep.setId("loj_tx_cep");
        loj_tx_cep.setMaxLength(10);
        getCpMaster().add(loj_tx_cep);

	LabelField lfloj_tx_endereco = new LabelField("loj_tx_endereco:");
        lfloj_tx_endereco.setId("lfloj_tx_endereco");
	getCpMaster().add(lfloj_tx_endereco);
        loj_tx_endereco.setId("loj_tx_endereco");
        loj_tx_endereco.setMaxLength(100);
        getCpMaster().add(loj_tx_endereco);

	LabelField lfloj_tx_email = new LabelField("loj_tx_email:");
        lfloj_tx_email.setId("lfloj_tx_email");
	getCpMaster().add(lfloj_tx_email);
        loj_tx_email.setId("loj_tx_email");
        loj_tx_email.setMaxLength(100);
        getCpMaster().add(loj_tx_email);

	LabelField lfloj_tx_home_page = new LabelField("loj_tx_home_page:");
        lfloj_tx_home_page.setId("lfloj_tx_home_page");
	getCpMaster().add(lfloj_tx_home_page);
        loj_tx_home_page.setId("loj_tx_home_page");
        loj_tx_home_page.setMaxLength(100);
        getCpMaster().add(loj_tx_home_page);

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
      Loj_lojaT loj_lojaT = new Loj_lojaT();
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
	btnClearAction(null);
        if (loj_lojaConsult != null) {
	  loj_lojaConsult.load();
        }
	setVisible(false);
      }
    };

    Loj_lojaServiceAsync loj_lojaAsync = GWT.create(Loj_lojaService.class);
    loj_lojaAsync.insert(loj_lojaT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			loj_tx_razao_social.setValue("");
		loj_tx_matriz.setValue("");
		loj_tx_nome_fantasia.setValue("");
		loj_tx_cidade.setValue("");
		loj_tx_status.setValue("");
		loj_tx_cnpj.setValue("");
		loj_tx_inscricao.setValue("");
		loj_tx_estado.setValue("");
		loj_tx_bairro.setValue("");
		loj_tx_cep.setValue("");
		loj_tx_endereco.setValue("");
		loj_tx_email.setValue("");
		loj_tx_home_page.setValue("");
		loj_nr_id.setValue("");

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

