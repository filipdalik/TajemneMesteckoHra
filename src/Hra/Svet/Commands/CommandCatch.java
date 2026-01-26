package Hra.Svet.Commands;

public class CommandCatch implements Command{
    @Override
    public String execute(String[] args) {
        return"Zahození předmětu";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
