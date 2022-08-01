/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

/**
 *
 * @author usuario
 */

public class PlanPostPagoMinutosMegas extends PlanCelular{
    
    private double Minutos;
    private double Costo_Minuto;
    private double Megas_Gigas;
    private double Costo_Gigas;

    public PlanPostPagoMinutosMegas(String Nombre_Pro, String Cedula_Pro, 
            String Ciudad_Pro, String Marca_Celular, String Modelo_Celular, 
            String Numero_Celular, double m, double cm, double mg, double cg) {
        super(Nombre_Pro, Cedula_Pro, Ciudad_Pro, Marca_Celular, Modelo_Celular, 
                Numero_Celular);
        Minutos = m;
        Costo_Minuto = cm;
        Megas_Gigas = mg;
        Costo_Gigas = cg;
    }
    
    public void establecerMinutos(double m) {
        Minutos = m;
    }
    public void establecerCosto_Minuto(double cm) {
        Costo_Minuto = cm;
    }
    public void establecerMegas_Gigas(double mg) {
        Megas_Gigas = mg;
    }
    public void establecerCosto_Gigas(double cg) {
        Costo_Gigas = cg;
    }

    public double obtenerMinutos() {
        return Minutos;
    }
    public double obtenerCosto_Minuto() {
        return Costo_Minuto;
    }
    public double obtenerMegas_Gigas() {
        return Megas_Gigas;
    }
    public double obtenerCosto_Gigas() {
        return Costo_Gigas;
    }
    
    
    @Override
    public void Pago_Mensual(){
        pago_Mensual = (Minutos * Costo_Minuto) + (Megas_Gigas * Costo_Gigas);
    }                               
 
    @Override
    public String toString() {
        String c = String.format("\n-------Plan PostPago MinutosMegas-------\n"
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
                obtenerPago_Mensual()
        );
        return c;
    }
}
