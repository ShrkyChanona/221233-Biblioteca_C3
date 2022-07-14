package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public interface Prestable{

    Scanner opcion = new Scanner(System.in);
    public static Libros prestar(ArrayList<Libros> listaLib)
    {
        Libros.imprimirlistaLibros(listaLib);
        System.out.println("Ingrese el id del libro que desee prestar: ");
        int op = Integer.parseInt(opcion.nextLine());
        listaLib.get(op -1).setPrestado(true); //El libro creado cambiara el valor del atributo prestado a verdadero
        return listaLib.get(op -1); //Se resta menos 1 por la posicion del arreglo
    }
    
    public static Libros devolver(ArrayList<Libros> listaDevolver)
    {
        //Nuevo arreglo donde se pueda mandar los elementos que preste
        Libros.imprimirlistaLibros(listaDevolver);
        System.out.println("Ingrese la posicion del elemento del libro que desee devolver: \n" + "NOTA: Recuerde iniciar desde 0");
        int op = Integer.parseInt(opcion.nextLine());
        return listaDevolver.remove(op);
    }
    
    public static void prestado(ArrayList<Libros> prestados)
    {
        String librosPrestados = "";

        //Recorrer arreglos
        for (Libros l: prestados) {
            librosPrestados += "Id: " + l.getId() + "\t" + "Titulo: " + l.getTitulo() + "\t" + "Fecha de publicacion: " + l.getAño() + "\t" + " Codigo de libro: " + l.getCodigo() + "\n";
        }
        System.out.println(librosPrestados);
    }
}
