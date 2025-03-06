package com.example.vc_demo.utils;

import id.walt.crypto.keys.Key;
import id.walt.did.dids.DidService;
import id.walt.did.dids.registrar.dids.DidCreateOptions;
import id.walt.did.dids.registrar.dids.DidJwkCreateOptions;

public class DIDUtils {

  private static final DidService didService = DidService.INSTANCE;

  public static String generateDidSync(Key key) {
    DidCreateOptions options = new DidJwkCreateOptions();

    return null;
  }

}
