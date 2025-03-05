package soluciona.dev.picpay.service;

import org.springframework.stereotype.Service;
import soluciona.dev.picpay.client.AuthorizationClient;
import soluciona.dev.picpay.controller.dto.TransferDto;
import soluciona.dev.picpay.entity.Transfer;
import soluciona.dev.picpay.exception.PicPayException;

@Service
public class AuthorizationService {
    private final AuthorizationClient authorizationClient;

    public AuthorizationService (AuthorizationClient authorizationClient){
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer){

        var resp =  authorizationClient.isAuthorized();

        if(resp.getStatusCode().isError()){
            throw  new PicPayException();
        }

        return resp.getBody().authorized();
    }
}
