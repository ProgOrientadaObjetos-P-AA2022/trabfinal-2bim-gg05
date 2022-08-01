/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

/**
 *
 * @author usuario
 */

public class PlanPostPagoMinutosMegasEconomico extends PlanCelular{
    
    private double minutos;
    private double costo_Minuto;
    private double megas_Gigas;
    private double costo_Gigas;
    private double descuento;

    public PlanPostPagoMinutosMegasEconomico(String nombrePro, String cedulaPro,
            String ciudadPro, String marcaCelular, String modeloCelular, 
            String numeroCelular, double m, double cm, double mg, double cg, 
            double d) {
        super(nombrePro, cedulaPro, ciudadPro, marcaCelular, modeloCelular, 
                numeroCelular);
        minutos = m;
        costo_Minuto = cm;
        megas_Gigas = mg;
        costo_Gigas = cg;
        descuento = d;
    }

    public void establecerMinutos(double m) {
        minutos = m;
    }
    public void establecerCosto_Minuto(double cm) {
        costo_Minuto = cm;
    }
    public void establecerMegas_Gigas(double mg) {
        megas_Gigas = mg;
    }
    public void establecerCosto_Gigas(double cg) {
        costo_Gigas = cg;
    }
    public void establecerDescuento(double d) {
        descuento = d;
    }
    
    public double obtenerMinutos() {
        return minutos;
    }
    public double obtenerCosto_Minuto() {
        return costo_Minuto;
    }
    public double obtenerMegas_Gigas() {
        return megas_Gigas;
    }
    public double obtenerCosto_Gigas() {
        return costo_Gigas;
    }
    public double obtenerDescuento(){
        return descuento;
    }
    
    @Override
    public void Pago_Mensual(){
        double operacion = (minutos * costo_Minuto) + (megas_Gigas * costo_Gigas);
        pago_Mensual =  (descuento * operacion) - operacion ;
    }                               

    @Override
    public String toString() {
         String c = String.format("\n-------Plan PostPago MinutosMegas Economico"
                 + "-------\n"
                + super.toString() + "\nFactura\n"
                + "Minutos: %.2f\n"
                + "Costo minuto : %.2f\n"
                + "Numero de Megas en Gg: %.2f\n"
                + "Costo del GB: %.2f\n"
                + "Porcentage Descuento: %.2f\n"
                + "Pago mensual: %.2f\n",
                obtenerMinutos(),
                obtenerCosto_Minuto(),
                obtenerMegas_Gigas(),
                obtenerCosto_Gigas(),
                obtenerDescuento(),
                obtenerPago_Mensual());
        return c;
    }
}
