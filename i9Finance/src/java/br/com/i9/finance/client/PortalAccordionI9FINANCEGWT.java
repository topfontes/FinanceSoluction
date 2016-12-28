package br.com.i9.finance.client;

import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
/**
 *
 * @author geoleite
 */
public class PortalAccordionI9FINANCEGWT extends PortalAccordionGWT {

    public PortalAccordionI9FINANCEGWT() {
        this(0);
    }

    public PortalAccordionI9FINANCEGWT(String urlImageHeader, int altura) {
        super(urlImageHeader, altura);
        getTabPanel().remove(getTiWelcome());
    }

    public PortalAccordionI9FINANCEGWT(int alturaBanner) {
        super(alturaBanner);
        getTabPanel().remove(getTiWelcome());
    }
    

    @Override
    public void createMenu() {
        super.createMenu(); //To change body of generated methods, choose Tools | Templates.
    }
        
}
