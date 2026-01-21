package Commands;

public class CommandPoison implements Command{
    @Override
    public String execute(String[] args) {
        return"Použití jedu";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
