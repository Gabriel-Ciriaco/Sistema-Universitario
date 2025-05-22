package com;

public abstract class ConstantesSistema {

  public static int getNumDepartamentos()
  {
    int numDepartamentos = 8;
    
    return numDepartamentos;
  }


  public static double adicionalTecnico(String nivelTecnico)
  {
    double adicional = 0.0;

    switch (nivelTecnico)
    {
      case "T1":
        adicional = 0.1;
      break;

      case "T2":
        adicional = 0.2;
      break;
    }

    return adicional;
  }

  public static double adicionalEfetivo(String nivelEfetivo)
  {
    double adicional = 0.0;

    switch (nivelEfetivo)
    {
      case "D1":
        adicional = 0.05;
      break;

      case "D2":
        adicional = 0.1;
      break;

      case "D3":
        adicional = 0.2;
      break;
    }

    return adicional;
  }

  public static double adicionalSubstituto(String nivelSubstituto)
  {
    double adicional = 0.0;

    switch (nivelSubstituto)
    {
      case "S1":
        adicional = 0.05;
      break;

      case "S2":
        adicional = 0.1;
      break;
    }

    return adicional;
  }
}
