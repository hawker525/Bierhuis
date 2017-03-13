package be.vdab.mwesteli.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Entity
@Table(name = "bestelbonlijnen")
@IdClass(BestelbonLijnId.class)
public class BestelbonLijn implements Serializable{
    private static long serialVersionUID = 1L;

    @Id
    private long bestelbonid;

    @Id
    private long bierid;

    private int aantal;

    private BigDecimal prijs;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "bierid", referencedColumnName = "id")
    private Bier bier;


    @ManyToOne
    @PrimaryKeyJoinColumn(name = "bestelbonid", referencedColumnName = "id")
    private Bestelbon bestelbon;

    public BestelbonLijn(){}

    public long getBestelbonid() {
        return bestelbonid;
    }

    public long getBierid() {
        return bierid;
    }

    public int getAantal() {
        return aantal;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public Bier getBier() {
        return bier;
    }

    public Bestelbon getBestelbon() {
        return bestelbon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BestelbonLijn that = (BestelbonLijn) o;

        if (getBestelbonid() != that.getBestelbonid()) return false;
        if (getBierid() != that.getBierid()) return false;
        if (getAantal() != that.getAantal()) return false;
        if (!getPrijs().equals(that.getPrijs())) return false;
        if (!getBier().equals(that.getBier())) return false;
        return getBestelbon().equals(that.getBestelbon());
    }

    @Override
    public int hashCode() {
        int result = (int) (getBestelbonid() ^ (getBestelbonid() >>> 32));
        result = 31 * result + (int) (getBierid() ^ (getBierid() >>> 32));
        result = 31 * result + getAantal();
        result = 31 * result + getPrijs().hashCode();
        result = 31 * result + getBier().hashCode();
        result = 31 * result + getBestelbon().hashCode();
        return result;
    }
}
