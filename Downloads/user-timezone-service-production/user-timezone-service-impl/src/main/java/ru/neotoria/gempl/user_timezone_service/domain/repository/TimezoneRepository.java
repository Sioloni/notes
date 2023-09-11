package ru.neotoria.gempl.user_timezone_service.domain.repository;

import org.springframework.stereotype.Repository;
import ru.neotoria.gempl.microservices.common_service.util.ExtendedRepository;
import ru.neotoria.gempl.user_timezone_service.domain.entity.Timezone;


@Repository
public interface TimezoneRepository extends ExtendedRepository<Timezone, Long> {

}
