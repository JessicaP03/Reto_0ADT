/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Cliente implements Serializable{

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

    public Cliente() {
    }

    /**
     * @return the id
     */
    public long getid() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the middleIntial
     */
    public String getMiddleIntial() {
        return middleIntial;
    }

    /**
     * @param middleIntial the middleIntial to set
     */
    public void setMiddleIntial(String middleIntial) {
        this.middleIntial = middleIntial;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
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
