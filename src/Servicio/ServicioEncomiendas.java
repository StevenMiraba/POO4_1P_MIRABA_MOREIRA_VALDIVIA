/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author GEOVANNY
 */
import Usuario.TipoVehiculo;
import java.util.Scanner;
import java.util.Random;
import Usuario.*;
import static Usuario.Conductor.obtenerEstado;
import static Usuario.Conductor.obtenerTipoVehiculo;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ServicioEncomiendas extends Servicio{
private int cantidad;
private double peso;
private TipoEncomienda tipo;


public ServicioEncomiendas(){
}

public ServicioEncomiendas(String fecha,String hora,Conductor conductor,Cliente cliente,String origen,String destino,double valorPagar,int numServicio,int idServicio,int cantidad, double peso, TipoEncomienda tipo){
    super(fecha,hora,conductor,cliente,origen,destino,valorPagar,numServicio,idServicio);
    this.cantidad=cantidad;
    this.peso=peso;
    this.tipo=tipo;
  }
@Override
public double calcularValorPagar(){
    valorPagar= 4+cantidad;
    return valorPagar;
    }
@Override
public void mostrarInformacion(){
System.out.println("Tipo: Encomienda" + "\n Tipo encomienda: " + tipo +"\n cantidad: "+ cantidad);
    super.mostrarInformacion();
    }
    
public void ingresarDatosEncomienda(Cliente cliente){
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
    Pago pago=new Pago(formaPago);
    System.out.print("Ingrese el tipo de encomienda: ");
    String tipoEncomiendaelegida=sc.nextLine().toUpperCase();
    tipo=TipoEncomienda.valueOf(tipoEncomiendaelegida);
    System.out.print("Ingrese la cantidad del producto: ");
    cantidad=sc.nextInt();
    System.out.print("Ingrese el peso(kg): ");
    peso=sc.nextDouble();
    double valorPagar=calcularValorPagar();
    System.out.println("El valor a pagar es: $"+valorPagar);
    Conductor conductorDisponible=conductorDisponibleEncomiendas();
    ServicioEncomiendas servicioEncomiendasNuevo=new ServicioEncomiendas( fecha, hora,conductorDisponible,cliente, origen, destino, valorPagar,super.numServicio,super.idServicio, cantidad, peso,  tipo);
    super.numServicio++;
    super.idServicio++;
    System.out.println("Servicio de Taxi creado");
    System.out.println("Usted ha pagado: $"+valorPagar);
    mostrarInformacion();

    String nombreArchivo="encomiendas.txt";

    FileWriter fichero = null;
    BufferedWriter bw = null;

    try {
        fichero = new FileWriter(nombreArchivo, true);
        bw = new BufferedWriter(fichero);
        String linea = "\"" + numServicio+"\","+tipoEncomiendaelegida + "\"," + cantidad + ",\"" + peso + "\","+valorPagar+"\"";
        bw.write(linea + "\n");
        System.out.println("Encomienda agregado al archivo.");

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
        String linea = "\"" + super.numServicio + "\"," + "E" +",\""+cliente.getNumCedula()+",\""+conductorDisponible.getNombre()+ origen+",\""+destino+",\""+fecha+",\""+hora+",\"" + cliente.getNumTarjCredito() + "\"";
          bw2.write(linea + "\n");
          System.out.println("Servicio agregado al archivo.");

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

  public Conductor conductorDisponibleEncomiendas(){
      ArrayList<String> estado=Conductor.obtenerEstado();
      ArrayList<String> tipoVehiculo=Conductor.obtenerTipoVehiculo();
      for(int i=0;i<estado.size();i++){
          if(estado.get(i).equals("D") && tipoVehiculo.get(i).equals("M")){
              state estadoElegido=state.valueOf(estado.get(i));
              TipoVehiculo tipoElegido=TipoVehiculo.valueOf(tipoVehiculo.get(i));
              Vehiculo vehiculo=new Vehiculo(tipoElegido);
              Conductor conductor=new Conductor(estadoElegido,vehiculo);
              return conductor;
          }
      }
      return null;
  }
}
