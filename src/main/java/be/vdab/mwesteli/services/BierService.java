package be.vdab.mwesteli.services;

import be.vdab.mwesteli.entities.Bier;

import java.util.List;
import java.util.Optional;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
public interface BierService {
    long count();
    Optional<Bier> read(long id);

    List<Bier> findAll();
}
