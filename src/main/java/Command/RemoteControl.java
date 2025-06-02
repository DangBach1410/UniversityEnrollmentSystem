package Command;

import java.util.Stack;

public class RemoteControl {
    private Stack<Command> commandHistory = new Stack<>();

    public void pressButton(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            System.out.print("Undo: ");
            lastCommand.undo();
        } else {
            System.out.println("Không có lệnh nào để undo");
        }
    }
}

