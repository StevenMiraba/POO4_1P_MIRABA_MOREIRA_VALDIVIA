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
    private static final double costoPorKm=0.50;
    private double subtotal;
    public ServicioTaxi(){
        
    }
    /**
     * Constructor que inicializa los atributos básicos de un servicio de taxi.
     *
     * @param fecha      Fecha del servicio.
     * @param hora       Hora del servicio.
     * @param origen     Lugar de origen del servicio.
     * @param destino    Lugar de destino del servicio.
     * @param numServicio Número único de servicio.
     * @param numPersonas Número de personas que viajan en el taxi.
     */
    public ServicioTaxi(String fecha,String hora,String origen,String destino,int numServicio,int numPersonas){
        super(fecha,hora,origen,destino,numServicio);
        this.numPersonas=numPersonas;
    }
    /**
     * Constructor que inicializa todos los atributos de un servicio de taxi.
     *
     * @param fecha      Fecha del servicio.
     * @param hora       Hora del servicio.
     * @param conductor  Conductor asignado al servicio.
     * @param cliente    Cliente asociado al servicio.
     * @param valorPagar  Valor a pagar por el servicio.
     * @param numServicio Número único de servicio.
     * @param idServicio Identificación única del servicio.
     * @param numPersonas Número de personas que viajan en el taxi.
     * @param distancia  Distancia del viaje en kilómetros.
     */
    public ServicioTaxi(String fecha,String hora,String origen,String destino,Conductor conductor,Cliente cliente,double valorPagar,int numServicio,int idServicio,int numPersonas,int distancia){
        super(fecha,hora,conductor,cliente,origen,destino,valorPagar,numServicio,idServicio);
        this.numPersonas=numPersonas;
        this.distancia=distancia;
        super.numServicio++;
        super.idServicio++;
    }
    public int getNumPersonas(){
        return numPersonas;
    }
    public int getDistancia(){
        return distancia;
    }
    /**
     * Método para ingresar datos del taxi y persistir la información en archivos.
     *
     * @param cliente Cliente que solicita el servicio de taxi.
     */
  public void ingresarDatosTaxi(Cliente cliente){
    Scanner sc=new Scanner(System.in);
    System.out.print("Ingrese el origen de su viaje: ");
    origen =cliente.verificar(sc.nextLine());
    System.out.print("Ingrese el destino de su viaje: ");
    destino=cliente.verificar(sc.nextLine());
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
    ServicioTaxi servicioTaxiNuevo=null;
    Pago pagoNuevo=null;
    if(formaPagoElegida.equals(comprobar)){
        valorPagar=calcularValorPagar();
      }else if(formaPagoElegida.equals(comprobar)){
        valorPagar=calcularValorPagar(cliente.getNumTarjCredito());
      }
      System.out.println("Desea confirmar su viaje?:"+ "\n 1. Si" + "\n 2. No");
      String confirmarViaje=sc.nextLine();
        conductor = conductorDisponible();
      if(confirmarViaje.equals("1")){
        System.out.println("viaje confirmado");
        //Crear nuevo servicio taxi
        servicioTaxiNuevo=new ServicioTaxi(fecha,hora,origen,destino,conductor,cliente,valorPagar,numServicio,idServicio,numPersonas,distancia);
        //Crear nuevo pago
        pagoNuevo=new Pago(Pago.ID_Pago,fecha,idServicio,formaPago,valorPagar);      
        System.out.println("Servicio de Taxi creado");
        System.out.println("Usted ha pagado: $"+servicioTaxiNuevo.valorPagar);
        mostrarInformacion();
        
        String nombreArchivo="viajes.txt";
        FileWriter fichero = null;
        BufferedWriter bw = null;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);
            String linea = servicioTaxiNuevo.getNumServicio()+","+servicioTaxiNuevo.getNumPersonas() + "," + servicioTaxiNuevo.getDistancia() + "," +servicioTaxiNuevo.getValorPagar();
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
        String linea = servicioTaxiNuevo.getNumServicio() + "," + "T" +","+cliente.getNumCedula()+","+conductor.getNombre()+","+ servicioTaxiNuevo.getOrigen()+","+servicioTaxiNuevo.getDestino()+","+servicioTaxiNuevo.getFecha()+","+servicioTaxiNuevo.getHora()+"," + cliente.getNumTarjCredito();
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
      }else if(confirmarViaje.equals("2")){
        System.out.println("viaje rechazado, será redireccionado al menú principal");
        cliente.seleccionarServicio(cliente);
        
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
     * Calcula el valor a pagar para el servicio de taxi.
     * Utiliza una distancia aleatoria entre 5 y 45 kilómetros.
     *
     * @return Valor a pagar por el servicio de taxi.
     */
@Override
public double calcularValorPagar(){
    Random rd=new Random();
    distancia =rd.nextInt(41)+5;
    subtotal=distancia*costoPorKm;
    valorPagar=distancia*costoPorKm;
    System.out.println("El subtotal a pagar es: $"+subtotal);
    System.out.println("El total a pagar es: $"+valorPagar);
    return valorPagar;
    }
    
    /**
     * Calcula el valor a pagar para el servicio de taxi con un recargo del 10% para tarjetas de crédito.
     *
     * @param numTarjCredito Número de tarjeta de crédito del cliente.
     * @return Valor a pagar con recargo por tarjeta de crédito.
     */
public double calcularValorPagar(String numTarjCredito){
    subtotal=calcularValorPagar();
    System.out.println("El subtotal a pagar es: $"+subtotal);
    valorPagar=(calcularValorPagar()*1.10);
    System.out.println("El total a pagar es: $"+valorPagar);
    return valorPagar;
    }
    /**
     * Busca y devuelve un conductor disponible para el servicio de taxi.
     * Elige el primer conductor disponible con un vehículo tipo "A".
     *
     * @return Conductor disponible para el servicio de taxi.
     */
  @Override
  public Conductor conductorDisponible(){
      ArrayList<String> estado=Conductor.obtenerEstado();
      ArrayList<String> tipoVehiculo=Conductor.obtenerTipoVehiculo();
      ArrayList<String> nombres=Conductor.obtenerNombreConductor();
      Estado estadoElegido=null;
      for(int i=0;i<estado.size();i++){
          if(estado.get(i).equals("D") && tipoVehiculo.get(i).equals("A")){
              String estadoCh=estado.get(i);
              String nombre=nombres.get(0);
              estadoElegido = Estado.valueOf(estadoCh);
              TipoVehiculo tipoElegido=TipoVehiculo.valueOf(tipoVehiculo.get(i));
              Vehiculo vehiculo=new Vehiculo(tipoElegido);
              Conductor conductornew=new Conductor(nombre,estadoElegido,vehiculo);
              return conductornew;
          }
      }
      return null;
  }
/**
* Muestra la información del servicio de taxi, incluyendo el número de personas.
*/
@Override
public void mostrarInformacion(){
    System.out.println("Tipo: Viaje" + 
                    "\n Cantidad pasajeros: "+numPersonas);
    super.mostrarInformacion();
    }  
}
