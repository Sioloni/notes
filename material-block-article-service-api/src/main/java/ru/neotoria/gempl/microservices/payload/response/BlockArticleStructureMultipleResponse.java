package ru.neotoria.gempl.microservices.payload.response;

import java.util.List;

public record BlockArticleStructureMultipleResponse
        (
                List<BlockArticleStructureResponse> data
        ) {
}
