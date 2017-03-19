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

    public BestelbonLijnId(long bestelbonid, long bierid) {
        this.bestelbonid = bestelbonid;
        this.bierid = bierid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BestelbonLijnId that = (BestelbonLijnId) o;

        if (bestelbonid != that.bestelbonid) return false;
        return bierid == that.bierid;
    }

    @Override
    public int hashCode() {
        int result = (int) (bestelbonid ^ (bestelbonid >>> 32));
        result = 31 * result + (int) (bierid ^ (bierid >>> 32));
        return result;
    }
}
