package org.opentmf.tmf662.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

/**
 * AssociationSpecification is an association class that describes a type of
 * relationship between two entities. This is a generic construct that may be
 * used to describe relationship types and roles. The role and type of each
 * entity in the relationship is given by an association role specification. Two
 * role specifications are embedded in the association specification.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> associationRoleSpec, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-662: Entity Catalog Management API</li>
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
    defaultImpl = AssociationSpecificationCreate.class
)
@Required(fields = {"name", "associationRoleSpec"})
public class AssociationSpecificationCreate extends AssociationSpecificationUpdate implements IAssociationSpecificationCreate {

  /**
   * The last modified date of this specification.
   */
  private OffsetDateTime lastUpdate;
}