package rs.carrot.authservice.service.external;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rs.carrot.authservice.entity.external.User;

@FeignClient("user-service")
public interface UserService {
    @LoadBalanced
    @GetMapping(value = "/users/{username}/details", produces = "application/json")
    User getByUsername(@PathVariable("username") String username);
}
