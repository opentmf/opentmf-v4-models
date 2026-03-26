package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationBase;
import org.opentmf.common.model.AssociationSpecificationRef;

/**
 * Association is the class that describes a relationship between two or more
 * entities or entity specifications based on a given association specification.
 * The role of each endpoint in the relationship is given by an association
 * role. The type of endpoints in the relationship should match the ones as
 * defined in the corresponding association role specification. A relationship
 * between entity specifications may be governed by conditions and rules which
 * are addressed by constraint references in this resource. Constraints for a
 * relationship may include new rules and conditions in addition to those
 * defined for the corresponding association specification.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-662: Entity Catalog Management API</li>
 *   <li>TMF-703: Entity Inventory Management API</li>
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
    defaultImpl = Association.class
)
public class Association extends AssociationBase implements IAssociation {

  /**
   * The end point roles of this association.
   */
  @JsonProperty("associationRole")
  private @Size(min = 2) List<@Valid AssociationRole> associationRoles;

  /**
   * reference to an AssociationSpecification object.
   */
  private @Valid AssociationSpecificationRef associationSpec;
}