package exception;

import java.io.IOException;

public class AttackException extends Exception {
	public String getMessage() {
    	return "Error, this type of virus can not attack cell ";
    }
}
