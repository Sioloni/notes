package ru.neotoria.gempl.microservices.payload.request;

import java.util.UUID;

public record UpdateBlockArticleFilePartRequest
        (
                UUID fileId,
                UUID materialBlockId
        ) {
}
