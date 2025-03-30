import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Archivos {
    public abstract void leer(String path, List<Map<String, String>> datos, Scanner sc);

    public abstract void exportar(String path, List<Map<String, String>> datos, Scanner sc);
}