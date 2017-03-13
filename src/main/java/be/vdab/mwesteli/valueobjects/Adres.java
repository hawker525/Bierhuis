package be.vdab.mwesteli.valueobjects;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Embeddable
public final class Adres implements Serializable{
    private static final long serialVersionUID = 1L;

    private String straat;

    private String huisnr;
    private int postcode;
    private String gemeente;

    public Adres() {}

    public String getStraat() {
        return straat;
    }

    public String getHuisnr() {
        return huisnr;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setHuisnr(String huisNr) {
        this.huisnr = huisNr;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adres adres = (Adres) o;

        if (getPostcode() != adres.getPostcode()) return false;
        if (!getStraat().equals(adres.getStraat())) return false;
        if (!getHuisnr().equals(adres.getHuisnr())) return false;
        return getGemeente().equals(adres.getGemeente());
    }

    @Override
    public int hashCode() {
        int result = getStraat().hashCode();
        result = 31 * result + getHuisnr().hashCode();
        result = 31 * result + getPostcode();
        result = 31 * result + getGemeente().hashCode();
        return result;
    }
}
