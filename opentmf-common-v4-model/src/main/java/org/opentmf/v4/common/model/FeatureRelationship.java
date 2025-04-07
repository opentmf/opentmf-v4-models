package org.opentmf.v4.common.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Configuration feature.
 *
 * <p><br/>
 * <strong>Required:</strong> name, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@Required(fields = {"relationshipType", "name"})
public class FeatureRelationship {

  /**
   * Unique identifier of the target feature.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * This is the name of the target feature.
   */
  private @SafeText String name;

  /**
   * This is the type of the feature relationship.
   */
  private @SafeText String relationshipType;

  /**
   * The period for which this feature relationship is valid.
   */
  private @Valid TimePeriod validFor;
}