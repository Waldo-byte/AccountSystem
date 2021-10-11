package za.ac.nwu.accountsys.translator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import za.ac.nwu.accountsys.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = "za.ac.nwu.accountsys.translator")
public class TranslatorConfig {
}
