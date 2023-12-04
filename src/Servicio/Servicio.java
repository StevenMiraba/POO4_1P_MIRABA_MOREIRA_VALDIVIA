/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import Usuario.*;
/**
 *
 * @author GEOVANNY
 */
public class Servicio{
    protected String fecha;
    protected String hora;
    protected Conductor conductor;
    protected Cliente cliente;
    protected String origen;
    protected String destino;
    protected double valorPagar;
    protected static int numServicio=1;
    protected static int idServicio=1;

    public Servicio(){}
    /**
     * Constructor que inicializa los atributos de servicio.
     *
     * @param fecha      Fecha del servicio.
     * @param hora       Hora del servicio.
     * @param origen     Lugar de origen del servicio.
     * @param destino    Lugar de destino del servicio.
     * @param numServicio Número único de servicio.
     */
    public Servicio(String fecha,String hora,String origen,String destino,int numServicio){
        this.fecha=fecha;
        this.hora=hora;
        this.origen=origen;
        this.destino=destino;
        this.numServicio=numServicio;
    }
    /**
     * Constructor que inicializa todos los atributos de servicio.
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
     */
    public Servicio(String fecha,String hora,Conductor conductor,Cliente cliente,String origen,String destino,double valorPagar,int numServicio,int idServicio){
        this.fecha=fecha;
        this.hora=hora;
        this.conductor=conductor;
        this.cliente=cliente;
        this.origen=origen;
        this.destino=destino;
        this.valorPagar=valorPagar;
    }
    public Conductor getConductor(){
        return conductor;
    }
    public String getFecha(){
        return fecha;
    }
    public String getHora(){
        return hora;
    }
    public String getDestino(){
        return destino;
    }
    public String getOrigen(){
        return origen;
    }
    public int getNumServicio(){
        return numServicio;
    }
    public int getIdServicio(){
        return idServicio;
    }
    public double getValorPagar(){
        return valorPagar;
    }
    /**
     * Calcula el valor a pagar por el servicio.
     *
     * @return Valor a pagar por el servicio.
     */
    public double calcularValorPagar(){
        double subtotal=2.2;
        //total=
        return subtotal;
    }
    /**
     * Método para obtener un conductor disponible para el servicio.
     *
     * @return Conductor disponible.
     */
    public Conductor conductorDisponible(){
        return null;
    }
    /**
     * Muestra la información básica del servicio.
     */
    public void mostrarInformacion(){
      System.out.println("Fecha:" + fecha + "\n Hora" + hora +"\n Desde:" + origen +"\n Hasta:" + destino);                
    }
}
