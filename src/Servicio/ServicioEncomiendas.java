/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author GEOVANNY
 */
import java.util.Scanner;
import java.util.Random;
import Usuario.*;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ServicioEncomiendas extends Servicio{
private int cantidad;
private double peso;
private TipoEncomienda tipo;


public ServicioEncomiendas(){
}

public ServicioEncomiendas(String fecha,String hora,Conductor conductor,String origen,String destino,double valorPagar,int numServicio,int idServicio,int cantidad, double peso, TipoEncomienda tipo){
    super(fecha,hora,conductor,origen,destino,valorPagar,numServicio,idServicio);
    this.cantidad=cantidad;
    this.peso=peso;
    this.tipo=tipo;
  }
@Override
public double calcularValorPagar(){
    valorPagar= 4+cantidad;
    return valorPagar;
    }
@Override
public void mostrarInformacion(){
System.out.println("Tipo: Encomienda" + "\n Tipo encomienda: " + tipo +"\n cantidad: "+ cantidad);
    super.mostrarInformacion();
    }
    
@Override
public Conductor crearConductor(){
    conductor=new Conductor();
    ArrayList<String> estados=conductor.obtenerEstado();
    ArrayList<String> vehiculos=conductor.obtenerVehiculo();
    for(int i=0;i<estados.size();i++){
        String estado=estados.get(i);
        String vehiculo=vehiculos.get(i);

    if(estado.equals("D") && vehiculo.equals("M")){
        state estadoConductor=state.valueOf(estado);
        TipoVehiculo tipodeVehiculo=TipoVehiculo.valueOf(vehiculo);
        Vehiculo vehiculoConductor=new Vehiculo(tipodeVehiculo);
        Conductor conductorDisponibleEncomienda=new Conductor(estadoConductor,vehiculoConductor);
          return conductorDisponibleEncomienda;
        }
      }
      return null;
    } 


}
