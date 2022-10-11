package com.dev.helpdesk.Config;

import com.dev.helpdesk.services.Dbservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("devmysql")
public class DevConfig {
    @Autowired
    private Dbservices dbservices;

    @Bean
    public  void instanciadb(){
        dbservices.instanciaDb();
    }
}
