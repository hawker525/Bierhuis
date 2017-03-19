package be.vdab.mwesteli.services;

import be.vdab.mwesteli.entities.BestelbonLijn;
import be.vdab.mwesteli.repositories.BestelbonLijnRepository;
import org.springframework.stereotype.Service;

/**
 * Created by maarten on 19/03/2017.
 */
@Service
public class DefaultBestelbonLijnService implements BestelbonLijnService{
    private final BestelbonLijnRepository bestelbonLijnRepository;

    public DefaultBestelbonLijnService(BestelbonLijnRepository bestelbonLijnRepository) {
        this.bestelbonLijnRepository = bestelbonLijnRepository;
    }

    @Override
    public void createMultiple(Iterable<BestelbonLijn> lijnen) {
        bestelbonLijnRepository.save(lijnen);
    }

}
