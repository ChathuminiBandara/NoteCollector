package lk.ijse.utill;

import lk.ijse.dto.impl.NoteDTO;
import lk.ijse.dto.impl.UserDTO;
import lk.ijse.entity.impl.NoteEntity;
import lk.ijse.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    // for user mapping : conversion from entity to dto
    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    // conversion dto to entity
    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public List<UserDTO> asUserDTOList(List<UserEntity> UserEntity) {
        return modelMapper.map(UserEntity, new TypeToken<List<UserDTO>>(){}.getType());
    }
    // for note mapping
    public NoteDTO toNoteDTO(NoteEntity noteEntity) {
        return modelMapper.map(noteEntity, NoteDTO.class);
    }
    public NoteEntity toNoteEntity(NoteDTO noteDTO) {
        return modelMapper.map(noteDTO, NoteEntity.class);
    }
    public List<NoteDTO> asNoteDTOList(List<NoteEntity> noteEntities) {
        return modelMapper.map(noteEntities, new TypeToken<List<NoteDTO>>() {}.getType());
    }
}
