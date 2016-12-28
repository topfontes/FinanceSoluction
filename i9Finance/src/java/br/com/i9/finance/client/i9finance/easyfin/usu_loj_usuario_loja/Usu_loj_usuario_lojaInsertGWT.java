/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.finance.client.i9finance.easyfin.usu_loj_usuario_loja;

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
public class Usu_loj_usuario_lojaInsertGWT extends CRUDBaseGWT  {
    protected Usu_loj_usuario_lojaConsultGWT usu_loj_usuario_lojaConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> usu_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();


    public Usu_loj_usuario_lojaInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
	setHeading("Cadastrar Usu_loj_usuario_loja");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfusu_nr_id = new LabelField("usu_nr_id:");
        lfusu_nr_id.setId("lfusu_nr_id");
	getCpMaster().add(lfusu_nr_id);
        usu_nr_id.setId("usu_nr_id");
        usu_nr_id.setMaxLength(10);
        getCpMaster().add(usu_nr_id);

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
      Usu_loj_usuario_lojaT usu_loj_usuario_lojaT = new Usu_loj_usuario_lojaT();
      		usu_loj_usuario_lojaT.setUsu_nr_id( Integer.parseInt(usu_nr_id.getValue()));
		usu_loj_usuario_lojaT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
	btnClearAction(null);
        if (usu_loj_usuario_lojaConsult != null) {
	  usu_loj_usuario_lojaConsult.load();
        }
	setVisible(false);
      }
    };

    Usu_loj_usuario_lojaServiceAsync usu_loj_usuario_lojaAsync = GWT.create(Usu_loj_usuario_lojaService.class);
    usu_loj_usuario_lojaAsync.insert(usu_loj_usuario_lojaT, callback);

    }
  }

  public void btnClearAction(ButtonEvent ce){
			usu_nr_id.setValue("");
		loj_nr_id.setValue("");

  }

   /**
     * @return the usu_loj_usuario_lojaConsult
     */
    public Usu_loj_usuario_lojaConsultGWT getUsu_loj_usuario_lojaConsult() {
        return usu_loj_usuario_lojaConsult;
    }

    /**
     * @param usu_loj_usuario_lojaConsult the usu_loj_usuario_lojaConsult to set
     */
    public void setUsu_loj_usuario_lojaConsult(Usu_loj_usuario_lojaConsultGWT usu_loj_usuario_lojaConsult) {
        this.usu_loj_usuario_lojaConsult = usu_loj_usuario_lojaConsult;
    }
}

