package soluciona.dev.bank.service;

import org.springframework.stereotype.Service;
import soluciona.dev.bank.client.AuthorizationClient;
import soluciona.dev.bank.controller.dto.TransferDto;
import soluciona.dev.bank.exception.BankException;

@Service
public class AuthorizationService {
    private final AuthorizationClient authorizationClient;

    public AuthorizationService (AuthorizationClient authorizationClient){
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer){

        var resp =  authorizationClient.isAuthorized();

        if(resp.getStatusCode().isError()){
            throw  new BankException();
        }

        return resp.getBody().authorized();
    }
}
