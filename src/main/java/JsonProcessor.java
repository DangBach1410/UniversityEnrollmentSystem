import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.*;

public class JsonProcessor {
    public static void main(String[] args) {
        String inputFile = "users.json";
        String outputFile = "filtered_users.csv";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            // Ghi header cho file CSV
            writer.write("Name,Age,Address,Email");
            writer.newLine();

            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(reader);

            // Bắt đầu đọc mảng JSON
            if (parser.nextToken() != JsonToken.START_ARRAY) {
                System.err.println("File không phải là mảng JSON.");
                return;
            }

            // Duyệt từng đối tượng trong mảng
            while (parser.nextToken() == JsonToken.START_OBJECT) {
                String name = "";
                int age = 0;
                String address = "";
                String email = "";

                // Đọc từng field của đối tượng
                while (parser.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken(); // chuyển tới giá trị

                    switch (fieldName) {
                        case "name":
                            name = parser.getText();
                            break;
                        case "age":
                            age = parser.getIntValue();
                            break;
                        case "address":
                            address = parser.getText();
                            break;
                        case "email":
                            email = parser.getText();
                            break;
                    }
                }

                // Kiểm tra độ tuổi > 30
                if (age > 30) {
                    writer.write(String.format("%s,%d,%s,%s", name, age, address, email));
                    writer.newLine();
                }
            }

            parser.close();
            System.out.println("Đã ghi xong file: " + outputFile);

        } catch (IOException e) {
            System.err.println("Lỗi xử lý: " + e.getMessage());
        }
    }
}

