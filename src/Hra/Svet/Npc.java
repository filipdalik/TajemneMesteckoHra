package Hra.Svet;

public class Npc {
    private String jmeno;

    public Npc(String jmeno) {
        this.jmeno = jmeno;
    }


    public void mluv() {
        System.out.println(jmeno + ": ...");
    }
}
