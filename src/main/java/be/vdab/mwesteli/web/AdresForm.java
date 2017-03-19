package be.vdab.mwesteli.web;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
public final class AdresForm {

    @NotBlank
    @SafeHtml
    private String naam;

    @NotBlank
    @SafeHtml
    private String straat;

    @NotBlank
    @SafeHtml
    private String huisnr;

    @NotNull
    @Min(1000)
    @Max(9999)
    private Integer postcode;

    @NotBlank
    @SafeHtml
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
}
