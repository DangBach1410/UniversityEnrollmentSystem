package bt2;

abstract class ImageDecorator implements ImageData {
    protected ImageData image;

    public ImageDecorator(ImageData image) {
        this.image = image;
    }

    public void save() {
        image.save();
    }
}
