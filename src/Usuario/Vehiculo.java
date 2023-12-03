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
  public Vehiculo(TipoVehiculo tipo){
    this.tipo=tipo;
  }
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

