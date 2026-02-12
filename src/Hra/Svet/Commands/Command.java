package Hra.Svet.Commands;

/**
 * Interface pro vsechny commandy
 */
public interface Command {
    String execute(String[] args);
    boolean exit();
}
