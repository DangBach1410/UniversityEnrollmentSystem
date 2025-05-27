package BridgePattern.bt2;

public class Main {
    public static void main(String[] args) {
        Document pdfOnMobile = new PDFDocument(new MobileRenderer());
        pdfOnMobile.display();

        Document wordOnDesktop = new WordDocument(new DesktopRenderer());
        wordOnDesktop.display();

        Document markdownOnMobile = new MarkdownDocument(new MobileRenderer());
        markdownOnMobile.display();
    }
}
