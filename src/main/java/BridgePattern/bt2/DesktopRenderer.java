package BridgePattern.bt2;

public class DesktopRenderer implements Renderer {
    @Override
    public void renderText(String text) {
        System.out.println("[Desktop View] " + text);
    }
}
