package org.opentmf.v4.tmf648.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.RelatedParty;

/**
 * If special discount or special product offering price or specific condition
 * need an approval for ISP sale representative it is described here.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = Authorization.class
)
public class Authorization extends Extensible {

  /**
   * Date when the authorization (approved or declined) was done.
   */
  private OffsetDateTime givenDate;

  /**
   * Name of the required authorization.
   */
  private @SafeText String name;

  /**
   * Date when the authorization is requested for.
   */
  private OffsetDateTime requestedDate;

  /**
   * To describe a digital or manual signature.
   */
  private @SafeText String signatureRepresentation;

  /**
   * State of the authorization, such as: approved or declined.
   */
  private @SafeText String state;

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("approver")
  private List<@Valid RelatedParty> approvers;
}