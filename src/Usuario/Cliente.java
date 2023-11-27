 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import java.util.Scanner;
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
    public void registrarCliente(int edad, String numTarjCredito){
        
    }
    public void presentarMenu(){
        System.out.println("/***************MENU***************/");
        System.out.println("/*                                */");
        System.out.println("/**********************************/");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar comida a domicilio");
        System.out.println("3. Solicitar entrega encomienda");
        System.out.println("4. Consultar servicios");
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
