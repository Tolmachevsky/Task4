package ru.tolmachevsky.tasks.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tolmachevsky.tasks.repository.UserRepository;
import ru.tolmachevsky.tasks.model.User;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }


}