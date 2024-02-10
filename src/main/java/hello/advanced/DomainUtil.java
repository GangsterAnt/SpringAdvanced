package hello.advanced;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DomainUtil {

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
