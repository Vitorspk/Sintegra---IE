package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualAL
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR = { Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9]");
    if ((ie.length() == 9) && ("24".equals(ie.substring(0, 2))))
    {
      Integer[] numeros = split(ie);
      Integer[] calculo = multiplicar(numeros, MULTIPLICADOR);
      int soma = somar(calculo) * 10;
      int digito = soma - round(soma / 11.0D) * 11;
      if (digito == 10) {
        digito = 0;
      }
      valido = numeros[8].intValue() == digito;
    }
    return valido;
  }
}