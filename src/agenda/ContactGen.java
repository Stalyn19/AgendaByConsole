
package agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ContactGen {
    
    public static ArrayList<Persona> contactGen(int n){
         Random r=new Random();
        List<Persona> lContactos=new ArrayList<>();
        String[]nombre={"Miguel","Rosa","Jacko","Stalyn","Joel","Vincent","Jose","Frank","Luis","Juan"};
        String[]apellido={"Rosario","Marte","Perez","Manzueta","Rodriguez","Cleto","Mena","Franks","Louis","Juarez"};
        String[]email={"Miguel@gmail.com","Rosa@hotmail.com","Jacko@aol.com","Stalyn@live.com","Joel@msn.com","Vincent@outlook","Jose@tricom.com","Frank@alorica.net","Luis@gmail.com","Juan@hotmail.com"};
         for(int i=0;i<n;i++){
             Persona p=new Persona();
             p.setNombre(nombre[r.nextInt(nombre.length)]);
             p.setApellido(apellido[r.nextInt(apellido.length)]);
             p.setEmail(email[r.nextInt(email.length)]);
             p.setTelefono(Integer.toString((int)(Math.random()*1000000000)));
             lContactos.add(p);
         }
    return (ArrayList<Persona>) lContactos;
    }
    
}
