package bt8;

abstract class FileHandler {
    protected String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public abstract void read();
    public abstract void write(String data);
    public abstract void delete();
}
