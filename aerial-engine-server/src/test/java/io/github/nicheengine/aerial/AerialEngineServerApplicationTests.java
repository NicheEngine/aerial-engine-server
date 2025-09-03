package io.github.nicheengine.aerial;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AerialEngineServerApplicationTests {

    /**
     * <code>contextLoads</code>
     * <p>The context loads method.</p>
     * @see org.junit.jupiter.api.Order
     * @see org.junit.jupiter.api.Test
     */
    @Order(0)
    @Test
    void contextLoads() {
        log.info("The example test will be initiated");
    }


}
