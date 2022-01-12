package SagaTanks.Factories;

import SagaTanks.Objects.UObject;
import SagaTanks.Commands.Command;

public interface CommandsFactory {

    public Command createMoveCommand(UObject obj);

    public Command createBurnCommand(UObject obj);
}
