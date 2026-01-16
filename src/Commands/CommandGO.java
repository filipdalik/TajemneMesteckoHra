package Commands;

public class CommandGO implements Command{
    private Game game;

    public CommandGO(Game game) {
        this.game = game;
    }

    public void execute(String[] args) {
        System.out.println("Pohyb hráče");
    }
}
