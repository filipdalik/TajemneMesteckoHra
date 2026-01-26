package Hra.Svet.Commands;

public class CommandAnswerDialog implements Command{
    @Override
    public String execute(String[] args) {
        return "Odpověď v dialogu";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
