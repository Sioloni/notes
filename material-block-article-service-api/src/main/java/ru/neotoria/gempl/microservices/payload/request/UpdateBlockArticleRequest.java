package ru.neotoria.gempl.microservices.payload.request;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record UpdateBlockArticleRequest
        (
                UUID materialBlockId,
                List<UUID> structureId
        ) {
}
