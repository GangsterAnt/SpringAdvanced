package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRespositoryV0 {

    public void save(String itemId) {
        //save logic
        if (itemId.equals("ex")) {
            throw new IllegalStateException("Exception!");
        }
    }
}
