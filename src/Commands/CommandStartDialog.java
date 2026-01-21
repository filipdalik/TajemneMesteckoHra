package Commands;

public class CommandStartDialog implements Command{
    @Override
    public String execute(String[] args) {
        return"Začíná dialog";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
