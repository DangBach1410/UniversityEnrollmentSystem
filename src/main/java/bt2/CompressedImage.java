package bt2;

class CompressedImage extends ImageDecorator {
    public CompressedImage(ImageData image) {
        super(image);
    }

    @Override
    public void save() {
        System.out.println("Nén ảnh...");
        super.save();
    }
}