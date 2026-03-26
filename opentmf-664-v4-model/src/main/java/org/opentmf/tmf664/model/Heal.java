package org.opentmf.tmf664.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Task Resource used to request healing of a Resource Function.
 *
 * <p><br/>
 * <strong>Required:</strong> cause, degreeOfHealing, resourceFunction<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-664: Resource Function Activation Management API</li>
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
    defaultImpl = Heal.class
)
@Required(fields = {"degreeOfHealing", "cause", "resourceFunction"})
public class Heal extends HealCreate implements IHeal {

  /**
   * Reference to the Heal task resource.
   */
  private URI href;

  /**
   * Unique identifier of the Heal task resource.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}