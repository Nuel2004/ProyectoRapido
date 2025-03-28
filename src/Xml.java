import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xml extends Archivos {
    @Override
    public void leer(String path, List<Map<String, String>> datos) {
        System.out.println("Leyendo archivo XML...");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            Map<String, String> coche = null;
<<<<<<< HEAD
            String key = null;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

=======
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
>>>>>>> 591fec4dbff165655f8582abc1a48baca569b352
                if (linea.startsWith("<coche>")) {
                    coche = new HashMap<>();
                } else if (linea.startsWith("</coche>")) {
                    if (coche != null) {
                        datos.add(coche);
<<<<<<< HEAD
                        coche = null;
                    }
                } else if (linea.startsWith("<") && linea.contains(">") && coche != null) {
                    key = linea.substring(1, linea.indexOf(">"));
                } else if (linea.startsWith("</") == false && coche != null && key != null) {
                    String value = linea;
                    coche.put(key, value);
                    key = null;
=======
                    }
                } else if (linea.startsWith("<") && linea.endsWith(">")) {
                    String[] partes = linea.substring(1, linea.length() - 1).split(">");
                    String key = partes[0].trim();
                    String value = partes[1].trim();
                    coche.put(key, value);
>>>>>>> 591fec4dbff165655f8582abc1a48baca569b352
                }
            }

            System.out.println("Archivo XML leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void exportar(String path, List<Map<String, String>> datos) {
        System.out.println("Exportando a XML...");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<coches>\n");
<<<<<<< HEAD

            for (Map<String, String> coche : datos) {
                bw.write("    <coche>\n");
                for (Map.Entry<String, String> entry : coche.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    value = value.replace("<", "&lt;").replace(">", "&gt;").replace("&", "&amp;")
                            .replace("\"", "&quot;").replace("'", "&apos;");
                    bw.write("        <" + key + ">" + value + "</" + key + ">\n");
                }
                bw.write("    </coche>\n");
            }

=======
            for (Map<String, String> coche : datos) {
                bw.write("  <coche>\n");
                for (Map.Entry<String, String> entry : coche.entrySet()) {
                    bw.write("    <" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">\n");
                }
                bw.write("  </coche>\n");
            }
>>>>>>> 591fec4dbff165655f8582abc1a48baca569b352
            bw.write("</coches>\n");
            System.out.println("Archivo XML exportado correctamente.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}