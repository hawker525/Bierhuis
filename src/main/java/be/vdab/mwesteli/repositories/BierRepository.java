package be.vdab.mwesteli.repositories;

import be.vdab.mwesteli.entities.Bier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
public interface BierRepository extends JpaRepository<Bier, Long>{
}
