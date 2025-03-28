import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

=======
            
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                
>>>>>>> 0cd261cccf31955a79956aecb09a58cec4af572d
                if (linea.startsWith("<coche>")) {
                    coche = new HashMap<>();
                } else if (linea.startsWith("</coche>")) {
                    if (coche != null && !coche.isEmpty()) {
                        datos.add(coche);
                        coche = null;
                    }
                } else if (linea.startsWith("<") && linea.endsWith(">") && !linea.startsWith("</")) {
                    try {
                        String key = linea.substring(1, linea.indexOf('>'));
                        int inicioValor = linea.indexOf('>') + 1;
                        int finValor = linea.indexOf('<', inicioValor);
<<<<<<< HEAD

=======
                        
>>>>>>> 0cd261cccf31955a79956aecb09a58cec4af572d
                        if (finValor > inicioValor) {
                            String value = linea.substring(inicioValor, finValor).trim();
                            if (!value.isEmpty() && coche != null) {
                                coche.put(key, value);
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error procesando línea: " + linea);
                        e.printStackTrace();
                    }
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
<<<<<<< HEAD

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            StringBuilder xml = new StringBuilder();

            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xml.append("<coches>\n");

=======
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            StringBuilder xml = new StringBuilder();
            
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xml.append("<coches>\n");
            
>>>>>>> 0cd261cccf31955a79956aecb09a58cec4af572d
            for (Map<String, String> coche : datos) {
                xml.append("    <coche>\n");
                for (Map.Entry<String, String> entry : coche.entrySet()) {
                    String key = entry.getKey();
                    String value = escapeXML(entry.getValue());
                    xml.append("        <").append(key).append(">")
<<<<<<< HEAD
                            .append(value).append("</").append(key).append(">\n");
                }
                xml.append("</coche>\n");
            }

            xml.append("</coches>\n");

            bw.write(xml.toString());

=======
                    .append(value).append("</").append(key).append(">\n");
                }
                xml.append("    </coche>\n");
            }
            
            xml.append("</coches>\n");
            
            bw.write(xml.toString());
            
>>>>>>> 0cd261cccf31955a79956aecb09a58cec4af572d
            System.out.println("Archivo XML exportado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al exportar XML: " + e.getMessage());
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 0cd261cccf31955a79956aecb09a58cec4af572d
    private String escapeXML(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&apos;");
<<<<<<< HEAD
    }
=======
    }
>>>>>>> 0cd261cccf31955a79956aecb09a58cec4af572d
}