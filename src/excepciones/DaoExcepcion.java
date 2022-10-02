/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;
    /**
     * Esta clase es para una de las excepciones de la base de datos
     */
public class DaoExcepcion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoExcepcion(String message) {
		super(message);
	}
	
}
