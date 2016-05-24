package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualDF
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR_1 = { Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  private static final Integer[] MULTIPLICADOR_2 = { Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9]");
    if (ie.length() == 13)
    {
      Integer[] numeros = split(ie);
      Integer[] calculo1 = multiplicar(numeros, MULTIPLICADOR_1);
      int soma = somar(calculo1);
      int digito = 11 - modulo11(soma);
      if ((digito == 10) || (digito == 11)) {
        digito = 0;
      }
      if (numeros[11].intValue() == digito)
      {
        Integer[] calculo2 = multiplicar(numeros, MULTIPLICADOR_2);
        soma = somar(calculo2);
        digito = 11 - modulo11(soma);
        if ((digito == 10) || (digito == 11)) {
          digito = 0;
        }
        valido = numeros[12].intValue() == digito;
      }
    }
    return valido;
  }
}
