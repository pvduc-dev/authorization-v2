package pvduc.dev.authorization.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pvduc.dev.authorization.dto.CreateUserDto;
import pvduc.dev.authorization.model.User;
import pvduc.dev.authorization.repository.UserRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public Page<User> paging(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(user -> modelMapper.map(user, User.class));
    }

    @Override
    public User create(CreateUserDto createUserDto) {
        User user = modelMapper.map(createUserDto, User.class);
        return userRepository.save(user);
    }
}
