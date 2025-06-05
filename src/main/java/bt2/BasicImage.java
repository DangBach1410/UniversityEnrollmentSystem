package bt2;

class BasicImage implements ImageData {
    private String filename;

    public BasicImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void save() {
        System.out.println("Lưu ảnh gốc: " + filename);
    }
}

