package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualMG
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR_1 = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(2) };
  private static final Integer[] MULTIPLICADOR_2 = { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(11), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9]");
    if (ie.length() == 13)
    {
      String ie1 = ie.substring(0, 3) + "0" + ie.substring(3);
      Integer[] numeros1 = split(ie1);
      Integer[] calculo1 = multiplicar(numeros1, MULTIPLICADOR_1);
      int soma = reduzir(calculo1);
      int digito = dezena(soma) - soma;
      if (numeros1[12].intValue() == digito)
      {
        Integer[] numeros2 = split(ie);
        Integer[] calculo2 = multiplicar(numeros2, MULTIPLICADOR_2);
        soma = somar(calculo2);
        digito = 11 - modulo11(soma);
        if ((digito == 10) || (digito == 11)) {
          digito = 0;
        }
        valido = numeros2[12].intValue() == digito;
      }
    }
    return valido;
  }
}
