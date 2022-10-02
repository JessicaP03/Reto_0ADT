/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import utilidades.Utilidades;

/**
 *
 * @author Grupo JJDA
 */
public class Movimiento {
    /**
     * atributos
     */
    private long id;
    private long idCuenta;
    private LocalDateTime timestamp;
    private float amount;
    private float balance;
    private String description;

    /**
     * constructores
     */
    public Movimiento(){
        
    }

    public Movimiento(long id, long idAccount, LocalDateTime timestamp, float amount, float balance, String description) {
        this.id = id;
        this.idCuenta = idCuenta;
        this.timestamp = timestamp;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }
    /**
     * getters y setters
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAccount() {
        return idCuenta;
    }

    public void setIdAccount(long idAccount) {
        this.idCuenta = idAccount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    


    public void setDatosMovimiento(Long id,float balance) {
        idCuenta = id;
        amount = Utilidades.leerFloat("Introduce la cantidad de dinero para el movimiento");
        this.balance=balance+amount;
        description = Utilidades.introducirCadena("Introduce la descripcion del movimiento");
    }

    public void getDatosMovimiento() {
        System.out.println("Id del movimiento:" + this.id);
        System.out.println("Id de la cuenta implicada:" + this.idCuenta);
        System.out.println("Timestamp del movimiento:" + this.timestamp);
        System.out.println("cantidad de dinero movida: " + this.amount);
        System.out.println("Balance del movimiento:" + this.balance);
        System.out.println("Descripcion del movimiento:" + this.description);
    }

}
