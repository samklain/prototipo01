package com.prototipo02.samflix.repository;

import com.prototipo02.samflix.domain.Prototipo;

import java.util.List;

public interface PrototipoRepository {
    List<Prototipo> listAll();

    //Vai ser a conexão direta com o banco de dados(domain)
}
