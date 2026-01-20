package Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor

public class SpravovaniLokaci {
    private List<Lokace> lokace;
}
