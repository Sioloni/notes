package ru.neotoria.gempl.microservices.payload.response;

import ru.neotoria.gempl.microservices.payload.constant.ESourceType;

import java.util.UUID;

public record BlockArticleStructureResponse
        (
                UUID id,
                UUID materialBlockId,
                UUID materialBlockArticleTypeId,
                ESourceType sourceType,
                Long position
        ) {
}
