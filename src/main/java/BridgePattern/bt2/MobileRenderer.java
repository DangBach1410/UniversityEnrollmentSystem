package BridgePattern.bt2;

public class MobileRenderer implements Renderer {
    @Override
    public void renderText(String text) {
        System.out.println("[Mobile View] " + text);
    }
}

