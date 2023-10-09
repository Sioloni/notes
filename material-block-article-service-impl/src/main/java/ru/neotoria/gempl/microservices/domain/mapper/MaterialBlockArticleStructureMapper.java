package ru.neotoria.gempl.microservices.domain.mapper;

import org.springframework.stereotype.Component;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleStructure;
import ru.neotoria.gempl.microservices.payload.response.BlockArticleStructureMultipleResponse;
import ru.neotoria.gempl.microservices.payload.response.BlockArticleStructureResponse;

import java.util.Collection;

@Component
public class MaterialBlockArticleStructureMapper {


    public BlockArticleStructureResponse toBlockArticleStructureResponse(
            MaterialBlockArticleStructure materialBlockArticleStructure
    ) {
        return new BlockArticleStructureResponse(
                materialBlockArticleStructure.getId(),
                materialBlockArticleStructure.getMaterialBlockId().getMaterialBlockId(),
                materialBlockArticleStructure.getMaterialBlockArticleTypeId(),
                materialBlockArticleStructure.getSourceType(),
                materialBlockArticleStructure.getPosition()
        );
    }

    public BlockArticleStructureMultipleResponse toBlockArticleStructureMultipleResponse(
            Collection<MaterialBlockArticleStructure> materialBlockArticleStructures
    ) {
        return new BlockArticleStructureMultipleResponse(
                materialBlockArticleStructures.stream()
                        .map(this::toBlockArticleStructureResponse)
                        .toList()
        );
    }

}
