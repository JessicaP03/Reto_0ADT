
package main;
//Implementamos los implementos de Dao
import java.util.Enumeration;
import java.util.ResourceBundle;
import modelo.DaoImplementsBD;
import modelo.DaoImplementsFile;
import utilidades.Utilidades;

public class Aplication {
    //Creamos las propiedades necesarias para poder llamar al fichero y sus contenidos
    private ResourceBundle data;
    private final String BD = "bd_type";
    private final String File = "file_type";
    //Creamos este método para detectar si la aplicación se va hacer por ficheros o base de datos
    public String eleccion(){
        
        data = ResourceBundle.getBundle("utilidades.runConfiguration.properties");
        if (BD.equals(data.getString("bd_type"))){
            DaoImplementsBD daoBD = new DaoImplementsBD();
                return daoBD.toString();
        }else if(File.equals(data.getString("file_type"))){
            DaoImplementsFile daoFile = new DaoImplementsFile();
                return daoFile.toString();
        }
       return data.toString();
    }
    
    public void leerData(){
        System.out.println(data);
    }
    
    
    public static void main(String[] args) {
       /*Aplication metodo = new Aplication();
       metodo.leerData();*/
       ResourceBundle fich = ResourceBundle.getBundle("utilidades.runConfiguration");
       Enumeration <String> keys = fich.getKeys();
       while (keys.hasMoreElements()) {
           String key = keys.nextElement();
           String value = fich.getString(key);
           System.out.println(key + ": " + value);
       }
       
    }
    
}
