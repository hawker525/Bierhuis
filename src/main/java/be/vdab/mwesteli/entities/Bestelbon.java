package be.vdab.mwesteli.entities;

import be.vdab.mwesteli.valueobjects.Adres;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Entity
@Table(name = "bestelbonnen")
public class Bestelbon implements Serializable{
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;

    @Embedded
    private Adres adres;

    @OneToMany(mappedBy = "bestelbon")
    private List<BestelbonLijn> bestelbonLijnen;

    public Bestelbon(){}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void setBestelbonLijnen(List<BestelbonLijn> bestelbonLijnen) {
        this.bestelbonLijnen = bestelbonLijnen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bestelbon bestelbon = (Bestelbon) o;

        if (getId() != bestelbon.getId()) return false;
        if (getNaam() != null ? !getNaam().equals(bestelbon.getNaam()) : bestelbon.getNaam() != null) return false;
        return getAdres().equals(bestelbon.getAdres());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getNaam() != null ? getNaam().hashCode() : 0);
        result = 31 * result + getAdres().hashCode();
        return result;
    }
}
