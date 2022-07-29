/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author usuario
 */

public abstract class PlanCelular {
    protected String nombre_pro;
    protected String cedula_pro;
    protected String ciudad_pro;
    protected String marca_celular;//una cadena
    protected String modelo_celular;//una cadena
    protected String numero_celular;//una cadena
    
    protected double pagoMensual;//se debe operar en cada subclase, se lo optiene
                               //en cada clase...

    public PlanCelular(String n, String ce, String ci, 
            String marca, String modelo, String num) {
        nombre_pro = n;
        cedula_pro = ce;
        ciudad_pro = ci;
        marca_celular = marca;
        modelo_celular = modelo;
        numero_celular = num;
    }

    public void establecerNombre_Pro(String n) {
        nombre_pro = n;
    }
    public void establecerCedula_Pro(String ce) {
        cedula_pro = ce;
    }
    public void establecerCiudad_Pro(String ci) {
        ciudad_pro = ci;
    }
    public void establecerMarca_Celular(String mar) {
        marca_celular = mar;
    }
    public void establecerModelo_Celular(String mo) {
        modelo_celular = mo;
    }
    public void establecerNumero_Celular(String nu) {
        numero_celular = nu;
    }
    
    
    public abstract void pagoMensual();  
                                         /// se debe operar en cada subclase, 
                                         /// se lo optiene en cada clase...
    public double obtenerPagoMensual(){
        return pagoMensual;
    }
    
    
    public String obtenerNombre_Pro() {
        return nombre_pro;
    }
    public String obtenerCedula_Pro() {
        return cedula_pro;
    }
    public String obtenerCiudad_Pro() {
        return ciudad_pro;
    }
    public String obtenerMarca_Celular() {
        return marca_celular;
    }
    public String obtenerModelo_Celular() {
        return modelo_celular;
    }
    public String obtenerNumero_Celular() {
        return numero_celular;
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
