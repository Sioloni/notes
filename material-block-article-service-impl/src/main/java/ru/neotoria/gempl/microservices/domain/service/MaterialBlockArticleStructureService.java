package ru.neotoria.gempl.microservices.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleStructure;
import ru.neotoria.gempl.microservices.domain.persistence.repository.MaterialBlockArticleRepository;
import ru.neotoria.gempl.microservices.domain.persistence.repository.MaterialBlockArticleStructureRepository;
import ru.neotoria.gempl.microservices.domain.persistence.spec.MaterialBlockArticleStructureSpec;
import ru.neotoria.gempl.microservices.payload.constant.ESourceType;
import ru.neotoria.gempl.microservices.payload.filter.BlockArticleStructureFilter;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialBlockArticleStructureService {
    private final MaterialBlockArticleStructureRepository repository;
    protected final MaterialBlockArticleRepository materialBlockArticleRepository;


    public List<MaterialBlockArticleStructure> getAll() {
        return repository.findAll();
    }

    public MaterialBlockArticleStructure getById(UUID id) {
        return repository.getEntityById(id);
    }

    public void create
            (
                    UUID materialBlockId,
                    UUID materialBlockArticleTypeId,
                    ESourceType sourceType,
                    Long position
            ) {
        repository.save(new MaterialBlockArticleStructure
                (
                        UUID.randomUUID(),
                        materialBlockArticleRepository.getEntityById(materialBlockId),
                        materialBlockArticleTypeId,
                        sourceType,
                        position
                )
        );

    }

    public void update
            (
                    UUID id,
                    UUID materialBlockId,
                    UUID materialBlockArticleId,
                    ESourceType sourceType,
                    Long position
            ) {

        MaterialBlockArticleStructure entity = repository.getEntityById(id);

        if (materialBlockId != null && !materialBlockId.toString().isEmpty()) {
            entity.setMaterialBlockId
                    (
                            materialBlockArticleRepository.getEntityById(materialBlockId)
                    );
        }
        if (materialBlockArticleId != null && !materialBlockArticleId.toString().isEmpty()) {
            entity.setMaterialBlockArticleTypeId(materialBlockArticleId);
        }
        if (sourceType != null && !sourceType.toString().isEmpty()) {
            entity.setSourceType(sourceType);
        }
        if (position != null) {
            entity.setPosition(position);
        }

        repository.save(entity);
    }

    public void delete(UUID id) {
        repository.getEntityById(id);
    }

    public List<MaterialBlockArticleStructure> filter
            (
                    BlockArticleStructureFilter filter
            ) {

        return repository.findAll(
                MaterialBlockArticleStructureSpec.buildSpec(filter));
    }
}
