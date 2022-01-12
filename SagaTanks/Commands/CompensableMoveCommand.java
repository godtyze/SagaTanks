package SagaTanks.Commands;

import Tanks.objects.UObject;

import java.util.List;

public class CompensableMoveCommand extends CompensableCommand{

    private UObject movableObject;

    public CompensableMoveCommand(UObject obj) {
        movableObject = obj;
    }


    @Override
    public void execute() throws CommandException {
        List<Integer> position = (List)movableObject.get("position");
        List<Integer> velocity = (List)movableObject.get("velocity");
        for(int i = 0;i < position.size();i++){
            position.set(i, position.get(i) + velocity.get(i));
        }
        movableObject.set("position", position);
    }

    @Override
    public void makeCompensation() {
        List<Integer> position = (List)movableObject.get("position");
        List<Integer> velocity = (List)movableObject.get("velocity");
        for(int i = 0;i < position.size();i++){
            position.set(i, position.get(i) - velocity.get(i));
        }
        movableObject.set("position", position);
    }
}
