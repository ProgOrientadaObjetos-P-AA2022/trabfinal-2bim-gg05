/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author usuario
 */

public class PlanPostPagoMinutosMegas extends PlanCelular{
    
    private double minutos;
    private double costo_minuto;
    private double megas_gigas;
    private double costo_gigas;

    public PlanPostPagoMinutosMegas(String nombre_Pro, String cedula_Pro, 
            String ciudad_Pro, String marca_Celular, String modelo_Celular, 
            String numero_Celular, double m, double cm, double mg, double cg) {
        super(nombre_Pro, cedula_Pro, ciudad_Pro, marca_Celular, modelo_Celular, 
                numero_Celular);
        minutos = m;
        costo_minuto = cm;
        megas_gigas = mg;
        costo_gigas = cg;
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
    
    
    @Override
    public void pagoMensual(){
        pagoMensual = (minutos * costo_minuto) + (megas_gigas * costo_gigas);
    }                               
    @Override
    public double obtenerPagoMensual(){
        return pagoMensual;
    }
 
    @Override
    public String toString() {
        String c = String.format("\nPlan PostPago MinutosMegas\n"
                + super.toString() + "\nFactura\n"
                + "Minutos: %.2f\n"
                + "Costo minuto : %.2f\n"
                + "Numero de Megas (GB): %.2f\n"
                + "Costo del GB: %.2f\n"
                + "Pago mensual: %.2f\n",
                obtenerMinutos(),
                obtenerCosto_Minuto(),
                obtenerMegas_Gigas(),
                obtenerCosto_Gigas(),
                obtenerPagoMensual()
        );
        return c;
    }
}
