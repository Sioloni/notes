package ru.hearmeout.post_time_service.domain.repository;

import org.springframework.stereotype.Repository;
import ru.hearmeout.post_time_service.domain.entity.PostTime;
import ru.hearmeout.post_time_service.tools.ExtendedRepository;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostTimeRepository extends ExtendedRepository<PostTime, UUID> {
    Optional<PostTime> findByStartAtAfter(LocalDateTime currentTime);

}
