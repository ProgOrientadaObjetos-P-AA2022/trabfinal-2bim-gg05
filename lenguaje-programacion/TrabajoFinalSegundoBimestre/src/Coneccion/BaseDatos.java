/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coneccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete01.*;
/**
 *
 * @author usuario
 */
public class BaseDatos {

    private Connection conn;
       
    
    //Se coneccta a la base de datos...
    public void establecerConexion() {  
        try {
            String url = "jdbc:sqlite:bd/planes.db.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
    } 
    public Connection obtenerConexion(){
        return conn;
    }

    
    //Se insertan datos
    public void insertarPlanCelularPosPagoMegas(PlanPostPagoMegas plan) {  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMegas"
                    + " (nombrePro,cedulaPro,ciudadPro,marcaCelular,"
                    + "modeloCelular,numeroCelular, megasGg, costoGiga, "
                    + "tarifaBase) "
                    + "values ('%s','%s','%s','%s','%s','%s', %s, %s, "
                    + "%s)", 
                    plan.obtenerNombre_Pro(),
                    plan.obtenerCedula_Pro(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMarca_Celular(),
                    plan.obtenerModelo_Celular(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMegas_Giga(),
                    plan.obtenerCosto_Giga(),
                    plan.obtenerTarifa_Base()
            );
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
        }  
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMegas> obtenerDataPlanPostPagoMegas() {  
        ArrayList<PlanPostPagoMegas> planes1 = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from planPostPagoMegas;";
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PlanPostPagoMegas planM = new PlanPostPagoMegas(
                        rs.getString("nombrePro"),
                        rs.getString("cedulaPro"),
                        rs.getString("ciudadPro"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getDouble("megasGg"),
                        rs.getDouble("costoGiga"),
                        rs.getDouble("tarifaBase")
                );
                planM.pagoMensual();
                
                planes1.add(planM);
            }
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPostPagoMinutosMegas");
             System.out.println(e.getMessage());  
        }  
        return planes1;
    }
    
    
    
    
    
    //Se insertan datos
    public void insertarPostPagoMinutos(PlanPostPagoMinutos plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data1 = String.format("INSERT INTO planPostPagoMinutos"
                    + " (nombrePro, cedulaPro, ciudadPro, marcaCelular,"
                    + "modeloCelular ,numeroCelular ,minutosNacionales,"
                    + " costoMinutoNa, minutosInternacional, costoMinutoIn) "
                    + "values ('%s', '%s', '%s', '%s', '%s','%s', "
                    + "%s, %s,%s, %s)",
                    plan.obtenerNombre_Pro(),
                    plan.obtenerCedula_Pro(),
                    plan.obtenerCiudad_Pro(),
                    plan.obtenerMarca_Celular(),
                    plan.obtenerModelo_Celular(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMinutos_Nacionales(),
                    plan.obtenerCosto_MinutosNa(),
                    plan.obtenerMinutos_Internacional(),
                    plan.obtenerCosto_MinutosIn()
            );
            System.out.println("\n");
            statement.executeUpdate(data1);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPagoMinutos");
            System.out.println(e.getMessage());

        }
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMinutos> obtenerDataPostPagoMinutos() {
        ArrayList<PlanPostPagoMinutos> listamin = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutos;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutos plan = new PlanPostPagoMinutos(
                        rs.getString("nombre_Pro"),
                        rs.getString("cedula_Pro"),
                        rs.getString("ciudad_Pro"),
                        rs.getString("marca_Celular"),
                        rs.getString("modelo_Celular"),
                        rs.getString("numero_Celular"),
                        rs.getDouble("minutos_Nacionales"),
                        rs.getDouble("costoMinutoNa"),
                        rs.getDouble("minutos_Internacional"),
                        rs.getDouble("costoMinutoIn"));
                plan.pagoMensual();
                listamin.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutos");
            System.out.println(e.getMessage());

        }
        return listamin;
    }

    
    
    
    
    //Se insertan datos
    public void insertarPostPagoMinutosMegas(PlanPostPagoMinutosMegas plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMinutos"
                    + " (nombrePro,cedulaPro,ciudadPro,marcaCelular,"
                    + "modeloCelular,numeroCelular, minutos, costoMinuto, "
                    + "megasGigas, costoGigas) "
                    + "values ('%s', '%s', '%s', '%s', '%s', "
                    + "'%s', %s, %s, %s, %s)",
                    plan.obtenerNombre_Pro(),
                    plan.obtenerCedula_Pro(),
                    plan.obtenerCiudad_Pro(),
                    plan.obtenerMarca_Celular(),
                    plan.obtenerModelo_Celular(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMinutos(),
                    plan.obtenerCosto_Minuto(),
                    plan.obtenerMegas_Gigas(),
                    plan.obtenerCosto_Gigas()
                    );
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegas");
            System.out.println(e.getMessage());

        }
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMinutosMegas> obtenerDataPostPagoMinutosMegas() {
        ArrayList<PlanPostPagoMinutosMegas> listaminmeg = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegas plan = new PlanPostPagoMinutosMegas(
                        rs.getString("nombre_Pro"),
                        rs.getString("cedula_Pro"),
                        rs.getString("ciudad_Pro"),
                        rs.getString("marca_Celular"),
                        rs.getString("modelo_Celular"),
                        rs.getString("numero_Celular"),
                        rs.getDouble("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getDouble("megas_Gigas"),
                        rs.getDouble("costoGigas"));
                plan.pagoMensual();
                listaminmeg.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegas");
            System.out.println(e.getMessage());

        }
        return listaminmeg;

    }
    
    
    
    //Se insertan datos
    public void insertarPostPagoMinutosMegasEc
        (PlanPostPagoMinutosMegasEconomico plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMinutos"
                    + " (nombrePro,cedulaPro,ciudadPro,marcaCelular,"
                    + "modeloCelular,numeroCelular, costoMinuto, megasGb, costoGb, porcentajeDes, "
                    + "costoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s','%s', "
                    + "'%s', %s,%s, %s, %s)",
                    plan.obtenerNombre_Pro(),
                    plan.obtenerCedula_Pro(),
                    plan.obtenerCiudad_Pro(),
                    plan.obtenerMarca_Celular(),
                    plan.obtenerModelo_Celular(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMinutos(),
                    plan.obtenerCosto_Minuto(),
                    plan.obtenerMinutos(),
                    plan.obtenerCosto_Minuto(),
                    plan.obtenerMegas_Gigas(),
                    plan.obtenerCosto_Gigas()
            );
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegasEc");
            System.out.println(e.getMessage());

        }
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMinutosMegasEconomico> 
        obtenerDataPostPagoMinutosMegasEc() {
        ArrayList<PlanPostPagoMinutosMegasEconomico> listaec = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegasEconomico;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegasEconomico plan = 
                        new PlanPostPagoMinutosMegasEconomico(
                        rs.getString("nombre_Pro"),
                        rs.getString("cedula_Pro"),
                        rs.getString("ciudad_Pro"),
                        rs.getString("marca_Celular"),
                        rs.getString("modelo_Celular"),
                        rs.getString("numero_Celular"),
                        rs.getDouble("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getDouble("megas_Gigas"),
                        rs.getDouble("costo_Gigas"),
                        rs.getDouble("descuento")        
                );
                plan.pagoMensual();
                listaec.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanPostPagoMinutosMegasEconomico");
            System.out.println(e.getMessage());

        }
        return listaec;
    }
    
    
    
}

