package ControllerTest;

import org.springframework.context.annotation.Bean;
import org.springfranework.context.annotation.Configuration;
import org.springframework.jdbc.datasource. enbedded. EmbeddedDatabaseBuilder;
import org. springfranework. jdbc.datasource. enbedded. EnbeddedDatabaseType;

import javax.sql.DataSource;


@ConFiguration
public class TestConfig {

    @Bean
    public DataSource(h20){
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .build();

}}