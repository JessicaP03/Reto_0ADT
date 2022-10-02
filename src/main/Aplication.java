
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
import modelo.Dao;
import modelo.DaoImplementsFile;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Aplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        int opc;
        int cont;

        Dao dao = new DaoImplementsFile();
        Cliente cliente = new Cliente();

        do {
            opc = menu();

            switch (opc) {
                case 1:
                    crearClientes(dao);
                    break;
                case 2:

                    leerDatosCliente(dao);

                    break;
                case 3:

                    //    modifNumCamasOcup();
                    break;
                case 4:

                    //  mostrarListaEspecialid();
                    break;
                case 5:
                    System.out.println("Usted saldra del programa");
                    break;
                default:
                    System.out.println("La opcion introducida no corresponde a ninguna de las existentes");
                    break;
            }
        } while (opc != 5);
    }

    private static int menu() {
        int resp = 0;
        System.out.println("Elige que quieres hacer:");
        System.out.println("1.- Crear un cliente");
        System.out.println("2.- Leer datos de un cliente");
        System.out.println("3.- Consultar las cuentas del cliente");
        System.out.println("4.- Crear la cuenta de un cliente");
        System.out.println("5.- Agregar un cliente a una cuenta");
        System.out.println("6.- Consultar datos de una cuenta");
        System.out.println("7.- Hacer un movimiento");
        System.out.println("8.- Comnsultar los movimientos");
        System.out.println("9.- Salir");
        resp = utilidades.Utilidades.leerInt("Introduce la opcion de menu");
        return resp;
    }

    private static void crearClientes(Dao dao) throws Exception {
        Cliente clt = new Cliente();
        clt.setDatosCliente();
        dao.createCustomer(clt);
        

    }

    private static void leerDatosCliente(Dao dao) throws Exception {
        
        Cliente cliente;
        int id = Utilidades.leerInt("Introduceme el id del que queiras saber los datos ");
        cliente = dao.consultCustomer(id);
        cliente.getDatosCliente();
    }

}