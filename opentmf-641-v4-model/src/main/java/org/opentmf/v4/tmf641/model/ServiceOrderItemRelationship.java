package org.opentmf.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

/**
 * Linked service order item to the one containing this attribute.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = ServiceOrderItemRelationship.class
)
public class ServiceOrderItemRelationship extends Extensible {

  /**
   * The type of related order item, can be: dependency if the order item needs to
   * be not started until another order item is complete.
   */
  private @SafeText String relationshipType;

  /**
   * A service order item in relationship with this order item.
   */
  private @Valid ServiceOrderItemRef orderItem;
}