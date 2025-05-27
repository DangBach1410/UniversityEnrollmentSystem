package ProxyPattern.bt2;

public class ProxyDocument implements Document {
    private String filename;
    private String userRole;
    private RealDocument realDocument;

    public ProxyDocument(String filename, String userRole) {
        this.filename = filename;
        this.userRole = userRole;
    }

    @Override
    public void display() {
        if ("admin".equalsIgnoreCase(userRole)) {
            if (realDocument == null) {
                realDocument = new RealDocument(filename);
            }
            realDocument.display();
        } else {
            System.out.println("ACCESS DENIED: '" + userRole + "' cannot access '" + filename + "'");
        }
    }
}

