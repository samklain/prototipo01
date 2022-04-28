package com.prototipo02.samflix.service;

import com.prototipo02.samflix.domain.Prototipo;
import com.prototipo02.samflix.repository.PrototipoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PrototipoService implements PrototipoRepository {
    private static List<Prototipo> prototipos;

    static {
        List.of(new Prototipo(1L, "Coraline"), new Prototipo(2L,"Hollow knight"), new Prototipo(3L,"Elden Ring"), new Prototipo( 4L, "Dark Souls"));
    }


    public List<Prototipo> listAll(){
        return prototipos;
    }

    public Prototipo findById(long id) {
        return prototipos.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime ID not Found"));
    }

    public Prototipo save(Prototipo prototipo) {
        prototipo.setId(ThreadLocalRandom.current().nextLong(3, 100000000));
        prototipos.add(prototipo);
        return prototipo;
    }

    public void delete(long id) {
        prototipos.remove(findById(id));
    }
}

//Service onde vai ser feita a lógica de negócio

