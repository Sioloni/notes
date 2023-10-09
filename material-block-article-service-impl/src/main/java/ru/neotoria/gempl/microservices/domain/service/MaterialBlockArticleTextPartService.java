package ru.neotoria.gempl.microservices.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleTextPart;
import ru.neotoria.gempl.microservices.domain.persistence.repository.MaterialBlockArticleTextPartRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialBlockArticleTextPartService {
    private final MaterialBlockArticleTextPartRepository repository;


    public List<MaterialBlockArticleTextPart> getAll() {
        return repository.findAll();
    }

    public MaterialBlockArticleTextPart getById(UUID id) {
        return repository.getEntityById(id);
    }

    public void create
            (
                    Long localizationContentId,
                    UUID materialBlockId
            ) {
        repository.save(
                new MaterialBlockArticleTextPart
                        (
                                UUID.randomUUID(),
                                localizationContentId,
                                materialBlockId
                        )
        );
    }


    public void update
            (
                    UUID id,
                    Long localizationContentId,
                    UUID materialBlockId
            ) {

        MaterialBlockArticleTextPart entity = repository.getEntityById(id);

        if (localizationContentId != null) {
            entity.setLocalizationContentId(localizationContentId);
        }
        if (materialBlockId != null && !materialBlockId.toString().isEmpty()) {
            entity.setMaterialBlockId(materialBlockId);
        }

        repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
