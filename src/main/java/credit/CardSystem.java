package credit;

import java.net.SocketException;

class ModemDidNotConnectException extends Exception {
}

class RetryCCLaterException extends Exception {
    public RetryCCLaterException() {
    }

    public RetryCCLaterException(String message) {
        super(message);
    }

    public RetryCCLaterException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetryCCLaterException(Throwable cause) {
        super(cause);
    }

    public RetryCCLaterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

public class CardSystem {

    public static void authorize() /* throws Modem... BAD */
            throws RetryCCLaterException {
        try {
            if (Math.random() > 0.5) {
                throw new ModemDidNotConnectException();
            }
            if (Math.random() > 0.5) {
                throw new SocketException();
            }
            // pre java7
//        } catch (Exception mdnce) {
        } catch (ModemDidNotConnectException | SocketException problem) {
            // if out of retries
            throw new RetryCCLaterException(problem);
        }
        // old style version 1 ugly duplication
//        catch (SocketException se) {
//
//        }
    }

    public static void main(String[] args) {

    }
}
