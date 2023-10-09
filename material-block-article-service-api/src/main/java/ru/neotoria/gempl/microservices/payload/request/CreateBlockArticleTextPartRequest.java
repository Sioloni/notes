package ru.neotoria.gempl.microservices.payload.request;

import java.util.UUID;

public record CreateBlockArticleTextPartRequest
        (
                Long localizationContentId,
                UUID materialBlockId
        ) {
}
