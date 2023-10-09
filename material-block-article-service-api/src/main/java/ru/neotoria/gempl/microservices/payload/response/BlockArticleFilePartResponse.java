package ru.neotoria.gempl.microservices.payload.response;

import java.util.UUID;

public record BlockArticleFilePartResponse
        (
                UUID id,
                UUID fileId,
                UUID materialBlockId
        ) {
}
