package org.opentmf.tmf701.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationSpecRef;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A relationship (triggers, delegates, etc...) between/among ProcessFlow
 * specifications.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ProcessFlowSpecificationRelationship.class
)
public class ProcessFlowSpecificationRelationship extends NamedEntity implements IProcessFlowSpecificationRelationship {

  /**
   * reference to an AssociationSpecification object.
   */
  private @Valid AssociationSpecRef associationSpec;

  /**
   * Type of relationship such as triggers, delegates, etc.
   */
  private @SafeText String relationshipType;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}