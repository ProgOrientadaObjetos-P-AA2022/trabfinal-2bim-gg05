/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

/**
 *
 * @author usuario
 */

public class PlanPostPagoMegas extends PlanCelular{
    
    private double megas_Gigas;
    private double costo_Gigas;
    private double tarifa_Base;

    //heredado de PlanCelular
    public PlanPostPagoMegas(String nombre_Pro, String cedula_Pro, 
            String ciudad_Pro, String marca_Celular, String modelo_Celular, 
            String numero_Celular, double mg, double cg, double t) {
        super(nombre_Pro, cedula_Pro, ciudad_Pro, marca_Celular, modelo_Celular, 
                numero_Celular);
        megas_Gigas = mg;
        costo_Gigas = cg;
        tarifa_Base = t;
    }
    
    public void estabelcerMegas_Gigas(double m){
        megas_Gigas = m;
    }
    public void establecerCosto_Gigas(double c){
        costo_Gigas = c;
    }
    public void establecerTarifa_Base(double t){
        tarifa_Base = t;
    }
    
    public double obtenerMegas_Gigas(){
        return megas_Gigas;
    }
    public double obtenerCosto_Gigas(){
        return costo_Gigas;
    }
    public double obtenerTarifa_Base(){
        return tarifa_Base;
    }
    
    @Override
    public void Pago_Mensual() {
        pago_Mensual = (megas_Gigas * costo_Gigas) + tarifa_Base;
    }
    
    @Override
    public String toString() {
        String c = String.format("\n-------PLAN POST PAGO MEGAS-------\n"
                + super.toString() + "\nFactura\n"
                + "Numero de Megas (GB): %.2f\n"
                + "Costo del GB: %.2f\n"
                + "Tarifa base: %.2f\n"
                + "Pago mensual: %.2f\n",
                obtenerMegas_Gigas(), 
                obtenerCosto_Gigas(),
                obtenerTarifa_Base(),
                obtenerPago_Mensual()
        );
        return c;
    }
}
