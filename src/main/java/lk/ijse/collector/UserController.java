package lk.ijse.collector;

import lk.ijse.Service.UserService;
import lk.ijse.customStatusCode.SelectedUserAndNoteErrorStatus;
import lk.ijse.dto.UserStatus;
import lk.ijse.dto.impl.UserDTO;
import lk.ijse.exception.UserNotFoundException;
import lk.ijse.utill.AppUtill;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;


@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    // new mime type - multipart_form_data   :  older type - json
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> saveUser(
            @RequestPart ("firstname") String firstName,
            @RequestPart ("lastname") String lastName,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password,
            @RequestPart ("profilepic")MultipartFile profilePic
            ) {
            // regex check here - from a predefined class

        System.out.println("RAW pro pic : " + profilePic);
        String base64pic = "";

        try {
            byte[] bytesProPIc = profilePic.getBytes();
            base64pic = AppUtill.profilePicToBase64(bytesProPIc);

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
            return new ResponseEntity<>(HttpStatus.CREATED);

            // return buildUserDTO;

        } catch (IOException e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // sending the status code
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatus getSelectedUser(@PathVariable ("userId") String userId) {
        String regexForUserID = "^User-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(userId);

        if(!regexMatcher.matches()){
            return new SelectedUserAndNoteErrorStatus(1,"User ID is not valid");
        }
        return userService.getUser(userId);
    }

    // @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteSelectedUser(@PathVariable ("userId") String userId) {
        String regexForUserID = "^User-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(userId);
        try {
            if(!regexMatcher.matches()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void  updateUser(  @RequestPart ("firstname") String firstName,
                              @RequestPart ("lastname") String lastName,
                              @RequestPart ("email") String email,
                              @RequestPart ("password") String password,
                              @RequestPart ("profilepic")MultipartFile profilePic,
                             @PathVariable ("userId") String userId )
    {
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

        //Todo : Build the object
        var buildUserDTO = new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64pic);
        userService.saveUser(buildUserDTO);    // passing data to db

    }

}