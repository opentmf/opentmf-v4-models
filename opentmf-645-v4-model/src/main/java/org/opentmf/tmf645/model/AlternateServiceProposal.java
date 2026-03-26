package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ServiceRefOrValue;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Alternate service proposal is used when the requested service is not
 * available with characteristic and date asked for. An alternate proposal could
 * be a distinct serviceSpecification close to requested one or same as
 * requested but with a different activation date.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
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
    defaultImpl = AlternateServiceProposal.class
)
public class AlternateServiceProposal extends Extensible implements IAlternateServiceProposal {

  /**
   * A Service to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the Service entity and not the RelatedServiceRefOrValue class itself.
   */
  private @Valid ServiceRefOrValue alternateService;

  /**
   * Alternate availability date in case seller is not able to meet requested
   * expected availability date for the service.
   */
  private OffsetDateTime alternateServiceAvailabilityDate;

  /**
   * Identifier of a alternate service proposal.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}