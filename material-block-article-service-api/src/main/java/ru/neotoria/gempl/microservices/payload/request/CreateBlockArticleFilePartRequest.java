package ru.neotoria.gempl.microservices.payload.request;

import java.util.UUID;

public record CreateBlockArticleFilePartRequest
        (
                UUID fileId,
                UUID materialBlockId
        ) {
}
