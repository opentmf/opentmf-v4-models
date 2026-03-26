package org.opentmf.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AppointmentRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ResourceRefOrValue;
import org.opentmf.common.model.ResourceSpecificationRef;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An identified part of the order. A resource order is decomposed into one or
 * more order items.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = ResourceOrderItem.class
)
public class ResourceOrderItem extends Extensible implements IResourceOrderItem {

  /**
   * Can be "add" / "modify" / "no_change"/ "delete".
   */
  private @SafeText String action;

  /**
   * Refers an appointment, such as a Customer presentation or internal meeting or
   * site visit.
   */
  private @Valid AppointmentRef appointment;

  /**
   * Identifier of the line item (generally it is a sequence number 01, 02, 03,
   * ...).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  @JsonProperty("orderItemRelationship")
  private List<@Valid ResourceOrderItemRelationship> orderItemRelationships;

  /**
   * Quantity ordered.
   */
  private Integer quantity;

  /**
   * Resource is an abstract entity that describes the common set of attributes
   * shared by all concrete resources. The polymorphic attributes {@literal @}type,
   * {@literal @}schemaLocation & {@literal @}referredType are related to the Resource entity and not
   * the related ResourceRefOrValue class itself.
   */
  private @Valid ResourceRefOrValue resource;

  /**
   * Resources are physical or non-physical components (or some combination of
   * these) within an enterprise's infrastructure or inventory. They are typically
   * consumed or used by services (for example a physical port assigned to a
   * service) or contribute to the realization of a Product (for example, a SIM
   * card). They can be drawn from the Application, Computing and Network domains,
   * and include, for example, Network Elements, software, IT systems, content and
   * information, and technology components.
   * <br/>A ResourceSpecification is an abstract base class for representing a
   * generic means for implementing a particular type of Resource. In essence, a
   * ResourceSpecification defines the common attributes and relationships of a
   * set of related Resources, while Resource defines a specific instance that is
   * based on a particular ResourceSpecification.
   */
  private @Valid ResourceSpecificationRef resourceSpecification;

  /**
   * State of the order item : described in the state machine diagram.
   */
  private @SafeText String state;
}