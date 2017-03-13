package be.vdab.mwesteli.entities;

import be.vdab.mwesteli.valueobjects.Adres;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable{
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;

    @Embedded
    private Adres adres;

    private BigDecimal omzet;

    @OneToMany(mappedBy = "brouwer")
    private Set<Bier> bieren;

    public Brouwer(){}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }


    public BigDecimal getOmzet() {
        return omzet;
    }

    public Set<Bier> getBieren() {
        return bieren;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brouwer brouwer = (Brouwer) o;

        if (getId() != brouwer.getId()) return false;
        if (getNaam() != null ? !getNaam().equals(brouwer.getNaam()) : brouwer.getNaam() != null) return false;
        if (getAdres() != null ? !getAdres().equals(brouwer.getAdres()) : brouwer.getAdres() != null) return false;
        return getOmzet() != null ? getOmzet().equals(brouwer.getOmzet()) : brouwer.getOmzet() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getNaam() != null ? getNaam().hashCode() : 0);
        result = 31 * result + (getAdres() != null ? getAdres().hashCode() : 0);
        result = 31 * result + (getOmzet() != null ? getOmzet().hashCode() : 0);
        return result;
    }

}
