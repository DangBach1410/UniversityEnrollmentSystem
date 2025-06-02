package Command;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        RemoteControl remote = new RemoteControl();

        remote.pressButton(lightOn);
        remote.pressButton(fanOn);
        remote.pressUndo();
        remote.pressButton(lightOff);
        remote.pressUndo();
        remote.pressButton(fanOn);
        remote.pressButton(fanOff);
    }
}
