package lk.ijse.Service.impl;

import lk.ijse.Service.UserService;
import lk.ijse.dto.impl.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // meta annotated from the @Component annotation
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserService userService;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO getUser(String userId) {
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public boolean updateUSer(String userId, UserDTO userDTO) {
        return false;
    }
}
