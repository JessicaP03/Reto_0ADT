/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author 2dam
 */
public class CrearExcepcion extends Exception{
    
    private static final long serialVersionUID = 1L;

	public CrearExcepcion(String message) {
		super(message);
	}
    
}
