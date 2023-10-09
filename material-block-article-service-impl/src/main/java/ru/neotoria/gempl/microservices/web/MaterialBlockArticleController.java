package ru.neotoria.gempl.microservices.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.neotoria.gempl.microservices.api.MaterialBlockArticleApi;
import ru.neotoria.gempl.microservices.domain.mapper.MaterialBlockArticleFilePartMapper;
import ru.neotoria.gempl.microservices.domain.mapper.MaterialBlockArticleMapper;
import ru.neotoria.gempl.microservices.domain.mapper.MaterialBlockArticleStructureMapper;
import ru.neotoria.gempl.microservices.domain.mapper.MaterialBlockArticleTextPartMapper;
import ru.neotoria.gempl.microservices.domain.service.MaterialBlockArticleFilePartService;
import ru.neotoria.gempl.microservices.domain.service.MaterialBlockArticleService;
import ru.neotoria.gempl.microservices.domain.service.MaterialBlockArticleStructureService;
import ru.neotoria.gempl.microservices.domain.service.MaterialBlockArticleTextPartService;
import ru.neotoria.gempl.microservices.payload.filter.BlockArticleStructureFilter;
import ru.neotoria.gempl.microservices.payload.request.*;
import ru.neotoria.gempl.microservices.payload.response.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MaterialBlockArticleController implements MaterialBlockArticleApi {
    private final MaterialBlockArticleService blockArticleService;
    private final MaterialBlockArticleMapper blockArticleMapper;
    private final MaterialBlockArticleFilePartService blockArticleFilePartService;
    private final MaterialBlockArticleFilePartMapper blockArticleFilePartMapper;
    private final MaterialBlockArticleTextPartService blockArticleTextPartService;
    private final MaterialBlockArticleTextPartMapper blockArticleTextPartMapper;
    private final MaterialBlockArticleStructureService materialBlockArticleStructureService;
    private final MaterialBlockArticleStructureMapper materialBlockArticleStructureMapper;


    @Override
    public BlockArticleMultipleResponse getAllBlockArticle() {
        return blockArticleMapper.toBlockArticleMultipleResponse(
                blockArticleService.getAll()
        );
    }

    @Override
    public BlockArticleResponse getByIdBlockArticle(UUID id) {
        return blockArticleMapper.toBlockArticleResponse(
                blockArticleService.getById(id)
        );
    }

    @Override
    public void createBlockArticle(CreateBlockArticleRequest request) {
        blockArticleService.create(
                request.materialBlockId(),
                request.structureIds()
        );
    }

    @Override
    public void updateBlockArticle(UUID id, UpdateBlockArticleRequest request) {
        blockArticleService.update(
                id,
                request.materialBlockId(),
                request.structureId()
        );
    }

    @Override
    public void deleteBlockArticle(UUID id) {
        blockArticleService.delete(id);
    }

    @Override
    public BlockArticleFilePartMultipleResponse getAllBlockArticleFilePart() {
        return blockArticleFilePartMapper
                .toBlockArticleFilePartMultipleResponse(
                        blockArticleFilePartService.getAll()
                );
    }

    @Override
    public BlockArticleFilePartResponse getByIdBlockArticleFilePart(UUID id) {
        return blockArticleFilePartMapper.toBlockArticleFilePartResponse
                (
                        blockArticleFilePartService.getById(id)
                );
    }

    @Override
    public void createBlockArticleFilePart(CreateBlockArticleFilePartRequest request) {
        blockArticleFilePartService.create
                (
                        request.fileId(),
                        request.materialBlockId()
                );
    }

    @Override
    public void updateBlockArticleFilePart(UUID id, UpdateBlockArticleFilePartRequest request) {
        blockArticleFilePartService.update
                (
                        id,
                        request.fileId(),
                        request.materialBlockId()
                );
    }

    @Override
    public void deleteBlockArticleFilePart(UUID id) {
        blockArticleFilePartService.delete(id);
    }

    @Override
    public BlockArticleTextPartMultipleResponse getAllBlockArticleTextPart() {
        return blockArticleTextPartMapper
                .toBlockArticleTextPartMultipleResponse
                        (
                                blockArticleTextPartService.getAll()
                        );
    }

    @Override
    public BlockArticleTextPartResponse getByIdBlockArticleTextPart(UUID id) {
        return blockArticleTextPartMapper
                .toBlockArticleTextPartResponse
                        (
                                blockArticleTextPartService.getById(id)
                        );
    }

    @Override
    public void createBlockArticleTextPart(CreateBlockArticleTextPartRequest request) {
        blockArticleTextPartService.create
                (
                        request.localizationContentId(),
                        request.materialBlockId()
                );
    }

    @Override
    public void updateBlockArticleTextPart(UUID id, UpdateBlockArticleTextPartRequest request) {
        blockArticleTextPartService.update
                (
                        id,
                        request.localizationContentId(),
                        request.materialBlockId()
                );
    }

    @Override
    public void deleteBlockArticleTextPart(UUID id) {
        blockArticleTextPartService.delete(id);
    }

    @Override
    public BlockArticleStructureMultipleResponse getAllBlockArticleStructure() {
        return materialBlockArticleStructureMapper
                .toBlockArticleStructureMultipleResponse
                        (
                                materialBlockArticleStructureService.getAll()
                        );
    }

    @Override
    public BlockArticleStructureResponse getByIdBlockArticleStructure(UUID id) {
        return materialBlockArticleStructureMapper
                .toBlockArticleStructureResponse
                        (
                                materialBlockArticleStructureService.getById(id)
                        );
    }

    @Override
    public void createBlockArticleStructure(CreateBlockArticleStructureRequest request) {
        materialBlockArticleStructureService.create
                (
                        request.materialBlockId(),
                        request.materialBlockArticleTypeId(),
                        request.sourceType()
                );
    }

    @Override
    public void updateBlockArticleStructure(UUID id, UpdateBlockArticleStructureRequest request) {
        materialBlockArticleStructureService
                .update
                        (
                                id,
                                request.materialBlockId(),
                                request.materialBlockArticleId(),
                                request.sourceType(),
                                request.position()
                        );
    }

    @Override
    public void deleteBlockArticleStructure(UUID id) {
        materialBlockArticleStructureService.delete(id);
    }

    @Override
    public BlockArticleStructureMultipleResponse filterBlockArticleStructure(BlockArticleStructureFilter filter) {
        return materialBlockArticleStructureMapper
                .toBlockArticleStructureMultipleResponse
                        (
                                materialBlockArticleStructureService
                                        .filter(filter)
                        );
    }
}
