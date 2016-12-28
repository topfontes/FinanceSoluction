package br.com.i9.finance.client.i9finance.easyfin.usu_loj_usuario_loja;

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
public class Usu_loj_usuario_lojaUpdateDeleteGWT extends Usu_loj_usuario_lojaInsertGWT {
    private Usu_loj_usuario_lojaT usu_loj_usuario_lojaT;

    public Usu_loj_usuario_lojaUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Usu_loj_usuario_loja");
    }

    public void load(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) {
	this.usu_loj_usuario_lojaT = usu_loj_usuario_lojaT;
		usu_nr_id.setValue(usu_loj_usuario_lojaT.getUsu_nr_id() + "");
		loj_nr_id.setValue(usu_loj_usuario_lojaT.getLoj_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		usu_loj_usuario_lojaT.setUsu_nr_id( Integer.parseInt(usu_nr_id.getValue()));
		usu_loj_usuario_lojaT.setLoj_nr_id( Integer.parseInt(loj_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (usu_loj_usuario_lojaConsult != null) {
	  usu_loj_usuario_lojaConsult.load();
        }
        setVisible(false);
      }
    };

    Usu_loj_usuario_lojaServiceAsync usu_loj_usuario_lojaAsync = GWT.create(Usu_loj_usuario_lojaService.class);
    usu_loj_usuario_lojaAsync.update(usu_loj_usuario_lojaT, callback);	
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
              if (usu_loj_usuario_lojaConsult != null) {
	        usu_loj_usuario_lojaConsult.load();
              }
              setVisible(false);
           }  
         };  

        Usu_loj_usuario_lojaServiceAsync usu_loj_usuario_lojaAsync = GWT.create(Usu_loj_usuario_lojaService.class);
        usu_loj_usuario_lojaAsync.delete(usu_loj_usuario_lojaT, callback);	
      }
    }
  });
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

