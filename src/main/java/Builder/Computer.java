package Builder;

public class Computer {
    private final String cpu;
    private final int ram;

    private final int storage;
    private final String gpu;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }

    public String getCpu() { return cpu; }
    public int getRam() { return ram; }
    public int getStorage() { return storage; }
    public String getGpu() { return gpu; }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + "GB, Storage=" + storage + "GB, GPU=" + gpu + "]";
    }

    public static class ComputerBuilder {
        private final String cpu;
        private final int ram;

        private int storage = 0;
        private String gpu = "Integrated";

        public ComputerBuilder(String cpu, int ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Computer build() {
            if (cpu == null || cpu.isEmpty() || ram <= 0) {
                throw new IllegalStateException("CPU and RAM must be set.");
            }
            return new Computer(this);
        }
    }
}

