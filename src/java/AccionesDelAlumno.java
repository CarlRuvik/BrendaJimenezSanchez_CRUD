/*
Esta clase representa todas las operaciones que se pueden realizar con los datos del alumno dentro del preograma
para poder establecer los métodos y operaciones conforme al encapsulamiento.
*/
import java.util.*;
import java.sql.*;

public class AccionesDelAlumno 
{
    public static Connection getConnection()//Clase que nos genera la conexión a la BD
    {
        String url,username,password;
        //Ruta donde se ubica la BD y los datos de acceso
        url="jdbc:mysql://localhost:3306/alumnos";
        username="root";
        password="Enderman7";
        
        //Creamos un objeto para la conexión.
        Connection conexion=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //Establecemos la conexión.
            conexion=DriverManager.getConnection(url,username,password);
            
            //Para saber si se conectó:
            System.out.println("Conexión existosa a la BD.");
        }
        catch(Exception e)
        {
            System.out.println("Error en la conexión a la BD.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }
    
    //Guardar nuevo alumno
    public static int GuardarAlumno(Alumno a)
    {
        int estado=0;
        try
        {
            //Establecemos conexión con la BD:
            Connection conexion=AccionesDelAlumno.getConnection();

            //Creamos el query para insertar nuevo alumno:
            String query="INSERT INTO alumno(nombre_alumno,pass_alumno,email_alumno,pais_alumno) VALUES(?,?,?,?)";
            
            //Obtenemos los valores que epecificamos en el query(atributos):
            //Preparamos la sentencia
            PreparedStatement PS=conexion.prepareStatement(query); 
            
            //Con ayuda de los getters y setters
            PS.setString(1,a.getNombre());
            PS.setString(2,a.getPassword());
            PS.setString(3,a.getEmail());
            PS.setString(4,a.getPais());
            
            //Ejecutamos la query que preparamos:
            estado=PS.executeUpdate();
            
            //Cerramos conexión
            conexion.close();
            System.out.println("Alumno registrado con éxito.");
        }
        catch(Exception e)
        {
            System.out.println("Error al registrar el alumno.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return estado;
    }

    //Editar datos del alumno
    public static int ModificarDatosDelAlumno(Alumno a)
    {
        int estado=0;
        try
        {
            //Establecemos conexión con la BD:
            Connection conexion=AccionesDelAlumno.getConnection();

            //Creamos el query para insertar nuevo alumno:
            String query="UPDATE alumno SET nombre_alumno=?,pass_alumno=?,email_alumno=?,pais_alumno=? WHERE id_alumno=?";
            
            //Obtenemos los valores que epecificamos en el query(atributos):
            //Preparamos la sentencia
            PreparedStatement PS=conexion.prepareStatement(query); 
            
            //Con ayuda de los getters y setters
            PS.setString(1,a.getNombre());
            PS.setString(2,a.getPassword());
            PS.setString(3,a.getEmail());
            PS.setString(4,a.getPais());
            PS.setInt(5,a.getId());
            
            //Ejecutamos la query que preparamos:
            estado=PS.executeUpdate();
            
            //Cerramos conexión
            conexion.close();
            System.out.println("Datos del alumno actualizados con éxito.");
        }
        catch(Exception e)
        {
            System.out.println("Error al alctualizar datos del alumno.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return estado;
    }
        
    //Borrar alumno
    public static int BorrarAlumno(int id)
    {
        int estado=0;
        try
        {
            //Establecemos conexión con la BD:
            Connection conexion=AccionesDelAlumno.getConnection();

            //Creamos el query para insertar nuevo alumno:
            String query="DELETE FROM alumno WHERE id_alumno=?";
            //Si fuera procedimiento almacenado: query="call nombre_procedimiento(?)"
            
            //Obtenemos los valores que epecificamos en el query(atributos):
            //Preparamos la sentencia
            PreparedStatement PS=conexion.prepareStatement(query); 
            
            //Con ayuda de los getters y setters
            PS.setInt(1,id);
            
            //Ejecutamos la query que preparamos:
            estado=PS.executeUpdate();
            
            //Cerramos conexión
            conexion.close();
            System.out.println("Alumno eliminado con éxito.");
        }
        catch(Exception e)
        {
            System.out.println("Error al eliminar el alumno.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return estado;
    }
        
    //Consultar alumno por id
    public static Alumno getAlumnoById(int id)
    {
        Alumno a=new Alumno();
        try
        {
            //Establecemos conexión con la BD:
            Connection conexion=AccionesDelAlumno.getConnection();

            //Creamos el query para insertar nuevo alumno:
            String query="SELECT*FROM alumno WHERE id_alumno=?";
            
            //Obtenemos los valores que epecificamos en el query(atributos):
            //Preparamos la sentencia
            PreparedStatement PS=conexion.prepareStatement(query); 
            
            //Con ayuda de los getters y setters
            PS.setInt(5,id);
            
            //Ejecutamos la consulta que preparamos:
            ResultSet RS=PS.executeQuery();
            
            //Buscamos el alumno por el id:
            if(RS.next())
            {
                //Obtenemos los elementos de la tabla a partir de el objeto a.
                a.setId(RS.getInt(1));
                a.setNombre(RS.getString(2));
                a.setPassword(RS.getString(3));
                a.setEmail(RS.getString(4));
                a.setPais(RS.getString(5));
            }
            
            //Cerramos conexión
            conexion.close();
            System.out.println("Alumno encontrado con éxito.");
        }
        catch(Exception e)
        {
            System.out.println("Alumno NO encontrado.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return a;
    }
    
    //Consultar todos los alumnos
    public static List<Alumno> getAllAlumnos()
    {
        //Lista a partir de un array
        List<Alumno> lista=new ArrayList<Alumno>();
        try
        {
            //Establecemos conexión con la BD:
            Connection conexion=AccionesDelAlumno.getConnection();

            //Creamos el query para insertar nuevo alumno:
            String query="SELECT*FROM alumno";
            
            //Obtenemos los valores que epecificamos en el query(atributos):
            //Preparamos la sentencia
            PreparedStatement PS=conexion.prepareStatement(query); 
            
            //Ejecutamos la query que preparamos:
            ResultSet RS=PS.executeQuery();
            
            //Obtenemos toda la lista de alumnos que hay en la tabla alumno:
            while(RS.next())
            {
                Alumno a=new Alumno();
                
                a.setId(RS.getInt(1));
                a.setNombre(RS.getString(2));
                a.setPassword(RS.getString(3));
                a.setEmail(RS.getString(4));
                a.setPais(RS.getString(5));
                
                //Agregamos los datos obtenidos a la lista
                lista.add(a);
            }
            
            //Cerramos conexión
            conexion.close();
            System.out.println("Búsqueda existosa");
        }
        catch(Exception e)
        {
            System.out.println("Error al buscar.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return lista;
    }
    
}

