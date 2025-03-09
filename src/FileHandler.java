import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {

    private static final String FILE_NAME = "passwords.txt";

    public static void saveData(Map<String, String> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        }
    }

    public static Map<String, String> loadData() throws IOException {
        Map<String, String> data = new HashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return data;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    data.put(parts[0], parts[1]);
                }
            }
        }
        return data;
    }
}
