package SagaTanks;

import SagaTanks.Commands.Command;
import SagaTanks.Commands.CommandException;
import SagaTanks.Commands.MacroCommand;
import SagaTanks.Factories.CommandsFactory;
import SagaTanks.Factories.CompensableCommandsFactory;
import SagaTanks.Objects.UObject;
import SagaTanks.Objects.UObjectImplementation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static CommandsFactory factory = new CompensableCommandsFactory();

    public static void main(String[] args) {
        UObject firstTank = new UObjectImplementation();
        UObject secondTank = new UObjectImplementation();
        ArrayList<Integer> position = new ArrayList<>();
        position.add(3);
        position.add(5);
        ArrayList<Integer> velocity = new ArrayList<>();
        velocity.add(3);
        velocity.add(5);

        firstTank.set("position", position);
        firstTank.set("velocity", velocity);
        Integer fuel = 15;
        Integer fuelConsumption = 3;
        firstTank.set("fuel", fuel);
        firstTank.set("fuel consumption", fuelConsumption);

        ArrayList<Command> commands = new ArrayList<>();
        addCommands(commands, firstTank);

        print(firstTank);

        Command macroCommand = new MacroCommand(commands);
        try {
            macroCommand.execute();
        }catch (CommandException e){
            e.printStackTrace();
        }
        print(firstTank);

        commands = new ArrayList<>();
        addCommands(commands, firstTank);
        addCommands(commands, secondTank);

        macroCommand = new MacroCommand(commands);
        try {
            macroCommand.execute();
        }catch (CommandException e){
            e.printStackTrace();
        }

        print(firstTank);
    }

    public static void print(UObject obj){
        System.out.println("current position is " + (ArrayList<Integer>)obj.get("position"));
        System.out.println("current fuel is " + (Integer)obj.get("fuel") + "\n");
    }

    public static void addCommands(List<Command> commands, UObject obj){
        commands.add(factory.createMoveCommand(obj));
        commands.add(factory.createBurnCommand(obj));
    }
}
