package soluciona.dev.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends BankException {

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Saldo Insulficiente.");
        pb.setDetail("Você não pode transferir um valor maior que o seu saldo.");

        return pb;
    }
}