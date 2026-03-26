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
import org.opentmf.service.model.ServiceCategoryRef;

/**
 * A ServiceQualificationItem relates to a specific service being checked in a
 * qualification operation.
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
    defaultImpl = ServiceQualificationItem.class
)
public class ServiceQualificationItem extends Extensible implements IServiceQualificationItem {

  /**
   * The (service) category resource is used to group service candidates in
   * logical containers. Categories can contain other categories.
   */
  private @Valid ServiceCategoryRef category;

  /**
   * The date when the service is expected to be activated.
   */
  private OffsetDateTime expectedActivationDate;

  /**
   * Date when the requester looks for service availability.
   */
  private OffsetDateTime expectedServiceAvailabilityDate;

  /**
   * Date when the qualification item response expires.
   */
  private OffsetDateTime expirationDate;

  /**
   * Id of the Service Qualification Item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A Service to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the Service entity and not the RelatedServiceRefOrValue class itself.
   */
  private @Valid ServiceRefOrValue service;
}