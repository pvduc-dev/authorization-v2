package pvduc.dev.authorization.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pvduc.dev.authorization.model.User;
import pvduc.dev.authorization.service.UserService;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllerImpl implements UserController {
    private final UserService userService;
    @Override
    @GetMapping
    public Page<User> find(Pageable pageable) {
        return userService.paging(pageable);
    }
}
