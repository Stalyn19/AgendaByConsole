
package agenda;

import java.util.List;


public interface AgendaInterfaz {
    
    public List<Persona> listasContactos();
    public Persona buscarContactoPorNombre(String nombre);
    public Persona buscarContactoPorTelefono(String telefono);
    public void agregarContacto(Persona persona);
    public void actualizarContacto(Persona persona, String nombre, String apellido, String email, String telefono);
    public void eliminarContacto(String telefono);
    public void borrarAgenda();
    public void menu();
}
