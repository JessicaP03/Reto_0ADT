/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Cuenta implements Serializable{
    
    private long id;
    private String description;
    private float balance;
    private float creditLine;
    private float beginBalance;
    private LocalDateTime beginBalanceTimestamp;
    private AccountType type;
    
    public enum AccountType {

        standard, credit
    }
    
    public Cuenta(){
        
    }

    public Cuenta(long id, String description, float balance, float creditLine, float beginBalance, LocalDateTime beginBalanceTimestamp, AccountType type) {
        this.id = id;
        this.description = description;
        this.balance = balance;
        this.creditLine = creditLine;
        this.beginBalance = beginBalance;
        this.beginBalanceTimestamp = beginBalanceTimestamp;
        this.type = type;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(float creditLine) {
        this.creditLine = creditLine;
    }

    public float getBeginBalance() {
        return beginBalance;
    }

    public void setBeginBalance(float beginBalance) {
        this.beginBalance = beginBalance;
    }

    public LocalDateTime getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public void setBeginBalanceTimestamp(LocalDateTime beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public int getType() {
        return type.ordinal();
    }

    public void setType(int type) {
        this.type = AccountType.values()[type];
    }
    
    
     public void setDatosCuenta() {
        int decision = 0;
        id = Utilidades.leerInt("Introduce el id ");
        description = Utilidades.introducirCadena("Introduce la descripcion");
        balance = Utilidades.leerFloat("Introduce el balance ");
        creditLine = Utilidades.leerFloat("Introduce la linea de credito");
        beginBalance = Utilidades.leerFloat("introduce el balance inicial ");
        do {
            decision = Utilidades.leerInt("The account is standard or credit? (standard=0/credit=1) ");
            if (decision != 0 && decision != 1) {
            System.out.println("The account must be standard or credit");
            }
        } while (decision != 0 && decision != 1);
        if (decision == 0) {
            this.type = AccountType.standard;
        } else {
            this.type = AccountType.credit;
        }
       
    }

    public void getDatosCuenta() {

        System.out.println("tu id es: " + id);
        System.out.println("tu description es: " + description);
        System.out.println("tu balance es: " + balance);
        System.out.println("tu creditLine es: " + creditLine);
        System.out.println("tu beginBalance es: " + beginBalance);
        System.out.println("Begin balance time stamp of the account: " + LocalDateTime.now());
        if (this.type == AccountType.standard) {
            System.out.println("Standard: " + this.type);
        }
        if (this.type == AccountType.credit) {
            System.out.println("Credit: " + this.type);
        }

    }
    
    
    
    
    
    
    
}
