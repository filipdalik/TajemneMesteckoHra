public class Player {
    private String jmeno;
    private int zivoty;
    Inventar inventar;

    public Player(String jmeno) {
        this.jmeno = jmeno;
        this.zivoty = 2;
        inventar = new Inventar();
    }
}
