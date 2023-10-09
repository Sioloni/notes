package ru.neotoria.gempl.microservices.payload.response;

import java.util.UUID;

public record BlockArticleTextPartResponse
        (
                UUID id,
                Long localizationContentId,
                UUID materialBlockId
        ) {
}
