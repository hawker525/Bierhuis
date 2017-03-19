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

    public BestelbonLijn(){}

    public BestelbonLijn(long bestelbonid, long bierid) {
        this.bestelbonid = bestelbonid;
        this.bierid = bierid;
    }

    public int getAantal() {
        return aantal;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public long getBestelbonid() {
        return bestelbonid;
    }

    public long getBierid() {
        return bierid;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BestelbonLijn that = (BestelbonLijn) o;

        if (bestelbonid != that.bestelbonid) return false;
        if (bierid != that.bierid) return false;
        if (aantal != that.aantal) return false;
        return prijs.equals(that.prijs);
    }

    @Override
    public int hashCode() {
        int result = (int) (bestelbonid ^ (bestelbonid >>> 32));
        result = 31 * result + (int) (bierid ^ (bierid >>> 32));
        result = 31 * result + aantal;
        result = 31 * result + prijs.hashCode();
        return result;
    }
}
