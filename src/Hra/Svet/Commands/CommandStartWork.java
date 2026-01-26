package Hra.Svet.Commands;

public class CommandStartWork implements Command{
    @Override
    public String execute(String[] args) {
        return"Začátek úkolu";
    }
    @Override
    public boolean exit() {
        return false;
    }

}
