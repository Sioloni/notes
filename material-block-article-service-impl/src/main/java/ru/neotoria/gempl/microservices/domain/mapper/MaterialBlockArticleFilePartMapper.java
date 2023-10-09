package ru.neotoria.gempl.microservices.domain.mapper;

import org.springframework.stereotype.Component;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleFilePart;
import ru.neotoria.gempl.microservices.payload.response.BlockArticleFilePartMultipleResponse;
import ru.neotoria.gempl.microservices.payload.response.BlockArticleFilePartResponse;

import java.util.Collection;

@Component
public class MaterialBlockArticleFilePartMapper {


    public BlockArticleFilePartResponse toBlockArticleFilePartResponse(
            MaterialBlockArticleFilePart materialBlockArticleFilePart) {
        return new BlockArticleFilePartResponse(
                materialBlockArticleFilePart.getId(),
                materialBlockArticleFilePart.getFileId(),
                materialBlockArticleFilePart.getMaterialBlockId()
        );
    }


    public BlockArticleFilePartMultipleResponse toBlockArticleFilePartMultipleResponse(
            Collection<MaterialBlockArticleFilePart> materialBlockArticleFileParts) {
        return new BlockArticleFilePartMultipleResponse(
                materialBlockArticleFileParts
                        .stream()
                        .map(this::toBlockArticleFilePartResponse)
                        .toList()
        );
    }
}
