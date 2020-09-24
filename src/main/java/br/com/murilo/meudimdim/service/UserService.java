package br.com.murilo.meudimdim.service;

import br.com.murilo.meudimdim.model.User;
import br.com.murilo.meudimdim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final String USER_NOT_FOUND_MESSAGE = "User not found";

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new RuntimeException(USER_NOT_FOUND_MESSAGE);
    }
}
