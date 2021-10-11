package za.ac.nwu.accountsys.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.accountsys.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.accountsys.web.sb.controller",
        "za.ac.nwu.accountsys.web.sb.exception"
})

public class WebConfig {
}
