package agenda;

import java.util.Iterator;
import java.util.List;
//Este ejercicio es una agenda telefononica para su uso por consola

public class AgendaImpl implements AgendaInterfaz {

    List<Persona> contactos;

    public AgendaImpl() {
        contactos = ContactGen.contactGen(100);
    }

    @Override//Imprime la lista de personas
    public List<Persona> listasContactos() {
        return this.contactos;
    }

    @Override//Busca el contacto por nombre
    public Persona buscarContactoPorNombre(String nombre) {
        Iterator<Persona> it = contactos.iterator();
        while (it.hasNext()) {
            Persona p = it.next();
            if (p.getNombre().compareTo(nombre) == 0) {
                return p;
            }
        }

        return null;
    }

    @Override//Busca el contacto por telefono
    public Persona buscarContactoPorTelefono(String telefono) {
        Iterator<Persona> it = contactos.iterator();
        while (it.hasNext()) {
            Persona p = it.next();
            if (p.getNombre().compareTo(telefono) == 0) {
                return p;
            }
        }

        return null;
    }

    @Override//actualiza el contacto
    public void actualizarContacto(Persona persona, String nombre, String apellido, String email, String telefono) {
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setEmail(email);
        persona.setTelefono(telefono);

        if (persona.getTelefono().compareTo(this.buscarContactoPorTelefono(telefono).getTelefono()) == 0) {
            this.eliminarContacto(telefono);
            this.contactos.add(persona);
        } else {
            System.out.println("Dicho contacto no existe");
        }

    }

    @Override//Elimina un contacto
    public void eliminarContacto(String telefono) {
        if (this.buscarContactoPorTelefono(telefono) == null) {
            System.out.println("Este contacto no existe");
        }
        this.contactos.remove(this.buscarContactoPorTelefono(telefono));
    }

    @Override//Muestra un menu en consola
    public void menu() {
        System.out.println("|--------------------------------------------|");
        System.out.println("|     Ejercicio Agenda por Consola           |");
        System.out.println("|                                            |");
        System.out.println("|1- Mostrar lista con todos los contactos    |");
        System.out.println("|2- Buscar Contacto por Nombre               |");
        System.out.println("|3- Buscar Contacto por Telefono             |");
        System.out.println("|4- Actualizar Contacto                      |");
        System.out.println("|5- Agregar Contacto                         |");
        System.out.println("|6- Borrar un Contacto                       |");
        System.out.println("|7- Borrar Agenda Completa                   |");
        System.out.println("|8- Salir del Programa                       |");
        System.out.println("|--------------------------------------------|");

    }

    @Override//AGrega un contacto a la lista
    public void agregarContacto(Persona persona) {

        if (this.buscarContactoPorTelefono(persona.getTelefono()) == null) {
            this.contactos.add(persona);
        } else {
            System.out.println("Este contacto ya existe");
        }
    }

    @Override//Borra la lista completa
    public void borrarAgenda() {
        contactos.clear();
    }

}
