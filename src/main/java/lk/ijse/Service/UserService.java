package lk.ijse.Service;

import lk.ijse.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUser(String userId);
    void deleteUser(String userId);
    boolean updateUser(String  userId, UserDTO userDTO);
}
