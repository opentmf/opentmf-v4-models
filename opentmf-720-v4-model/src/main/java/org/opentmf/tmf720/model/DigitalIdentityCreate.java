package org.opentmf.tmf720.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AttachmentRefOrValue;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.PartyRef;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.common.model.ResourceRef;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * DigitalIdentity is a class that allow to describe a digital identity for an
 * individual or a resource or a specific party role. One of these three MUST be
 * provided. If an individual is provided, this identity will be for all her/his
 * partyRole. To avoid confusion it is recommended in this case to not provide
 * partyRoleIdentified.
 * <br/>Skipped properties: id,href,status,digitalIdentityDate.
 *
 * <p><br/>
 * <strong>Required:</strong> credential<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-720: Digital Identity Management API</li>
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
    defaultImpl = DigitalIdentityCreate.class
)
@Required(fields = {"credential"})
public class DigitalIdentityCreate extends Extensible implements IDigitalIdentityCreate {

  /**
   * List of attachment associated with this digital identity. Could be use to
   * link a cute cat or moose picture to a digital identity for example.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of contact medium associated with the digital identity.
   */
  @JsonProperty("contactMedium")
  private List<@Valid DigitalIdentityContactMedium> contactMediums;

  /**
   * Date and time of the Digital Identity creation (timestamp).
   */
  private OffsetDateTime creationDate;

  /**
   * A list of credential/authentification method that are used for this digital
   * identity.
   */
  @JsonProperty("credential")
  private @Size(min = 1) List<@Valid Credential> credentials;

  private @Valid PartyRef individualIdentified;

  /**
   * Date and time of the Digital Identity last update (timestamp).
   */
  private OffsetDateTime lastUpdate;

  /**
   * Nickname associated to this digital identity (like Juanito17 or the
   * QuebecMoose etc...).
   */
  private @SafeText String nickname;

  /**
   * Related Parties who are identified by this digital identity.
   */
  @JsonProperty("partyRoleIdentified")
  private List<@Valid RelatedParty> partyRoleIdentifieds;

  /**
   * Parties who have an interest in this digital identity (like the organization
   * in charge of providing identity). This is NOT the party identified by this
   * digital identity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  private @Valid ResourceRef resourceIdentified;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}