package soluciona.dev.picpay.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.http.HttpStatus;

public class TransferNotAuthorizedException extends PicPayException{

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Transfer not authorized.");
        pb.setDetail("Authorization service not authorized this transfer.");

        return pb;
    }
}