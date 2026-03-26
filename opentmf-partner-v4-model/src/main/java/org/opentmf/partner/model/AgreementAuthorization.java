package org.opentmf.partner.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Entity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A business participant that is responsible for approving the agreement.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-644: Privacy Management API</li>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = AgreementAuthorization.class
)
public class AgreementAuthorization extends Entity implements IAgreementAuthorization {

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