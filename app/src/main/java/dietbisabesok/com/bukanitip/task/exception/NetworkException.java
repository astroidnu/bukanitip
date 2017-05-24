package dietbisabesok.com.bukanitip.task.exception;


import dietbisabesok.com.bukanitip.R;

/**
 * PLEASE FILL IN THE CLASS DESCRIPTION
 *
 * @author zhaocong
 */
public class NetworkException extends BaseException {

    public final int errorCode;

    public NetworkException(String detailMessage, int errorCode) {
        super(detailMessage);
        this.errorCode = errorCode;
    }

    @Override
    public int getErrorMessage() {
        return R.string.network_error;
    }

    public boolean shouldRetry() {
        return errorCode < 0;
    }
}
