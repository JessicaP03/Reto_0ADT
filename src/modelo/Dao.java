/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;

import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author 2dam
 */

//FALTAN LOS DATOS QUE HAY QUE PASAR EN LOS DATOS 
public interface Dao {
    
    public void crearClientes(Cliente cliente);

    public void leerDatosCliente(Cliente cliente);
    
    public void consultarCuentasCliente();
    
    public void crearCuentaCliente(Cliente cliente, Cuenta ct);
    
    public void agregarClienteCuenta();
    
    public void consultarDatosCuenta(String id);
    
    public void realizarMovimientios();
    
    public void consultarMovimientos();
    
   
    
  
}
