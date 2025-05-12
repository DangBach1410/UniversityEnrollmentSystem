package bt8;

class ImageFileHandler extends FileHandler implements Compressible {

    public ImageFileHandler(String fileName) {
        super(fileName);
    }

    @Override
    public void read() {
        System.out.println("Viewing image file: " + fileName);
    }

    @Override
    public void write(String data) {
        System.out.println("Modifying image metadata: " + fileName + " | Data: " + data);
    }

    @Override
    public void delete() {
        System.out.println("Deleting image file: " + fileName);
    }

    @Override
    public void compress() {
        System.out.println("Compressing image file: " + fileName);
    }
}
