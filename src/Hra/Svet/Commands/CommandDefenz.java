package Hra.Svet.Commands;

public class CommandDefenz implements Command{
    @Override
    public String execute(String[] args) {
        return"Obrana";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
