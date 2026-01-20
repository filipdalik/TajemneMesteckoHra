package NPC;

public class Npc {
    protected String jmeno;

    public Npc(String jmeno) {
        this.jmeno = jmeno;
    }
    public void mluv() {
        System.out.println(jmeno + ": ...");
    }
}
