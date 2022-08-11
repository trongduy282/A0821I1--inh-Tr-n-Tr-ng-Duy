package codegym.vn.casefurama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<E> {
    void delete(E e);
    E findById(String id);
    void save(E e);
    Page<E> getAll(Pageable pageable);
    List<E> getAll();
}
