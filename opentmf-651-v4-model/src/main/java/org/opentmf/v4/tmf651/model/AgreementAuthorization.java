package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Entity;

/**
 * A business participant that is responsible for approving the agreement.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement</li>
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
    defaultImpl = AgreementAuthorization.class
)
public class AgreementAuthorization extends Entity {

  /**
   * The date associated with the authorization state.
   */
  private OffsetDateTime date;

  /**
   * Indication that represents whether the signature is a physical paper
   * signature or a digital signature.
   */
  private @SafeText String signatureRepresentation;

  /**
   * Current status of the authorization, for example in process, approved,
   * rejected.
   */
  private @SafeText String state;
}