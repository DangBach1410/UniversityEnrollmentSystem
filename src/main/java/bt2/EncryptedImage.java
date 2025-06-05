package bt2;

class EncryptedImage extends ImageDecorator {
    public EncryptedImage(ImageData image) {
        super(image);
    }

    @Override
    public void save() {
        System.out.println("Mã hóa ảnh...");
        super.save();
    }
}
