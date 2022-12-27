package pvduc.dev.authorization.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pvduc.dev.authorization.model.User;

public interface UserController {
    Page<User> find(Pageable pageable);
}
