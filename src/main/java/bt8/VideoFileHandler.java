package bt8;

class VideoFileHandler extends FileHandler implements Encryptable {

    public VideoFileHandler(String fileName) {
        super(fileName);
    }

    @Override
    public void read() {
        System.out.println("Playing video file: " + fileName);
    }

    @Override
    public void write(String data) {
        System.out.println("Updating video info: " + fileName + " | Data: " + data);
    }

    @Override
    public void delete() {
        System.out.println("Deleting video file: " + fileName);
    }

    @Override
    public void encrypt() {
        System.out.println("Encrypting video file: " + fileName);
    }
}
