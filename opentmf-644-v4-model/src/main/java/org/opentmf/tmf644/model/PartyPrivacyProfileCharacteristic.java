package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A characteristic for an instantiated party profile, where the value indicates
 * the allowed use of the characteristic.
 *
 * <p><br/>
 * <strong>Required:</strong> name, value<br/>
 * </p>
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = PartyPrivacyProfileCharacteristic.class
)
@Required(fields = {"name", "value"})
public class PartyPrivacyProfileCharacteristic extends Characteristic implements IPartyPrivacyProfileCharacteristic {

  /**
   * Defines the purpose authorized or refused for the characteristic (e.g. ADMIN,
   * INFORMATION, MARKETING, RESEARCH, etc.
   */
  private @SafeText String privacyUsagePurpose;

  /**
   * A list of parties to which the allowed use of the characteristic applies.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}