/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Movimiento implements Serializable{

    private int id;
    private LocalDate timeStamp;
    private float cantidad;
    private float balance;
    private String description;

    public Movimiento() {
    }

    public int getId() {
        return id;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public float getCantidad() {
        return cantidad;
    }

    public float getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatosCuenta() {

        id = Utilidades.leerInt("Introduce el id ");
        timeStamp = Utilidades.leerFecha("Introduce la fecha");
        cantidad = Utilidades.leerFloat("Introduce el balance ");
        balance = Utilidades.leerFloat("Introduce la linea de credito ");
        description = Utilidades.introducirCadena("Introduce la descripcion ");

    }

    public void getDatosCuenta() {

        System.out.println("tu id es: " + id);
        System.out.println("tu timeStamp es: " + timeStamp);
        System.out.println("tu cantidad es: " + cantidad);
        System.out.println("tu balance es: " + balance);
        System.out.println("tu description es: " + description);

    }

}
