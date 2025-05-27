package BridgePattern.bt2;

public class PDFDocument extends Document {
    public PDFDocument(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void display() {
        renderer.renderText("Displaying PDF content");
    }
}
