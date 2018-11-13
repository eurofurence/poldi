package org.eurofurence.poldi.poldi;

import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    static private Log log = LogFactory.getLog(HelloController.class);

    {
        log.warn("Dragon: HelloController static started");
    }
    
    @RequestMapping("/hello")
    public String index() {
        log.warn("Dragon: HelloController index called");
        return "Greetings from Spring Boot!";
    }
    
}