package ru.neotoria.gempl.microservices.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleFilePart;
import ru.neotoria.gempl.microservices.domain.persistence.repository.MaterialBlockArticleFilePartRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialBlockArticleFilePartService {
    private final MaterialBlockArticleFilePartRepository repository;


    public List<MaterialBlockArticleFilePart> getAll() {
        return repository.findAll();
    }


    public MaterialBlockArticleFilePart getById(UUID id) {
        return repository.getEntityById(id);
    }


    public void create
            (
                    UUID fileId,
                    UUID materialBlockId
            ) {

        repository.save(
                new MaterialBlockArticleFilePart(
                        UUID.randomUUID(),
                        fileId,
                        materialBlockId
                ));
    }


    public void update
            (
                    UUID id,
                    UUID fileId,
                    UUID materialBlockId
            ) {

        MaterialBlockArticleFilePart materialBlockArticleFilePart
                = repository.getEntityById(id);

        if (fileId != null && !fileId.toString().isEmpty()) {
            materialBlockArticleFilePart.setFileId(fileId);
        }
        if (materialBlockId != null && !materialBlockId.toString().isEmpty()) {
            materialBlockArticleFilePart.setMaterialBlockId(materialBlockId);
        }

        repository.save(materialBlockArticleFilePart);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
