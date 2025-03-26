import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Xml implements Archivos{

    @Override
    public void aTextoPlano() {
        
=======
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leer'");
>>>>>>> ramaJuanfran
    }

    @Override
    public void exportar(String path, List<Map<String, String>> datos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportar'");
    }

}