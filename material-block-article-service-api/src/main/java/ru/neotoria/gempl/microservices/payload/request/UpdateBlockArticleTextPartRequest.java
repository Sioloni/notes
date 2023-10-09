package ru.neotoria.gempl.microservices.payload.request;

import java.util.UUID;

public record UpdateBlockArticleTextPartRequest
        (
                Long localizationContentId,
                UUID materialBlockId
        ) {
}
