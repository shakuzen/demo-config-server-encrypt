Config Server decryption issue repro
=====

This repository shows that encrypted properties for the config server itself are not getting decrypted.

On startup, the value of the `myorg.security.password` property from a corresponding `@ConfigurationProperties` class will be printed to STDOUT.
It is not decrypted but just passed as is with `{cipher}` and the ciphertext.

### Use case

I would like to encrypt the value of the password for the user that will be configured with Spring Security on the Config Server, as [suggested in the documentation](https://cloud.spring.io/spring-cloud-config/single/spring-cloud-config.html#_security).
