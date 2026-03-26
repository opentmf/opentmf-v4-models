package org.opentmf.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An edge in a resource graph.
 *
 * <p><br/>
 * <strong>Required:</strong> associationType, endpoint<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-664: Resource Function Activation Management API</li>
 *   <li>TMF-730: Software And Compute Management API</li>
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
    defaultImpl = Connection.class
)
@Required(fields = {"endpoint", "associationType"})
public class Connection extends NamedEntity implements IConnection {

  /**
   * Association type.
   */
  private @SafeText String associationType;

  /**
   * A vertex in a resource graph.
   */
  private @Valid EndpointRef endpoint;
}