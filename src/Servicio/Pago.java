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
    public static int ID_Pago=1;
    private String fechaPago;
    private int numServicio;
    private TipoPago formaPago;
    private double valorPagar;

public Pago(TipoPago formaPago){
    this.formaPago=formaPago;
  }
  public Pago(int ID_Pago,String fechaPago,int numServicio,TipoPago formaPago,double valorPagar){
    this.ID_Pago=ID_Pago;
    this.fechaPago=fechaPago;
    this.numServicio=numServicio;
    this.formaPago=formaPago;
    this.valorPagar=valorPagar;
  }

    public static int getID_Pago() {
        return ID_Pago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public int getNumServicio() {
        return numServicio;
    }

    public double getValorPagar() {
        return valorPagar;
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
                  formPago="EFECTIVO";
                  break;
              case TARJETA_DE_CREDITO:
                  formPago="TARJETA_DE_CREDITO";
              
                  break;
              default:
                  return "default";
          }
          return formPago;
      }
      return null;
  }
}