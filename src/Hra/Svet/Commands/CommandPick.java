package Hra.Svet.Commands;

public class CommandPick implements Command{
    @Override
    public String execute(String[] args) {
       return "Sebrání předmětu";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
