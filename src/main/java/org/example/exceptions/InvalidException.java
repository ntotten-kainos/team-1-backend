package org.example.exceptions;

public class InvalidException extends Throwable {
    public InvalidException(final Entity entity, final String message) {
        super(entity.getEntity() + " " + message);
    }
}
