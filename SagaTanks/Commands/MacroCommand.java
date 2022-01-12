package SagaTanks.Commands;

import java.util.List;

public class MacroCommand extends CompensableCommand{

    private List<Command> commands;
    private Integer numberOfSuccessfulCommands = 0;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() throws CommandException {
        try{
            for(int i = 0;i < commands.size();i++){
                commands.get(i).execute();
                numberOfSuccessfulCommands++;
            }
        }catch (Exception e){
            makeCompensation();
        }
        numberOfSuccessfulCommands = 0;
    }

    @Override
    public void makeCompensation() {
        Command curCommand;
        for(int i = 0;i < numberOfSuccessfulCommands;i++){
            curCommand = commands.get(i);
            if(curCommand instanceof Compensable){
                ((Compensable) curCommand).makeCompensation();
            }
        }
    }
}
