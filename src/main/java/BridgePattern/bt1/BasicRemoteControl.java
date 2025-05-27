package BridgePattern.bt1;

public class BasicRemoteControl extends RemoteControl {
    public BasicRemoteControl(TV tv) {
        super(tv);
    }

    @Override
    public void turnOn() {
        tv.on();
    }

    @Override
    public void turnOff() {
        tv.off();
    }

    @Override
    public void setChannel(int channel) {
        tv.setChannel(channel);
    }
}

