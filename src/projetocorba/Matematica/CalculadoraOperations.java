package Matematica;


/**
* Matematica/CalculadoraOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcIDL.idl
* Domingo, 14 de Outubro de 2018 11h13min34s GMT-03:00
*/

public interface CalculadoraOperations 
{
  float soma (float arg1, float arg2);
  float divisao (float arg1, float arg2) throws Matematica.DivisaoPorZero;
} // interface CalculadoraOperations
