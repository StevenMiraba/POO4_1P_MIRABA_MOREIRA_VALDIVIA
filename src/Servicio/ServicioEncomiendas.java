/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author GEOVANNY
 */
import java.util.Scanner;
import java.util.Random;
import Usuario.*;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ServicioEncomiendas extends Servicio{
private int cantidad;
private double peso;
private TipoEncomienda tipo;


public ServicioEncomiendas(){
}

public ServicioEncomiendas(String fecha,String hora,Conductor conductor,String origen,String destino,double valorPagar,int numServicio,int idServicio,int cantidad, double peso, TipoEncomienda tipo){
    super(fecha,hora,conductor,origen,destino,valorPagar,numServicio,idServicio);
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
    
@Override
public Conductor crearConductor(){
    conductor=new Conductor();
    ArrayList<String> estados=conductor.obtenerEstado();
    ArrayList<String> vehiculos=conductor.obtenerVehiculo();
    for(int i=0;i<estados.size();i++){
        String estado=estados.get(i);
        String vehiculo=vehiculos.get(i);

    if(estado.equals("D") && vehiculo.equals("M")){
        state estadoConductor=state.valueOf(estado);
        TipoVehiculo tipodeVehiculo=TipoVehiculo.valueOf(vehiculo);
        Vehiculo vehiculoConductor=new Vehiculo(tipodeVehiculo);
        Conductor conductorDisponibleEncomienda=new Conductor(estadoConductor,vehiculoConductor);
          return conductorDisponibleEncomienda;
        }
      }
      return null;
    } 
public void ingresarDatosEncomienda(){
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
    Conductor conductorDisponible=crearConductor();
    ServicioEncomiendas servicioEncomiendasNuevo=new ServicioEncomiendas( fecha, hora,conductorDisponible, origen, destino, valorPagar,super.numServicio,2316, cantidad, peso,  tipo);
    super.numServicio++;
    System.out.println("Servicio de Taxi creado");
    System.out.println("Usted ha pagado: $"+valorPagar);
    mostrarInformacion();

    String nombreArchivo="Servicio/encomiendas.txt";

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
    }
}
