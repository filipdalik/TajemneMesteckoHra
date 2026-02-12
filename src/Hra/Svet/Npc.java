package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
/**
 * Trida ktera slouzi jako vzor pro vsechny NPC v hre
 */
public class Npc {
    private String jmeno;
    private Dialog dialog;
}
