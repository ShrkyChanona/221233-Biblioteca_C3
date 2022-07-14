package biblioteca;

import jdk.swing.interop.SwingInterOpUtils;

//Librerias
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Biblioteca {

    public static void main(String[] args) {
        //Arreglos
        ArrayList<Libros> listaLibro = new ArrayList<>();
        ArrayList<Revistas> listaRevista = new ArrayList<>();
        ArrayList<Libros> libroPrestado = new ArrayList<>();

        //Objetos
        Scanner datos = new Scanner(System.in);
        Random random = new Random();

        //Atributos
        String codigo,titulo, año;
        int opcion;

        do
        {

            System.out.println("**************** MENU *****************");
            System.out.println("1.- Crear Libro");
            System.out.println("2.- Crear Revista ");
            System.out.println("3.- Prestar libro");
            System.out.println("4.- Lista de libros prestados");
            System.out.println("5.- Devolver libro");
            System.out.println("6.- Salir");
            opcion = Integer.parseInt(datos.nextLine());

            switch(opcion)
            {
                case 1:
                    // Creacion de libros
                    System.out.println("Titulo: ");
                    titulo = datos.nextLine();
                    System.out.println("Fecha de publicacion: ");
                    año = datos.nextLine();
                    codigo = String.valueOf(random.nextInt()); // generar un numero aleatorio
                    listaLibro.add(new Libros(codigo,titulo,año));
                    break;
                case 2:
                    //Creacion de Revistas
                    int numero;
                    System.out.println("Titulo: ");
                    titulo = datos.nextLine();
                    System.out.println("Fecha de publicacion: ");
                    año = datos.nextLine();
                    System.out.println("Numero de revista: ");
                    numero = datos.nextInt();
                    codigo = String.valueOf(random.nextInt());

                    listaRevista.add(new Revistas(codigo,titulo,año,numero));
                    break;
                case 3:
                    //Solicitar prestamo
                    libroPrestado.add(Prestable.prestar(listaLibro));
                    break;
                case 4:
                    Prestable.prestado(libroPrestado);
                    break;
                case 5:
                    libroPrestado.remove(Prestable.devolver(libroPrestado));
                    break;
                case 6:
                        System.exit(0);
                        break;
                default:
                    System.out.println("El numero de opcion no fue encontrado, por favor intentelo de nuevo");
                    break;
            }

        }while(opcion != 6);
    }
    
}
