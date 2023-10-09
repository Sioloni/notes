package ru.neotoria.gempl.microservices.payload.request;

import ru.neotoria.gempl.microservices.payload.constant.ESourceType;

import java.util.UUID;

public record UpdateBlockArticleStructureRequest
        (
                UUID materialBlockId,
                UUID materialBlockArticleId,
                ESourceType sourceType,
                Long position
        ) {
}
