package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.partner.model.RoleSpecification;

/**
 * A characteristic of the party privacy profile, whose value(s) would be
 * supplied at runtime. For example, email address.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-644: Privacy Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PartyPrivacyProfileSpecificationCharacteristic implements IPartyPrivacyProfileSpecificationCharacteristic {

  /**
   * A list of roles in the organization who are allowed access to this
   * characteristic.
   */
  @JsonProperty("allowedRole")
  private List<@Valid RoleSpecification> allowedRoles;

  /**
   * Level of criticality for this characteristic of personal identifiable
   * information (e.g. in terms of the damage if this item was breached), such as
   * low, medium, high.
   */
  private @SafeText String criticalityLevel;

  /**
   * Description of the characteristic.
   */
  private @SafeText String description;

  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Name of the characteristic.
   */
  private @SafeText String name;

  /**
   * List of values that can be assigned to this characteristic at runtime.
   */
  @JsonProperty("partyPrivacyProfileSpecCharacteristicValue")
  private List<@Valid SpecificationCharacteristicValue> partyPrivacyProfileSpecCharacteristicValues;

  /**
   * Type of privacy (e.g. Internal Purpose, External Purpose, Internal Retention,
   * External Retention).
   */
  private @SafeText String privacyType;

  /**
   * Defines the purpose authorized or refused for the characteristic (e.g. ADMIN,
   * INFORMATION, MARKETING, RESEARCH).
   */
  private @SafeText String privacyUsagePurpose;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}