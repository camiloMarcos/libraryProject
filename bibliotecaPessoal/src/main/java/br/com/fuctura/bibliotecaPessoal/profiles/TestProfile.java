package br.com.fuctura.bibliotecaPessoal.profiles;

import br.com.fuctura.bibliotecaPessoal.services.DBService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestProfile {

    @Autowired
    private DBService dbService;

    @PostConstruct // para o método ficar visivel numa classe @configuration
    public void initDB() {
        dbService.inicializaDB();
    }
}
