package org.opentmf.tmf644.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Party Privacy Profile Specification serves as a template for creating Privacy
 * Profiles. The specification defines characteristics for the profile. For
 * example there might be a profile specification for residential customers, and
 * a different specification for partners.
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
public class PartyPrivacyProfileSpecification extends PartyPrivacyProfileSpecificationUpdate implements IPartyPrivacyProfileSpecification {

  /**
   * URI reference of the specification allowing navigation to the resource.
   */
  private URI href;

  /**
   * Unique identifier of the specification.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}