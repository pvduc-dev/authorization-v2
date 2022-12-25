package pvduc.dev.authorization.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pvduc.dev.authorization.dto.CreateUserDto;
import pvduc.dev.authorization.dto.UserDto;
import pvduc.dev.authorization.model.User;

public interface UserService {
    Page<User> paging(Pageable pageable);

    User create(CreateUserDto createUserDto);
}
