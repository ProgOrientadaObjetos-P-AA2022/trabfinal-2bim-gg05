/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

/**
 *
 * @author usuario
 */

public class PlanPostPagoMinutos extends PlanCelular{
    
    private double Minutos_Nacionales;
    private double Costo_MinutoNa;
    private double Minutos_Internacional;
    private double Costo_MinutoIn;

    public PlanPostPagoMinutos(String Nombre_Pro, String Cedula_Pro, 
            String Ciudad_Pro, String Marca_Celular, String Modelo_Celular,
            String Numero_Celular,double m,double cm,double mi,
                        double ci) {
        super(Nombre_Pro, Cedula_Pro, Ciudad_Pro, Marca_Celular, 
                Modelo_Celular, Numero_Celular);
        Minutos_Nacionales = m;
        Costo_MinutoNa = cm;
        Minutos_Internacional = mi;
        Costo_MinutoIn = ci;
    }
    public void establecerMinutos_Nacionales(double mn){
        Minutos_Nacionales = mn;
    }
    public void establecerCosto_MinutoNa(double cmn){
        Costo_MinutoNa = cmn;
    }
    public void establecerMinutos_Internacional(double mi){
        Minutos_Internacional = mi;
    }
    public void establecerCosto_MinutoIn(double cmi){
        Costo_MinutoIn = cmi;
    }
    
    public double obtenerMinutos_Nacionales(){
        return Minutos_Nacionales;
    }
    public double obtenerCosto_MinutoNa(){
        return Costo_MinutoNa;
    }
    public double obtenerMinutos_Internacional(){
        return Minutos_Internacional;
    }
    public double obtenerCosto_MinutoIn(){
        return Costo_MinutoIn;
    }
    
    @Override
    public void Pago_Mensual() {
       pago_Mensual = (Minutos_Nacionales * Costo_MinutoNa) +
                (Minutos_Internacional * Costo_MinutoIn);
    }

    @Override
    public String toString() {
        String c = String.format("\n-------PLAN POST PAGO MINUTOS-------\n"
                + super.toString()+ "\nFactura\n"
                + "Cantidad Minutos Nacionales: %.2f\n"
                + "Costo Minutos Nacionales: %.2f\n"
                + "Cantidad Minutos Internacionales: %.2f\n"
                + "Costo Minutos Internacionales: %.2f\n"
                + "Valor Mensual: %.2f\n",
                obtenerMinutos_Nacionales(),
                obtenerCosto_MinutoNa(),
                obtenerMinutos_Internacional(),
                obtenerCosto_MinutoIn(),
                obtenerPago_Mensual());
        return c;
    }
}
