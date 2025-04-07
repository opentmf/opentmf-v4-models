package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Relationship between feature specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> name, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = FeatureSpecificationRelationship.class
)
@Required(fields = {"relationshipType", "name"})
public class FeatureSpecificationRelationship extends NamedEntity {

  /**
   * Unique identifier of the target feature specification.
   */
  @SafeId
  @Size(max = 100)
  private String featureId;

  /**
   * Hyperlink reference to the parent specification containing the target
   * feature.
   */
  private URI parentSpecificationHref;

  /**
   * Unique identifier of the parent specification containing the target feature.
   */
  @SafeId
  @Size(max = 100)
  private String parentSpecificationId;

  /**
   * This is the type of the feature specification relationship.
   */
  private @SafeText String relationshipType;

  /**
   * The period for which this feature specification relationship is valid.
   */
  private @Valid TimePeriod validFor;
}