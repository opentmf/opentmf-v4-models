package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.WorkRefOrValue;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Alternate work proposal is used when the requested unit of work is not valid
 * as specified in the request. An alternate proposal could be a distinct
 * workSpecification close to the requested one or the same specification as
 * requested but with a different parameters.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-714: Work Qualification Management</li>
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
    defaultImpl = AlternateWorkProposal.class
)
public class AlternateWorkProposal extends Extensible implements IAlternateWorkProposal {

  /**
   * A Unit of Work defined by value or existing defined by reference. The
   * polymorphic attributes {@literal @}type, {@literal @}schemaLocation &amp; {@literal @}referredType are related
   * to the work entity and not the related WorkRefOrValue class itself.
   */
  private @Valid WorkRefOrValue alternateWork;

  /**
   * Alternate date where the work could take place in case the expected date
   * cannot be met.
   */
  private OffsetDateTime alternateWorkDate;

  /**
   * Identifier of an alternate work proposal.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}