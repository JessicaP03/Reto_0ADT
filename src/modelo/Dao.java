/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimiento;
import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import java.util.Collection;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author 2dam
 */
public interface Dao {
   public Long createCustomer(Cliente cust)throws Exception;
   public Cliente consultCustomer(Long id)throws Exception;
   public Collection<Cuenta> consultAccounts(Long idCustom)throws Exception;
   public Long createAccount(Long id, Cuenta account)throws Exception;
   public void createCustomerAccount(Long id, Long id_acc)throws Exception;
   public Cuenta consultDataAccount(Long id)throws Exception;
   public void createMovement(Movimiento move)throws Exception;
   public Collection<Movimiento> consultMovements(Long id)throws Exception;
}
