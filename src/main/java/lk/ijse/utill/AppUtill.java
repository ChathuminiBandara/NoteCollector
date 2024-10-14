package lk.ijse.utill;

import java.util.Base64;
import java.util.UUID;

public class AppUtill {
    public static String generateNoteId(){
    return  "Note-" + UUID.randomUUID();
    }

    public static String generateUserId(){
        return "User-" + UUID.randomUUID();
    }

    public static String profilePicToBase64(byte[] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
