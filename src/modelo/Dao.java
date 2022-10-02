/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimiento;
import java.util.Collection;
/*
 * @author Grupo JJDA
 * Esta es la interfaz Dao, donde se recogen los metodos
 */
public interface Dao {
   public Long createCustomer(Cliente cust)throws Exception;
   public Cliente consultCustomer(long id)throws Exception;
   public Collection<Cuenta> consultAccounts(Long idCustom)throws Exception;
   public Long createAccount(Long id, Cuenta account)throws Exception;
   public void createCustomerAccount(Long id, Long id_acc)throws Exception;
   public Cuenta consultDataAccount(Long id)throws Exception;
   public void createMovement(Movimiento move)throws Exception;
   public Collection<Movimiento> consultMovements(Long id)throws Exception;
}