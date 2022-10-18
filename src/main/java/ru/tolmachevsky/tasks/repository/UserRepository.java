package ru.tolmachevsky.tasks.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tolmachevsky.tasks.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}