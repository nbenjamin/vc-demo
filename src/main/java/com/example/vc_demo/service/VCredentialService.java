package com.example.vc_demo.service;

import id.walt.credentials.CredentialBuilder;
import id.walt.credentials.CredentialBuilderType;
import id.walt.crypto.keys.Key;
import id.walt.crypto.keys.KeyType;
import id.walt.crypto.keys.jwk.JWKKey;
import id.walt.crypto.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

public class VCredentialService {

  public static void createVC() {

    String id = "12345";
    String issuingAuthorityId = "abc";
    String proofType = "document";
    String proofLocation = "Richmond-VA";

    Map<String, Object> issuingCircumstances = new HashMap<>();
    issuingCircumstances.put("proofType", proofType);
    issuingCircumstances.put("locationType", "physicalLocation");
    issuingCircumstances.put("location", proofLocation);

    Map<String, Object> credentialSubjectMap = new HashMap<>();
    credentialSubjectMap.put("id", id);
    credentialSubjectMap.put("issuingAuthority", issuingAuthorityId);
    credentialSubjectMap.put("issuingCircumstances", issuingCircumstances);

    var credentialSubject = JsonUtils.INSTANCE.javaToJsonObject(credentialSubjectMap);

    var credentialBuilder = new CredentialBuilder(CredentialBuilderType.W3CV2CredentialBuilder);
    credentialBuilder.setCredentialId("https://www.w3.org/ns/credentials/examples/v2");
    credentialBuilder.useCredentialSubject(credentialSubject);
    var vc = credentialBuilder.buildW3C();

    // setup signing
    Key key = JWKKey.Companion.generateBlocking(KeyType.Ed25519, null);

    System.out.println(vc);

  }

  public static void main(String[] args) {
    createVC();
  }
}
