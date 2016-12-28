package br.com.i9.finance.client.i9finance.easyfin.fpar_forma_parcela;

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
public class Fpar_forma_parcelaUpdateDeleteGWT extends Fpar_forma_parcelaInsertGWT {
    private Fpar_forma_parcelaT fpar_forma_parcelaT;

    public Fpar_forma_parcelaUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Fpar_forma_parcela");
    }

    public void load(Fpar_forma_parcelaT fpar_forma_parcelaT) {
	this.fpar_forma_parcelaT = fpar_forma_parcelaT;
		fpar_nr_id.setValue(fpar_forma_parcelaT.getFpar_nr_id() + "");
		fop_nr_id.setValue(fpar_forma_parcelaT.getFop_nr_id() + "");
		par_nr_id.setValue(fpar_forma_parcelaT.getPar_nr_id() + "");

    }

  public void btnUpdateAction(ButtonEvent ce) {
    if (valide()) {
  		fpar_forma_parcelaT.setFpar_nr_id( Integer.parseInt(fpar_nr_id.getValue()));
		fpar_forma_parcelaT.setFop_nr_id( Integer.parseInt(fop_nr_id.getValue()));
		fpar_forma_parcelaT.setPar_nr_id( Integer.parseInt(par_nr_id.getValue()));


    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(Void result) {
        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
        if (fpar_forma_parcelaConsult != null) {
	  fpar_forma_parcelaConsult.load();
        }
        setVisible(false);
      }
    };

    Fpar_forma_parcelaServiceAsync fpar_forma_parcelaAsync = GWT.create(Fpar_forma_parcelaService.class);
    fpar_forma_parcelaAsync.update(fpar_forma_parcelaT, callback);	
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
              if (fpar_forma_parcelaConsult != null) {
	        fpar_forma_parcelaConsult.load();
              }
              setVisible(false);
           }  
         };  

        Fpar_forma_parcelaServiceAsync fpar_forma_parcelaAsync = GWT.create(Fpar_forma_parcelaService.class);
        fpar_forma_parcelaAsync.delete(fpar_forma_parcelaT, callback);	
      }
    }
  });
 }


   /**
     * @return the fpar_forma_parcelaConsult
     */
    public Fpar_forma_parcelaConsultGWT getFpar_forma_parcelaConsult() {
        return fpar_forma_parcelaConsult;
    }

    /**
     * @param fpar_forma_parcelaConsult the fpar_forma_parcelaConsult to set
     */
    public void setFpar_forma_parcelaConsult(Fpar_forma_parcelaConsultGWT fpar_forma_parcelaConsult) {
        this.fpar_forma_parcelaConsult = fpar_forma_parcelaConsult;
    }

}

