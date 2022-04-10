/*
    Chef.java
    IRepository for Waiter
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.entity.Waiter;

import java.util.Set;

public interface IWaiterRepository extends IRepository <Waiter, String> {
    Waiter create(Waiter waiter);

    Waiter read(int waiterId);

    Waiter delete(int waiterId);

    Set<Waiter>
    getAll();
}
