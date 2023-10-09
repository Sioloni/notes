package ru.neotoria.gempl.microservices.payload.response;

import java.util.List;
import java.util.UUID;

public record BlockArticleResponse
        (
                UUID id,
                List<UUID> structures
        ) {

}
