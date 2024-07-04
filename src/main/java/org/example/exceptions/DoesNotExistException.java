package org.example.exceptions;

public final class DoesNotExistException extends Throwable {
    public DoesNotExistException(final Entity entity) {
        super(entity.getEntity() + "does not exist");
    }
}
