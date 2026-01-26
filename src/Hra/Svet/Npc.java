package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor

public class Npc {
    private String jmeno;




    public void mluv() {
        System.out.println(jmeno + ": ...");
    }
}
