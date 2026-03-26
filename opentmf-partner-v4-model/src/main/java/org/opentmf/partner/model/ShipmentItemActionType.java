package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * action to be performed on the shipment item.
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
public enum ShipmentItemActionType {

  ADD("add"),
  MODIFY("modify"),
  DELETE("delete"),
  NO_CHANGE("noChange");

  private final String value;

  ShipmentItemActionType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ShipmentItemActionType> REVERSE_MAP = new HashMap<>();

  static {
    for (ShipmentItemActionType shipmentItemActionType : values()) {
      REVERSE_MAP.put(shipmentItemActionType.getValue(), shipmentItemActionType);
    }
  }

  @JsonCreator
  public static ShipmentItemActionType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
