package be.vdab.mwesteli.repositories;

import be.vdab.mwesteli.entities.Bestelbon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
public interface BestelbonRepository extends JpaRepository<Bestelbon, Long>{
}
