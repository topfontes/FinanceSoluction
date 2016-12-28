
/*
 * EasyNet JDragon
 */

package br.com.i9.finance.client.i9finance.easyfin.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author George Leite Junior
 */
public class Usu_loj_usuario_lojaT extends BaseModel {
  public static final String USU_NR_ID = "usu_nr_id";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Usu_loj_usuario_lojaT() {
  }

  public int getUsu_nr_id() {
    return   get(USU_NR_ID)==null?0: ((Integer)get(USU_NR_ID)).intValue();
  }

  public void setUsu_nr_id(int usu_nr_id) {
    set(USU_NR_ID, usu_nr_id);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

