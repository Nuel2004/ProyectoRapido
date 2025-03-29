import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Csv extends Archivos {
    @Override
<<<<<<< HEAD
    public void leer(String path, List<Map<String, String>> datos, Scanner sc) {
=======
    public void leer(String path, List<Map<String, String>> datos) {
>>>>>>> ramadeveloper
        System.out.println("Leyendo archivo CSV...");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea = br.readLine();
            if (linea != null) {
                String[] arrayEncabezado = linea.split(",");
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split(",");
                    Map<String, String> fila = new HashMap<>();
                    for (int i = 0; i < arrayEncabezado.length; i++) {
                        fila.put(arrayEncabezado[i], valores[i]);
                    }
                    datos.add(fila);
                }
            }
            System.out.println("Archivo CSV leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
<<<<<<< HEAD
    public void exportar(String path, List<Map<String, String>> datos, Scanner sc) {
=======
    public void exportar(String path, List<Map<String, String>> datos) {
>>>>>>> ramadeveloper
        System.out.println("Exportando a CSV...");
        String extension = "src\\csv";
        File carpeta = new File(extension);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        path = carpeta.getAbsolutePath() + File.separator + path;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            if (!datos.isEmpty()) {
                Set<String> arrayEncabezado = datos.get(0).keySet();
                bw.write(String.join(",", arrayEncabezado));
                bw.newLine();
                for (Map<String, String> fila : datos) {
                    bw.write(String.join(",", fila.values()));
                    bw.newLine();
                }
            }
            System.out.println("Archivo CSV exportado correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
