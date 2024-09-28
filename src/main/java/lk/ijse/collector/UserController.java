package lk.ijse.collector;

import lk.ijse.dto.impl.UserDTO;
import lk.ijse.utill.AppUtill;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("api/v1/users")
public class UserController {
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
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64pic);

        return buildUserDTO;


    }
}
