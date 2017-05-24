package dietbisabesok.com.bukanitip.task.exception;

/**
 * PLEASE FILL IN THE CLASS DESCRIPTION
 *
 * @author zhaocong
 */
public abstract class BaseException extends Exception {

    public BaseException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * @return resource ID for error messages
     */
    public abstract int getErrorMessage();
}
