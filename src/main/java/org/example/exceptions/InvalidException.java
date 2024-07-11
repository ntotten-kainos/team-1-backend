package org.example.exceptions;

public class InvalidException extends Throwable {
    public InvalidException(Entity entity, String message) {
        super(entity.getEntity() + " " + message);
    }
}
