package org.opentmf.tmf657.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Service Level Specification represents a pre-defined or negotiated set of
 * Service Level 
 * <br/>Objectives. In addition, certain consequences are associated with not
 * meeting the Service Level 
 * <br/>Objectives. Service Level Agreements are expressed in terms of Service
 * Level Specifications.
 * <br/>Skipped properties: id,href,validFor.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-657: Service Quality Management Management API</li>
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
    defaultImpl = ServiceLevelSpecificationUpdate.class
)
public class ServiceLevelSpecificationUpdate extends Extensible implements IServiceLevelSpecificationUpdate {

  /**
   * A brief introduction of a service level specification.
   */
  private @SafeText String description;

  /**
   * The name of Service Level Specification.
   */
  private @SafeText String name;

  /**
   * A list of objectives related to this service level specification.
   */
  @JsonProperty("relatedServiceLevelObjective")
  private List<@Valid ServiceLevelObjectiveRef> relatedServiceLevelObjectives;
}