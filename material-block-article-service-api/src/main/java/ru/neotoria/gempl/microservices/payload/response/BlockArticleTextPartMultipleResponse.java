package ru.neotoria.gempl.microservices.payload.response;

import java.util.List;

public record BlockArticleTextPartMultipleResponse
        (
                List<BlockArticleTextPartResponse> data
        ) {
}
