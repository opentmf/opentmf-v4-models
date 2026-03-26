package org.opentmf.tmf644.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.DocumentUpdateBase;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Party Privacy Profile Specification serves as a template for creating Privacy
 * Profiles. The specification defines characteristics for the profile. For
 * example there might be a profile specification for residential customers, and
 * a different specification for partners.
 * <br/>Skipped properties: id,href.
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
public class PartyPrivacyProfileSpecificationUpdate extends DocumentUpdateBase implements IPartyPrivacyProfileSpecificationUpdate {

  /**
   * A list of roles to which this specification can apply. For example: Shop
   * Agent, Call Center Agent.
   */
  @JsonProperty("applicableRole")
  private List<@Valid PartyPrivacyRoleSpecification> applicableRoles;

  /**
   * List of characteristics of the specification, whose values would typically be
   * supplied when the profile is instantiated.
   */
  @JsonProperty("partyPrivacyProfileSpecCharacteristic")
  private List<@Valid PartyPrivacyProfileSpecificationCharacteristic> partyPrivacyProfileSpecCharacteristics;

  /**
   * List of: ProductOffering reference. A product offering represents entities
   * that are orderable from the provider of the catalog, this resource includes
   * pricing information.
   */
  @JsonProperty("productOffering")
  private List<@Valid ProductOfferingRef> productOfferings;

  /**
   * List of parties or party roles involved in the definition or management of
   * the specification.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Lifecycle status of the specification (for example: In Design, Active,
   * Rejected, Retired).
   */
  private @SafeText String status;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}