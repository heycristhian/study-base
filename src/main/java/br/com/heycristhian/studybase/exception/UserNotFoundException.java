package br.com.heycristhian.studybase.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID uuid) {
        super("User not found with uuid: " + uuid);
    }
}
