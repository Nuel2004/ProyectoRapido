import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Concesionario {
    static Scanner sc = new Scanner(System.in);
    static String carpetaSeleccionada = "";
    static List<Map<String, String>> datos = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        menu();
        //seleccionarCarpeta();
        //leerFichero();
        //convertirFormato();
        //obtenerExtension(carpetaSeleccionada);
        //leerCsv(carpetaSeleccionada);
        //leerJson(carpetaSeleccionada);
        //leerXml(carpetaSeleccionada);
        //exportarCsv(carpetaSeleccionada);
        //exportarJson(carpetaSeleccionada);
        //exportarXml(carpetaSeleccionada);
    }

    private static void exportarXml(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarXml'");
    }

    private static void exportarJson(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarJson'");
    }

    private static void exportarCsv(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarCsv'");
    }

    // Este método lee un archivo XML.
    // Cada elemento `<item>` se convierte en un mapa con claves y valores extraidos
    // de las etiquetas.
    public static void leerXml(String path) {
        // Lee un archivo XML básico.
        // Cada elemento <item> se convierte en un mapa con claves y valores extraidos
        // de las etiquetas.
        // Los datos se almacenan en la lista de mapas.
        System.out.println("Leyendo archivo XML...");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            Map<String, String> fila = null;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("<item>")) {
                    fila = new HashMap<>();
                } else if (linea.startsWith("</item>")) {
                    if (fila != null)
                        datos.add(fila);
                } else if (fila != null && linea.startsWith("<") && linea.contains(">")) {
                    String key = linea.substring(1, linea.indexOf(">"));
                    String value = linea.substring(linea.indexOf(">") + 1, linea.lastIndexOf("<"));
                    fila.put(key, value);
                }
            }
            System.out.println("Archivo XML leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void leerJson(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerJson'");
    }

    // Este metodo lee un archivo CSV.
    // Los encabezados de la primera linea se usan como claves, y las siguientes
    // lineas como valores.
    public static void leerCsv(String path) {
        // Lee un archivo CSV linea por linea.
        // La primera linea se utiliza como encabezados y las siguientes como datos.
        // Los datos se almacenan en la lista de mapas.
        System.out.println("Leyendo archivo CSV...");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea = br.readLine();
            if (linea != null) {
                String[] headers = linea.split(","); // Obtenemos los encabezados del CSV.
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split(",");
                    Map<String, String> fila = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        fila.put(headers[i], valores[i]); // Asociamos cada valor con su encabezado.
                    }
                    datos.add(fila);
                }
            }
            System.out.println("Archivo CSV leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void obtenerExtension(String carpetaSeleccionada2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerExtension'");
    }

    private static void convertirFormato() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertirFormato'");
    }

    private static void leerFichero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leerFichero'");
    }

    private static void seleccionarCarpeta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seleccionarCarpeta'");
    }



    public static String menu(){
        String tVerde = "\u001B[32m";
        String fBlanco = "\u001B[32;40m";
        String reset = "\u001B[0m";
        String menu= tVerde +"-----------------------------------\n"
                            + "|                                 |\n"
                            + "|    "+fBlanco+"Bienvenido a Byte & book" + reset + tVerde+"     |\n"
                            + "|                                 |\n"
                            + "|---------------------------------|\n"
                            + "|      1. Seleccionar carpeta     |\n" 
                            + "|      2. Leer fichero            |\n"
                            + "|      3. Convertir               |\n"
                            + "|      4. Salir                   |\n"
                            + "-----------------------------------\n"
                            + "Elija una opción:\n" + reset;
        return menu;
    }
    public static String menuConversionDibujar(){
        String tVerde = "\u001B[32m";
        String fBlanco = "\u001B[32;40m";
        String reset = "\u001B[0m";
        String menu= tVerde +"-----------------------------------\n"
                            + "|                                 |\n"
                            + "|    "+fBlanco+"Bienvenido a Byte & book" + reset + tVerde+"     |\n"
                            + "|                                 |\n"
                            + "|---------------------------------|\n"
                            + "|      1. Convertir a csv         |\n" 
                            + "|      2. Convertir a json        |\n"
                            + "|      3. Convertir a xml         |\n"
                            + "|      4. Volver al menu          |\n"
                            + "-----------------------------------\n"
                            + "Elija una opción:\n" + reset;
        return menu;
    }
    public void menuPrincipal(){
        int opcion;
        do{
            System.out.println(menu());
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1 -> seleccionarCarpeta();
                case 2 -> leerFichero();
                case 3 -> menuConversion();
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida");
            }
        }while(opcion !=2);     
    }
    public void menuConversion(){
        int opcion;
        do{
            System.out.println(menuConversionDibujar());
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1 -> seleccionarCarpeta();
                case 2 -> leerFichero();
                case 3 -> menuConversionDibujar();
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida");
            }
        }while(opcion !=2);     
    }
    /*public static void leerFicheros(){
        File file = new File(carpetaSeleccionada);
        if (file==file.csv) {
            leerCsv(carpetaSeleccionada);
        }
        if (file==file.xml) {
            leerXml(carpetaSeleccionada);
        }
        if (file==file.json) {
            leerJson(carpetaSeleccionada);
        }
    }*/

}