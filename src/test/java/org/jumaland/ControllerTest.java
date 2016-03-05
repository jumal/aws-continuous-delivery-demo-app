package org.jumaland;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ControllerTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void index() throws Exception {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity("http://127.0.0.1:" + port, String.class);
        assertThat(response.getStatusCode(), is(OK));
        assertThat(response.getBody(), containsString(InetAddress.getLocalHost().getHostAddress()));
    }

    @Test
    public void useRandomPort() {
        assertThat(port, not(80));
        assertThat(port, not(8080));
    }
}
