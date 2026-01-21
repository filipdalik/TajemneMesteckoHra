package Commands;

public class CommandEndDialog implements Command{
    @Override
    public String execute(String[] args) {
        return"Dialog ukončen";
    }
    @Override
    public boolean exit() {
        return false;
    }
}
