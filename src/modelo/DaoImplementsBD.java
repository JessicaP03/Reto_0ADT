/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.annotation.Resource;

/**
 *
 * @author 2dam
 */
public class DaoImplementsBD implements Dao{
    //Esta implementacion servira para conectarnos con nuestra base de datos.
    private Connection con;
    private PreparedStatement stmt;
    
    //Atributos para recoger los valores del fichero de configuracion
    private ResourceBundle configuracionFich;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;
    private String id;
    
    //Guardamos lo que usaremos en el fichero de configuracion
    public DaoImplementsBD() {
		this.configuracionFich = ResourceBundle.getBundle("modelo.configuracion");
		this.driverBD = this.configuracionFich.getString("Driver");
		this.urlBD = this.configuracionFich.getString("Conn");
		this.userBD = this.configuracionFich.getString("DBUser");
		this.passwordBD = this.configuracionFich.getString("DBPass");
  
    }
    
    //Metodo para abrir la conexión con la base de datos.
    private void openConnection() {
        try {
            con = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
            
        } catch (SQLException e) {
            System.out.println("ERROR! No se puede abrir la BD");
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Se ha abierto la BD");
            e.printStackTrace();
        }
        
    }
    
    //Metodo para cerrar la conexion de la BD
    private void closeConnection () throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }
                
    
    //Sentencias sql para la base de datos para crear o leer datos.
   final String INSERTcliente = "INSERT INTO customer (id, city, email, firstName, lastName, middleInitial, phone, state, street,zip) VALUES ( ?, ?, ?, ?,?,?, ?, ?, ?, ?)";
    
    //Metodos que vamos a utilizar en el programa.
    @Override
    public void crearClientes(Cliente customer) {
       this.openConnection();
    /*
    private int id;
    private String city;
    private String email;
    private String firstName;
    private String lastName;
    private String middleIntial;
    private int phone;
    private String state;
    private String street;
    private int zip;
    
   
       try  {
           stmt = con.preparedStatement(INSERTCliente);
                    stmt.setInt(1, customer );
       } catch (SQLExecption e){
           
       }
        
     */   
    }

    @Override
    public void leerDatosCliente(String id) {
        throw new UnsupportedOperationException(); 
        
    }

    @Override
    public void consultarCuentasCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearCuentaCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarClienteCuenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarDatosCuenta(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void realizarMovimientios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarMovimientos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
