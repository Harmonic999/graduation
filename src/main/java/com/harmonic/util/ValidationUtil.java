package com.harmonic.util;

import com.harmonic.util.exception.NotFoundException;

public class ValidationUtil {

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFoundObject(object, "id=" + id);
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    private static <T> T checkNotFoundObject(T object, String message) {
        checkNotFound(object != null, message);
        return object;
    }

    private static void checkNotFound(boolean found, String message) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + message);
        }
    }

    //  http://stackoverflow.com/a/28565320/548473
    public static Throwable getRootCause(Throwable t) {
        Throwable result = t;
        Throwable cause;

        while (null != (cause = result.getCause()) && (result != cause)) {
            result = cause;
        }
        return result;
    }

    public static String getMessage(Throwable e) {
        return e.getLocalizedMessage() != null ? e.getLocalizedMessage() : e.getClass().getName();
    }

}
