package exception;

import java.io.IOException;

public class GetFieldException extends IOException {
	public String getMessage() {
    	return "Error when get virus's component by GetField ";
    }
}
