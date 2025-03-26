import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Csv implements Archivos{
    
    @Override
    public void aTextoPlano() {
        String rutaArchivo = "";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void darFormato() {
        
    }
    
}
