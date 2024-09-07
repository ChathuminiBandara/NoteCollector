package lk.ijse.utill;

import java.util.UUID;

public class AppUtill {
    public static String generateNoteId(){
    return  "Note-" + UUID.randomUUID();

    }
}
