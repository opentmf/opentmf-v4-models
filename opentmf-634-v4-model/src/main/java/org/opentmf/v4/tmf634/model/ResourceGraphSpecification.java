package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.NamedEntity;

/**
 * Resource graph specification.
 *
 * <p><br/>
 * <strong>Required:</strong> connectionSpecification<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = ResourceGraphSpecification.class
)
@Required(fields = {"connectionSpecification"})
public class ResourceGraphSpecification extends NamedEntity {

  /**
   * Description of the resource graph specification.
   */
  private @SafeText String description;

  /**
   * Resource graph edge specifications.
   */
  @JsonProperty("connectionSpecification")
  private @Size(min = 1) List<@Valid ConnectionSpecification> connectionSpecifications;

  /**
   * Relationships to other resource graph specifications.
   */
  @JsonProperty("graphSpecificationRelationship")
  private List<@Valid ResourceGraphSpecificationRelationship> graphSpecificationRelationships;
}