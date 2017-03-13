package be.vdab.mwesteli.services;

import be.vdab.mwesteli.entities.Bier;
import be.vdab.mwesteli.repositories.BierRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Service
public class DefaultBierService implements BierService{
    private final BierRepository bierRepository;

    public DefaultBierService(BierRepository bierRepository) {
        this.bierRepository = bierRepository;
    }

    @Override
    public long count() {
        return bierRepository.count();
    }

    @Override
    public Optional<Bier> read(long id) {
        return Optional.ofNullable(bierRepository.findOne(id));
    }

    @Override
    public List<Bier> findAll() {
        return bierRepository.findAll(new Sort("naam"));
    }
}
