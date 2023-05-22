package ru.hearmeout.post_time_service.tools;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;
import ru.hearmeout.post_time_service.core.exceptions.HMOError;
import ru.hearmeout.post_time_service.core.exceptions.HMOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoRepositoryBean
public interface ExtendedRepository<T, ID> extends JpaRepositoryImplementation<T, ID> {


    default T getEntityById(ID id) {
        return this.findById(id).orElseThrow(
                () -> new HMOException(
                        HMOError.NOT_FOUND_BY_ID
                )
        );
    }

    default List<T> getEntityByIds(Collection<ID> ids) {

        if (ids != null) {
            ids.remove(null);

            return this.findAllById(ids);
        }

        return new ArrayList<>();
    }

    default void deleteByIds(Collection<ID> ids) {
        if (ids != null) {
            ids.remove(null);

            this.deleteAllById(ids);
        }
    }
}
