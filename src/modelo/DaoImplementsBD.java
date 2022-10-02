/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimiento;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javax.annotation.Resource;
import excepciones.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 2dam
 */

public class DaoImplementsBD implements Dao {

    private Connection con = null;
    private Properties prope;
    private PreparedStatement stmt = null;

    private ResourceBundle configFile;
    private String driverBD;
    private String urlDB;
    private String userBD;
    private String passwordBD;

    public DaoImplementsBD() {
        this.configFile = ResourceBundle.getBundle("modelo.configuracion");
        this.driverBD = this.configFile.getString("Driver");
        this.urlDB = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }

    public void conectar() throws DaoExcepcion {
        try {
            Class.forName(this.driverBD);
            con = DriverManager.getConnection(this.urlDB, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            throw new DaoExcepcion("Error en la SQL al conectar" + e.getMessage());
        } catch (ClassNotFoundException e1) {
            throw new DaoExcepcion("No se ha encontrado el driver para la conexion" + e1.getMessage());
        }
    }

    public void desconectar() throws DaoExcepcion {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new DaoExcepcion("Error de SQL " + e.getMessage());
        }
    }

    private final String createCustomer = "INSERT INTO customer (city,email,firstName,lastName,middleInitial,phone,state,street,zip) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String consultCustomer = "SELECT customer.* FROM customer WHERE customer.id = ?";
    private final String consultAccounts = "SELECT account.* FROM customer_account, account WHERE customer_account.customers_id = ? AND customer_account.accounts_id = account.id";
    private final String createAccount = "INSERT INTO account (balance,beginBalance,beginBalanceTimestamp,creditLine,description,type) VALUES (?,?,?,?,?,?)";
    private final String createCustomerAccount = "INSERT INTO customer_account VALUES (?,?)";
    private final String consultDataAccount = "SELECT account.* FROM account WHERE account.id = ?";
    private final String createMovement = "INSERT INTO movement (amount,balance,description,timestamp,account_id) VALUES (?,?,?,?,?)";
    private final String consultMovement = "SELECT movement.* FROM account, movement WHERE movement.account_id = account.id AND account.id = ?";
    private final String updateAccountBalance = "UPDATE account SET account.balance = ? WHERE account.id = ?";

    @Override
    public Long createCustomer(Cliente clie) throws CrearExcepcion, LeerExcepcion, DaoExcepcion {
        Long id_cus=null;
        ResultSet rs =null;
        try {
            this.conectar();
        } catch (DaoExcepcion e1) {
            throw new LeerExcepcion(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(createCustomer,stmt.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, clie.getCity());
            stmt.setString(2, clie.getEmail());
            stmt.setString(3, clie.getFirstName());
            stmt.setString(4, clie.getLastName());
            stmt.setString(5, clie.getMiddleIntial());
            stmt.setLong(6, clie.getPhone());
            stmt.setString(7, clie.getState());
            stmt.setString(8, clie.getStreet());
            stmt.setInt(9, clie.getZip());
           
           
            
            stmt.executeUpdate();
           
            rs=stmt.getGeneratedKeys();
            if(rs.next()){
                id_cus=rs.getLong(1);
            }
        } catch (Exception e) {
            throw new LeerExcepcion("Error al Crear");
        }
        this.desconectar();
        return id_cus;
    }

    @Override
    public Cliente consultCustomer(long id) throws LeerExcepcion, CrearExcepcion, DaoExcepcion {
        Cliente clie = null;
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoExcepcion e1) {
            throw new CrearExcepcion(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(consultCustomer);
            stmt.setLong(1, id);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                clie = new Cliente();
                clie.setId(id);
                clie.setFirstName(rs.getString("customer.firstName"));
                clie.setLastName(rs.getString("customer.lastName"));
                clie.setMiddleIntial("customer.middleInitial");
                clie.setStreet(rs.getString("customer.street"));
                clie.setCity(rs.getString("customer.city"));
                clie.setState(rs.getString("customer.state"));
                clie.setZip(rs.getInt("customer.zip"));
                clie.setPhone((int) rs.getLong("customer.phone"));
                clie.setEmail(rs.getString("customer.email"));
            }

        } catch (Exception e) {
            throw new CrearExcepcion("Error al consultar");
        }
        this.desconectar();
        
        return clie;
    }

    @Override
    public Collection<Cuenta> consultAccounts(Long idCustom) throws LeerExcepcion, CrearExcepcion, DaoExcepcion {
        
        Cuenta cunt = null;
        Collection<Cuenta> ccunt =  new ArrayList<>();
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoExcepcion e1) {
            throw new CrearExcepcion(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(consultAccounts);
            stmt.setLong(1, idCustom);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                cunt = new Cuenta();
                cunt.setId(rs.getLong("account.id"));
                cunt.setDescription(rs.getString("account.description"));
                cunt.setBalance(rs.getFloat("account.balance"));
                cunt.setCreditLine(rs.getFloat("account.creditLine"));
                cunt.setBeginBalance(rs.getFloat("account.beginBalance"));
                cunt.setBeginBalanceTimestamp(rs.getTimestamp("account.beginBalanceTimestamp").toLocalDateTime());
                cunt.setType(rs.getInt("account.type"));
                
                ccunt.add(cunt);
            }

        } catch (Exception e) {
            throw new LeerExcepcion("Error al Leer");
        }
        this.desconectar();
        
