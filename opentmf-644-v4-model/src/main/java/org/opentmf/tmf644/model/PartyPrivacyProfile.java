package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A Party Privacy Profile represents the set of Privacy settings defined for a
 * Party.
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
    defaultImpl = PartyPrivacyProfile.class
)
public class PartyPrivacyProfile extends PartyPrivacyProfileCreate implements IPartyPrivacyProfile {

  /**
   * URI reference of the privacy profile allowing navigation to the resource.
   */
  private URI href;

  /**
   * Unique identifier of the privacy profile.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}