package Commands;

public class CommandOfenz implements Command{
    @Override
    public String execute(String[] args) {
        return"Útok";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
