package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualRS
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR = { Integer.valueOf(2), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9]");
    if (ie.length() == 10)
    {
      Integer[] numeros = split(ie);
      Integer[] calculo = multiplicar(numeros, MULTIPLICADOR);
      int soma = somar(calculo);
      int digito = 11 - modulo11(soma);
      if ((digito == 10) || (digito == 11)) {
        digito = 0;
      }
      valido = numeros[9].intValue() == digito;
    }
    return valido;
  }
}
