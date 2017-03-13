package be.vdab.mwesteli.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Entity
@Table(name = "soorten")
public class Soort implements Serializable{
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;

    @OneToMany(mappedBy = "soort")
    private Set<Bier> bieren;

    public Soort(){}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Bier> getBieren() {
        return bieren;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Soort soort = (Soort) o;

        if (getId() != soort.getId()) return false;
        return getNaam().equals(soort.getNaam());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getNaam().hashCode();
        return result;
    }
}
