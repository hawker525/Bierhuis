package be.vdab.mwesteli.controllers;

import be.vdab.mwesteli.entities.Bier;

import java.math.BigDecimal;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
final class WinkelwagenLijn {
    private final Bier bier;
    private int aantal;
    private BigDecimal totaal;

    WinkelwagenLijn(Bier bier, int aantal) {
        this.bier = bier;
        addAantal(aantal);
    }

    public Bier getBier() {
        return bier;
    }

    public int getAantal() {
        return aantal;
    }

    public BigDecimal getTotaal() {
        return totaal;
    }

    void addAantal(int aantal){
        this.aantal += aantal;
        this.totaal = bier.getPrijs().multiply(BigDecimal.valueOf(this.aantal));
    }
}
