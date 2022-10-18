package ru.tolmachevsky.tasks.service;


import ru.tolmachevsky.tasks.model.User;

public interface UserService {
    void save(User user);

    public Iterable<User> getAllUsers();

    void dropAllTables();

}