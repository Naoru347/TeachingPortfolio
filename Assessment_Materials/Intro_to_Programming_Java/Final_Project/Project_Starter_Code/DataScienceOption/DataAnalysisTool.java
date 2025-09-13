import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataAnalysisTool {

    public static List<Map<String, String>> loadCSV(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("Error: CSV file is empty.");
                return data;
            }

            String[] headers = headerLine.split(",");
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1); // -1 to include trailing empty strings
                Map<String, String> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.length && i < values.length; i++) {
                    row.put(headers[i].trim(), values[i].trim());
                }
                data.add(row);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return data;
    }

    public static void displayData(List<Map<String, String>> data) {
        if (data.isEmpty()) {
            System.out.println("No data to display.");
            return;
        }

        // Print headers
        Map<String, String> firstRow = data.get(0);
        List<String> headers = new ArrayList<>(firstRow.keySet());
        System.out.println(String.join("\t", headers));

        // Print rows
        for (Map<String, String> row : data) {
            for (String header : headers) {
                System.out.print(row.getOrDefault(header, "") + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Data Analysis Tool!");

        System.out.print("Enter the path to your CSV file: ");
        String filePath = scanner.nextLine().trim();

        List<Map<String, String>> data = loadCSV(filePath);

        if (!data.isEmpty()) {
            System.out.println("\nLoaded Data:\n");
            displayData(data);
        } else {
            System.out.println("No data loaded. Please check the file and try again.");
        }

        scanner.close();
    }
}
