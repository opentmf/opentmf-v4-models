package org.opentmf.tmf680.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Describes a specific item contained in a parent element.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-680: Recommendation Management API</li>
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
    defaultImpl = ItemRef.class
)
public class ItemRef extends Extensible implements IItemRef {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * Hypertext Reference of the parent element.
   */
  private URI entityHref;

  /**
   * Unique identifier of the parent element.
   */
  @SafeId
  @Size(max = 100)
  private String entityId;

  /**
   * Unique identifier of the considered item.
   */
  @SafeId
  @Size(max = 100)
  private String itemId;

  /**
   * Name of the related entity.
   */
  private @SafeText String name;
}