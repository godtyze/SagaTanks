package SagaTanks.Commands;

public abstract class CompensableCommand implements Command, Compensable {

    public abstract void execute() throws CommandException;

    public abstract void makeCompensation();
}
