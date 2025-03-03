package soluciona.dev.picpay.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import soluciona.dev.picpay.client.dto.AuthorizationResponse;

@FeignClient(
        name = "AuthorizationClient",
        url = "${client.authorization-service.url}"
)
public interface AuthorizationClient {

    @GetMapping
    ResponseEntity<AuthorizationResponse> isAuthorized();
}
