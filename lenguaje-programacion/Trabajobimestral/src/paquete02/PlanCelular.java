/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

/**
 *
 * @author usuario
 */

public abstract class PlanCelular {
    protected String nombre_Pro;
    protected String cedula_Pro;
    protected String ciudad_Pro;
    protected String marca_Celular;
    protected String modelo_Celular;
    protected String numero_Celular;
    protected double pago_Mensual;//se debe operar en cada subclase, se lo optiene
                               //en cada clase...

    public PlanCelular(String n, String ce, String ci, 
            String mc, String md, String num) {
        nombre_Pro = n;
        cedula_Pro = ce;
        ciudad_Pro = ci;
        marca_Celular = mc;
        modelo_Celular = md;
        numero_Celular = num;
    }

    public void establecerNombre_Pro(String n) {
        nombre_Pro = n;
    }
    public void establecerCedula_Pro(String ce) {
        cedula_Pro = ce;
    }
    public void establecerCiudad_Pro(String ci) {
        ciudad_Pro = ci;
    }
    public void establecerMarca_Celular(String mar) {
        marca_Celular = mar;
    }
    public void establecerModelo_Celular(String mo) {
        modelo_Celular = mo;
    }
    public void establecerNumero_Celular(String nu) {
        numero_Celular = nu;
    }
    
    public abstract void Pago_Mensual();  
                                        
    
    public double obtenerPago_Mensual(){
        return pago_Mensual;
    }
    public String obtenerNombre_Pro() {
        return nombre_Pro;
    }
    public String obtenerCedula_Pro() {
        return ciudad_Pro;
    }
    public String obtenerCiudad_Pro() {
        return ciudad_Pro;
    }
    public String obtenerMarca_Celular() {
        return marca_Celular;
    }
    public String obtenerModelo_Celular() {
        return modelo_Celular;
    }
    public String obtenerNumero_Celular() {
        return numero_Celular;
    }
    
    @Override
    public String toString() {
        String c = String.format("Datos del Propietario\n"
                + "Nombres: %s\n"
                + "Cedula: %s\n"
                + "Ciudad: %s\n"
                + "Datos del Celular\n"
                + "Marca: %s\n"
                + "Modelo: %s\n"
                + "Número: %s\n",
                obtenerNombre_Pro(),
                obtenerCedula_Pro(),
                obtenerCiudad_Pro(), 
                obtenerMarca_Celular(),
                obtenerModelo_Celular(),
                obtenerNumero_Celular());

        return c;
    }
    
}
