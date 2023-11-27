/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Servicio.Pago;
import Servicio.Servicio;
import Usuario.*;
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
        //Cliente cl = new Cliente();
        //Conductor cd=new Conductor();
        System.out.println("+".repeat(31));
        System.out.println("     " + "BIENVENIDO AL SISTEMA" + "     ");
        System.out.println("+".repeat(31));
        Scanner sc = new Scanner(System.in);
        System.out.print("USUARIO: ");
        String user1 = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String key1 = sc.nextLine();
        //ArrayList<String> Users = cl.obtenerUsuario();
            
        }
    }
//}
