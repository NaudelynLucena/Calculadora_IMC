package org.factoriaf5.calculadoraimc;

public class CalculadoraImc {

    public double calcularImc(double peso, double estatura) {
        if (peso <= 0 || estatura <= 0) {
            throw new IllegalArgumentException("El peso y la estatura deben ser mayores que cero.");
        }
        return peso / (estatura * estatura);
    }
    
    public String clasificarIMC(double imc) {
        if (imc < 16) {
            return "Delgadez severa";
        } else if (imc < 17) {
            return "Delgadez moderada";
        } else if (imc < 18.5) {
            return "Delgadez leve";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidad leve";
        } else if (imc < 40) {
            return "Obesidad moderada";
        } else {
            return "Obesidad mórbida";
        }
    }
 
    static class IMCResult {
        double imc;
        String clasificacion;

        IMCResult(double imc, String clasificacion) {
            this.imc = imc;
            this.clasificacion = clasificacion;
        }
    }

    public IMCResult obtenerResultados(double peso, double estatura) {
        double imc = calcularImc(peso, estatura);
        String clasificacion = clasificarIMC(imc);
        return new IMCResult(imc, clasificacion);
    }
}