package paquete01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete02.*;

/**
 *
 * @author usuario
 */

public class Enlace {

    private Connection conect;
       
    
    //Se coneccta a la base de datos...
    public void establecerConexion() {  
        try {
            String url ="jdbc:sqlite:bd/planes.db.db";
            conect = DriverManager.getConnection(url);
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
    } 
    public Connection obtenerConexion(){
        return conect;
    }


    //Se insertan datos
    public void insertarPlanCelularPosPagoMegas(PlanPostPagoMegas plan) {  
        try{
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMegas"
                    + " (nombre_Pro, cedula_Pro, ciudad_Pro, marca_Celular,"
                    + "modelo_Celular, numero_Celular, megas_Gigas, costo_Gigas, "
                    + "tarifa_Base) "
                    + "values ('%s','%s','%s','%s','%s','%s', %s, %s, "
                    + "%s)", 
                    plan.obtenerNombre_Pro(),
                    plan.obtenerCedula_Pro(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMarca_Celular(),
                    plan.obtenerModelo_Celular(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMegas_Gigas(),
                    plan.obtenerCosto_Gigas(),
                    plan.obtenerTarifa_Base()
            );
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarplanPostPagoMegas");
             System.out.println(e.getMessage());  
        }  
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMegas> obtenerDataPlanPostPagoMegas() {  
        ArrayList<PlanPostPagoMegas> lista1 = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from planPostPagoMegas;";
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PlanPostPagoMegas planM = new PlanPostPagoMegas(
                        rs.getString("nombre_Pro"),
                        rs.getString("cedula_Pro"),
                        rs.getString("ciudad_Pro"),
                        rs.getString("marca_Celular"),
                        rs.getString("modelo_Celular"),
                        rs.getString("numero_Celular"),
                        rs.getDouble("megas_Gigas"),
                        rs.getDouble("costo_Gigas"),
                        rs.getDouble("tarifa_Base")
                );
                planM.Pago_Mensual();
                
                lista1.add(planM);
            }
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPostPagoMinutosMegas");
             System.out.println(e.getMessage());  
        }  
        return lista1;
    }
    

    //Se insertan datos
    public void insertarPostPagoMinutos(PlanPostPagoMinutos plan) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data1 = String.format("INSERT INTO planPostPagoMinutos"
                    + " (nombre_Pro, cedula_Pro, ciudad_Pro, marca_Celular,"
                    + "modelo_Celular ,numero_Celular ,minutos_Nacionales,"
                    + " costo_MinutoNa, minutos_Internacional, costo_MinutoIn) "
                    + "values ('%s', '%s', '%s', '%s', '%s','%s', "
                    + "%s, %s,%s, %s)",
                    plan.obtenerNombre_Pro(),
                    plan.obtenerCedula_Pro(),
                    plan.obtenerCiudad_Pro(),
                    plan.obtenerMarca_Celular(),
                    plan.obtenerModelo_Celular(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMinutos_Nacionales(),
                    plan.obtenerCosto_MinutoNa(),
                    plan.obtenerMinutos_Internacional(),
                    plan.obtenerCosto_MinutoIn()
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
        ArrayList<PlanPostPagoMinutos> lista2 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from planPostPagoMinutos;";

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
                        rs.getDouble("costo_MinutoNa"),
                        rs.getDouble("minutos_Internacional"),
                        rs.getDouble("costo_MinutoIn"));
                plan.Pago_Mensual();
                lista2.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutos");
            System.out.println(e.getMessage());

        }
        return lista2;
    }

    
    
    
    
    //Se insertan datos
    public void insertarPostPagoMinutosMegas(PlanPostPagoMinutosMegas plan) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMinutosMegas"
                    + " (nombre_Pro, cedula_Pro, ciudad_Pro, marca_Celular,"
                    + " modelo_Celular, numero_Celular, minutos, costo_Minuto, "
                    + "megas_Gigas, costo_Gigas) "
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
        ArrayList<PlanPostPagoMinutosMegas> lista3 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from planPostPagoMinutosMegas;";

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
                        rs.getDouble("costo_Minuto"),
                        rs.getDouble("megas_Gigas"),
                        rs.getDouble("costo_Gigas"));
                plan.Pago_Mensual();
                lista3.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegas");
            System.out.println(e.getMessage());

        }
        return lista3;

    }
    
    
    
    //Se insertan datos
    public void insertarPostPagoMinutosMegasEc
        (PlanPostPagoMinutosMegasEconomico plan) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMinutosMegasEconomico"
                    + " (nombre_Pro,cedula_Pro,ciudad_Pro,marca_Celular,"
                    + "modelo_Celular,numero_Celular, minutos, costo_Minuto, "
                    + "megas_Gigas, costo_Gigas, descuento) "
                    + "values ('%s', '%s', '%s', '%s', '%s','%s', "
                    + "%s, %s,%s, %s, %s)",
                    plan.obtenerNombre_Pro(),
                    plan.obtenerCedula_Pro(),
                    plan.obtenerCiudad_Pro(),
                    plan.obtenerMarca_Celular(),
                    plan.obtenerModelo_Celular(),
                    plan.obtenerNumero_Celular(),
                    plan.obtenerMinutos(),
                    plan.obtenerCosto_Minuto(),
                    plan.obtenerMegas_Gigas(),
                    plan.obtenerCosto_Gigas(),
                    plan.obtenerDescuento()
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
        ArrayList<PlanPostPagoMinutosMegasEconomico> lista4 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from planPostPagoMinutosMegasEconomico;";

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
                        rs.getDouble("costo_Minuto"),
                        rs.getDouble("megas_Gigas"),
                        rs.getDouble("costo_Gigas"),
                        rs.getDouble("descuento")        
                );
                plan.Pago_Mensual();
                lista4.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanPostPagoMinutosMegasEconomico");
            System.out.println(e.getMessage());

        }
        return lista4;
    }
    
    
    
}

