package ru.neotoria.gempl.microservices.domain.mapper;

import org.springframework.stereotype.Component;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleTextPart;
import ru.neotoria.gempl.microservices.payload.response.BlockArticleTextPartMultipleResponse;
import ru.neotoria.gempl.microservices.payload.response.BlockArticleTextPartResponse;

import java.util.Collection;

@Component
public class MaterialBlockArticleTextPartMapper {


    public BlockArticleTextPartResponse toBlockArticleTextPartResponse(
            MaterialBlockArticleTextPart materialBlockArticleTextPart) {
        return new BlockArticleTextPartResponse(
                materialBlockArticleTextPart.getId(),
                materialBlockArticleTextPart.getLocalizationContentId(),
                materialBlockArticleTextPart.getMaterialBlockId()
        );
    }


    public BlockArticleTextPartMultipleResponse toBlockArticleTextPartMultipleResponse(
            Collection<MaterialBlockArticleTextPart> materialBlockArticleTextParts) {
        return new BlockArticleTextPartMultipleResponse(
                materialBlockArticleTextParts
                        .stream()
                        .map(this::toBlockArticleTextPartResponse)
                        .toList()
        );
    }
}
