package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible values for the state of a managed artifact: 'incomplete', 'beta',
 * 'stable', 'deprecated'.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-704: Test Case Management API</li>
 *   <li>TMF-705: Test Environment Management API</li>
 *   <li>TMF-706: Test Data Management API</li>
 *   <li>TMF-709: Test Scenario Management API</li>
 *   <li>TMF-710: General Test Artifact Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
public enum ManagedArtifactStateType {

  INCOMPLETE("incomplete"),
  BETA("beta"),
  STABLE("stable"),
  DEPRECATED("deprecated");

  private final String value;

  ManagedArtifactStateType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  private static final Map<String, ManagedArtifactStateType> REVERSE_MAP = new HashMap<>();

  static {
    for (ManagedArtifactStateType managedArtifactStateType : values()) {
      REVERSE_MAP.put(managedArtifactStateType.getValue(), managedArtifactStateType);
    }
  }

  @JsonCreator
  public static ManagedArtifactStateType resolve(String value) {
    if (REVERSE_MAP.containsKey(value)) {
      return REVERSE_MAP.get(value);
    }
    throw new IllegalArgumentException("Provided value '" + value + "' is not supported");
  }
}
