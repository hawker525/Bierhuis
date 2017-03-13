package be.vdab.mwesteli.services;

import be.vdab.mwesteli.entities.Brouwer;

import java.util.List;
import java.util.Optional;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
public interface BrouwerService {
    List<Brouwer> findAll();
    Optional<Brouwer> read(long id);
}
