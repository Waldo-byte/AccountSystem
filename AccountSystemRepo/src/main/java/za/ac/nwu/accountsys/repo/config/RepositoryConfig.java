package za.ac.nwu.accountsys.repo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.accountsys.repo.persistence")
@EntityScan("domain.persistance")
@PropertySource(value = "classpath:application-db.properties")
public class RepositoryConfig {}
