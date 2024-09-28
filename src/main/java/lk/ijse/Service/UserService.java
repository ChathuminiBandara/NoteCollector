package lk.ijse.Service;

import lk.ijse.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUser(String userId);
    boolean deleteUser(String userId);
    boolean updateUSer(String  userId, UserDTO userDTO);
}
