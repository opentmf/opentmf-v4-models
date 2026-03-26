package org.opentmf.tmf662.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ConstraintRef;
import org.opentmf.common.model.EntityCatalogUpdateBase;

/**
 * AssociationSpecification is an association class that describes a type of
 * relationship between two entities. This is a generic construct that may be
 * used to describe relationship types and roles. The role and type of each
 * entity in the relationship is given by an association role specification. Two
 * role specifications are embedded in the association specification.
 * <br/>Skipped properties: id,href,lastUpdate.
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
    defaultImpl = AssociationSpecificationUpdate.class
)
public class AssociationSpecificationUpdate extends EntityCatalogUpdateBase implements IAssociationSpecificationUpdate {

  /**
   * This embedded object represents the role and type of each entity involved in
   * a relationship.
   */
  private @Valid AssociationRoleSpecification associationRoleSpec;

  /**
   * Constraints relating to this association.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;
}