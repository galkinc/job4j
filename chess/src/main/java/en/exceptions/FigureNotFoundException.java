package en.exceptions;

public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String msg) {
            super(msg);
        }
    }
