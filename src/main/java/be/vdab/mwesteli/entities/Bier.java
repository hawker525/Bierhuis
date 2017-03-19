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


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "brouwerid")
    private Brouwer brouwer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "soortid")
    private Soort soort;

//    @OneToMany(mappedBy = "bier")
    @OneToMany
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

        if (!naam.equals(bier.naam)) return false;
        if (alcohol != null ? !alcohol.equals(bier.alcohol) : bier.alcohol != null) return false;
        if (prijs != null ? !prijs.equals(bier.prijs) : bier.prijs != null) return false;
        if (!brouwer.equals(bier.brouwer)) return false;
        return soort.equals(bier.soort);
    }

    @Override
    public int hashCode() {
        int result = naam.hashCode();
        result = 31 * result + (alcohol != null ? alcohol.hashCode() : 0);
        result = 31 * result + (prijs != null ? prijs.hashCode() : 0);
        result = 31 * result + brouwer.hashCode();
        result = 31 * result + soort.hashCode();
        return result;
    }
}
