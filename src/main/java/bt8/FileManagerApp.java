package bt8;

import java.util.Scanner;

public class FileManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler file = null;

        System.out.println("Welcome to File Manager");
        System.out.print("Enter file type (text/image/video): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter file name: ");
        String name = scanner.nextLine();

        switch (type) {
            case "text":
                file = new TextFileHandler(name);
                break;
            case "image":
                file = new ImageFileHandler(name);
                break;
            case "video":
                file = new VideoFileHandler(name);
                break;
            default:
                System.out.println("Unknown file type.");
                return;
        }

        while (true) {
            System.out.println("\nChoose action: read | write | delete | compress | encrypt | exit");
            String action = scanner.nextLine();

            switch (action) {
                case "read":
                    file.read();
                    break;
                case "write":
                    System.out.print("Enter data to write: ");
                    String data = scanner.nextLine();
                    file.write(data);
                    break;
                case "delete":
                    file.delete();
                    break;
                case "compress":
                    if (file instanceof Compressible) {
                        ((Compressible) file).compress();
                    } else {
                        System.out.println("This file type does not support compression.");
                    }
                    break;
                case "encrypt":
                    if (file instanceof Encryptable) {
                        ((Encryptable) file).encrypt();
                    } else {
                        System.out.println("This file type does not support encryption.");
                    }
                    break;
                case "exit":
                    System.out.println("Exiting File Manager.");
                    return;
                default:
                    System.out.println("Invalid action.");
            }
        }
    }
}
