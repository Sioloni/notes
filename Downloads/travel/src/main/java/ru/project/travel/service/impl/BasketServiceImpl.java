package ru.project.travel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.travel.dto.BasketDto;
import ru.project.travel.entity.Basket;
import ru.project.travel.exception.ApplicationException;
import ru.project.travel.exception.ExceptionMassage;
import ru.project.travel.mapper.BasketMapper;
import ru.project.travel.repository.BasketRepository;
import ru.project.travel.service.BasketService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository repository;
    private final BasketMapper mapper;


    @Override
    public List<BasketDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public BasketDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMassage.ID_NOT_FOUND)));
    }

    @Override
    public void create(BasketDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Long id, BasketDto dto) {
        Basket entity = mapper.toEntity(get(id));

        repository.save(mapper.update(entity, dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
