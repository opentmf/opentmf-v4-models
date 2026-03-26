package org.opentmf.tmf632.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Characteristic;
import org.opentmf.common.model.ContactMedium;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ExternalReference;
import org.opentmf.common.model.PartyCreditProfile;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.TaxExemptionCertificate;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Organization represents a group of people identified by shared interests or
 * purpose. Examples include business, department and enterprise. Because of the
 * complex nature of many businesses, both organizations and organization units
 * are represented by the same data.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = OrganizationUpdate.class
)
public class OrganizationUpdate extends Extensible implements IOrganizationUpdate {

  /**
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * List of: An individual might be evaluated for its worthiness and this
   * evaluation might be based on a credit rating given by a credit agency.
   */
  @JsonProperty("creditRating")
  private List<@Valid PartyCreditProfile> creditRatings;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod existsDuring;

  /**
   * List of: External reference of the individual or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * If value is true, the organization is the head office.
   */
  private Boolean isHeadOffice;

  /**
   * If value is true, the organization is a legal entity known by a national
   * referential.
   */
  private Boolean isLegalEntity;

  /**
   * Organization name (department name for example).
   */
  private @SafeText String name;

  /**
   * Type of the name : Co, Inc, Ltd,….
   */
  private @SafeText String nameType;

  /**
   * List of: Child references of an organization in a structure of organizations.
   */
  @JsonProperty("organizationChildRelationship")
  private List<@Valid OrganizationChildRelationship> organizationChildRelationships;

  /**
   * List of: Represents our registration of information used as proof of identity
   * by an organization.
   */
  @JsonProperty("organizationIdentification")
  private List<@Valid OrganizationIdentification> organizationIdentifications;

  /**
   * Parent references of an organization in a structure of organizations.
   */
  private @Valid OrganizationParentRelationship organizationParentRelationship;

  /**
   * Type of Organization (company, department...).
   */
  private @SafeText String organizationType;

  /**
   * List of: Keeps track of other names, for example the old name of an
   * organization.
   */
  @JsonProperty("otherName")
  private List<@Valid OtherNameOrganization> otherNames;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("partyCharacteristic")
  private List<@Valid Characteristic> partyCharacteristics;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Valid values for the lifecycle state of the organization
   * <br/><p>Recommended values: initialized, validated, closed.
   *
   * @see org.opentmf.tmf632.model.OrganizationStateType
   */
  private @SafeText String status;

  /**
   * List of: A tax exemption certificate represents a tax exemption granted to a
   * party (individual or organization) by a tax jurisdiction which may be a city,
   * state, country,... An exemption has a certificate identifier (received from
   * the jurisdiction that levied the tax) and a validity period. An exemption is
   * per tax types and determines for each type of tax what portion of the tax is
   * exempted (partial by percentage or complete) via the tax definition.
   */
  @JsonProperty("taxExemptionCertificate")
  private List<@Valid TaxExemptionCertificate> taxExemptionCertificates;

  /**
   * Name that the organization (unit) trades under.
   */
  private @SafeText String tradingName;
}