package br.gov.sintegra.ie.estados;

import br.gov.sintegra.ie.InscricaoEstadualBase;

public class InscricaoEstadualSP
  extends InscricaoEstadualBase
{
  private static final Integer[] MULTIPLICADOR_1 = { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
  private static final Integer[] MULTIPLICADOR_2 = { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(5), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(2) };
  
  public boolean validar(String numero)
  {
    boolean valido = false;
    
    String ie = limpar(numero, "[^0-9P]");
    if ((ie.length() == 12) || ((ie.length() == 13) && ("P".equals(ie.subSequence(0, 1)))))
    {
      Integer[] numeros = split(ie);
      if (!"P".equals(ie.subSequence(0, 1)))
      {
        Integer[] calculo1 = multiplicar(numeros, MULTIPLICADOR_1);
        int soma = somar(calculo1);
        int digito = right(modulo11(soma));
        if (numeros[8].intValue() == digito)
        {
          Integer[] calculo2 = multiplicar(numeros, MULTIPLICADOR_2);
          soma = somar(calculo2);
          digito = right(modulo11(soma));
          valido = numeros[11].intValue() == digito;
        }
      }
      else
      {
        Integer[] calculo1 = multiplicar(numeros, MULTIPLICADOR_1);
        int soma = somar(calculo1);
        int digito = right(modulo11(soma));
        valido = numeros[8].intValue() == digito;
      }
    }
    return valido;
  }
}
