package Commands;

public class CommandInfoItem implements Command{

    @Override
    public String execute(String[] args) {
        return"Informace o předmětu";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
