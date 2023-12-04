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
private double subtotal;


public ServicioEncomiendas(){
}
    /**
     * Constructor que inicializa los atributos básicos de un servicio de encomiendas.
     *
     * @param fecha      Fecha del servicio.
     * @param hora       Hora del servicio.
     * @param origen     Lugar de origen del servicio.
     * @param destino    Lugar de destino del servicio.
     * @param numServicio Número único de servicio.
     * @param cantidad   Cantidad de productos en la encomienda.
     */
public ServicioEncomiendas(String fecha,String hora,String origen,String destino,int numServicio,int cantidad){
        super(fecha,hora,origen,destino,numServicio);
        this.cantidad=cantidad;
    }
    /**
     * Constructor que inicializa todos los atributos de un servicio de encomiendas.
     *
     * @param fecha      Fecha del servicio.
     * @param hora       Hora del servicio.
     * @param conductor  Conductor asignado al servicio.
     * @param cliente    Cliente asociado al servicio.
     * @param origen     Lugar de origen del servicio.
     * @param destino    Lugar de destino del servicio.
     * @param valorPagar Valor a pagar por el servicio.
     * @param numServicio Número único de servicio.
     * @param idServicio Identificación única del servicio.
     * @param cantidad   Cantidad de productos en la encomienda.
     * @param peso       Peso total de la encomienda en kilogramos.
     * @param tipo       Tipo de encomienda (fragil, estandar, etc.).
     */
public ServicioEncomiendas(String fecha,String hora,Conductor conductor,Cliente cliente,String origen,String destino,double valorPagar,int numServicio,int idServicio,int cantidad, double peso, TipoEncomienda tipo){
    super(fecha,hora,conductor,cliente,origen,destino,valorPagar,numServicio,idServicio);
    this.cantidad=cantidad;
    this.peso=peso;
    this.tipo=tipo;
    super.numServicio++;
    super.idServicio++;
  }
    public int getCantidad(){
        return cantidad;
    }
    public TipoEncomienda getTipo(){
        return tipo;
    }
    public double getPeso(){
        return peso;
    }
        /**
     * Calcula el valor a pagar por el servicio de encomiendas.
     *
     * @return Valor a pagar por el servicio de encomiendas.
     */
@Override
public double calcularValorPagar(){
    subtotal=4+cantidad;
    valorPagar= 4+cantidad;
    return valorPagar;
    }
        /**
     * Muestra la información específica del servicio de encomiendas.
     */
@Override
public void mostrarInformacion(){
System.out.println("Tipo: Encomienda" + "\n Tipo encomienda: " + tipo +"\n cantidad: "+ cantidad);
    super.mostrarInformacion();
    }
    /**
     * Método para ingresar datos de una encomienda.
     *
     * @param cliente Cliente que realiza la encomienda.
     */
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
    valorPagar=calcularValorPagar();
    System.out.println("El valor a pagar es: $"+valorPagar);
    conductor=conductorDisponible();
    //Crear nuevo servicio encomiendas
    ServicioEncomiendas servicioEncomiendasNuevo=new ServicioEncomiendas( fecha, hora,conductor,cliente, origen, destino, valorPagar,numServicio,idServicio, cantidad, peso,  tipo);
    //Crear nuevo pago
    Pago pagoNuevo=new Pago(Pago.ID_Pago,fecha,idServicio,formaPago,valorPagar);
    System.out.println("Servicio de Taxi creado");
    System.out.println("Usted ha pagado: $"+valorPagar);
    mostrarInformacion();

    String nombreArchivo="encomiendas.txt";

    FileWriter fichero = null;
    BufferedWriter bw = null;

    try {
        fichero = new FileWriter(nombreArchivo, true);
        bw = new BufferedWriter(fichero);
        String linea = servicioEncomiendasNuevo.getNumServicio()+","+servicioEncomiendasNuevo.getTipo() + "," + servicioEncomiendasNuevo.getCantidad() + "," + servicioEncomiendasNuevo.getPeso() + ","+servicioEncomiendasNuevo.getValorPagar();
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
        String linea = servicioEncomiendasNuevo.getNumServicio() + "," + "E" +","+cliente.getNumCedula()+","+conductor.getNombre()+","+ servicioEncomiendasNuevo.getOrigen()+","+servicioEncomiendasNuevo.getDestino()+","+servicioEncomiendasNuevo.getFecha()+","+servicioEncomiendasNuevo.getHora()+"," + cliente.getNumTarjCredito();
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
    String nombreArchivo3="pagos.txt";
        FileWriter fichero3 = null;
        BufferedWriter bw3 = null;
        try {
            fichero3 = new FileWriter(nombreArchivo3, true);
            bw3 = new BufferedWriter(fichero3);
            String linea = pagoNuevo.getID_Pago()+","+pagoNuevo.getFechaPago() + "," + pagoNuevo.getNumServicio() + "," +pagoNuevo.getFormaPago()+"," +cliente.getNumCedula()+"," +subtotal+"," +pagoNuevo.getValorPagar();
            bw3.write(linea + "\n");
            System.out.println("Pago agregado al archivo.");
        } catch (IOException e3) {
            e3.printStackTrace();
        } finally {
            try {
                if (bw3 != null) {
                    bw3.close();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }
        /**
     * Método que busca y devuelve un conductor disponible para el servicio de encomiendas.
     *
     * @return Conductor disponible.
     */
    @Override
    public Conductor conductorDisponible(){
      ArrayList<String> estado=Conductor.obtenerEstado();
      ArrayList<String> tipoVehiculo=Conductor.obtenerTipoVehiculo();
      ArrayList<String> nombres=Conductor.obtenerNombreConductor();
      for(int i=0;i<estado.size();i++){
          if(estado.get(i).equals("D") && tipoVehiculo.get(i).equals("M")){
              Estado estadoElegido=Estado.valueOf(estado.get(i));
              String nombre=nombres.get(0);
              TipoVehiculo tipoElegido=TipoVehiculo.valueOf(tipoVehiculo.get(i));
              Vehiculo vehiculo=new Vehiculo(tipoElegido);
              Conductor conductornew=new Conductor(nombre,estadoElegido,vehiculo);
              return conductornew;
          }
      }
      return null;
  }
}
