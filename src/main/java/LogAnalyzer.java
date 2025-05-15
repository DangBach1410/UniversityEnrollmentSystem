import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) {
        String logFilePath = "server.log";
        String reportFilePath = "log_report.txt";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        int infoCount = 0;
        int errorCount = 0;
        int warnCount = 0;

        List<LocalDateTime> infoTimes = new ArrayList<>();
        List<LocalDateTime> errorTimes = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(logFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String timestampStr = line.substring(0, 19);
                LocalDateTime timestamp;
                try {
                    timestamp = LocalDateTime.parse(timestampStr, dtf);
                } catch (Exception e) {
                    // Nếu không parse được timestamp, bỏ qua dòng
                    continue;
                }

                // Lấy phần còn lại của dòng để tìm loại sự kiện
                String rest = line.substring(20).trim();
                if (rest.startsWith("INFO")) {
                    infoCount++;
                    infoTimes.add(timestamp);
                } else if (rest.startsWith("ERROR")) {
                    errorCount++;
                    errorTimes.add(timestamp);
                } else if (rest.startsWith("WARN")) {
                    warnCount++;
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc file log: " + e.getMessage());
            return;
        }

        // Hàm tính thời gian trung bình giữa các sự kiện (ms)
        double avgInfoInterval = calculateAverageInterval(infoTimes);
        double avgErrorInterval = calculateAverageInterval(errorTimes);

        // Ghi báo cáo
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(reportFilePath))) {
            bw.write("BÁO CÁO THỐNG KÊ LOG\n");
            bw.write("=====================\n");
            bw.write("Tổng số sự kiện INFO: " + infoCount + "\n");
            bw.write("Tổng số sự kiện ERROR: " + errorCount + "\n");
            bw.write("Tổng số sự kiện WARN: " + warnCount + "\n\n");

            if (infoCount > 1) {
                bw.write(String.format("Thời gian trung bình giữa các sự kiện INFO: %.2f giây\n", avgInfoInterval / 1000));
            } else {
                bw.write("Không đủ dữ liệu để tính thời gian trung bình giữa các sự kiện INFO.\n");
            }

            if (errorCount > 1) {
                bw.write(String.format("Thời gian trung bình giữa các sự kiện ERROR: %.2f giây\n", avgErrorInterval / 1000));
            } else {
                bw.write("Không đủ dữ liệu để tính thời gian trung bình giữa các sự kiện ERROR.\n");
            }

        } catch (IOException e) {
            System.err.println("Lỗi ghi báo cáo: " + e.getMessage());
        }
    }

    // Hàm tính thời gian trung bình giữa các timestamp trong danh sách (ms)
    private static double calculateAverageInterval(List<LocalDateTime> times) {
        if (times.size() < 2) return 0;

        long totalInterval = 0;
        for (int i = 1; i < times.size(); i++) {
            Duration duration = Duration.between(times.get(i - 1), times.get(i));
            totalInterval += duration.toMillis();
        }
        return (double) totalInterval / (times.size() - 1);
    }
}
