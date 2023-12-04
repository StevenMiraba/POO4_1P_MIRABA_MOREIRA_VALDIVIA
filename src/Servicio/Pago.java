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
    /**
     * Constructor que recibe la forma de pago para el pago en efectivo.
     *
     * @param formaPago Forma de pago utilizada.
     */
public Pago(TipoPago formaPago){
    this.formaPago=formaPago;
  }
    /**
     * Constructor que inicializa un pago con todos sus atributos.
     *
     * @param ID_Pago     Identificador único del pago.
     * @param fechaPago   Fecha en la que se realizó el pago.
     * @param numServicio Número de servicio asociado al pago.
     * @param formaPago   Forma de pago utilizada.
     * @param valorPagar  Valor total a pagar por el servicio.
     */
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

  /**
     * Calcula el costo asociado a la forma de pago actual.
     *
     * @return Representación en cadena de la forma de pago o "default" si es desconocida.
     */
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
