package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualRO
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR_1 = { Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  private static final Integer[] MULTIPLICADOR_2 = { Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9]");
    if (ie.length() == 9)
    {
      String ie2 = ie.substring(3);
      Integer[] numeros = split(ie2);
      Integer[] calculo = multiplicar(numeros, MULTIPLICADOR_1);
      int soma = somar(calculo);
      int digito = 11 - modulo11(soma);
      if ((digito == 10) || (digito == 11)) {
        digito -= 10;
      }
      valido = numeros[5].intValue() == digito;
    }
    else if (ie.length() == 14)
    {
      Integer[] numeros = split(ie);
      Integer[] calculo = multiplicar(numeros, MULTIPLICADOR_2);
      int soma = somar(calculo);
      int digito = 11 - modulo11(soma);
      if ((digito == 10) || (digito == 11)) {
        digito -= 10;
      }
      valido = numeros[13].intValue() == digito;
    }
    return valido;
  }
}
