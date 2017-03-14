package be.vdab.mwesteli.web;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
public final class AantalForm {

    @NotNull
    @Min(1)
    private Integer aantal;

    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }
}
