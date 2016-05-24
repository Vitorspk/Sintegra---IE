package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualRN
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR_1 = { Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  private static final Integer[] MULTIPLICADOR_2 = { Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9]");
    if ((ie.length() == 9) && ("20".equals(ie.substring(0, 2))))
    {
      Integer[] numeros = split(ie);
      Integer[] calculo = multiplicar(numeros, MULTIPLICADOR_1);
      int soma = somar(calculo);
      int digito = modulo11(soma * 10);
      if (digito == 10) {
        digito = 0;
      }
      valido = numeros[8].intValue() == digito;
    }
    else if ((ie.length() == 10) && ("20".equals(ie.substring(0, 2))))
    {
      Integer[] numeros = split(ie);
      Integer[] calculo = multiplicar(numeros, MULTIPLICADOR_2);
      int soma = somar(calculo);
      int digito = modulo11(soma * 10);
      if (digito == 10) {
        digito = 0;
      }
      valido = numeros[9].intValue() == digito;
    }
    return valido;
  }
}
