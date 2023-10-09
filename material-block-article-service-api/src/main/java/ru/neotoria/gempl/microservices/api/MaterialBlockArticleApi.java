package ru.neotoria.gempl.microservices.api;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neotoria.gempl.microservices.api.router.MaterialBlockArticleRouter;
import ru.neotoria.gempl.microservices.payload.filter.BlockArticleStructureFilter;
import ru.neotoria.gempl.microservices.payload.request.*;
import ru.neotoria.gempl.microservices.payload.response.*;
import ru.neotoria.microservices.common.config.open_feign.OpenFeignAutoConfig;

import java.util.UUID;

@LoadBalancerClient("material-block-article-service")
@FeignClient(name = "material-block-article-service", configuration = {OpenFeignAutoConfig.class})
public interface MaterialBlockArticleApi {


    @PostMapping(MaterialBlockArticleRouter.ROOT)
    BlockArticleMultipleResponse getAllBlockArticle();

    @PostMapping(MaterialBlockArticleRouter.ID.ROOT)
    BlockArticleResponse getByIdBlockArticle(@PathVariable UUID id);

    @PostMapping(MaterialBlockArticleRouter.CREATE)
    void createBlockArticle(@RequestBody CreateBlockArticleRequest request);

    @PostMapping(MaterialBlockArticleRouter.ID.UPDATE)
    void updateBlockArticle(@PathVariable UUID id, @RequestBody UpdateBlockArticleRequest request);

    @PostMapping(MaterialBlockArticleRouter.ID.DELETE)
    void deleteBlockArticle(@PathVariable UUID id);

    @PostMapping(MaterialBlockArticleRouter.FILE)
    BlockArticleFilePartMultipleResponse getAllBlockArticleFilePart();

    @PostMapping(MaterialBlockArticleRouter.ID.FILE)
    BlockArticleFilePartResponse getByIdBlockArticleFilePart(@PathVariable UUID id);

    @PostMapping(MaterialBlockArticleRouter.FILE_CREATE)
    void createBlockArticleFilePart(@RequestBody CreateBlockArticleFilePartRequest request);

    @PostMapping(MaterialBlockArticleRouter.ID.FILE_UPDATE)
    void updateBlockArticleFilePart(@PathVariable UUID id, @RequestBody UpdateBlockArticleFilePartRequest request);

    @PostMapping(MaterialBlockArticleRouter.ID.FILE_DELETE)
    void deleteBlockArticleFilePart(@PathVariable UUID id);

    @PostMapping(MaterialBlockArticleRouter.TEXT)
    BlockArticleTextPartMultipleResponse getAllBlockArticleTextPart();

    @PostMapping(MaterialBlockArticleRouter.ID.TEXT)
    BlockArticleTextPartResponse getByIdBlockArticleTextPart(@PathVariable UUID id);

    @PostMapping(MaterialBlockArticleRouter.TEXT_CREATE)
    void createBlockArticleTextPart(@RequestBody CreateBlockArticleTextPartRequest request);

    @PostMapping(MaterialBlockArticleRouter.ID.TEXT_UPDATE)
    void updateBlockArticleTextPart(@PathVariable UUID id, @RequestBody UpdateBlockArticleTextPartRequest request);

    @PostMapping(MaterialBlockArticleRouter.ID.TEXT_DELETE)
    void deleteBlockArticleTextPart(@PathVariable UUID id);

    @PostMapping(MaterialBlockArticleRouter.STRUCTURE)
    BlockArticleStructureMultipleResponse getAllBlockArticleStructure();

    @PostMapping(MaterialBlockArticleRouter.ID.STRUCTURE)
    BlockArticleStructureResponse getByIdBlockArticleStructure(@PathVariable UUID id);

    @PostMapping(MaterialBlockArticleRouter.STRUCTURE_CREATE)
    void createBlockArticleStructure(@RequestBody CreateBlockArticleStructureRequest request);

    @PostMapping(MaterialBlockArticleRouter.ID.STRUCTURE_UPDATE)
    void updateBlockArticleStructure(@PathVariable UUID id, @RequestBody UpdateBlockArticleStructureRequest request);

    @PostMapping(MaterialBlockArticleRouter.ID.STRUCTURE_DELETE)
    void deleteBlockArticleStructure(@PathVariable UUID id);

    @PostMapping(MaterialBlockArticleRouter.STRUCTURE_FILTER)
    BlockArticleStructureMultipleResponse filterBlockArticleStructure(@RequestBody BlockArticleStructureFilter filter);

}
