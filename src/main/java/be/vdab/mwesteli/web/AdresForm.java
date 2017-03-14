package be.vdab.mwesteli.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
public final class AdresForm {

    @NotNull
    private String naam;

    @NotNull
    private String straat;

    @NotNull
    private String huisnr;

    @NotNull
    @Min(1000)
    @Max(9999)
    private Integer postcode;

    @NotNull
    private String gemeente;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnr() {
        return huisnr;
    }

    public void setHuisnr(String huisnr) {
        this.huisnr = huisnr;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    @Override
    public String toString() {
        return "TOSTRING BABY WOOO";
    }
}
