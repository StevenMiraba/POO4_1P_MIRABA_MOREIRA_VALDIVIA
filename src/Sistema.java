/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Servicio.Pago;
import Servicio.Servicio;
import Usuario.*;
import static Usuario.Cliente.LeeCliente;
import static Usuario.Conductor.LeeConductor;
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
        Cliente cliente=null;
        Conductor conductor=null;
        for (String user : Users) {
            if (user1.equals(user)) {
                String tipoUsuario=obtenerTipoUsuario(user1);
            if(tipoUsuario.equals("C")){
                ArrayList<String> Lineas= LeeCliente("usuarios.txt");
                ArrayList<String> Lineas2= LeeCliente("clientes.txt");
                for(String lineas:Lineas){
                String[] linea=lineas.split(",");
                String userExtraido=linea[3];
                    if(user1.equals(userExtraido)){
                        String cedulaEx=linea[0];
                        for(String lineas2:Lineas2){
                            String[] linea2=lineas2.split(",");
                            String cedulaEx2=linea2[0];
                            if(cedulaEx.equals(cedulaEx2)){
                                String numTC=linea2[2];
                                cliente = new Cliente(cedulaEx,numTC);
                                cliente.seleccionarServicio(cliente);
                        }
                    }
                    }
                
                }
            }else if(tipoUsuario.equals("R")){
                ArrayList<String> Lineas= LeeConductor("usuarios.txt");
                ArrayList<String> Lineas2= LeeConductor("conductores.txt");
                for(String lineas:Lineas){
                String[] linea=lineas.split(",");
                String userExtraido=linea[3];
                    if(user1.equals(userExtraido)){
                        String cedulaEx=linea[0];
                        for(String lineas2:Lineas2){
                            String[] linea2=lineas2.split(",");
                            String cedulaEx2=linea2[0];
                            if(cedulaEx.equals(cedulaEx2)){
                                String estadoext=linea2[1];
                                Estado estado=Estado.valueOf(estadoext);
                                conductor=new Conductor(cedulaEx,estado);
                                conductor.seleccionarMenuConductor(conductor);
                        }
                    }
                    }
                
                }
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
        Cliente.registrarCliente(cedula, edad, tarjCredit);
        if(tipoUsuario.equals("C")){
          cliente = new Cliente(cedula,tarjCredit);
          cliente.seleccionarServicio(cliente);
        }else if(tipoUsuario.equals("R")){
          conductor=new Conductor(cedula);
          conductor.seleccionarMenuConductor(conductor);
        }
        typeUsuario tipoDeUsuario=typeUsuario.valueOf(tipoUsuario);
      }
      sc.close();
    }
    public static ArrayList<String> obtenerUsuario(){
      ArrayList<String> usuarios = new ArrayList<>();
      ArrayList<String> Lineas= LeeCliente("usuarios.txt");
      for(String linea:Lineas){
        String[] lineas=linea.split(",");
        String user1=lineas[3];
        usuarios.add(user1);

      }
      return usuarios;
    }
    public static String obtenerTipoUsuario(String usuario){
      ArrayList<String> Lineas= LeeCliente("usuarios.txt");
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
    

