 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import Servicio.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
//import Servicio.*;
/**
 *
 * @author STEVEN
 */
public class Cliente extends Usuario{
    private String numTarjCredito;
    public Cliente(String nombre,String apellido,String user,String contraseña,String numCedula,String numCelular,typeUsuario tipoUsuario,int edad,String numTarjCredito){
       super(nombre,apellido,user,contraseña,numCedula,numCelular,tipoUsuario,edad); 
       this.numTarjCredito=numTarjCredito;
    }
    public Cliente(){
        
    }
 public String getNumTarjCredito(){
      return numTarjCredito;
    }
    public static ArrayList<String> LeeCliente(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            br.readLine();

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas.add(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lineas;
    }
 
    public static void presentarMenu(){
        System.out.println("/***************MENU***************/");
        System.out.println("/*                                */");
        System.out.println("/**********************************/");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar entrega encomienda");
        System.out.println("3. Consultar servicios");
    }
    public static void seleccionarServicio(Cliente cliente){
        String entrada = "";
        Scanner sc=new Scanner(System.in);
        presentarMenu();
        ServicioTaxi svt =new ServicioTaxi();
        ServicioEncomiendas sve=new ServicioEncomiendas();
        System.out.print("Ingrese opcion: ");
        entrada = sc.nextLine();
      switch(entrada){
          case "1":
              svt.ingresarDatosTaxi(cliente);//argumento CLIENTE
              break;
          case "2":
              sve.ingresarDatosEncomienda(cliente);
              break;
        case "3":
                 
      }
    }
    public void registrarCliente(String numcedula, int edad, String numTarjCredito){
      String nombreArchivo="clientes.txt";

      FileWriter fichero = null;
      BufferedWriter bw = null;

      try {
          fichero = new FileWriter(nombreArchivo, true);
          bw = new BufferedWriter(fichero);
          String linea = "\"" + numcedula + "\"," + edad + ",\"" + numTarjCredito + "\"";
          bw.write(linea + "\n");
          System.out.println("Cliente agregado al archivo.");

      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          try {
              if (bw != null) {
                  bw.close();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
     
}
 @Override
    public void consultarServicio(){
      ArrayList<Servicio> servicios=new ArrayList<>();

    }
 
}
