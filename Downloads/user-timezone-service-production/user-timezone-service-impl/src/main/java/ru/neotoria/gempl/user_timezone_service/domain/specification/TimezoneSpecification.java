package ru.neotoria.gempl.user_timezone_service.domain.specification;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.neotoria.gempl.user_timezone_service.domain.entity.Timezone;
import ru.neotoria.gempl.user_timezone_service.domain.entity.Timezone_;


@UtilityClass
public class TimezoneSpecification {


    public Specification<Timezone> keyLike(String key) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Timezone_.key), "%" + key + "%");
    }

    public Specification<Timezone> offsetAfter(Integer offset) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Timezone_.offset), offset);
    }

    public Specification<Timezone> offsetBefore(Integer offset) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get(Timezone_.offset), offset);
    }

    public Specification<Timezone> buildSpec(String key, Integer offsetAfter, Integer offsetBefore) {
        Specification<Timezone> spec = (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        if (key != null && !key.isEmpty()) {
            spec = spec.and(keyLike(key));
        }
        if (offsetAfter != null && offsetAfter > 0) {
            spec = spec.and(offsetAfter(offsetAfter));
        }
        if (offsetBefore != null && offsetBefore > 0) {
            spec = spec.and(offsetBefore(offsetBefore));
        }
        return spec;
    }


}
