package ru.neotoria.microservices.common.payload;

import java.util.Collection;

public record getByIdsRequest<T>
        (
                Collection<T> ids
        ) {
}
