package BridgePattern.bt2;

public class WordDocument extends Document {
    public WordDocument(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void display() {
        renderer.renderText("Displaying Word content");
    }
}
