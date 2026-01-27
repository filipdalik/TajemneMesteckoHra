package Hra.Svet.Commands;
public interface Command {
    String execute(String[] args);

    boolean exit();
}
