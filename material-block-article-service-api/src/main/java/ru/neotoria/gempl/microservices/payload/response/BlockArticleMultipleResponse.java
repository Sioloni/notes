package ru.neotoria.gempl.microservices.payload.response;

import java.util.List;

public record BlockArticleMultipleResponse
        (
                List<BlockArticleResponse> data
        ) {
}
