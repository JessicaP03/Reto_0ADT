/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.annotations.Ignore;
import utilidades.MyObjectOutputStream;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class DaoImplementsFile implements Dao {

    private final File fitch = new File("fichero.txt");

    @Override
    public void consultarCuentasCliente() {
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

    @Override
    public void crearClientes(Cliente cliente) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        MyObjectOutputStream moos = null;
        boolean continuar;
        // Cliente clien;

        if (fitch.exists()) {
            try {
                //si el fichero ya existe
                fos = new FileOutputStream(fitch, true);
                moos = new MyObjectOutputStream(fos);

                do {

                    System.out.println("Quieres introducir mas clientes ");
                    continuar = Utilidades.esBoolean();
                    moos.writeObject(cliente);
                } while (continuar);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                //si el fichero no existe
                fos = new FileOutputStream(fitch);
                oos = new MyObjectOutputStream(fos);

                do {

                    System.out.println("Quieres introducir mas clientes ");
                    continuar = Utilidades.esBoolean();
                    oos.writeObject(cliente);
                } while (continuar);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    oos.flush();
                    oos.close();
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    private boolean existeCuenta(int id, File fitch) {

        boolean encontrado = false;
        Cuenta cuentas;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fitch);
            ois = new ObjectInputStream(fis);

            do {

                cuentas = new Cuenta();
                cuentas = (Cuenta) ois.readObject();
                if (cuentas.getId() == (id)) {
                    encontrado = true;
                    cuentas.getDatosCuenta();
                }

            } while (fis.available() >= 1 && !encontrado);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ois.close();
            fis.close();
        } catch (IOException ex) {
            Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encontrado;
    }

    @Override
    public Cliente leerDatosCliente(int id) {
        FileInputStream fis;
        ObjectInputStream ois = null;
        Cliente cliente;
        int numCliente;
        // int id;

        numCliente = Utilidades.calculoFichero(fitch);
        // id = Utilidades.leerInt("Introduceme el id del que queiras saber los datos ");
        try {
            fis = new FileInputStream(fitch);
            ois = new ObjectInputStream(fis);

            for (int i = 0; i < numCliente; i++) {
                cliente = (Cliente) ois.readObject();

                if (cliente.getId() == id) {
                    return cliente;
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();

            } catch (IOException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    @Override
    public void crearCuentaCliente(Cliente clte, Cuenta ct) {
        //  ArrayList<Cuenta> cuentas = new ArrayList<>();
        Cuenta datosC;
        boolean continuar;
        boolean encontrado;
        int cont;
        int idCuenta;

        if (fitch.exists()) {
            FileOutputStream fos = null;
            MyObjectOutputStream moos = null;
            try {
                fos = new FileOutputStream(fitch, true);
                moos = new MyObjectOutputStream(fos);
                cont = Utilidades.calculoFichero(fitch);
                idCuenta = Utilidades.leerInt("Introduzca su id de cliente ");
                encontrado = existeCuenta(idCuenta, fitch);

                if (encontrado) {
                    System.out.println("esta cuenta ya existe ");
                } else {

                    datosC = new Cuenta();
                    datosC.setDatosCuenta(idCuenta);
                    moos.writeObject(datosC);

                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                moos.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            try {
                fos = new FileOutputStream(fitch);
                oos = new MyObjectOutputStream(fos);
                idCuenta = Utilidades.leerInt("Introduzca su id de cliente ");
                datosC = new Cuenta();
                datosC.setDatosCuenta(idCuenta);
                oos.writeObject(datosC);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
