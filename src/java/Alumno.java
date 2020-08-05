/*
Est aclas enos va a servir para poder implementar POO y su atributo
de encapsulamiento para tener acceso a os datos que provienen de la tabla de alumno en la base de datos.
Para ello utilizaremos los métodos getters y setters.

Esta calse representa la tabla Alumno en la base de datos.
*/
public class Alumno 
{
 private int id;
 private String nombre,password,email,pais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
 
 
}
