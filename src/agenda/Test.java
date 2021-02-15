package agenda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    static Persona persona;
    static String nombre;
    static String apellido;
    static String email;
    static String telefono;

    public static void main(String[] args) throws InputMismatchException{

        Scanner sc = new Scanner(System.in);
        AgendaImpl agenda = new AgendaImpl();
       // ContactGen.contactGen(100);
        boolean salir = false;

        do {

            agenda.menu();
            int opt = sc.nextInt();
            switch (opt) {
               
                case 1: {
                    System.out.println("Lista de contactos actual");
                
                    agenda.listasContactos().forEach(persona1 -> {
                        System.out.println(persona1);
                    });
                    break;
                }
                case 2: {
                    System.out.println("Ingrese nombre de contacto a buscar");
                    nombre = sc.next();
                    System.out.println(agenda.buscarContactoPorNombre(nombre));
                    break;
                }
                case 3: {
                    System.out.println("Ingrese telefono a buscar");
                    telefono = sc.next();
                    System.out.println(agenda.buscarContactoPorTelefono(telefono));
                    break;
                }
                case 4: {
                    System.out.println("Nombre a Actualizar");
                    nombre = sc.next();
                    System.out.println("Apellido a Actualizar");
                    apellido = sc.next();
                    System.out.println("Email a Actualizar");
                    email = sc.next();
                    System.out.println("Telefonoa Actualizar");
                    telefono = sc.next();
                    persona = new Persona(nombre, apellido, email, telefono);
                    agenda.actualizarContacto(persona, nombre, apellido, email, telefono);
                    System.out.println("Contacto " + nombre + " actualizado");
                    break;
                }
                case 5: {
                    System.out.println("Nombre a agregar");
                    nombre = sc.next();
                    System.out.println("Apellido a agregar");
                    apellido = sc.next();
                    System.out.println("Email a agregar");
                    email = sc.next();
                    System.out.println("Telefono a agregar");
                    telefono = sc.next();
                    persona = new Persona(nombre, apellido, email, telefono);
                    agenda.agregarContacto(persona);
                    System.out.println("Contacto " + nombre + " agregado");
                    break;
                }
                case 6: {
                    System.out.println("Ingrese telefono del contacto a borrar");
                    telefono = sc.next();
                    agenda.eliminarContacto(telefono);
                    System.out.println("Contacto eliminado");
                    break;
                }
                case 7: {
                    System.out.println("Esta seguro de borrar toda la lista de contactos esta accion no se puede dedacer");
                    System.out.println("1-Si");
                    System.out.println("2-No");
                    int num = sc.nextInt();
                    if (num == 1) {
                        agenda.borrarAgenda();
                        System.out.println("Se ha borrados todos los contactos, la lista esta vacia");
                    } else {
                        System.out.println("No se han borrado los contactos");
                    }

                    break;
                }
                case 8: {
                    System.out.println("Fin del programa");
                    salir = true;
                    break;}
                    case 9:{
                    System.out.println("Generar Contactos Aleatorios");   
                        System.out.println("Cantidad de contactos a generar");
                    int i=sc.nextInt();
                    ContactGen.contactGen(i);
                    break;}
                
                default: {
                    System.out.println("Opcion no validad intente de nuevo");
                    break;
                }
          
       }
        } while (salir == false);

    }
}
