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

/**
 *
 * @author 2dam
 */
public class DaoImplementsBD implements Dao {

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
        } catch (Exception e) {
            System.out.println("Se ha abierto la BD");
            e.printStackTrace();
        }

    }

    //Metodo para cerrar la conexion de la BD
    private void closeConnection() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    //Sentencias sql para la base de datos para crear o leer datos.
    final String INSERTcliente = "INSERT INTO customer (id, city, email, firstName, lastName, middleInitial, phone, state, street,zip) VALUES ( ?, ?, ?, ?,?,?, ?, ?, ?, ?)";
    final String LeerDatosClien = "SELECT * FROM customer where id = ?";
    final String LeerCuentaCLient = "SELECT a.* FROM account a, customer c, customer_account ca WHERE c.id = ca.customers_id AND a.id = accounts_id AND c.id = ?";
    
    final String RealizarMovimi = "INSERT INTO movement (id, ammount, balance, description, timestamp, account_id) VALUES (?, ?, ?, ?, ?, ?)";
    final String ConsultaMovimi =  "SELECT m.* FROM accoun a, movement m WHERE m.account_id = a.id AND m.id = ?";

    //Metodos que vamos a utilizar en el programa.
    @Override
    public void crearClientes(Cliente customer) {
        this.openConnection();
    
    
        try {

            stmt = con.prepareStatement(INSERTcliente); // Cargamos el insert de cliente con el stmt

            // Posicionamos cada valor para insertarlo en la base de datos
            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getCity());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getFirstName());
            stmt.setString(5, customer.getLastName());
            stmt.setString(6, customer.getMiddleIntial());
            stmt.setInt(7, customer.getPhone());
            stmt.setString(8, customer.getState());
            stmt.setString(9, customer.getStreet());
            stmt.setInt(10, customer.getZip());

            //tString(10, "CLIENTE");
            stmt.executeUpdate();

           } catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			this.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}


     @Override
    public void leerDatosCliente(String id) {
        ResultSet rs = null;
		Cliente custom = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(LeerDatosClien);

			stmt.setString(0, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
                            
				custom = new Cliente();
				custom.setCity(rs.getString("city"));
				custom.setEmail(rs.getString("email"));
				custom.setFirstName(rs.getString("firstName"));
				custom.setLastName(rs.getString("lastName"));
				custom.setMiddleIntial(rs.getString("middleIntial"));
				custom.setPhone(rs.getInt("phone"));
                                custom.setState(rs.getString("state"));
                                custom.setStreet(rs.getString("street"));
                                custom.setZip(rs.getInt("zip"));

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
	
    }  
        
    @Override
    public void consultarCuentasCliente(Cliente custom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public void crearCuentaCliente(Cliente custom) {
        
    }

    @Override
    public void agregarClienteCuenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarDatosCuenta(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void realizarMovimientios(Movimiento move) throws ConnectException, SQLException, CrearExcepcion {
       //NOs manda borrar el try catch
        this.openConnection();
        try {
            stmt = con.prepareStatement(RealizarMovimi); //////hay que cambiarlo


            stmt.setFloat(1, move.getCantidad());
            stmt.setFloat(2, move.getBalance());
            stmt.setString(3, move.getDescription());
            stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setInt(5, move.getId());

            stmt.executeUpdate();
          
        } catch (Exception e) {
            throw new CrearExcepcion("Error al Crear");
        }
        try{
            //stmt = con.prepareStatement(updateAccountBalance);//??????
            stmt.setFloat(1,move.getBalance());
            stmt.setLong(2,move.getId());
            stmt.executeUpdate();
        }catch (Exception ex){
            throw new CrearExcepcion("Error al modificar");
        }
        this.closeConnection();
    }
    

    //@Override
    public Movimiento consultarMovimientos(String id) throws ConnectException, SQLException, CrearExcepcion {
       Movimiento move = null;
        Collection<Movimiento> movimientos = new ArrayList<>();
        ResultSet rs = null;
        this.openConnection();
        
        try {
            stmt = con.prepareStatement(ConsultaMovimi);
            //stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                move = new Movimiento();
                move.setId(rs.getInt("movement.id"));
                
                move.setId(rs.getInt("movement.account_id"));
                //move.setTimeStamp(rs.getTimestamp("movement.timestamp"));
                move.setCantidad(rs.getFloat("movement.cantidad"));
                move.setBalance(rs.getFloat("movement.balance"));
                move.setDescription(rs.getString("movement.description"));
                movimientos.add(move);
                
            }

        } catch (Exception e) {
            throw new CrearExcepcion("Error al consultar");
        }
        this.closeConnection();
        
        return move;
    }

    @Override
    public void crearCuentaCliente() {
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
 

