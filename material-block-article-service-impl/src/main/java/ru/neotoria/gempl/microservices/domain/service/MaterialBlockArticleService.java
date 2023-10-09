package ru.neotoria.gempl.microservices.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticle;
import ru.neotoria.gempl.microservices.domain.persistence.repository.MaterialBlockArticleRepository;
import ru.neotoria.gempl.microservices.domain.persistence.repository.MaterialBlockArticleStructureRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialBlockArticleService {
    private final MaterialBlockArticleRepository blockArticleRepository;
    private final MaterialBlockArticleStructureRepository blockArticleStructureRepository;


    public List<MaterialBlockArticle> getAll() {
        return blockArticleRepository.findAll();
    }


    public MaterialBlockArticle getById(UUID id) {
        return blockArticleRepository.getEntityById(id);
    }


    public void create
            (
                    UUID materialBlockId,
                    Collection<UUID> structureIds
            ) {

        blockArticleRepository.save(
                new MaterialBlockArticle(
                        materialBlockId,
                        blockArticleStructureRepository.getEntityByIds(structureIds)
                )
        );
    }


    public void update
            (
                    UUID id,
                    UUID materialBlockId,
                    List<UUID> structureId
            ) {

        MaterialBlockArticle entity = blockArticleRepository.getEntityById(id);

        if (materialBlockId != null) {
            entity.setMaterialBlockId(materialBlockId);
        }
        if (structureId.size() != -1) {
            entity.setStructures(
                    blockArticleStructureRepository
                            .getEntityByIds(structureId));
        }

        blockArticleRepository.save(entity);
    }


    public void delete(UUID id) {
        blockArticleRepository.deleteById(id);
    }
}
