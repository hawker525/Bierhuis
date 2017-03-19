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

    @OneToMany
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

    public List<BestelbonLijn> getBestelbonLijnen(){
        return bestelbonLijnen;
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

        if (!naam.equals(bestelbon.naam)) return false;
        if (!adres.equals(bestelbon.adres)) return false;
        return bestelbonLijnen.equals(bestelbon.bestelbonLijnen);
    }

    @Override
    public int hashCode() {
        int result = naam.hashCode();
        result = 31 * result + adres.hashCode();
        result = 31 * result + bestelbonLijnen.hashCode();
        return result;
    }
}
