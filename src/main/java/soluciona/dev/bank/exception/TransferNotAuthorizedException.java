package soluciona.dev.bank.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.http.HttpStatus;

public class TransferNotAuthorizedException extends BankException {

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Transferência não autorizada.");
        pb.setDetail("Serviço de autorização não esta disponivel para essa transferência.");

        return pb;
    }
}