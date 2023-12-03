/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Servicio.*;
import static Usuario.Conductor.LeeConductor;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
//import Servicio.*;

/**
 *
 * @author STEVEN
 */
public class Cliente extends Usuario {

    private String numTarjCredito;

    public Cliente(String nombre, String apellido, String user, String contraseña, String numCedula, String numCelular, typeUsuario tipoUsuario, int edad, String numTarjCredito) {
        super(nombre, apellido, user, contraseña, numCedula, numCelular, tipoUsuario, edad);
        this.numTarjCredito = numTarjCredito;
    }

    public Cliente(String numCedula, String numTarjCredito) {
        super(numCedula);
        this.numTarjCredito = numTarjCredito;
    }

    public String getNumTarjCredito() {
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

    public void presentarMenu() {
        System.out.println("/***************MENU***************/");
        System.out.println("/*                                */");
        System.out.println("/**********************************/");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar entrega encomienda");
        System.out.println("3. Consultar servicios");
    }

    public void seleccionarServicio(Cliente cliente) {
        String entrada = "";
        Scanner sc = new Scanner(System.in);
        presentarMenu();
        ServicioTaxi svt = new ServicioTaxi();
        ServicioEncomiendas sve = new ServicioEncomiendas();
        System.out.print("Ingrese opcion: ");
        entrada = sc.nextLine();
        switch (entrada) {
            case "1":
                svt.ingresarDatosTaxi(cliente);//argumento CLIENTE
                break;
            case "2":
                sve.ingresarDatosEncomienda(cliente);
                break;
            case "3":
                consultarServicio(cliente);
                break;

        }
    }

    public static void registrarCliente(String numcedula, int edad, String numTarjCredito) {
        String nombreArchivo = "clientes.txt";

        FileWriter fichero = null;
        BufferedWriter bw = null;

        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);
            String linea = numcedula + "," + edad + "," + numTarjCredito;
            bw.write(linea + "\n");
            System.out.println("Cliente agregado al archivo.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (bw != null) {
                    bw.close();
      }}catch (IOException e){
          e.printStackTrace();
      }
      }
     
}
    
    @Override
    public void consultarServicio(){
        
    }
    public void consultarServicio(Cliente cliente) {
        ArrayList<Servicio> serviciosCliente = new ArrayList<>();
        String cedula = cliente.getNumCedula();
        ArrayList<String> Lineas = LeeConductor("servicios.txt");
        for (String linea : Lineas) {
            String[] lineas = linea.split(",");
            String Tipo = lineas[1];
            if(Tipo.equals("T") && cedula.equals(lineas[2])) {
                int num = Integer.parseInt(lineas[0]);
                Servicio serTNew = new ServicioTaxi(lineas[6], lineas[7], lineas[4], lineas[5], num, 2);
                serviciosCliente.add(serTNew);
            } else if (Tipo.equals("E") && cedula.equals(lineas[2])) {
                int num2 = Integer.parseInt(lineas[0]);
                Servicio serENew = new ServicioEncomiendas(lineas[6], lineas[7], lineas[4], lineas[5], num2, 2);
                serviciosCliente.add(serENew);
            }
        }
        for (Servicio ser : serviciosCliente) {
            if (ser instanceof ServicioTaxi) {
                ServicioTaxi serT = (ServicioTaxi) ser;
                System.out.println("/*************************************/");
                System.out.println("Tipo: Viaje"
                        + "\n Cantidad pasajeros: " + serT.getNumPersonas()
                        + "\n Fecha: " + serT.getFecha()
                        + "\n Hora: " + serT.getHora()
                        + "\n Desde: " + serT.getOrigen()
                        + "\n Hasta: " + serT.getDestino());
            }else if (ser instanceof ServicioEncomiendas) {
                ServicioEncomiendas serE = (ServicioEncomiendas) ser;
                System.out.println("/*************************************/");
                System.out.println("Tipo: Encomienda"
                        + "\n Tipo encomienda: " + serE.getTipo()
                        + "\n Cantidad: " + serE.getCantidad()
                        + "\n Fecha: " + serE.getFecha()
                        + "\n Hora: " + serE.getHora()
                        + "\n Desde: " + serE.getOrigen()
                        + "\n Hasta: " + serE.getDestino());
}
    }

}
}
