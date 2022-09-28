/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Cuenta implements Serializable{
    
    private int id;
    private String description;
    private float balance;
    private float creditLine;
    private float beginBalance;
    private LocalDate beginBalanceTime;
    ArrayList<String> accountType;

    public Cuenta() {
        accountType = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getBalance() {
        return balance;
    }

    public float getCreditLine() {
        return creditLine;
    }

    public float getBeginBalance() {
        return beginBalance;
    }

    public LocalDate getBeginBalanceTime() {
        return beginBalanceTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setCreditLine(float creditLine) {
        this.creditLine = creditLine;
    }

    public void setBeginBalance(float beginBalance) {
        this.beginBalance = beginBalance;
    }

    public void setBeginBalanceTime(LocalDate beginBalanceTime) {
        this.beginBalanceTime = beginBalanceTime;
    }
    
    
     public void setDatosCuenta() {

        id = Utilidades.leerInt("Introduce el id ");
        description = Utilidades.introducirCadena("Introduce la descripcion");
        balance = Utilidades.leerFloat("Introduce el balance ");
        creditLine = Utilidades.leerFloat("Introduce la linea de credito");
        beginBalance = Utilidades.leerFloat("introduce el balance inicial ");
        beginBalanceTime = Utilidades.leerFecha("introduce indice inicial de balance  ");
     
       
    }

    public void getDatosCuenta() {

        System.out.println("tu id es: " + id);
        System.out.println("tu description es: " + description);
        System.out.println("tu balance es: " + balance);
        System.out.println("tu creditLine es: " + creditLine);
        System.out.println("tu beginBalance es: " + beginBalance);
        System.out.println("tu beginBalanceTime es: " + beginBalanceTime);
       

    }
    
    
    
    
    
    
    
}
