package Hra.Svet.Commands;

public class CommandWorkScore implements Command{
    @Override
    public String execute(String[] args) {
        return"Vyhodnocení úkolu";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
