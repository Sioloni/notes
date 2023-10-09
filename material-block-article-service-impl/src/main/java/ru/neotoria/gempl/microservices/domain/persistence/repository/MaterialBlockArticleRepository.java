package ru.neotoria.gempl.microservices.domain.persistence.repository;


import org.springframework.stereotype.Repository;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticle;
import ru.neotoria.microservices.common.util.ExtendedRepository;

import java.util.UUID;

@Repository
public interface MaterialBlockArticleRepository
        extends ExtendedRepository<MaterialBlockArticle, UUID> {
}
