package be.vdab.mwesteli.entities;

import java.io.Serializable;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
public class BestelbonLijnId implements Serializable{
    private static long serialVersionUID = 1L;

    private long bestelbonid;

    private long bierid;

    public BestelbonLijnId(){}

    public long getBestelbonid() {
        return bestelbonid;
    }

    public long getBierid() {
        return bierid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BestelbonLijnId that = (BestelbonLijnId) o;

        if (getBestelbonid() != that.getBestelbonid()) return false;
        return getBierid() == that.getBierid();
    }

    @Override
    public int hashCode() {
        int result = (int) (getBestelbonid() ^ (getBestelbonid() >>> 32));
        result = 31 * result + (int) (getBierid() ^ (getBierid() >>> 32));
        return result;
    }
}
