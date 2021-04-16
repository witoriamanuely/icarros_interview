package br.com.br.consumingrest.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.MalformedURLException;


@Getter
@Setter
public class ApplicationProperties {

    public ApplicationProperties(@Value("${application.yml}") String url){
        ApplicationProperties.URL = url;
    }
    public static String URL;
}
