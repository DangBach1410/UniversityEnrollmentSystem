package CompositePattern.bt2;

public class Main {
    public static void main(String[] args) {
        SubMenu file = new SubMenu("File");
        file.add(new MenuItem("New"));
        file.add(new MenuItem("Open"));
        file.add(new MenuItem("Save"));

        SubMenu edit = new SubMenu("Edit");
        edit.add(new MenuItem("Undo"));
        edit.add(new MenuItem("Redo"));

        SubMenu view = new SubMenu("View");
        view.add(new MenuItem("Zoom In"));
        view.add(new MenuItem("Zoom Out"));

        SubMenu settings = new SubMenu("Settings");
        settings.add(new MenuItem("Preferences"));
        settings.add(new MenuItem("Themes"));

        SubMenu rootMenu = new SubMenu("Main Menu");
        rootMenu.add(file);
        rootMenu.add(edit);
        rootMenu.add(view);
        rootMenu.add(settings);

        rootMenu.show("");
    }
}
