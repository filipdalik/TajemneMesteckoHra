package Charakters;

public class Vodnik extends Npc{

    public Vodnik() {
        super("Vodník");
    }
    @Override
    public void mluv() {
        System.out.println("Vodník: Kašna je klíčem k městu.");
    }
}
