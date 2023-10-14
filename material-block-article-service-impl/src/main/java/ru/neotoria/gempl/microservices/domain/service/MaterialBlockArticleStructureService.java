package ru.neotoria.gempl.microservices.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticle;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleStructure;
import ru.neotoria.gempl.microservices.domain.persistence.repository.MaterialBlockArticleRepository;
import ru.neotoria.gempl.microservices.domain.persistence.repository.MaterialBlockArticleStructureRepository;
import ru.neotoria.gempl.microservices.domain.persistence.spec.MaterialBlockArticleStructureSpec;
import ru.neotoria.gempl.microservices.payload.constant.ESourceType;
import ru.neotoria.gempl.microservices.payload.filter.BlockArticleStructureFilter;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialBlockArticleStructureService {
    private final MaterialBlockArticleStructureRepository repository;
    private final MaterialBlockArticleRepository materialBlockArticleRepository;


    public List<MaterialBlockArticleStructure> getAll() {
        return repository.findAll();
    }

    public MaterialBlockArticleStructure getById(UUID id) {
        return repository.getEntityById(id);
    }

    public MaterialBlockArticleStructure create
            (
                    UUID materialBlockId,
                    UUID materialBlockArticleTypeId,
                    ESourceType sourceType

            ) {
        Long position = 1L;

        List<MaterialBlockArticleStructure> materialBlockArticleStructures =
                repository.findAll(MaterialBlockArticleStructureSpec
                        .materialBlockIdIn(List.of(
                                        materialBlockId
                                )
                        )
                );

        if (!materialBlockArticleStructures.isEmpty()) {
            Long maxPosition = materialBlockArticleStructures
                    .stream()
                    .max(Comparator.comparingLong(MaterialBlockArticleStructure::getPosition))
                    .get()
                    .getPosition();

            position = ++maxPosition;
        }

        MaterialBlockArticle materialBlockArticle = materialBlockArticleRepository.getEntityById(materialBlockId);

        MaterialBlockArticleStructure materialBlockArticleStructure = repository.save(new MaterialBlockArticleStructure
                (
                        UUID.randomUUID(),
                        materialBlockArticle,
                        materialBlockArticleTypeId,
                        sourceType,
                        position
                )
        );
        materialBlockArticle.getStructures().add(materialBlockArticleStructure);
        materialBlockArticleRepository.save(materialBlockArticle);
        return materialBlockArticleStructure;
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
