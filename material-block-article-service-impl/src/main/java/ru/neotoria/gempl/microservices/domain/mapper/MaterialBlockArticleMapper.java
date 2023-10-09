package ru.neotoria.gempl.microservices.domain.mapper;


import org.springframework.stereotype.Component;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticle;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleStructure;
import ru.neotoria.gempl.microservices.payload.response.BlockArticleMultipleResponse;
import ru.neotoria.gempl.microservices.payload.response.BlockArticleResponse;

import java.util.Collection;

@Component
public class MaterialBlockArticleMapper {


    public BlockArticleResponse toBlockArticleResponse(
            MaterialBlockArticle materialBlockArticle
    ) {
        return new BlockArticleResponse(
                materialBlockArticle.getMaterialBlockId(),
                materialBlockArticle.getStructures()
                        .stream()
                        .map(MaterialBlockArticleStructure::getId)
                        .toList()
        );
    }

    public BlockArticleMultipleResponse toBlockArticleMultipleResponse(
            Collection<MaterialBlockArticle> materialBlockArticles
    ) {
        return new BlockArticleMultipleResponse(
                materialBlockArticles.stream()
                        .map(this::toBlockArticleResponse)
                        .toList()
        );
    }
}
