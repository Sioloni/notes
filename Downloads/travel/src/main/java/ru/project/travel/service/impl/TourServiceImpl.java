package ru.project.travel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.travel.dto.TourDto;
import ru.project.travel.entity.Tour;
import ru.project.travel.exception.ApplicationException;
import ru.project.travel.exception.ExceptionMassage;
import ru.project.travel.mapper.TourMapper;
import ru.project.travel.repository.TourRepository;
import ru.project.travel.service.TourService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {
    private final TourRepository repository;
    private final TourMapper mapper;


    @Override
    public List<Tour> get(List<Long> id) {
        return repository.findAllById(id);
    }

    @Override
    public List<TourDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public TourDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMassage.ID_NOT_FOUND)));
    }

    @Override
    public void create(TourDto dto) {
        dto.setAmountUser(1);
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Long id, TourDto dto) {
        Tour entity = mapper.toEntity(get(id));
        repository.save(mapper.update(entity, dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
