import java.util.ArrayList;
import java.util.Scanner;
import Entidades.Persona;


public class Menu {
    
    public static void main(String[] args) throws Exception {
       

        Scanner entrada = new Scanner(System.in);
        ArrayList<Persona> listaPersona = new ArrayList<>();
        boolean exit = false;
        while (!exit) {
            System.out.println("INGRESE UNA OPCION");
            System.out.println("1. CREAR USUARIO");
            System.out.println("2. LISTAR USUARIO");
            System.out.println("3. ELIMINAR USUARIO");
            System.out.println("4. MODIFICAR USUARIO");
            System.out.println("0. SALIR");
            int opt = Integer. parseInt(entrada.nextLine());
            switch (opt) {
                case 1:
                Persona p = new Persona();
                System.out.println("INGRESE NOMBRE DEL USUARIO");
                p.setNombre(entrada.nextLine());
                System.out.println("INGRESE PRIMER APELLIDO");
                p.setAp_paterno(entrada.nextLine());
                System.out.println("INGRESE SEGUNDO APELLIDO");
                p.setAp_materno(entrada.nextLine());
                System.out.println("INGRESE SU DIRECCION");
                p.setDireccion(entrada.nextLine());
                listaPersona.add(p);
                System.out.println("USUARIO CREADO");
                System.out.println("NOMBRE " + p.getNombre());
                System.out.println("APELLIDOS " + p.getAp_paterno()+" "+p.getAp_materno());
                System.out.println("DIRECCION " + p.getDireccion());
                break;
                case 2:
                for (int i = 0; i <listaPersona.size(); i++) {
                    System.out.println("USUARIO " +(i+1));
                    Persona a = listaPersona.get(i);
                    System.out.println("NOMBRE " + a.getNombre());
                    System.out.println("APELLIDOS " + a.getAp_paterno()+" " + a.getAp_materno());
                    System.out.println("NOMBRE " + a.getDireccion());
                    
                   
                }
                break;
                case 3:
                System.out.println("INGRESE EL NOMBRE DEL USUARIO A ELIMINAR");
                String nombre = entrada.nextLine();
                for (int i = 0; i <listaPersona.size(); i++) {
                Persona a = listaPersona.get(i);
                if (nombre.equals(a.getNombre())){
                    listaPersona.remove(i);
                    System.out.println("USUARIO ELIMINADO");
                    
                }
                }
                break;
                case 4: 
                System.out.println("INGRESE NOMBRE DE USUARIO MODIFICAR");
                nombre = entrada.nextLine();
                for (int i = 0; i <listaPersona.size(); i++){
                    Persona a = listaPersona.get(i);
                    if (nombre.equals(a.getNombre())){
                        System.out.println("INGRESE NUEVO NOMBRE");
                        String Nombre = entrada.nextLine();
                        System.out.println("INGRESE PRIMER APELLIDO");
                        String Ap_paterno = entrada.nextLine();
                        System.out.println("INGRESE SEGUNDO APELLIDO");
                        String Ap_materno = entrada.nextLine();
                        System.out.println("INGRESE DIRECCION");
                        String Direccion = entrada.nextLine();
                        a.setNombre(Nombre);
                        a.setAp_paterno(Ap_paterno);
                        a.setAp_materno(Ap_materno);
                        a.setDireccion(Direccion);

                    }
                }
                break;
                case 0:
                exit = true;
                System.out.println("SALIENDO DEL PROGRAMA");
                break;
                default:
                System.out.println("OPCION INVALIDA:");



                
                


            }
        }
    }
}
