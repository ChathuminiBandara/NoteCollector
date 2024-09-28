package lk.ijse.dao;

import lk.ijse.dto.impl.UserDTO;
import lk.ijse.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity, String> {  // entity type and primality keys daya type{
    UserEntity saveUser(UserDTO userDTO);
}
