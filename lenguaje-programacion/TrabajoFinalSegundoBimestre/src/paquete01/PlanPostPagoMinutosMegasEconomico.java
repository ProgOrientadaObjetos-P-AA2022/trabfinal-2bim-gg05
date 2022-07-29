/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author usuario
 */

public class PlanPostPagoMinutosMegasEconomico extends PlanCelular{
    
    private double minutos;
    private double costo_minuto;
    private double megas_gigas;
    private double costo_gigas;
    private double descuento;

    public PlanPostPagoMinutosMegasEconomico(String nombrePro, String cedulaPro,
            String ciudadPro, String marcaCelular, String modeloCelular, 
            String numeroCelular, double m, double cm, double mg, double cg, 
            double d) {
        super(nombrePro, cedulaPro, ciudadPro, marcaCelular, modeloCelular, 
                numeroCelular);
        minutos = m;
        costo_minuto = cm;
        megas_gigas = mg;
        costo_gigas = cg;
        descuento = d;
    }

    public void establecerMinutos(double m) {
        minutos = m;
    }
    public void establecerCosto_Minuto(double cm) {
        costo_minuto = cm;
    }
    public void establecerMegas_Gigas(double mg) {
        megas_gigas = mg;
    }
    public void establecerCosto_Gigas(double cg) {
        costo_gigas = cg;
    }
    public void establecerDescuento(double d) {
        descuento = d;
    }
    
    public double obtenerMinutos() {
        return minutos;
    }
    public double obtenerCosto_Minuto() {
        return costo_minuto;
    }
    public double obtenerMegas_Gigas() {
        return megas_gigas;
    }
    public double obtenerCosto_Gigas() {
        return costo_gigas;
    }
    public double obtenerDescuento(){
        return descuento;
    }
    
    @Override
    public void pagoMensual(){
        double operacion = (minutos * costo_minuto) + (megas_gigas * costo_gigas);
        pagoMensual = operacion - (descuento * operacion);
    }                               
    @Override
    public double obtenerPagoMensual(){
        return pagoMensual;
    }

    @Override
    public String toString() {
        String c= String.format("%s\nMegas: %.2f\n"
                + "Costo Gigas:  %.2f\n"
                + "Tarifa: %.2f\n"
                + "Pago Mensual: %.2f\n"
                + "Obtener Costo Minutos: %.2f\n"
                + "Descuento: %.2f\n"
                ,super.toString()
                ,obtenerMinutos()
                ,obtenerCosto_Minuto()
                ,obtenerMegas_Gigas()
                ,obtenerCosto_Gigas()
                ,obtenerDescuento()
                ,obtenerPagoMensual());
        return c;
    }
}
