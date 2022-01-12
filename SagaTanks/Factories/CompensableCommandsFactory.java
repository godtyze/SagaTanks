package SagaTanks.Factories;

import SagaTanks.Objects.UObject;
import SagaTanks.Commands.Command;
import SagaTanks.Commands.CompensableBurnCommand;
import SagaTanks.Commands.CompensableMoveCommand;

public class CompensableCommandsFactory implements CommandsFactory {


    @Override
    public Command createMoveCommand(UObject obj) {
        return new CompensableMoveCommand(obj);
    }

    @Override
    public Command createBurnCommand(UObject obj) {
        return new CompensableBurnCommand(obj);
    }
}
