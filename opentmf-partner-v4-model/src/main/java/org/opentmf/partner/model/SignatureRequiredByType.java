package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the signature requirement upon receiving the shipment.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-700: Shipping Order Management API</li>
 *   <li>TMF-711: Shipment Management Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum SignatureRequiredByType {

  ADULT("adult"),
  RECEIVER("receiver");

  private final String value;

  SignatureRequiredByType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, SignatureRequiredByType> REVERSE_MAP = new HashMap<>();

  static {
    for (SignatureRequiredByType signatureRequiredByType : values()) {
      REVERSE_MAP.put(signatureRequiredByType.getValue(), signatureRequiredByType);
    }
  }

  @JsonCreator
  public static SignatureRequiredByType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
