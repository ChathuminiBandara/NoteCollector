package lk.ijse.Service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Service.UserService;
import lk.ijse.dao.UserDAO;
import lk.ijse.dto.impl.UserDTO;
import lk.ijse.entity.impl.UserEntity;
import lk.ijse.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // meta annotated from the @Component annotation
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
       UserEntity saveUser =  userDAO.save(mapping.toUserEntity(userDTO));
       return mapping.toUserDTO(saveUser);
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
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }
}
