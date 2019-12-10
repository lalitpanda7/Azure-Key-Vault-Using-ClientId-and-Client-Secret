package com.keyvault.poc.vault;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microsoft.azure.keyvault.KeyVaultClient;
import com.microsoft.azure.keyvault.models.SecretBundle;

@SpringBootApplication
public class VaultApplication {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(VaultApplication.class, args);
	}
	
}













	/*
	 * public static void prerun() throws Exception {
	 * 
	 * String pathToCsv="D:\\Key_Vault\\kevVault credentials.csv"; BufferedReader
	 * csvReader = new BufferedReader(new FileReader(pathToCsv)); String row =null;
	 * SecretBundle otherSecretBundle =null;
	 * 
	 * KeyVaultClient kvClientCertAuth =
	 * KeyVaultADALAuthenticator.getAuthenticatedClient();//
	 * 
	 * String secretName="spring-datasource-password"; //
	 * kvClientCertAuth.httpClient().connectionPool().evictAll(); otherSecretBundle
	 * = kvClientCertAuth.getSecret(VAULT_URL+secretName);//setSecret(new
	 * SetSecretRequest.Builder("https://" + vaultCert.vaultUri(),
	 * "auth-other-sample-secret", "client is authenticated to the vault").build());
	 * secretName="auth-other-sample-secret";
	 * System.out.println(otherSecretBundle.value()); otherSecretBundle =
	 * kvClientCertAuth.getSecret(VAULT_URL+secretName);
	 * 
	 * System.out.println(otherSecretBundle.value());
	 * 
	 * 
	 * 
	 * 
	 * 
	 * KeyVaultClient kvClientCertAuth =
	 * KeyVaultADALAuthenticator.getAuthenticatedClient();//
	 * 
	 * 
	 * while ((row = csvReader.readLine()) != null) { String[] data =
	 * row.split(","); String secretName = data[0], value = data[1];
	 * otherSecretBundle = kvClientCertAuth.setSecret(VAULT_BASE_URL, secretName,
	 * value); // Thread.sleep(10000); }
	 * 
	 * 
	 * csvReader = new BufferedReader(new FileReader(pathToCsv));
	 * 
	 * while (( row = csvReader.readLine()) != null) { String[] data =
	 * row.split(","); kvClientCertAuth.httpClient().connectionPool().evictAll();
	 * String secretName=data[0]; otherSecretBundle =
	 * kvClientCertAuth.getSecret(VAULT_URL+secretName);
	 * System.out.println(otherSecretBundle.value()); } csvReader.close();
	 * 
	 * 
	 * 
	 * }
	 */
