/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.Cliente;
import java.util.Scanner;

/**
 *
 * @author 2dam
 */
public class Aplication {
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Primero vamos a havcer un menú repetitivo mediante un metodo
        int opcion;
        do {
            opcion = menu();
        
            switch (opcion) {
            
                case 1:
                    //crearClientes(Cliente cliente);
                    break;
                
                case 2:
                    //leerDatosCliente(String id);
                    break;
                
                case 3:
                    //consultarCuentasCliente();
                    break;
                
                case 4:
                    //crearCuentaCliente();
                    break;
                
                case 5:
                    //agregarClienteCuenta();
                    break;
                
                case 6:
                    //consultarDatosCuenta(String id);
                    break;
                
                case 7:
                    //realizarMovimientios();
                    break;
                
                case 8:
                    //consultarMovimientos();
                    break;
            }
        }while (opcion != 9);
        System.out.println("Has salido");
    }

    private static int menu() {
       System.out.println("Elige que quieres hacer:");
       System.out.println("1.- Crear un cliente");
       System.out.println("2.- Leer datos de un cliente");
       System.out.println("3.- Consultar las cuentas del cliente");
       System.out.println("4.- Crear la cuenta de un cliente");
       System.out.println("5.- Agregar un cliente a una cuenta");
       System.out.println("6.- Consultar datos de una cuenta");
       System.out.println("7.- Hacer un movimiento");
       System.out.println("8.- Comnsultar lo movimientos");
       System.out.println("9.- Salir");
       return sc.nextInt();
    }
    
}
