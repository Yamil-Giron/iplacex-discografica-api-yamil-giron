package com.iplaex.discografia.artista;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface IArtistaRepository extends MongoRepository<Artista, String> {
}
