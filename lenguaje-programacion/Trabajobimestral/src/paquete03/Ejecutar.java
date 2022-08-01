/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import paquete01.Enlace;
import java.util.Scanner;
import paquete02.*;

/**
 *
 * @author usuario
 */

public class Ejecutar {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Enlace c = new Enlace();

        int op1;
        int op2;
        int op3;
        boolean bandera = false;
        
        do {            
            try {
                System.out.println("Que decea realizar..\n"
                        + "Ingresar tipo de plan celular              [1]\n"
                        + "Consultar los tipos de planes celulares    [2]"
                );
               op1 = sc.nextInt();
               sc.nextLine();
               
               if(op1 == 1){
                    System.out.printf("Segun el numero, indique que plan desea."
                            + "\n"
                            + "Plan Minutos                     [1]\n"
                            + "Plan Megas                       [2]\n"
                            + "Plan Minutos-Megas               [3]\n"
                            + "Plan Minutos-Megas-Economico     [4]\n"
                    );
                    op2 = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Ingrese el nombres del Cliente");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese la cedula del Cliente");
                    String cedula = sc.nextLine();
                    System.out.println("Ingrese la ciudad del Cliente");
                    String ciudad = sc.nextLine();
                    System.out.println("Ingrese la marca del Celular");
                    String marcaC = sc.nextLine();
                    System.out.println("Ingrese el modelo del celular");
                    String modeloC = sc.nextLine();
                    System.out.println("Ingrese el numero celular del cliente");
                    String numeroC = sc.nextLine();
                    
                    switch (op2) {
                       case 1:
                            System.out.println("Ingrese la cantidad de minutos "
                                    + "nacionales");
                            double mN = sc.nextDouble();
                            System.out.println("Ingrese el costo por minuto "
                                    + "nacional");
                            double cN = sc.nextDouble();
                            System.out.println("Ingrese cantidad de minutos "
                                    + "internacionales");
                            double mI = sc.nextDouble();
                            System.out.println("Ingrese costo por minuto "
                                    + "internacional");
                            double cI = sc.nextDouble();
                            
                            PlanPostPagoMinutos pMin = new PlanPostPagoMinutos(
                                    nombre, cedula, ciudad, marcaC, modeloC
                                    ,numeroC, mN, cN, mI, cI);
                            pMin.Pago_Mensual();
                            c.insertarPostPagoMinutos(pMin);
                            sc.nextLine();
                           break;
                       case 2:
                            System.out.println("Ingrese el Número de Megas :");
                            double nMegas = sc.nextDouble();
                            System.out.println("Ingrese el Costo por Mega:");
                            double cGigas = sc.nextDouble();
                            System.out.println("Ingrese la tarifa base: ");
                            double tar = sc.nextDouble();
                            
                            PlanPostPagoMegas pMegas = new PlanPostPagoMegas(
                                    nombre, cedula, ciudad, marcaC, modeloC
                                    ,numeroC, nMegas, cGigas, tar);
                            pMegas.Pago_Mensual();
                            
                            c.insertarPlanCelularPosPagoMegas(pMegas);
                            sc.nextLine();
                           break;
                       case 3:
                            System.out.println("Ingrese el Número de minutos:");
                            double min1 = sc.nextDouble();
                            System.out.println("Ingrese el Costo por minuto:");
                            double costo1 = sc.nextDouble();
                            System.out.println("Ingrese el Número de Megas :");
                            double numGigas1 = sc.nextDouble();
                            System.out.println("Ingrese el Costo por Mega:");
                            double cosGigas1 = sc.nextDouble();
                           
                            PlanPostPagoMinutosMegas pMinMegas
                                    = new PlanPostPagoMinutosMegas(
                                            nombre, cedula, ciudad, marcaC, 
                                            modeloC, numeroC, min1, costo1, 
                                            numGigas1, cosGigas1);
                            
                            pMinMegas.Pago_Mensual();
                            c.insertarPostPagoMinutosMegas(pMinMegas);
                            sc.nextLine();
                           break;
                       case 4:
                           
                            System.out.println("Ingrese el Número de minutos:");
                            double min2 = sc.nextDouble();
                            System.out.println("Ingrese el Costo por minuto:");
                            double costo2 = sc.nextDouble();
                            System.out.println("Ingrese el Número de Megas :");
                            double numGigas2 = sc.nextDouble();
                            System.out.println("Ingrese el Costo por Mega:");
                            double cosGigas2 = sc.nextDouble();
                            System.out.println("Ingrese el descuento: ");
                            double des = sc.nextDouble();
                            
                            PlanPostPagoMinutosMegasEconomico pMegasE
                                    = new PlanPostPagoMinutosMegasEconomico(
                                            nombre, cedula, ciudad, marcaC, 
                                            modeloC, numeroC, min2, costo2, 
                                            numGigas2, cosGigas2, des);
                            
                            pMegasE.Pago_Mensual();
                            c.insertarPostPagoMinutosMegasEc(pMegasE);
                           sc.nextLine();
                           break;
                    }
                }else if(op1 == 2){
                    System.out.printf("Mostar Datos almacenados\n"
                            + "Plan Minutos                     [1]\n"
                            + "Plan Megas                       [2]\n"
                            + "Plan Minutos-Megas               [3]\n"
                            + "Plan Minutos-Megas-Economico     [4]\n"
                            + "TODAS LAS TABLAS                 [5]\n"
                    );
                    op3 = sc.nextInt();
                    sc.nextLine();
                    
                    switch (op3) {
                        case 1:
                                for (int i = 0; i < 
                                        c.obtenerDataPostPagoMinutos().size();i++) {
                                    System.out.printf("%s",c.obtenerDataPostPagoMinutos().get(i));
                                }
                            break;
                        case 2:
                            for (int i = 0; i < c.obtenerDataPlanPostPagoMegas().size(); i++) {
                                    System.out.printf("%s"
                                            , c.obtenerDataPlanPostPagoMegas().get(i));
                                }
                            break;
                        case 3:
                            for (int i = 0; i < c.obtenerDataPostPagoMinutosMegas().size();i++) {
                                System.out.printf("%s",c.obtenerDataPostPagoMinutosMegas().get(i));
                                }
                            break;
                        case 4:
                            for (int i = 0; i < c.obtenerDataPostPagoMinutosMegasEc().size();i++) {
                                    System.out.printf("%s",c.obtenerDataPostPagoMinutosMegasEc().get(i));
                                }
                            break;
                        case 5:
                            for (int i = 0; i < c.obtenerDataPostPagoMinutosMegasEc().size();i++) {
                                    System.out.printf("%s\n"
                                            + "%s\n"
                                            + "%s\n"
                                            + "\n%s",
                                            c.obtenerDataPostPagoMinutos().get(i),
                                            c.obtenerDataPlanPostPagoMegas().get(i),
                                            c.obtenerDataPostPagoMinutosMegas().get(i),
                                            c.obtenerDataPostPagoMinutosMegasEc().get(i)
                                    );
                                }
                            break;
                   }
                }
            } catch (Exception e) {
                System.out.println("Error. Ingrese una opcion validad.");
            }
            
            
            System.out.println("Precione la letra 'S' para salir o "
                    + "dijite otra tecla para continuar.");
            char salir = sc.nextLine().toUpperCase().charAt(0);
            if(salir ==  'S' ){
                bandera = true;                     
            }else
                bandera = false;
        } while (bandera == false);
    }
}
