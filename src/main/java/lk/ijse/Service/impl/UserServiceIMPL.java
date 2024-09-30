package lk.ijse.Service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Service.UserService;
import lk.ijse.customStatusCode.SelectedUserAndNoteErrorStatus;
import lk.ijse.dao.UserDAO;
import lk.ijse.dto.UserStatus;
import lk.ijse.dto.impl.UserDTO;
import lk.ijse.entity.impl.UserEntity;
import lk.ijse.exception.UserNotFoundException;
import lk.ijse.utill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // meta annotated from the @Component annotation
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveUser(UserDTO userDTO) {
       UserEntity saveUser =  userDAO.save(mapping.toUserEntity(userDTO));
       if(saveUser == null){
           throw new DataIntegrityViolationException("User already exists");
       }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers =  userDAO.findAll();
        return mapping.asUserDTOList(allUsers);         // ena userdto tika entity walata convert kragena returning
    }

    @Override
    public UserStatus getUser(String userId) {
        if(userDAO.existsById(userId)){
            UserEntity selectedUser = userDAO.getReferenceById(userId);
            return mapping.toUserDTO(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2, "User with id " + userId + " not found");
        }
    }


    @Override
    public void deleteUser(String userId) {
          Optional<UserEntity> existUser =  userDAO.findById(userId);
          if(!existUser.isPresent()){
              throw new UserNotFoundException( "User with id " + userId + " not found");
          }else {
              userDAO.deleteById(userId);
          }
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
       Optional<UserEntity> tempUser = userDAO.findById(userId);
       if(tempUser.isPresent()) {
           tempUser.get().setFirstName(userDTO.getFirstName());
           tempUser.get().setLastName(userDTO.getLastName());
           tempUser.get().setEmail(userDTO.getEmail());
           tempUser.get().setProfilePic(userDTO.getProfilePic());
           tempUser.get().setPassword(userDTO.getPassword());
       }
    }
}
