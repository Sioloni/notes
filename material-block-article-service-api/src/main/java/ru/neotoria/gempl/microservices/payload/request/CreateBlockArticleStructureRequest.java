package ru.neotoria.gempl.microservices.payload.request;

import ru.neotoria.gempl.microservices.payload.constant.ESourceType;

import java.util.UUID;

public record CreateBlockArticleStructureRequest
        (
                UUID materialBlockId,
                UUID materialBlockArticleTypeId,
                ESourceType sourceType,
                Long position
        ) {
}
