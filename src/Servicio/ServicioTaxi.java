/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Usuario.TipoVehiculo;
import java.util.Scanner;
import java.util.Random;
import Usuario.*;
//import static Usuario.Conductor.obtenerEstado;
//import static Usuario.Conductor.obtenerTipoVehiculo;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author GEOVANNY
 */
public class ServicioTaxi extends Servicio{
    private int numPersonas;
    private int distancia;
    public ServicioTaxi(){
        
    }
    public ServicioTaxi(String fecha,String hora,String origen,String destino,Conductor conductor,Cliente cliente,double valorPagar,int numServicio,int idServicio,int numPersonas,int distancia){
        super(fecha,hora,conductor,cliente,origen,destino,valorPagar,numServicio,idServicio);
        this.numPersonas=numPersonas;
        this.distancia=distancia;
    }

  public void ingresarDatosTaxi(Cliente cliente){
    Scanner sc=new Scanner(System.in);
    System.out.print("Ingrese el origen de su viaje: ");
    origen =sc.nextLine();
    System.out.print("Ingrese el destino de su viaje: ");
    destino=sc.nextLine();
    System.out.print("Ingrese la fecha: ");
    fecha=sc.nextLine();  
    System.out.print("Ingrese la hora: ");
    hora=sc.nextLine();
    System.out.print("Ingrese la forma de pago: ");
    String formaPagoElegida=sc.nextLine().toUpperCase();
    TipoPago formaPago=TipoPago.valueOf(formaPagoElegida);
    System.out.println("Ingrese el numero de personas que viajan: ");
    numPersonas = sc.nextInt();
    sc.nextLine();
    
    Pago pago=new Pago(formaPago);
    String comprobar=pago.calcularCosto();
    if(formaPagoElegida.equals(comprobar)){
        valorPagar=calcularValorPagar();
      }else if(formaPagoElegida.equals(comprobar)){
        valorPagar=calcularValorPagar(cliente.getNumTarjCredito());
      }
      System.out.println("Desea confirmar su viaje?:"+ "\n 1. Si" + "\n 2. No");
      String confirmarViaje=sc.nextLine();
      ServicioTaxi servicioTaxiNuevo;
      Conductor conductorDisponible;
        conductorDisponible = conductorDisponibleTaxi();
      if(confirmarViaje.equals("1")){
        System.out.println("viaje confirmado");
        servicioTaxiNuevo=new ServicioTaxi(fecha,hora,origen,destino,conductorDisponible,cliente,valorPagar,super.numServicio,super.idServicio,numPersonas,distancia);
        super.numServicio++;
        super.idServicio++;
        System.out.println("Servicio de Taxi creado");
        System.out.println("Usted ha pagado: $"+servicioTaxiNuevo.valorPagar);
              }else if(confirmarViaje.equals("2")){
        System.out.println("viaje rechazado, será redireccionado al menú principal");
        //cliente.seleccionarServicio(cliente,conductorDisponible);
      }
      String nombreArchivo="viajes.txt";
        FileWriter fichero = null;
        BufferedWriter bw = null;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);
            String linea = "\"" + super.numServicio+"\","+numPersonas + "\"," + distancia + ",\"" +valorPagar+"\"";
            bw.write(linea + "\n");
            System.out.println("Servicio de Taxi agregado al archivo.");
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
        String nombreArchivo2="servicios.txt";
        FileWriter fichero2 = null;
        BufferedWriter bw2 = null;
    try {
        fichero2 = new FileWriter(nombreArchivo2, true);
        bw2 = new BufferedWriter(fichero2);
        String linea = "\"" + super.numServicio + "\"," + "T" +",\""+cliente.getNumCedula()+",\""+conductorDisponible.getNombre()+ origen+",\""+destino+",\""+fecha+",\""+hora+",\"" + cliente.getNumTarjCredito() + "\"";
        bw2.write(linea + "\n");
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            try {
                if (bw2 != null) {
                    bw2.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
      }

@Override
public double calcularValorPagar(){
    Random rd=new Random();
    int distancia =rd.nextInt(41)+5;
    double costoPorKm=0.50;
    double valorPagar=distancia*costoPorKm;
    System.out.println("El subtotal a pagar es: $"+valorPagar);
    System.out.println("El total a pagar es: $"+valorPagar);
    return valorPagar;
    }

public double calcularValorPagar(String numTarjCredito){
    double valorPagar=calcularValorPagar();
    System.out.println("El subtotal a pagar es: $"+valorPagar);
    valorPagar=(calcularValorPagar()*1.10);
    System.out.println("El total a pagar es: $"+valorPagar);
    return valorPagar;
    }
  public Conductor conductorDisponibleTaxi(){
      ArrayList<String> estado=Conductor.obtenerEstado();
      ArrayList<String> tipoVehiculo=Conductor.obtenerTipoVehiculo();
      Estado estadoElegido=null;
      for(int i=0;i<estado.size();i++){
          if(estado.get(i).equals("D") && tipoVehiculo.get(i).equals("A")){
              String estadoCh=estado.get(i);
              estadoElegido = Estado.valueOf(estadoCh);
              TipoVehiculo tipoElegido=TipoVehiculo.valueOf(tipoVehiculo.get(i));
              Vehiculo vehiculo=new Vehiculo(tipoElegido);
              Conductor conductor=new Conductor(estadoElegido,vehiculo);
              return conductor;
          }
      }
      return null;
  }

@Override
public void mostrarInformacion(){
    System.out.println("Tipo: Viaje" + 
                    "\n Cantidad pasajeros: "+numPersonas);
    super.mostrarInformacion();
    }  
}
