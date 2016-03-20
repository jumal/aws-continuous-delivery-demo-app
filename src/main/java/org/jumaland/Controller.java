package org.jumaland;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class Controller {

    @RequestMapping("/")
    public String index() throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        return "Hello from " + localhost.getHostName() + " (" + localhost.getHostAddress() + ")!";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
