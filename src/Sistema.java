/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Servicio.Pago;
import Servicio.Servicio;
import Usuario.*;
import static Usuario.Cliente.LeeCliente;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author STEVEN
 */
public class Sistema {
    public ArrayList<Usuario> usuarios;
    public ArrayList<Pago> pagos;
    public ArrayList<Servicio> servicios;
    
    public Sistema(ArrayList<Usuario> usuarios,ArrayList<Pago>pagos,ArrayList<Servicio> servicios){
        this.usuarios=usuarios;
        this.pagos=pagos;
        this.servicios=servicios;
    }
    public static void iniciarSistema(){ 
    }
    public static void main(String[] args){
        System.out.println("+".repeat(31));
        System.out.println("     " + "BIENVENIDO AL SISTEMA" + "     ");
        System.out.println("+".repeat(31));
        Scanner sc = new Scanner(System.in);
        System.out.print("USUARIO: ");
        String user1 = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String key1 = sc.nextLine();
        ArrayList<String> Users = obtenerUsuario();
        String sino = "no";
        for (String user : Users) {
            if (user1.equals(user)) {
                String tipoUsuario=obtenerTipoUsuario(user);
            if(tipoUsuario.equals("C")){
                
                Cliente.seleccionarServicio();
            }else if(tipoUsuario.equals("R")){
                System.out.println("Menu del conductor");
                cd.seleccionarMenuConductor();
            }
        sino = "si";

        }
      }
      if (sino.equals("no")) {
        System.out.println("Ingrese su numero de cedula: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese su edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese su numero de tarjeta de credito: ");
        String tarjCredit = sc.nextLine();
        System.out.println("Seleccionar el tipo de usuario");
        System.out.println("C. Cliente ");
        System.out.println("R. Conductor ");
        System.out.println("Ingrese su opcion: ");
        String tipoUsuario=sc.nextLine().toUpperCase();
        cl.registrarCliente(cedula, edad, tarjCredit);
        if(tipoUsuario.equals("C")){
          cl.seleccionarServicio(cl,cd);
        }else if(tipoUsuario.equals("R")){
          System.out.println("menu del conductor");
          cd.seleccionarMenuConductor();
        }
        typeUsuario tipoDeUsuario=typeUsuario.valueOf(tipoUsuario);
      }
      sc.close();

    }
    public static ArrayList<String> obtenerUsuario(){
      ArrayList<String> usuarios = new ArrayList<>();
      ArrayList<String> Lineas= LeeCliente("Usuario/usuarios.txt");
      for(String linea:Lineas){
        String[] lineas=linea.split(",");
        String user1=lineas[3];
        usuarios.add(user1);

      }
      return usuarios;
    }
    public static String obtenerTipoUsuario(String usuario){
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
        }
    

