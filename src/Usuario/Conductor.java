package Usuario;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import Servicio.*;

public class Conductor extends Usuario{
  private String numLicencia;
  private Estado estado;
  private Vehiculo vehiculo;
  public Conductor(String nombre,Estado estado,Vehiculo vehiculo){
      super(nombre);
      this.estado=estado;
      this.vehiculo=vehiculo;
  }
    public Conductor(String numCedula,Estado estado){
      super(numCedula);
      this.estado=estado;
  }
    public Conductor(String numCedula){
      super(numCedula);
  }
  
  public Conductor(String numLicencia, Estado estado, String nombre, String apellido, String numCedula, int edad) {
      super(nombre, apellido, "", "", numCedula, "", typeUsuario.R, edad);
      this.numLicencia = numLicencia;
      this.estado = estado;
  }

  public String getNumLicencia() {
      return numLicencia;
  }

  public void setNumLicencia(String numLicencia) {
      this.numLicencia = numLicencia;
  }

  public Estado getEstado() {
      return estado;
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
  public static ArrayList<String> obtenerEstado(){
    ArrayList<String> estados = new ArrayList<>();
    ArrayList<String> Lineas= LeeConductor("conductores.txt");
    for(String linea:Lineas){
      String[] lineas=linea.split(",");
      String estado=lineas[1];
      estados.add(estado);
      }
    return estados;
    }
  
  public static ArrayList<String> obtenerTipoVehiculo(){
    ArrayList<String> vehiculos = new ArrayList<>();
    ArrayList<String> Lineas= LeeConductor("vehiculos.txt");
    for(String linea:Lineas){
      String[] lineas=linea.split(",");
      String vehiculo=lineas[4];
      vehiculos.add(vehiculo);
      }
    return vehiculos;
    }
  
  public static ArrayList<String> obtenerNombreConductor(){
    ArrayList<String> nombresConductor = new ArrayList<>();
    ArrayList<String> Lineas= LeeConductor("usuarios.txt");
    for(String linea:Lineas){
      String[] lineas=linea.split(",");
      String tipoUser=lineas[6];
      if(tipoUser.equals("R")){
          String nombreConductor=lineas[1];
          nombresConductor.add(nombreConductor);
      }
    }
    return nombresConductor;
    }
  
  public void presentarMenu(){
      System.out.println("/**********MENU CONDUCTOR**********/");
      System.out.println("/*                                */");
      System.out.println("/**********************************/");
      System.out.println("1. Consultar Servicio Asignado");
      System.out.println("2. Datos de su vehículo");
  }
  
  public void seleccionarMenuConductor(){
    String entrada = "";
    Scanner sc=new Scanner(System.in);
    presentarMenu();
    System.out.print("Ingrese opcion: ");
    entrada = sc.nextLine();
    switch(entrada){
        case "1": //1. Consultar Servicio Asignado
              consultarServicio();
            break;
        case "2": //2. Datos de su vehículo
                datosVehiculo();
            break;
      

    }
  }
  public void datosVehiculo(){
    System.out.println("/***********Datos Vehiculo************/");
    System.out.println("/*                                   */");
    System.out.println("/*************************************/");

    ArrayList<String> placa=new ArrayList<>();
    ArrayList<String> modelo=new ArrayList<>();
    ArrayList<String> marca=new ArrayList<>();
    
    ArrayList<String> Lineas= LeeConductor("vehiculos.txt");
    for(String linea:Lineas){
      String[] lineas=linea.split(",");
      placa.add(lineas[1]);
      modelo.add(lineas[2]);
      marca.add(lineas[3]);
      for(int i=0;i<placa.size();i++){
        System.out.println("/*************************************/");
        System.out.println("placa: "+placa.get(i)+
                          "\n modelo: "+modelo.get(i)+
                          "\n marca: "+marca.get(i));
      }
        
  }
  }
 @Override
  public void consultarServicio(){
      System.out.println("/**********SERVICIO ASIGNADO**********/");
      System.out.println("/*                                   */");
      System.out.println("/*************************************/");
    ArrayList<String> tipoServicios=new ArrayList<>();
    ArrayList<String> fechas=new ArrayList<>();
    ArrayList<String> horas=new ArrayList<>();
    ArrayList<String> origenes=new ArrayList<>();
    ArrayList<String> destinos=new ArrayList<>();
      ArrayList<String> Lineas= LeeConductor("servicios.txt");
      for(String linea:Lineas){
        String[] lineas=linea.split(",");
        tipoServicios.add(lineas[1]);
        fechas.add(lineas[6]);
        horas.add(lineas[7]);
        origenes.add(lineas[4]);
        destinos.add(lineas[5]);
      }
      for(int i=0;i<fechas.size();i++){
        System.out.println("/*************************************/");
        System.out.println("Tipo: "+tipoServicios.get(i)+
                          "\n Fecha: "+fechas.get(i)+
                          "\n Hora: "+horas.get(i)+
                          "\n Desde: "+origenes.get(i)+
                          "\n Hasta: "+destinos.get(i));
      }
      
  }
    
}