package Hra.Svet;

public abstract class Ukol {
    protected String jmenoUkolu;

    public Ukol(String jmenoUkolu) {
        this.jmenoUkolu = jmenoUkolu;
    }
    public String getJmenoUkolu() {
        return jmenoUkolu;
    }
    public abstract boolean spust();
}