        return ccunt;
        
    }

    @Override
    public Long createAccount(Long id, Cuenta cunt) throws CrearExcepcion, LeerExcepcion, DaoExcepcion {
        Long id_acc = null;
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoExcepcion e1) {
            throw new LeerExcepcion(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(createAccount,stmt.RETURN_GENERATED_KEYS);
            
            stmt.setFloat(1, cunt.getBalance());
            stmt.setFloat(2, cunt.getBeginBalance());
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setFloat(4, cunt.getCreditLine());
            stmt.setString(5, cunt.getDescription());
            stmt.setInt(6, cunt.getType());

            stmt.executeUpdate();
            
          
            rs=stmt.getGeneratedKeys();
            if(rs.next()){
                id_acc=rs.getLong(1);
            }
        } catch (Exception e) {
            throw new CrearExcepcion("Error al Crear");
        }
        this.desconectar();
        
        createCustomerAccount(id, id_acc);
        return id_acc;
    }
    
    @Override
    public void createCustomerAccount(Long id, Long id_acc) throws CrearExcepcion, LeerExcepcion, DaoExcepcion {
        
        try {
            this.conectar();
        } catch (DaoExcepcion e1) {
            throw new LeerExcepcion(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(createCustomerAccount);
            stmt.setLong(1, id);
            stmt.setLong(2, id_acc);
            
            
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new CrearExcepcion("Error al Crear");
        }
        this.desconectar();
    }

    @Override
    public Cuenta consultDataAccount(Long id) throws CrearExcepcion, LeerExcepcion, DaoExcepcion {
        
        Cuenta cunt = null;
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoExcepcion e1) {
            throw new LeerExcepcion(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(consultDataAccount);
            stmt.setLong(1, id);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                cunt = new Cuenta();
                cunt.setId(id);
                cunt.setDescription(rs.getString("account.description"));
                cunt.setBalance(rs.getFloat("account.balance"));
                cunt.setCreditLine(rs.getFloat("account.creditLine"));
                cunt.setBeginBalance(rs.getFloat("account.beginBalance"));
                cunt.setBeginBalanceTimestamp(rs.getTimestamp("account.beginBalanceTimestamp").toLocalDateTime());
                cunt.setType(rs.getInt("account.type"));
                
            }

        } catch (Exception e) {
            throw new CrearExcepcion("Error al consultar");
        }
        this.desconectar();
        
        return cunt;
    }

    @Override
    public void createMovement(Movimiento move) throws CrearExcepcion, ActualizarExcepcion, LeerExcepcion, DaoExcepcion {
        
        
        try {
            this.conectar();
        } catch (DaoExcepcion e1) {
            throw new LeerExcepcion(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(createMovement);


            stmt.setFloat(1, move.getAmount());
            stmt.setFloat(2, move.getBalance());
            stmt.setString(3, move.getDescription());
            stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(5, move.getIdAccount());

            stmt.executeUpdate();
          
        } catch (Exception e) {
            throw new CrearExcepcion("Error al Crear");
        }
        try{
            stmt = con.prepareStatement(updateAccountBalance);
            stmt.setFloat(1,move.getBalance());
            stmt.setLong(2,move.getIdAccount());
            stmt.executeUpdate();
        }catch (Exception ex){
            throw new ActualizarExcepcion("Error al modificar");
        }
        this.desconectar();
    }

    @Override
    public Collection<Movimiento> consultMovements(Long id) throws CrearExcepcion, LeerExcepcion, DaoExcepcion {
        Movimiento move = null;
        Collection<Movimiento> movements = new ArrayList<>();
        ResultSet rs = null;
        try {
            this.conectar();
        } catch (DaoExcepcion e1) {
            throw new LeerExcepcion(e1.getMessage());
        }
        try {
            stmt = con.prepareStatement(consultMovement);
            stmt.setLong(1, id);
            
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                move = new Movimiento();
                move.setId(rs.getLong("movement.id"));
                
                move.setIdAccount(rs.getLong("movement.account_id"));
                move.setTimestamp(rs.getTimestamp("movement.timestamp").toLocalDateTime());
                move.setAmount(rs.getFloat("movement.amount"));
                move.setBalance(rs.getFloat("movement.balance"));
                move.setDescription(rs.getString("movement.description"));
                movements.add(move);
                
            }

        } catch (Exception e) {
            throw new CrearExcepcion("Error al consultar");
        }
        this.desconectar();
        
        return movements;
    }

   
}
 

