package io.github.nicheengine.aerial;

import io.github.nichetoolkit.rest.worker.sha.ShaWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PasswordTest extends AerialEngineServerApplicationTests {

    @Order(1)
    @Test
    void getPassword() {
        String password = "123456";
        String encrypts = ShaWorker.encrypts(password);
        log.info("{}", encrypts);
    }

}
