package br.com.i9.finance.client;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easyportal.gwt.client.AuthenticationGWT;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.i9.portal.client.AdminPortalAccordion;
import com.extjs.gxt.themes.client.Access;
import com.extjs.gxt.themes.client.Slate;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Timer;

/**
 * Main entry point.
 *
 * @author geoleite
 */
public class MainEntryPoint implements EntryPoint {

    public static final String EASYPORTAL = "EASYPORTAL";
    public static final String I9FINANCE = "I9FINANCE";

    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {

    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    public void onModuleLoad() {
        /* */
        EasyAccessURL.setNrMaxTentativas(0);
        EasyAccessURL.setTimeMaxWait(999999999);

        ThemeManager.register(Slate.SLATE);
        ThemeManager.register(Access.ACCESS);
        GXT.setDefaultTheme(Slate.GRAY, true);

        br.com.i9.portal.client.Constantes.URL = Constantes.URL;
        br.com.easyportal.gwt.client.Constantes.URL = Constantes.URL;

        final EventBus eventBus = new SimpleEventBus();

        AdminPortalAccordion adminMenuPortal = new AdminPortalAccordion();
        //INSTANCIAR O ADMINPORTALACORDION DO PROJETO [1]
        AdminFINANCEAccordion adminMenuFINANCE = new AdminFINANCEAccordion();

        final PortalAccordionGWT portal = new PortalAccordionI9FINANCEGWT("images/topo.png", 38);

        portal.checkSession(60000 * 35);//35 minutos
        portal.carregaParametrosSistema(EASYPORTAL);
        portal.carregaParametrosSistema(I9FINANCE);

        portal.addMenuHandler(adminMenuPortal);
        //ADICIONAR O ADMINPORTALACORDION AO PORTAL
        portal.addMenuHandler(adminMenuFINANCE);
        

        AuthenticationGWT authentication = new AuthenticationGWT();
        authentication.setWidth(270);
        authentication.setPortal(portal);
        authentication.setVisible(true);
        Timer timer = new Timer() {

            @Override
            public void run() {
                String versao = PortalAccordionGWT.getParametro(I9FINANCE, "VERSAO");
                portal.setObsText("Versão: " + versao);
            }
        };
        timer.schedule(5000);               
    }    
}
