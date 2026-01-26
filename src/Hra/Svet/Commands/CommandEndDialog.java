package Hra.Svet.Commands;

public class CommandEndDialog implements Command{
    @Override
    public String execute(String[] args) {
        return"Hra.Svet.Dialog ukončen";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
