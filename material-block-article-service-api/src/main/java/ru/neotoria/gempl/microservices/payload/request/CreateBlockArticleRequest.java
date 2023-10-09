package ru.neotoria.gempl.microservices.payload.request;

import java.util.List;
import java.util.UUID;

public record CreateBlockArticleRequest
        (
                UUID materialBlockId,
                List<UUID> structureIds
        ) {
}
