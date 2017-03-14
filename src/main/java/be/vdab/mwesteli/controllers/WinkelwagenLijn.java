package be.vdab.mwesteli.controllers;

import be.vdab.mwesteli.entities.Bier;

import java.math.BigDecimal;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
final class WinkelwagenLijn {
    private final Bier bier;
    private final int aantal;
    private final BigDecimal totaal;

    WinkelwagenLijn(Bier bier, int aantal) {
        this.bier = bier;
        this.aantal = aantal;
        this.totaal = bier.getPrijs().multiply(BigDecimal.valueOf(aantal));
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
}
