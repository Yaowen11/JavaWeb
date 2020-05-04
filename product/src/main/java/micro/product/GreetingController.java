package micro.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyaowen
 */
@RestController
public class GreetingController {

    private final GreetingProps props;
    @Autowired

    public GreetingController(GreetingProps props) {
        this.props = props;
    }

    @GetMapping("/hello")
    public String message() {
        return props.getMessage();
    }
}
