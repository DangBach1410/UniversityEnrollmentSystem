package Builder;

public class Main {
    public static void main(String[] args) {
        Computer basicPc = new Computer.ComputerBuilder("Intel i3", 8).build();

        Computer gamingPc = new Computer.ComputerBuilder("Intel i9", 32)
                .setStorage(1000)
                .setGpu("NVIDIA RTX 4090")
                .build();

        Computer officePc = new Computer.ComputerBuilder("AMD Ryzen 5", 16)
                .setStorage(512)
                .build();

        System.out.println(basicPc);
        System.out.println(gamingPc);
        System.out.println(officePc);
    }
}

