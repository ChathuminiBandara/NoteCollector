package lk.ijse.collector;

import lk.ijse.Service.UserService;
import lk.ijse.dto.impl.UserDTO;
import lk.ijse.entity.impl.UserEntity;
import lk.ijse.utill.AppUtill;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    // new mime type - multipart_form_data   :  older type - json
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public UserDTO saveUser(
            @RequestPart ("firstname") String firstName,
            @RequestPart ("lastname") String lastName,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password,
            @RequestPart ("profilepic")MultipartFile profilePic
            ) {


        System.out.println("RAW pro pic : " + profilePic);
        String base64pic = "";

        try {
            byte[] bytesProPIc = profilePic.getBytes();
            base64pic = AppUtill.profilePicToBase64(bytesProPIc);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Todo : UserId Generate
        //String base64pic =  AppUtill.profilePicToBase64(profilePic);

        //Todo : ProfilePic --> Base64
        String userId = AppUtill.generateUserId();

        //Todo : Build the object
        var buildUserDTO = new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64pic);
        userService.saveUser(buildUserDTO);    // passing data to db
        return buildUserDTO;
    }
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getSelectedUser(@PathVariable ("userId") String userId) {
        return userService.getUser(userId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public void deleteSelectedUser(@PathVariable ("userId") String userId) {
        userService.deleteUser(userId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}