package com.keyvault.poc.vault;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import com.microsoft.azure.keyvault.KeyVaultClient;
import com.microsoft.azure.keyvault.models.SecretBundle;




public class AppConfigEnvironmentPostProcessor implements EnvironmentPostProcessor
{

    /**
     * Name of the custom property source added by this post processor class
     */
    private static final String PROPERTY_SOURCE_NAME = "ApplicationConfiguration";

    private static final Logger logger = LoggerFactory.getLogger(AppConfigEnvironmentPostProcessor.class);
    private static final String VAULT_URL = "https://your.vault.azure.net/secrets/";
    private static final String VAULT_BASE_URL="https://your.vault.azure.net/";

    @Override
    public void postProcessEnvironment( ConfigurableEnvironment environment, SpringApplication application )
    {
    	
        Map<String, Object> propertySource = new HashMap<>();
        String pathToCsv="path containing the csv for sample look file test4 in resource folder ";
        BufferedReader csvReader=null;
    	String row =null;
    	SecretBundle otherSecretBundle =null;
    	KeyVaultClient kvClientCertAuth = KeyVaultADALAuthenticator.getAuthenticatedClient();
		try {
			csvReader = new BufferedReader(new FileReader(pathToCsv));
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				kvClientCertAuth.httpClient().connectionPool().evictAll();
				String secretName = data[1];
				otherSecretBundle = kvClientCertAuth.getSecret(VAULT_URL + secretName);
				propertySource.put(data[0], otherSecretBundle.value());
				System.out.println(data[0] + ":" + otherSecretBundle.value());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
     	try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
     
         // Create a custom property source with the highest precedence
        environment.getPropertySources().addFirst( new MapPropertySource( PROPERTY_SOURCE_NAME, propertySource ) );
     }

}