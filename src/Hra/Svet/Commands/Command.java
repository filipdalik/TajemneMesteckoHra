package Hra.Svet.Commands;
public interface Command {
    String execute(String[] args);

    String execute(String[] args, Hra hra);

    boolean exit();
}
