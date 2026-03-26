package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This embedded object represents the role and type of each entity involved in
 * a relationship.
 *
 * <p><br/>
 * <strong>Required:</strong> entity, role<br/>
 * </p>
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
    defaultImpl = AssociationRole.class
)
@Required(fields = {"role", "entity"})
public class AssociationRole extends Extensible implements IAssociationRole {

  /**
   * Entity reference schema to be used for all entityRef class.
   */
  private @Valid EntityRef entity;

  /**
   * A flag indicating if the participant involved in a relationship is the source
   * or not. If this flag is true for both roles in an association, the
   * association is bi-directional (both end points are navigable).
   */
  private Boolean isSource;

  /**
   * The association role of this relationship participant as defined in the
   * associationRoleSpecification.
   */
  private @SafeText String role;
}