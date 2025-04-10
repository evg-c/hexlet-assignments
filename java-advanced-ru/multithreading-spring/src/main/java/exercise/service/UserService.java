package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    public Mono<User> update(int id, User user) {
        //user.setId(id);
        //return userRepository.save(user);
//        var oldData = userRepository.findById(id);
//        var newData = oldData.subscribe(a -> {
//            a.setFirstName(user.getFirstName());
//            a.setLastName(user.getLastName());
//            a.setEmail(user.getEmail());
//            return userRepository.save(a);
//        });
//        return (Mono<User>) newData;
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    existingUser.setEmail(user.getEmail());
                    return userRepository.save(existingUser);
                });
    }

    public Mono<Void> delete(int userId) {
        return userRepository.deleteById(userId);
    }
    // END
}
