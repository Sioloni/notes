package ru.neotoria.gempl.microservices.payload.filter;

import ru.neotoria.gempl.microservices.payload.constant.ESourceType;

import java.util.List;
import java.util.UUID;

public record BlockArticleStructureFilter
        (
                List<UUID> materialBlockArticleId,
                ESourceType sourceType
        ) {
}
