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

  /**
    * Constructor que recibe nombre, estado y vehículo como parámetros.
    * @param nombre requerido para devolver String
    * @param estado Estado del conductor.
    * @param vehiculo Vehículo asociado al conductor.
    */
  public Conductor(String nombre,Estado estado,Vehiculo vehiculo){
      super(nombre);
      this.estado=estado;
      this.vehiculo=vehiculo;
  }
  /**
    * Constructor que recibe parametro de numero de cedula y estado.
    * @param numCedula Número de cédula del conductor.
    * @param estado Estado del conductor.
    */
    public Conductor(String numCedula,Estado estado){
      super(numCedula);
      this.estado=estado;
  }
  /**
    * Constructor que recibe parametro de numero de cedula.
    * @param numCedula Número de cédula del conductor.
    */
    public Conductor(String numCedula){
      super(numCedula);
  }
  /**
     * Constructor que inicializa varios atributos.
     * @param numLicencia Número de licencia del conductor.
     * @param estado Estado del conductor.
     * @param nombre Nombre del conductor.
     * @param apellido Apellido del conductor.
     * @param numCedula Número de cédula del conductor.
     * @param edad Edad del conductor.
     */
  public Conductor(String numLicencia, Estado estado, String nombre, String apellido, String numCedula, int edad) {
      super(nombre, apellido, "", "", numCedula, "", typeUsuario.R, edad);
      this.numLicencia = numLicencia;
      this.estado = estado;
  }
//Metodos getters y setters
  public String getNumLicencia() {
      return numLicencia;
  }

  public void setNumLicencia(String numLicencia) {
      this.numLicencia = numLicencia;
  }

  public Estado getEstado() {
      return estado;
  }
/**
   * Método para extraer el nombre de los conductores desde el archivo "usuarios.txt".
   *
   * @return Lista de nombres de los conductores.
   */
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

    /**
     * Se obtiene los tipos de vehículo de los conductores.
     * @return lista de tipos de vehículo de los conductores.
     */
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

    /**
     * Se Obtiene los tipos de vehículo de los conductores.
     * @return lista de tipos de vehículo de los conductores.
     */
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
  /**
     * Se obtiene los nombres de los conductores.
     * @return lista de nombres de los conductores.
     */
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
  /**
     * Presenta el menú para los conductores.
     */
  public void presentarMenu(){
      System.out.println("/**********MENU CONDUCTOR**********/");
      System.out.println("/*                                */");
      System.out.println("/**********************************/");
      System.out.println("1. Consultar Servicio Asignado");
      System.out.println("2. Datos de su vehículo");
  }
  /**
     * Menú de Conductor para seleccionar una opcion
     * @param conductor Conductor que realiza la selección.
     */
  public void seleccionarMenuConductor(Conductor conductor){
    String entrada = "";
    Scanner sc=new Scanner(System.in);
    presentarMenu();
    System.out.print("Ingrese opcion: ");
    entrada = sc.nextLine();
    switch(entrada){
        case "1": //1. Consultar Servicio Asignado
              consultarServicio(conductor);
            break;
        case "2": //2. Datos de su vehículo
                datosVehiculo(conductor);
            break;
      

    }
  }
  /**
   * Muestra los datos del vehículo asignado al conductor.
   *
   * @param conductor Conductor que desea ver los datos de su vehículo.
   */
  public void datosVehiculo(Conductor conductor){
    System.out.println("/***********Datos Vehiculo************/");
    System.out.println("/*                                   */");
    System.out.println("/*************************************/");
    ArrayList<Servicio> serviciosCliente = new ArrayList<>();
        String cedula = conductor.getNumCedula();
        ArrayList<String> Lineas = LeeConductor("conductores.txt");
        ArrayList<String> Lineas2 = LeeConductor("vehiculos.txt");
        for (String linea : Lineas) {
            String[] lineas = linea.split(",");
            String cedulaExt = lineas[0];
            if(cedula.equals(cedulaExt)){
                String codVehiculo=lineas[2];
                for (String linea2 : Lineas2){
                    String[] lineas2 = linea2.split(",");
                    String codVehiculoExt = lineas2[0];
                    if(codVehiculo.equals(codVehiculoExt)){
                        System.out.println("/*************************************/");
                System.out.println("Tipo Vehiculo: "+lineas2[4]
                                    + "\n placa: " + lineas2[1]
                                    + "\n modelo: " + lineas2[2]
                                    + "\n marca: " + lineas2[3]);
                    }
                }
}
    }

  }
    @Override
    public void consultarServicio(){   
    }

  /**
   * Consulta y muestra el servicio asignado al conductor.
   *
   * @param conductor Conductor que desea consultar el servicio asignado.
   */
    public void consultarServicio(Conductor conductor){
        System.out.println("/***********SERVICIO ASIGNADO************/");
        System.out.println("/*                                      */");
        System.out.println("/****************************************/");
        ArrayList<Servicio> serviciosCliente = new ArrayList<>();
        String cedula = conductor.getNumCedula();
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
                System.out.println("Tipo: Servicio Taxi"
                        + "\n Cantidad pasajeros: " + serT.getNumPersonas()
                        + "\n Fecha: " + serT.getFecha()
                        + "\n Hora: " + serT.getHora()
                        + "\n Desde: " + serT.getOrigen()
                        + "\n Hasta: " + serT.getDestino());
            }else if (ser instanceof ServicioEncomiendas) {
                ServicioEncomiendas serE = (ServicioEncomiendas) ser;
                System.out.println("/*************************************/");
                System.out.println("Tipo: Servicio Encomienda"
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
