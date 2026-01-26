package Hra.Svet.Commands;

public class CommandUse implements Command{
    @Override
    public String execute(String[] args) {
        return"Použití předmětu";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
