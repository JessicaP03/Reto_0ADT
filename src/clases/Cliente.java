/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import utilidades.Utilidades;

/*
 * @author Grupo JJDA
 * En esta clase ponemos los atributos de Cliente, y los metodos para obtenerlos
 */
public class Cliente implements Serializable{
/**
* atributos
*/
    private long id;
    private String firstName;
    private String lastName;
    private String middleIntial;
    private String street;
    private String city;
    private String state;
    private int zip;
    private int phone;
    private String email;
/**
*Constructor
*/
    public Cliente() {
    }

    /**
     * Setters y getters
     */
    public long getid() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

  
    public String getFirstName() {
        return firstName;
    }

   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public String getLastName() {
        return lastName;
    }

  
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  
    public String getMiddleIntial() {
        return middleIntial;
    }

    
    public void setMiddleIntial(String middleIntial) {
        this.middleIntial = middleIntial;
    }

    
    public String getStreet() {
        return street;
    }

   
    public void setStreet(String street) {
        this.street = street;
    }

    
    public String getCity() {
        return city;
    }

   
    public void setCity(String city) {
        this.city = city;
    }

   
    public String getState() {
        return state;
    }

    
    public void setState(String state) {
        this.state = state;
    }

    
    public int getZip() {
        return zip;
    }

   
    public void setZip(int zip) {
        this.zip = zip;
    }

   
    public int getPhone() {
        return phone;
    }

    
    public void setPhone(int phone) {
        this.phone = phone;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setDatosCliente() {

        id = Utilidades.leerLong("Introduce el id");
        firstName = Utilidades.introducirCadena("Introduce el 1 apellido");
        lastName = Utilidades.introducirCadena("Introduce el 2 apellido");
        middleIntial = Utilidades.introducirCadena("Introduce el nombre");
        street = Utilidades.introducirCadena("Introduceme la calle ");
        city = Utilidades.introducirCadena("Introduce la ciudad ");
        state = Utilidades.introducirCadena("Introduce el estado");
        zip = Utilidades.leerInt("Introduce el codigo postal");
        phone = Utilidades.leerInt("Introduce el numero de telefono");
        email = Utilidades.introducirCadena("Introduce el email");
    }

    public void getDatosCliente() {

        System.out.println("tu id es: " + id);
        System.out.println("tu first name es: " + firstName);
        System.out.println("tu lastName es: " + lastName);
        System.out.println("tu middleIntial es: " + middleIntial);
        System.out.println("tu street es: " + street);
        System.out.println("tu city es: " + city);
        System.out.println("tu state es: " + state);
        System.out.println("tu zip es: " + zip);
        System.out.println("tu phone es: " + phone);
        System.out.println("tu email es: " + email);

    }
    
    @Override
    public String toString() {
        return "Customer{" + "Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleIntial + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + '}';
    }

}
