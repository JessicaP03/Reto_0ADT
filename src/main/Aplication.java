
package main;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimiento;
import static java.awt.SystemColor.control;
import java.util.Collection;
import java.util.ResourceBundle;
import modelo.*;
import utilidades.Utilidades;


/*
 * @author Grupo JJDA
 * Esta clase esta destinada a mostrar un menu al usuario y a llamar a los metodos
 */
public class Aplication {
/*
 * Aqui decidimos si los datos se implementaran en el fichero o la base de datos
 *Para decidir si se va a trabajar desde la base de datos o fichero, en el archivo de propiedades tendremos que cambiar el valor de 'Modo_BD'
 */
    public static void main(String[] args) throws Exception {
        ResourceBundle data;
        String BD = "BD";
        String File = "Fich";
        /**
         * Modelo donde dependiendo de la opcion ejecuta una de las formas
         * @see menuPrincipal();
         */
       String forma = ResourceBundle.getBundle("modelo.configuracion").getString("Modo_BD");
       if(BD.equals(forma)){
           Dao dataBD = new DaoImplementsBD();
           menuPrincipal(dataBD);
       }else{
           Dao dataFile = new DaoImplementsFile();
           menuPrincipal(dataFile);
       }
        /**
         * Menu en el cual el usuario podrá elegir la opción que desee
         * @see menuPrincipal();
         */
    }
    

    private static void menuPrincipal(Dao data) throws Exception {
        
        int opcMenu;
        
        do{
            System.out.println("***Menu Principal****");
            System.out.println("\t1. Crear cliente");
            System.out.println("\t2. Consultar datos de un cliente");
            System.out.println("\t3. Consultar cuentas de un cliente");
            System.out.println("\t4. Crear cuenta para cliente");
            System.out.println("\t5. Agregar cliente a cuenta");
            System.out.println("\t6. Consultar datos de una cuenta");
            System.out.println("\t7. Realizar un movimiento");
            System.out.println("\t8. Consultar los movimientos de una cuenta");
            System.out.println("\t9. Salir");
            opcMenu = Utilidades.leerInt();
            
            
            switch (opcMenu){
                case 1:
                    /**
                     * Metodo destinado a la creacion de un nuevo cliente
                     * @see createCustomer();
                     */
                    createCustomer(data);
                    break;
                case 2:
                    /**
                     * Metodo destinado a la consulta de la informacion de un cliente
                     * @see consultCustomerData();
                     */
                    consultCustomerData(data);
                    break;
                case 3:
                    /**
                     * Metodo que permite consultar las cuentas de un cliente en cuestion
                     * @see ConsultClientAccounts();
                     */
                    ConsultClientAccounts(data);
                    break;
                case 4:
                    /**
                     * Metodo que permite Crear una cuenta a un cliente
                     * @see createCustomerAccount();
                     */
                    createCustomerAccount(data);
                    break;
                case 5:
                    /**
                     * Metodo que permite añadir a un cliente a una cuenta
                     * @see AddCustomerToAccount();
                     */

                    AddCustomerToAccount(data);
                    break;
                case 6:
                    /**
                     * Metodo el cual permite consultar los detalles de una cuenta en cuestion
                     * @see consultAccountDetails();
                     */
                    consultAccountDetails(data);
                    break;
                case 7:
                    /**
                     * Metodo que permite hacer un movimiento sobre una cuenta
                     * @see makeMovement();
                     */
                    makeMovement(data);
                    break;
                case 8:
                    /**
                     * Metodo que permite consultar los movimientos sobre una cuenta
                     * @see consultAccountMovements();
                     */
                    consultAccountMovements(data);
                    break;
                case 9:
                    System.out.println("Fin de la ejecucion");
                    break;
                default:
                    System.out.println("Introduzca una opcion valida");
                    break;
            }
        }while (opcMenu != 9);
    }
/*
 * Aqui se hacen las llamadas a los metodos
 */
    private static void createCustomer(Dao data) throws Exception {
        Cliente cus;
        Long id_cus;
        cus = new Cliente();
        cus.setDatosCliente();
        id_cus = data.createCustomer(cus);
        System.out.println("La id de cliente que se te ha asignado es: "+id_cus);
    }

    private static void consultCustomerData(Dao data) throws Exception {
        Cliente cus;
        Long id_cus;
        id_cus=Utilidades.leerLong("Introduce la id del cliente: ");
        cus = data.consultCustomer(id_cus);
        if(cus != null){
            cus.getDatosCliente();
        }else{
            
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void ConsultClientAccounts(Dao data) throws Exception {
        Cliente cus;
        Collection<Cuenta> accounts;
        Long id_cus;
        id_cus=Utilidades.leerLong("Introduce la id del cliente: ");
        cus = data.consultCustomer(id_cus);
        
        if(cus != null){
            accounts = data.consultAccounts(id_cus);
            for(Cuenta acc : accounts){
                acc.getDatosCuenta();
            }
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void createCustomerAccount(Dao data) throws Exception {
        Cliente cus;
        Cuenta acc;
        Long id_cus,id_acc;
        id_cus=Utilidades.leerLong("Introduce la id del cliente: ");
        cus = data.consultCustomer(id_cus);
        if(cus != null){
            acc = new Cuenta();
            acc.setDatosCuenta();
            id_acc = data.createAccount(id_cus,acc);
            System.out.println("La id de la cuenta creada es: "+id_acc);
            
           
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void AddCustomerToAccount(Dao data) throws Exception {
        Cliente cus;
        Cuenta acc;
        Long id_cus,id_acc;
        id_cus=Utilidades.leerLong("Introduce la id del cliente:");
        cus = data.consultCustomer(id_cus);
        if(cus != null){
            id_acc=Utilidades.leerLong("Introduce la id de la cuenta:");
            acc = data.consultDataAccount(id_acc);
            if(acc != null){
                data.createCustomerAccount(id_cus,id_acc);
                System.out.println("Se agrego el cliente a la cuenta");
            }else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void consultAccountDetails(Dao data) throws Exception {
        Cuenta acc;
        Long id_acc;
        id_acc = Utilidades.leerLong("Introduce la id de la cuenta:");
          acc = data.consultDataAccount(id_acc);
           if(acc != null){
               acc.getDatosCuenta();
           } else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
    }

    private static void makeMovement(Dao data) throws Exception {
        Movimiento mov = new Movimiento();
        Cuenta acc;
        Long id_acc;
        id_acc = Utilidades.leerLong("Introduce la id de la cuenta a la que se le va a hacer el movimiento:");
        acc = data.consultDataAccount(id_acc);
        if(acc != null){
            mov.setDatosMovimiento(id_acc,acc.getBalance());
            data.createMovement(mov);
            
        }else{
            System.out.println("La id introducida no corresponde a ninguna cuenta");
        }
        
    }

    private static void consultAccountMovements(Dao data) throws Exception {
        Long id_acc;
        Cuenta acc;
        Collection<Movimiento> movements;
        id_acc = Utilidades.leerLong("Introduce la id de la cuenta:");
            acc = data.consultDataAccount(id_acc);
            if(acc != null){
                movements = data.consultMovements(id_acc);
                for(Movimiento mov : movements){
                    mov.getDatosMovimiento();
                }
           } else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
    }
   
    
}