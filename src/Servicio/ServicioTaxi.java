/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author GEOVANNY
 */
public class ServicioTaxi extends Servicio{
    private int numPersonas;
    public ServicioTaxi(String fecha,String origen,String destino,double valorPagar,String numServicio,int idServicio,int numPersonas){
        super(fecha,origen,destino,valorPagar,numServicio,idServicio);
        this.numPersonas=numPersonas;
    }

    public static ArrayList<String> LeeConductor(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
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
    
    @Override
    public Conductor crearConductor(){
      conductor=new Conductor();
      ArrayList<String> estados=conductor.obtenerEstado();
      ArrayList<String> vehiculos=conductor.obtenerVehiculo();
      for(int i=0;i<estados.size();i++){
        String estado=estados.get(i);
        String vehiculo=vehiculos.get(i);
        if(estado.equals("D") && vehiculo.equals("A")){
          state estadoConductor=state.valueOf(estado);
          TipoVehiculo tipodeVehiculo=TipoVehiculo.valueOf(vehiculo);
          Vehiculo vehiculoConductor=new Vehiculo(tipodeVehiculo);
          Conductor conductorDisponibleTaxi=new Conductor(estadoConductor,vehiculoConductor);
          //Conductor(String numLicencia, state estado, String nombre, String apellido, String numCedula, int edad) 
          return conductorDisponibleTaxi;
        }
      }
      return null;
    } 

  public void ingresarDatosTaxi(Cliente cliente){
    Conductor conductorDisponible=new Conductor();
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
    System.out.println("Ingrese el numero de personas que viajan: ");
    numPersonas = sc.nextInt();
    sc.nextLine();
    //sc.close();
    String comprobar=pago.calcularCosto();
    if(comprobar.equals("efectivo")){
        valorPagar=calcularValorPagar();
      }else if(comprobar.equals("TarjetaCredito")){
        valorPagar=calcularValorPagar(cliente.getNumTarjCredito());//argumento es la tarjeta de credito
      }
      System.out.println("Desea confirmar su viaje?:"+ "\n 1. Si" + "\n 2. No");
      String confirmarViaje=sc.nextLine();
      if(confirmarViaje.equals("1")){
        System.out.println("viaje confirmado");
        conductorDisponible = crearConductor();
        ServicioTaxi servicioTaxiNuevo=new ServicioTaxi(fecha,hora,conductorDisponible,origen,destino,valorPagar,super.numServicio,super.idServicio,numPersonas);
        super.numServicio++;
        System.out.println("Servicio de Taxi creado");
        System.out.println("Usted ha pagado: $"+valorPagar);
              }else if(confirmarViaje.equals("2")){
        System.out.println("viaje rechazado, será redireccionado al menú principal");
        cliente.seleccionarServicio(cliente,conductorDisponible);
      }
      String nombreArchivo="Servicio/vijes.txt";
        FileWriter fichero = null;
        BufferedWriter bw = null;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);
            String linea = "\"" + super.numServicio+"\","+numPersonas + "\"," + distancia + ",\"" +valorPagar+"\"";
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

public void registrarServicioTaxi(Cliente cliente,Conductor conductor){
    String nombreArchivo="Servicio/servicios.txt";
    FileWriter fichero = null;
    BufferedWriter bw = null;
    try {
        fichero = new FileWriter(nombreArchivo, true);
        bw = new BufferedWriter(fichero);
        String linea = "\"" + super.numServicio + "\"," + "T" +",\""+cliente.getNumCedula()+",\""+conductor.getNombre()+ origen+",\""+destino+",\""+fecha+",\""+hora+",\"" + cliente.getNumTarjCredito() + "\"";
        bw.write(linea + "\n");
        System.out.println("Servicio agregado al archivo.");
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
    
    @Override
    public double calcularValorPagar(){
        Random rd=new Random();
        int distancia =rd.nextInt(41)+5;
        double costoPorKm=0.50;
        double subtotal=distancia*costoPorKm;
        System.out.println("El subtotal a pagar es: "+subtotal);
        return subtotal;
    }
    public void calcularValorPagar(String numTarjCredito){
        System.out.println("El subtotal a pagar es: $"+(calcularValorPagar()*1.10));
    }
    
}
