package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * TaskFlowSpecification is a class that allow to describe a TaskFlow
 * specification design. A TaskFlow instance as used in TMF701 will use a
 * TaskFlowSpecification as reference.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-701: Process Flow Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TaskFlowSpecification extends TaskFlowSpecificationCreate implements ITaskFlowSpecification {

  /**
   * When subclassing, this defines the super-class.
   */
  @JsonProperty("@baseType")
  private @SafeText String atBaseType;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Date and time of the last update of the TaskFlowspecification.
   */
  private OffsetDateTime lastUpdate;
}