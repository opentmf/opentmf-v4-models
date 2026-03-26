package org.opentmf.tmf664.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Task Resource used to request scaling of a Resource Function.
 *
 * <p><br/>
 * <strong>Required:</strong> numberOfSteps, resourceFunction, scaleType<br/>
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
    defaultImpl = Scale.class
)
@Required(fields = {"numberOfSteps", "scaleType", "resourceFunction"})
public class Scale extends ScaleCreate implements IScale {

  /**
   * Reference to the Scale task resource.
   */
  private URI href;

  /**
   * Unique identifier of the Scale task resource.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}