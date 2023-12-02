/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author STEVEN
 */
public class Pago {
    private int ID_Pago;
    private String fechaPago;
    private int ID_Servicio;
    private TipoPago formaPago;
    private double valorPagar;

public Pago(TipoPago formaPago){
    this.formaPago=formaPago;
  }
  public Pago(int ID_Pago,String fechaPago,int ID_Servicio,TipoPago formaPago,double valorPagar){
    this.ID_Pago=ID_Pago;
    this.fechaPago=fechaPago;
    this.ID_Servicio=ID_Servicio;
    this.formaPago=formaPago;
    this.valorPagar=valorPagar;
  }
  public TipoPago getFormaPago(){
      return formaPago;
  }
  public void setFormaPago(TipoPago formaPago){
    this.formaPago=formaPago;
    
  }
  public String calcularCosto(){
      String formPago="";
      //double valorPagar=0;
      if(formaPago!=null){
          switch(formaPago){
              case EFECTIVO:
                  formPago="Efectivo";
                  break;
              case TARJETA_DE_CREDITO:
                  formPago="TarjetaCredito";
              
                  break;
              default:
                  return "default";
          }
          return formPago;
      }
      return null;
  }
}