package pl.javastart.cookbook.services;

import org.springframework.stereotype.Service;
import pl.javastart.cookbook.dto.UserDto;
import pl.javastart.cookbook.entities.User;
import pl.javastart.cookbook.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    public void addUser(UserDto userDto) {
        User user = new User(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getDateOfBirth(),
                userDto.getEmail(),
                userDto.isAssignedToNewsletter());
        userRepository.save(user);
    }

    private UserDto userToDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth(),
                user.getEmail(),
                user.isAssignedInNewsletter());
    }
}
