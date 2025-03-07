package soluciona.dev.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletDataAlreadyExistsException  extends BankException {

    private String detail;

    public WalletDataAlreadyExistsException(String detail) {
        this.detail = detail;

    }

    @Override
    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Carteira já cadastrada.");
        pb.setDetail(detail);

        return pb;

    }
}
