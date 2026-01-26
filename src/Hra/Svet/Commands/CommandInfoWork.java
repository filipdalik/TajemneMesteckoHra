package Hra.Svet.Commands;

public class CommandInfoWork implements Command{
    @Override
    public String execute(String[] args) {
        return"Informace o úkolu";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
