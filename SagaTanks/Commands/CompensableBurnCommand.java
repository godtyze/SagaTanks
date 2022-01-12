package SagaTanks.Commands;

import SagaTanks.Objects.UObject;

public class CompensableBurnCommand extends CompensableCommand{

    private UObject burnableObject;

    public CompensableBurnCommand(UObject obj) {
        burnableObject = obj;
    }

    @Override
    public void execute() throws CommandException {
        Integer fuelConsumption = (Integer)burnableObject.get("fuel consumption");
        Integer fuel = (Integer)burnableObject.get("fuel");
        fuel = fuel - fuelConsumption;
        burnableObject.set("fuel", fuel);
    }

    @Override
    public void makeCompensation() {
        Integer fuelConsumption = (Integer)burnableObject.get("fuel consumption");
        Integer fuel = (Integer)burnableObject.get("fuel");
        fuel = fuel + fuelConsumption;
        burnableObject.set("fuel", fuel);
    }
}
