package za.ac.cput.service;

import java.util.List;

public interface IServiceM<T, t>{
    T save(T t);
    T find(int t);
    T update(T t);
    boolean delete(int t);
    List<T> findAll();
}
