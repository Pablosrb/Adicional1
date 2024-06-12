import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class KGen {
    static String data = ""; //Todos los genes
    static Map<String, Integer> misGenes = new HashMap<>();

    public static String readText(String fileName) {
        FileReader fr = null;
        Scanner sc = null;

        try {
            fr = new FileReader(fileName);
            sc = new Scanner(fr);


            // Para mirar si el archivo empieza con >, si este empieza no va a entrar en el if, así que no leerá la primera linea,
            if (!sc.nextLine().startsWith(">")) {
                data += sc.nextLine();
            }

            // Y aquí empezará a leer la segunda linea.
            while (sc.hasNextLine()) {
                data += sc.nextLine();
            }

            fr.close();
            fr = null;


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        return data;
    }

    public static Map<String,Integer> getKgenMap(int size){
        //Recorremos el contenido de data menos el tamaño que hemos especificado, porque si lo recorremos solo data.length nos va a dar un error, porque el substring no va a poder coger el segundo valor.
        for (int i = 0; i <= data.length() - size; i++) {
            //Cogemos el gen con el substring dependiendo del tamaño que le hemos asignado
            String gen = data.substring(i, i + size);


            if (misGenes.containsKey(gen)) { //Si este "gen" está
                misGenes.put(gen, misGenes.get(gen) + 1); //Coge el pone el gen, hace un get para coger el valor que tenia el gen(las veces que se ha repetido), y le suma uno.
            } else {
                misGenes.put(gen, 1); // Para cuando el gen sea nuevo, se inserta en el mapa con el valor 1.
            }

        }


        return misGenes;
    }
}