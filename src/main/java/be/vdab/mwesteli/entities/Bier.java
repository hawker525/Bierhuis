package be.vdab.mwesteli.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Entity
@Table(name = "bieren")
public class Bier implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;

    private BigDecimal alcohol;
    private BigDecimal prijs;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brouwerid")
    private Brouwer brouwer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "soortid")
    private Soort soort;

    @OneToMany(mappedBy = "bier")
    private List<BestelbonLijn> bestelbonlijnen;

    public Bier(){}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public Brouwer getBrouwer() {
        return brouwer;
    }

    public Soort getSoort() {
        return soort;
    }

    public List<BestelbonLijn> getBestelbonlijnen() {
        return bestelbonlijnen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bier bier = (Bier) o;

        if (getId() != bier.getId()) return false;
        if (!getNaam().equals(bier.getNaam())) return false;
        if (getAlcohol() != null ? !getAlcohol().equals(bier.getAlcohol()) : bier.getAlcohol() != null) return false;
        return getPrijs() != null ? getPrijs().equals(bier.getPrijs()) : bier.getPrijs() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getNaam().hashCode();
        result = 31 * result + (getAlcohol() != null ? getAlcohol().hashCode() : 0);
        result = 31 * result + (getPrijs() != null ? getPrijs().hashCode() : 0);
        return result;
    }
}
