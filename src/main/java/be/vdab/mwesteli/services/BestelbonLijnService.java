package be.vdab.mwesteli.services;

import be.vdab.mwesteli.entities.BestelbonLijn;

/**
 * Created by maarten on 19/03/2017.
 */
public interface BestelbonLijnService {
    void createMultiple(Iterable<BestelbonLijn> lijnen);
}
