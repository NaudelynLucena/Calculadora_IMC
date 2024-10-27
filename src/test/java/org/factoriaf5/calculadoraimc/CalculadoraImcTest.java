package org.factoriaf5.calculadoraimc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraImcTest {

    private final CalculadoraImc calculadora = new CalculadoraImc();

    @Test
    public void testCalcularImc_ValidInput() {
        double peso = 70.0;
        double estatura = 1.75;
        double resultado = calculadora.calcularImc(peso, estatura);
        assertEquals(22.86, resultado, 0.01);
    }

    @Test
    public void testCalcularImc_InvalidPeso() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularImc(-1, 1.75);
        });
        assertEquals("El peso y la estatura deben ser mayores que cero.", exception.getMessage());
    }

    @Test
    public void testCalcularImc_InvalidEstatura() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularImc(70, 0);
        });
        assertEquals("El peso y la estatura deben ser mayores que cero.", exception.getMessage());
    }

    @Test
    public void testClasificarIMC_DelgadezSevera() {
        String clasificacion = calculadora.clasificarIMC(15.0);
        assertEquals("Delgadez severa", clasificacion);
    }

    @Test
    public void testClasificarIMC_DelgadezModerada() {
        String clasificacion = calculadora.clasificarIMC(16.5);
        assertEquals("Delgadez moderada", clasificacion);
    }

    @Test
    public void testClasificarIMC_DelgadezLeve(){
        String clasificacion = calculadora.clasificarIMC(18.0);
        assertEquals("Delgadez leve", clasificacion);
    }

    @Test
    public void testClasificarIMC_PesoNormal() {
        String clasificacion = calculadora.clasificarIMC(22.0);
        assertEquals("Peso normal", clasificacion);
    }

    @Test
    public void testClasificarIMC_Sobrepeso() {
        String clasificacion = calculadora.clasificarIMC(27.0);
        assertEquals("Sobrepeso", clasificacion);
    }

    @Test
    public void testClasificarIMC_ObesidadLeve() {
        String clasificacion = calculadora.clasificarIMC(32.0);
        assertEquals("Obesidad leve", clasificacion);
    }

    @Test
    public void testClasificarIMC_ObesidadModerada() {
        String clasificacion = calculadora.clasificarIMC(36.0);
        assertEquals("Obesidad moderada", clasificacion);
    }

    @Test
    public void testClasificarIMC_ObesidadMorbida() {
        String clasificacion = calculadora.clasificarIMC(40.0);
        assertEquals("Obesidad mórbida", clasificacion);
    }

    @Test
    public void testObtenerResultados() {
        double peso = 70.0;
        double estatura = 1.75;
        CalculadoraImc.IMCResult resultado = calculadora.obtenerResultados(peso, estatura);
        assertEquals(22.86, resultado.imc, 0.01);
        assertEquals("Peso normal", resultado.clasificacion);
    }
}