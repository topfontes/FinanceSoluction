/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.server.bl;

import br.com.i9.finance.client.i9finance.easyfin.transfer.Loj_lojaT;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;  

/**
 *
 * @author marcos
 */
public class LojaSesion extends SystemBusinessBase{
    
    public  Loj_lojaT getLojaSesion_(){
        Loj_lojaT loj_lojaT = new Loj_lojaT();
        return loj_lojaT;
    }
    
}
