package ProxyPattern.bt2;

public class RealDocument implements Document {
    private String filename;

    public RealDocument(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading document from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying document: " + filename);
    }
}

