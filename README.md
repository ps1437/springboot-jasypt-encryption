# springboot-jasypt-encryption
Jasypt integration for Spring boot 


Use the Encrypted password in application.properties
key = ENC(ENCRYPTED_PASSWORD)



---------------------------------------------------------------------------------------------
Java configuration  - 1 Approach
---------------------------------------------------------------------------------------------
Application.properties - ADD BELOW LINE
jasypt.encryptor.password=password

//ADD BELOW BEAN IN MAIN CLASS
@Bean(name = "encryptorBean")
	public StringEncryptor stringEncryptor() {
	    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
	    config.setAlgorithm("PBEWithMD5AndDES");
	    config.setKeyObtentionIterations("1000");
	    config.setPoolSize("1");
	    config.setProviderName("SunJCE");
	    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
	    config.setStringOutputType("base64");
	    encryptor.setConfig(config);
	    return encryptor;
}



---------------------------------------------------------------------------------------------
Application.properties - 2 Approach
---------------------------------------------------------------------------------------------
ADD BELOW 3 PROPERTIES IN APPLICATION.properties file 
jasypt.encryptor.bean=encryptorBean
jasypt.encryptor.password=password
jasypt.encryptor.algorithm=PBEWithMD5AndDES
		