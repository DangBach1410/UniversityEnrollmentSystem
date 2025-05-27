package BridgePattern.bt1;

public class Main {
    public static void main(String[] args) {
        TV samsung = new SamsungTV();
        RemoteControl samsungRemote = new BasicRemoteControl(samsung);
        samsungRemote.turnOn();
        samsungRemote.setChannel(5);
        samsungRemote.turnOff();

        System.out.println();

        TV sony = new SonyTV();
        RemoteControl sonyRemote = new BasicRemoteControl(sony);
        sonyRemote.turnOn();
        sonyRemote.setChannel(10);
        sonyRemote.turnOff();
    }
}
