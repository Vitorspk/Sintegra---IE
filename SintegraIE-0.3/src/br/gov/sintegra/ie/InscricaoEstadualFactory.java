package br.gov.sintegra.ie;

import br.gov.sintegra.ie.estados.InscricaoEstadualAC;
import br.gov.sintegra.ie.estados.InscricaoEstadualAL;
import br.gov.sintegra.ie.estados.InscricaoEstadualAM;
import br.gov.sintegra.ie.estados.InscricaoEstadualAP;
import br.gov.sintegra.ie.estados.InscricaoEstadualBA;
import br.gov.sintegra.ie.estados.InscricaoEstadualCE;
import br.gov.sintegra.ie.estados.InscricaoEstadualDF;
import br.gov.sintegra.ie.estados.InscricaoEstadualES;
import br.gov.sintegra.ie.estados.InscricaoEstadualGO;
import br.gov.sintegra.ie.estados.InscricaoEstadualMA;
import br.gov.sintegra.ie.estados.InscricaoEstadualMG;
import br.gov.sintegra.ie.estados.InscricaoEstadualMS;
import br.gov.sintegra.ie.estados.InscricaoEstadualMT;
import br.gov.sintegra.ie.estados.InscricaoEstadualPA;
import br.gov.sintegra.ie.estados.InscricaoEstadualPB;
import br.gov.sintegra.ie.estados.InscricaoEstadualPE;
import br.gov.sintegra.ie.estados.InscricaoEstadualPI;
import br.gov.sintegra.ie.estados.InscricaoEstadualPR;
import br.gov.sintegra.ie.estados.InscricaoEstadualRJ;
import br.gov.sintegra.ie.estados.InscricaoEstadualRN;
import br.gov.sintegra.ie.estados.InscricaoEstadualRO;
import br.gov.sintegra.ie.estados.InscricaoEstadualRR;
import br.gov.sintegra.ie.estados.InscricaoEstadualRS;
import br.gov.sintegra.ie.estados.InscricaoEstadualSC;
import br.gov.sintegra.ie.estados.InscricaoEstadualSE;
import br.gov.sintegra.ie.estados.InscricaoEstadualSP;
import br.gov.sintegra.ie.estados.InscricaoEstadualTO;

public abstract class InscricaoEstadualFactory
{
  public static InscricaoEstadual getInstance(String estado)
  {
    InscricaoEstadual ie = null;
    if ("AC".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualAC();
    } else if ("AL".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualAL();
    } else if ("AP".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualAP();
    } else if ("AM".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualAM();
    } else if ("BA".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualBA();
    } else if ("CE".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualCE();
    } else if ("DF".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualDF();
    } else if ("ES".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualES();
    } else if ("GO".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualGO();
    } else if ("MA".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualMA();
    } else if ("MT".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualMT();
    } else if ("MS".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualMS();
    } else if ("MG".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualMG();
    } else if ("PA".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualPA();
    } else if ("PB".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualPB();
    } else if ("PR".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualPR();
    } else if ("PE".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualPE();
    } else if ("PI".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualPI();
    } else if ("RJ".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualRJ();
    } else if ("RN".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualRN();
    } else if ("RS".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualRS();
    } else if ("RO".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualRO();
    } else if ("RR".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualRR();
    } else if ("SC".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualSC();
    } else if ("SP".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualSP();
    } else if ("SE".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualSE();
    } else if ("TO".equalsIgnoreCase(estado)) {
      ie = new InscricaoEstadualTO();
    }
    return ie;
  }
}
