package be.vdab.mwesteli.repositories;

import be.vdab.mwesteli.entities.Brouwer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
public interface BrouwerRepository extends JpaRepository<Brouwer, Long>{}
