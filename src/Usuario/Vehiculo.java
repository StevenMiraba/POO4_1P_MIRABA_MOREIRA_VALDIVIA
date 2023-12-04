package Usuario;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Vehiculo{
  private String placa;
  private String modelo;
  private String marca;
  private TipoVehiculo tipo;
  private int codigoVehiculo;
  public Vehiculo(){
    
  }
  /**
     * Constructor que recibe un tipo de vehículo y lo asigna al vehículo.
     *
     * @param tipo Tipo de vehículo.
     */
  public Vehiculo(TipoVehiculo tipo){
    this.tipo=tipo;
  }
  /**
     * Constructor que recibe varios parámetros para inicializar las características del vehículo.
     *
     * @param placa          Número de placa del vehículo.
     * @param modelo         Modelo del vehículo.
     * @param marca          Marca del vehículo.
     * @param tipo           Tipo de vehículo.
     * @param codigoVehiculo Código único del vehículo.
     */
  public Vehiculo(String placa,String modelo,String marca,TipoVehiculo tipo,int codigoVehiculo){
  this.placa=placa;
this.modelo=modelo;
this.marca=marca;
this.tipo=tipo;
this.codigoVehiculo=codigoVehiculo;
    }
  
  public void setCodigoVehiculo(int codigoVehiculo) {
      this.codigoVehiculo = codigoVehiculo;
  }

  public int getCodigoVehiculo() {
      return codigoVehiculo;
  }

  public String getPlaca(){
      return placa;
  }
  public void setPlaca(String placa){
      this.placa=placa;
  }

  public String getModelo(){
      return modelo;
  }
  public void setModelo(String modelo){
      this.modelo=modelo;
  }

  public String getMarca(){
      return marca;
  }
  public void setMarca(String marca){
      this.marca=marca;
  }

  public TipoVehiculo getTipo(){
      return tipo;
  }
  /**
     * Lee la información de los vehículos desde un archivo y devuelve las líneas leídas.
     *
     * @param nombrearchivo Nombre del archivo que contiene la información de los vehículos.
     * @return Lista de líneas leídas desde el archivo.
     */
  public static ArrayList<String> LeeVehiculo(String nombrearchivo) {
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

  

  
  
}

