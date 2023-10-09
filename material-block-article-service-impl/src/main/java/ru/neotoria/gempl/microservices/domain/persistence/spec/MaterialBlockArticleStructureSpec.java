package ru.neotoria.gempl.microservices.domain.persistence.spec;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleStructure;
import ru.neotoria.gempl.microservices.domain.persistence.entity.MaterialBlockArticleStructure_;
import ru.neotoria.gempl.microservices.payload.constant.ESourceType;
import ru.neotoria.gempl.microservices.payload.filter.BlockArticleStructureFilter;
import ru.neotoria.microservices.common.util.Spec;

import java.util.Collection;
import java.util.UUID;

@UtilityClass
public class MaterialBlockArticleStructureSpec {


//    public Specification<MaterialBlockArticleStructure> materialBlockIdIn(Collection<UUID> ids) {
//        if (ids == null || ids.isEmpty()) {
//            return Spec.conjunction();
//        }
//        return Spec.fieldIn(
//                Materia,
//                ids
//        );
//    }

    public Specification<MaterialBlockArticleStructure> materialBlockArticleIdIn(Collection<UUID> ids) {
        if (ids == null || ids.isEmpty()) {
            return Spec.conjunction();
        }
        return Spec.fieldIn(
                MaterialBlockArticleStructure_.materialBlockArticleTypeId,
                ids
        );
    }

    public Specification<MaterialBlockArticleStructure> sourceTypeEquals(ESourceType type) {
        if (type == null || type.toString().isEmpty()) {
            return Spec.conjunction();
        }
        return Spec.fieldEqual(
                MaterialBlockArticleStructure_.sourceType,
                type
        );
    }

    public Specification<MaterialBlockArticleStructure> buildSpec(BlockArticleStructureFilter filter) {
        Specification<MaterialBlockArticleStructure> spec = (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();

        if (filter.materialBlockArticleId() != null && !filter.materialBlockArticleId().toString().isEmpty()) {
            spec = spec.and(MaterialBlockArticleStructureSpec.materialBlockArticleIdIn(filter.materialBlockArticleId()));
        }
        if (filter.sourceType() != null && !filter.sourceType().toString().isEmpty()) {
            spec = spec.and(MaterialBlockArticleStructureSpec.sourceTypeEquals(filter.sourceType()));
        }

        return spec;
    }
}
