package soluciona.dev.bank.exception;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends BankException {

    private String walletId;

    public WalletNotFoundException(String walletId) {
        this.walletId = String.valueOf(walletId);
    }

    public WalletNotFoundException(@NotNull Long payer) {
        super();
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Carteira não encontrada.");
        pb.setDetail("Não foi encontrado essa carteira  " + walletId + ".");

        return pb;
    }
}