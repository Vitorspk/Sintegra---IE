package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualBA
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR_8_1 = { Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  private static final Integer[] MULTIPLICADOR_8_2 = { Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3) };
  private static final Integer[] MULTIPLICADOR_9_1 = { Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  private static final Integer[] MULTIPLICADOR_9_2 = { Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9]");
    if (ie.length() == 8)
    {
      int inicial = toInt(ie.substring(0, 1));
      if (in(inicial, new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(8) }))
      {
        Integer[] numeros = split(ie);
        Integer[] calculo1 = multiplicar(numeros, MULTIPLICADOR_8_1);
        int soma = somar(calculo1);
        int digito = 10 - modulo10(soma);
        if (digito == 10) {
          digito = 0;
        }
        if (numeros[7].intValue() == digito)
        {
          Integer[] calculo2 = multiplicar(numeros, MULTIPLICADOR_8_2);
          soma = somar(calculo2) + 2 * digito;
          digito = 10 - modulo10(soma);
          if (digito == 10) {
            digito = 0;
          }
          valido = numeros[6].intValue() == digito;
        }
      }
      else if (in(inicial, new Integer[] { Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(9) }))
      {
        Integer[] numeros = split(ie);
        Integer[] calculo1 = multiplicar(numeros, MULTIPLICADOR_8_1);
        int soma = somar(calculo1);
        int digito = 11 - modulo11(soma);
        if ((digito == 10) || (digito == 11)) {
          digito = 0;
        }
        if (numeros[7].intValue() == digito)
        {
          Integer[] calculo2 = multiplicar(numeros, MULTIPLICADOR_8_2);
          soma = somar(calculo2) + 2 * digito;
          digito = 11 - modulo11(soma);
          if ((digito == 10) || (digito == 11)) {
            digito = 0;
          }
          valido = numeros[6].intValue() == digito;
        }
      }
    }
    else if (ie.length() == 9)
    {
      int inicial = toInt(ie.substring(0, 1));
      if (in(inicial, new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(8) }))
      {
        Integer[] numeros = split(ie);
        Integer[] calculo1 = multiplicar(numeros, MULTIPLICADOR_9_1);
        int soma = somar(calculo1);
        int digito = 10 - modulo10(soma);
        if (digito == 10) {
          digito = 0;
        }
        if (numeros[8].intValue() == digito)
        {
          Integer[] calculo2 = multiplicar(numeros, MULTIPLICADOR_9_2);
          soma = somar(calculo2) + 2 * digito;
          digito = 10 - modulo10(soma);
          if (digito == 10) {
            digito = 0;
          }
          valido = numeros[7].intValue() == digito;
        }
      }
      else if (in(inicial, new Integer[] { Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(9) }))
      {
        Integer[] numeros = split(ie);
        Integer[] calculo1 = multiplicar(numeros, MULTIPLICADOR_9_1);
        int soma = somar(calculo1);
        int digito = 11 - modulo11(soma);
        if ((digito == 10) || (digito == 11)) {
          digito = 0;
        }
        if (numeros[8].intValue() == digito)
        {
          Integer[] calculo2 = multiplicar(numeros, MULTIPLICADOR_9_2);
          soma = somar(calculo2) + 2 * digito;
          digito = 11 - modulo11(soma);
          if ((digito == 10) || (digito == 11)) {
            digito = 0;
          }
          valido = numeros[7].intValue() == digito;
        }
      }
    }
    return valido;
  }
}
