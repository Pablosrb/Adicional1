import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename;

        boolean salir = true;
        do {
            System.out.println("1. Abrir FASTA");
            System.out.println("2. Crear mapa de Gen");
            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 1){
                System.out.println("Introduce la ruta del fichero FASTA: ");
                filename = sc.nextLine();

                if (filename.endsWith(".fasta")) {
                    KGen.readText(filename);
                } else {
                    System.out.println("El archivo debe tener la extensión .fasta");
                }


            } else if (menu == 2) {
                System.out.println("Introduce el tamaño del Gen");

                try {   // Con esto controlamos que el usuario ponga un numero, porque si el usuario pone una letra, se saldría del programa, así que con este try controlamos que el usuario ponga un número
                    int size = Integer.parseInt(sc.nextLine());

                    if (size > 0) { //Controlamos que el numero sea mayor a 0, y que no sea menor.
                        KGen.getKgenMap(size); //Llamamos al metodo
                        Map<String, Integer> misGenes = KGen.misGenes; // Cogemos el mapa y creamos uno nuevo en el Main

                        for (String miGen : misGenes.keySet()) { // Recorremos el mapa cogiendo el gen y el contenido de este.
                            System.out.println( miGen + " : " + misGenes.get(miGen));
                        }


                    } else {
                        System.out.println("Tiene que ser un número mayor a 0");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("No se ha introducido el numero correctamente");

                }

            } else {
                System.out.println("Saliendo...");
                salir = false;
            }



        } while (salir);

    }
}