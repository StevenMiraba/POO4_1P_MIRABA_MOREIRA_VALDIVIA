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

    //OBTENER USUARIO
    public ArrayList<String> obtenerUsuario(){
      ArrayList<String> usuarios = new ArrayList<>();
      ArrayList<String> Lineas= LeeCliente("Usuario/usuarios.txt");
      for(String linea:Lineas){
        String[] lineas=linea.split(",");
        String user1=lineas[3];
        usuarios.add(user1);

      }
      return usuarios;
    }

     public String obtenerTipoUsuario(String usuario){
      ArrayList<String> Lineas= LeeCliente("Usuario/usuarios.txt");
      String tipoUsuario=null;
      for(String linea:Lineas){
        String[] lineas=linea.split(",");
        if(usuario.equals(lineas[3])){
          tipoUsuario=lineas[6];    
        }
    }
      return tipoUsuario;
    }
 
    public void presentarMenu(){
        System.out.println("/***************MENU***************/");
        System.out.println("/*                                */");
        System.out.println("/**********************************/");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar entrega encomienda");
        System.out.println("3. Consultar servicios");

    }
    public void registrarCliente(String numcedula, int edad, String numTarjCredito){
      String nombreArchivo="Usuario/clientes.txt";

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
public void seleccionarServicio(Cliente cliente,Conductor conductor){
        String entrada = "";
        Scanner sc=new Scanner(System.in);
        ServicioTaxi svt=new ServicioTaxi();
        ServicioEncomiendas sve=new ServicioEncomiendas();
      presentarMenu();
      System.out.print("Ingrese opcion: ");
      entrada = sc.nextLine();
      switch(entrada){
          case "1":
              svt.ingresarDatosTaxi(cliente);//argumento CLIENTE
              svt.registrarServicioTaxi(cliente,conductor);//ARGUMENTOS
              break;
          case "2":
              sve.ingresarDatosEncomienda();
              sve.registrarServicioEncomienda(cliente,conductor);
              break;
        case "3":
                 
      }
    }
 
}
