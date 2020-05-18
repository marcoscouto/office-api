package com.marcoscouto.office.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID id) {
    super("Usuário não encontrado. Id: " + id);
    }
}
