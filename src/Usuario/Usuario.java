package Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author STEVEN
 */
public abstract class Usuario{
    protected String nombre;
    protected String apellido;
    protected String user;
    protected String contraseña;
    protected String numCedula;
    protected String numCelular;
    protected typeUsuario tipoUsuario;
    protected int edad;
    public Usuario(){}
    /**
     * Constructor que recibe el nÃºmero de cÃ©dula del usuario.
     *
     * @param numCedula NÃºmero de cÃ©dula del usuario.
     */
    public Usuario(String numCedula){
        this.numCedula=numCedula;
    }
    /**
     * Constructor que recibe nombre y número de cédula del usuario.
     *
     * @param nombre    Nombre del usuario.
     * @param numCedula Número de cédula del usuario.
     */
    public Usuario(String nombre,String numCedula){
      this.numCedula=numCedula;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param nombre      Nombre del usuario.
     * @param apellido    Apellido del usuario.
     * @param user        Nombre de usuario (user).
     * @param contraseña  Contraseña del usuario.
     * @param numCedula   Número de cédula del usuario.
     * @param numCelular  Número de celular del usuario.
     * @param tipoUsuario Tipo de usuario (enum).
     * @param edad        Edad del usuario.
     */
    public Usuario(String nombre,String apellido,String user,String contraseña,String numCedula,String numCelular,typeUsuario tipoUsuario,int edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.user=user;
        this.contraseña=contraseña;
        this.numCedula=numCedula;
        this.numCelular=numCelular;
        this.tipoUsuario=tipoUsuario;
        this.edad=edad;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user=user;
    }
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }
    public String getNumCedula(){
        return numCedula;
    }
    public void setNumCedula(String numCedula){
        this.numCedula=numCedula;
    }
    public String getNumCelular(){
        return numCelular;
    }
    public void setNumCelular(String numCelular){
        this.numCelular=numCelular;
    }
    public typeUsuario getTipoUsuario(){
        return tipoUsuario;
    }
    public void setTipoUsuario(typeUsuario tipoUsuario){
        this.tipoUsuario=tipoUsuario;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public abstract void consultarServicio();
}

