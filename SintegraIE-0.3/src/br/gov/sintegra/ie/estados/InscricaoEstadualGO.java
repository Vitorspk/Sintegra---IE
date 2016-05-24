package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualGO
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR = { Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9]");
    if (ie.length() == 9)
    {
      int base = toInt(ie.substring(0, 2));
      if (in(base, new Integer[] { Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(15) }))
      {
        int num = toInt(ie.substring(0, 8));
        Integer[] numeros = split(ie);
        Integer[] calculo = multiplicar(numeros, MULTIPLICADOR);
        int soma = somar(calculo);
        int digito = 11 - modulo11(soma);
        if (digito == 11) {
          digito = 0;
        } else if ((digito == 10) && (num >= 10103105) && (num <= 10119997)) {
          digito = 1;
        } else if (digito == 10) {
          digito = 0;
        }
        if ((num == 11094402) && (numeros[8].intValue() == 1)) {
          digito = 1;
        }
        valido = numeros[8].intValue() == digito;
      }
    }
    return valido;
  }
}
