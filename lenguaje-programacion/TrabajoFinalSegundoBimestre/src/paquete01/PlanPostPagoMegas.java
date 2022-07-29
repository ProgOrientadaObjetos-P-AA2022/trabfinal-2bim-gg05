/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author usuario
 */

public class PlanPostPagoMegas extends PlanCelular{
    
    private double megas_giga;
    private double costo_giga;
    private double tarifa_base;

    //heredado de PlanCelular
    public PlanPostPagoMegas(String nombre_Pro, String cedula_Pro, 
            String ciudad_Pro, String marca_Celular, String modelo_Celular, 
            String numero_Celular, double mg, double cg, double t) {
        super(nombre_Pro, cedula_Pro, ciudad_Pro, marca_Celular, modelo_Celular, 
                numero_Celular);
        megas_giga = mg;
        costo_giga = cg;
        tarifa_base = t;
    }
    
    public void estabelcerMegas_Giga(double m){
        megas_giga = m;
    }
    public void establecerCosto_Giga(double c){
        costo_giga = c;
    }
    public void establecerTarifa_Base(double t){
        tarifa_base = t;
    }
    
    public double obtenerMegas_Giga(){
        return megas_giga;
    }
    public double obtenerCosto_Giga(){
        return costo_giga;
    }
    public double obtenerTarifa_Base(){
        return tarifa_base;
    }
    
    @Override
    public void pagoMensual() {
        pagoMensual = (megas_giga * costo_giga) + tarifa_base;
    }
    
    @Override
    public String toString() {
        String c = String.format("\n-------PLAN POST PAGO MEGAS-------\n"
                + super.toString() + "\nFactura\n"
                + "Numero de Megas (GB): %.2f\n"
                + "Costo del GB: %.2f\n"
                + "Tarifa base: %.2f\n"
                + "Pago mensual: %.2f\n",
                obtenerMegas_Giga(), 
                obtenerCosto_Giga(),
                obtenerTarifa_Base(),
                obtenerPagoMensual()
        );
        return c;
    }
}
