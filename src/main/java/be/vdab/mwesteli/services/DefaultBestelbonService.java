package be.vdab.mwesteli.services;

import be.vdab.mwesteli.entities.Bestelbon;
import be.vdab.mwesteli.repositories.BestelbonRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
@Service
public class DefaultBestelbonService implements BestelbonService{

    private final BestelbonRepository bestelbonRepository;

    public DefaultBestelbonService(BestelbonRepository bestelbonRepository) {
        this.bestelbonRepository = bestelbonRepository;
    }

    @Override
    public void create(Bestelbon bestelbon) {
        bestelbonRepository.save(bestelbon);
    }
}
