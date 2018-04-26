package dmitry.spring.test.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties("spring.mydatasource.myhikari")
public class HikariConfiguration extends HikariConfig {

    @Bean
    public DataSource getDataSource() {
        return new HikariDataSource(this);
    }
}
