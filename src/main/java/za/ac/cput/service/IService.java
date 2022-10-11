package za.ac.cput.service;

import java.util.List;
import java.util.Optional;

public interface IService <T, ID>{

    T create (T t);
    Optional<T> read (ID id);
    T update (T t);
    void delete (T t);


}
