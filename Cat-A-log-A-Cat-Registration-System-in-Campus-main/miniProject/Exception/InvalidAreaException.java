//package miniProject.Exception;

public class InvalidAreaException extends Exception {

    public InvalidAreaException(String area) {
        super(String.format("\"%s\" is not a recognised area.", area));
    }

}

