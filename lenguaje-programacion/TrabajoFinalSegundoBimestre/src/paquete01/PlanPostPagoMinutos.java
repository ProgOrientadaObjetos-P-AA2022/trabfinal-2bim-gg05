/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author usuario
 */

public class PlanPostPagoMinutos extends PlanCelular{
    
    private double minutos_nacionales;
    private double costo_minutoNa;
    private double minutos_internacional;
    private double costo_minutoIn;

    public PlanPostPagoMinutos(String nombre_Pro, String cedula_Pro, 
            String ciudad_Pro, String marca_Celular, String modelo_Celular,
            String numero_Celular,double m,double cm,double mi,
                        double ci) {
        super(nombre_Pro, cedula_Pro, ciudad_Pro, marca_Celular, 
                modelo_Celular, numero_Celular);
        minutos_nacionales = m;
        costo_minutoNa = cm;
        minutos_internacional = mi;
        costo_minutoIn = ci;
    }
    public void establecerMinutos_Nacionales(double mn){
        minutos_nacionales = mn;
    }
    public void establecerCosto_MinutosNa(double cmn){
        costo_minutoNa = cmn;
    }
    public void establecerMinutos_Internacional(double mi){
        minutos_internacional = mi;
    }
    public void establecerCosto_MinutosIn(double cmi){
        costo_minutoIn = cmi;
    }
    
    public double obtenerMinutos_Nacionales(){
        return minutos_nacionales;
    }
    public double obtenerCosto_MinutosNa(){
        return costo_minutoNa;
    }
    public double obtenerMinutos_Internacional(){
        return minutos_internacional;
    }
    public double obtenerCosto_MinutosIn(){
        return costo_minutoIn;
    }
    
    @Override
    public void pagoMensual() {
        pagoMensual = (minutos_nacionales * costo_minutoNa) +
                (minutos_internacional * costo_minutoIn);
    }

    @Override
    public double obtenerPagoMensual() {
        return pagoMensual;
    }
    
    @Override
    public String toString() {
        String c = String.format("\n-------PLAN POST PAGO MINUTOS-------\n"
                + super.toString()+ "\nFactura\n"
                + "Cantidad Minutos Nacionales: %.2f\n"
                + "Costo Minutos Nacionales: %.3f\n"
                + "Cantidad Minutos Internacionales: %.3f\n"
                + "Costo Minutos Internacionales: %.2f\n"
                + "Valor Mensual: %.2f\n",
                obtenerMinutos_Nacionales(),
                obtenerCosto_MinutosNa(),
                obtenerMinutos_Internacional(),
                obtenerCosto_MinutosIn(),
                obtenerPagoMensual());
        return c;
    }
}
