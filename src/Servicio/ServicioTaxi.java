/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author STEVEN
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

    public void ingresarDatos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el origen de su viaje: ");
        origen =sc.nextLine();
        System.out.println("Ingrese el destino de su viaje: ");
        destino=sc.nextLine();
        System.out.println("Ingrese la fecha y hora de su viaje: ");
        fecha=sc.nextLine();
        System.out.println("Ingrese la forma de pago: ");
        String tipoPago=sc.nextLine();
        System.out.println("Ingrese el numero de personas que viajan: ");
        numPersonas = sc.nextInt();
        sc.nextLine();
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
