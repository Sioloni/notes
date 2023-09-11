package ru.neotoria.gempl.user_timezone_service.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neotoria.gempl.user_timezone_service.domain.entity.Timezone;
import ru.neotoria.gempl.user_timezone_service.domain.repository.TimezoneRepository;
import ru.neotoria.gempl.user_timezone_service.domain.specification.TimezoneSpecification;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TimezoneService {
    private final TimezoneRepository repository;


    public Timezone get(Long id) {
        return repository.getEntityById(id);
    }

    public List<Timezone> get() {
        return repository.findAll();
    }

    public List<Timezone> searchTimezone(String key, Integer offsetAfter, Integer offsetBefore) {
        return repository.findAll(TimezoneSpecification.buildSpec
                (
                        key,
                        offsetAfter,
                        offsetBefore
                )
        );
    }

}
