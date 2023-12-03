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

        public Servicio(){
    }
    
    public Servicio(String fecha,String hora,Conductor conductor,Cliente cliente,String origen,String destino,double valorPagar,int numServicio,int idServicio){
        this.fecha=fecha;
        this.hora=hora;
        this.conductor=conductor;
        this.cliente=cliente;
        this.origen=origen;
        this.destino=destino;
        this.valorPagar=valorPagar;
        this.numServicio=numServicio;
        this.idServicio=idServicio;
    }
    
    public double calcularValorPagar(){
        double subtotal=2.2;
        //total=
        return subtotal;
    }
    public Conductor conductorDisponible(){
        return null;
    }

    public void mostrarInformacion(){
      System.out.println("Fecha:" + fecha + "\n Hora" + hora +"\n Desde:" + origen +"\n Hasta:" + destino);                
    }
}