package za.ac.nwu.accountsys.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.accountsys.web.sb.controller",
        "za.ac.nwu.accountsys.web.sb.exception"
})

public class WebConfig {
}
