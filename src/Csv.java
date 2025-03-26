import java.io.BufferedReader;
import java.io.FileReader;
<<<<<<< HEAD
import java.io.IOException;
=======
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Csv extends Archivos {
>>>>>>> ramaJuanfran

public class Csv implements Archivos{
    
    @Override
<<<<<<< HEAD
    public void aTextoPlano() {
        String rutaArchivo = "";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
=======
    public void leer(String path, List<Map<String, String>> datos) {
        System.out.println("Leyendo archivo CSV...");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea = br.readLine();
            if (linea != null) {
                String[] headers = linea.split(",");
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split(",");
                    Map<String, String> fila = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        fila.put(headers[i], valores[i]);
                    }
                    datos.add(fila);
                }
            }
            System.out.println("Archivo CSV leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
>>>>>>> ramaJuanfran
        }
    }


    @Override
<<<<<<< HEAD
    public void darFormato() {
        
=======
    public void exportar(String path, List<Map<String, String>> datos) {
        System.out.println("Exportando a CSV...");
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            if (!datos.isEmpty()) {
                Set<String> headers = datos.get(0).keySet();
                pw.println(String.join(",", headers));
                for (Map<String, String> fila : datos) {
                    pw.println(String.join(",", fila.values()));
                }
            }
            System.out.println("Archivo CSV exportado correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
>>>>>>> ramaJuanfran
    }
}