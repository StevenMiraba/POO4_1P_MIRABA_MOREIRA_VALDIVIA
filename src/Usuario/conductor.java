package Usuario;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import Servicio.*;

public class Conductor extends Usuario{
  private String numLicencia;
  private state estado;
  private Vehiculo vehiculo;
  public Conductor(){
  }
  public Conductor(state estado,Vehiculo vehiculo){
    this.estado=estado;
    this.vehiculo=vehiculo;
  }
  
  public Conductor(String numLicencia, state estado, String nombre, String apellido, String numCedula, int edad) {
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

  public state getEstado() {
      return estado;
  }
