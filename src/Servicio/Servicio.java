/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author GEOVANNY
 */
public class Servicio {
    //private Ruta ruta;
    protected String fecha;
    //private Conductor conductor;
    protected String origen;
    protected String destino;
    protected double valorPagar;
    protected String numServicio;
    protected int idServicio;
    public Servicio(String fecha,String origen,String destino,double valorPagar,String numServicio,int idServicio){
        this.fecha=fecha;
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
}
