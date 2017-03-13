package be.vdab.mwesteli.services;

import be.vdab.mwesteli.entities.Brouwer;
import be.vdab.mwesteli.repositories.BrouwerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Service
public class DefaultBrouwerService implements BrouwerService{
    private final BrouwerRepository brouwerRepository;

    public DefaultBrouwerService(BrouwerRepository brouwerRepository) {
        this.brouwerRepository = brouwerRepository;
    }

    @Override
    public List<Brouwer> findAll() {
        return brouwerRepository.findAll(new Sort("naam"));
    }

    @Override
    public Optional<Brouwer> read(long id) {
        return Optional.ofNullable(brouwerRepository.findOne(id));
    }
}
