
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
public class Fpar_forma_parcelaT extends BaseModel {
  public static final String FPAR_NR_ID = "fpar_nr_id";
  public static final String FOP_NR_ID = "fop_nr_id";
  public static final String PAR_NR_ID = "par_nr_id";

  public Fpar_forma_parcelaT() {
  }

  public int getFpar_nr_id() {
    return   get(FPAR_NR_ID)==null?0: ((Integer)get(FPAR_NR_ID)).intValue();
  }

  public void setFpar_nr_id(int fpar_nr_id) {
    set(FPAR_NR_ID, fpar_nr_id);
  }

  public int getFop_nr_id() {
    return   get(FOP_NR_ID)==null?0: ((Integer)get(FOP_NR_ID)).intValue();
  }

  public void setFop_nr_id(int fop_nr_id) {
    set(FOP_NR_ID, fop_nr_id);
  }

  public int getPar_nr_id() {
    return   get(PAR_NR_ID)==null?0: ((Integer)get(PAR_NR_ID)).intValue();
  }

  public void setPar_nr_id(int par_nr_id) {
    set(PAR_NR_ID, par_nr_id);
  }



}

