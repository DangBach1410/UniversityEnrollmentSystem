package bt8;

class TextFileHandler extends FileHandler implements Compressible, Encryptable {

    public TextFileHandler(String fileName) {
        super(fileName);
    }

    @Override
    public void read() {
        System.out.println("Reading text file: " + fileName);
    }

    @Override
    public void write(String data) {
        System.out.println("Writing to text file: " + fileName + " | Content: " + data);
    }

    @Override
    public void delete() {
        System.out.println("Deleting text file: " + fileName);
    }

    @Override
    public void compress() {
        System.out.println("Compressing text file: " + fileName);
    }

    @Override
    public void encrypt() {
        System.out.println("Encrypting text file: " + fileName);
    }
}
