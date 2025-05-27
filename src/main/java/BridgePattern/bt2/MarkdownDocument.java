package BridgePattern.bt2;

public class MarkdownDocument extends Document {
    public MarkdownDocument(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void display() {
        renderer.renderText("Displaying Markdown content");
    }
}
