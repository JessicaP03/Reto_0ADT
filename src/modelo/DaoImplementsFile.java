/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.annotations.Ignore;
import utilidades.MyObjectOutputStream;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public abstract class DaoImplementsFile implements Dao {

    File fitch = new File("fichero.txt");

    public void crearClientes(Cliente cliente, File fitch) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        MyObjectOutputStream moos = null;
        boolean continuar;
        Cliente clien;

        if (fitch.exists()) {
            try {
                //si el fichero ya existe
                fos = new FileOutputStream(fitch, true);
                moos = new MyObjectOutputStream(fos);

                do {
                    clien = new Cliente();
                    clien.setDatosCliente();
                    moos.writeObject(clien);
                    System.out.println("Quieres introducir mas clientes ");
                    continuar = Utilidades.esBoolean();
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
                moos = new MyObjectOutputStream(fos);

                do {
                    clien = new Cliente();
                    clien.setDatosCliente();
                    moos.writeObject(clien);
                    System.out.println("Quieres introducir mas clientes ");
                    continuar = Utilidades.esBoolean();
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


    public void leerDatosCliente(String id,File fitch) {

        FileInputStream fis;
        ObjectInputStream ois = null;
        Cliente clien;
        int numCliente;

        numCliente = Utilidades.calculoFichero(fitch);

        try {
            fis = new FileInputStream(fitch);
            ois = new ObjectInputStream(fis);

            for (int i = 0; i < numCliente; i++) {
                clien = (Cliente) ois.readObject();
                clien.getDatosCliente();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
                try {
                    ois.close();

                } catch (IOException ex) {
                    Logger.getLogger(DaoImplementsFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

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

    @Ignore
    public void crearClientes(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
