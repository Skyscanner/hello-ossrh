# hello-ossrh

A sample repo that is used to claim net.skyscanner namespace on maven central.
If you want to push a new OSS artifact to net.skyscanner namespace, please reach out to catalystsquad@skyscanner.net or @artifactory-gf on #engineering-support

**DO NOT USE THIS AS A TEMPLATE FOR CREATING AN OPENSOURCE ARTIFACT. USE IT ONLY AS ROUGH GUIDELINES ON HOW TO SIGN YOUR ARTIFACTS
AS PER https://central.sonatype.org/publish/requirements/gpg/**


## Setting up gradle to publish signed artifacts

Add to your $HOME gradle.properties:

```gradle.properties

# We recommend publishing the public key to keys.openpgp.org keyserver
# gpg --keyserver keys.openpgp.org --send-keys YourKeyId 
# since the keyserver mentioned in https://central.sonatype.org/publish/requirements/gpg/#distributing-your-public-key (hkp://pool.sks-keyservers.net) is down
signing.keyId=YourKeyId
signing.password=YourKeyPassPhrase
signing.secretKeyRingFile=YourKeyRingFile # (Since gpg 2.1, you need to export the keys with command gpg --keyring secring.gpg --export-secret-keys > ~/.gnupg/secring.gpg). See https://docs.gradle.org/current/userguide/signing_plugin.html


# Reach out to artifactory greenflag to obtain these..
ossrhUsername=...
ossrhPassword=...
```

Run `./gradlew uploadArchives` to publish the artifact