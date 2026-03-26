package org.opentmf.tmf662.model;

import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * This embedded object represents the role and type of each entity involved in
 * a relationship.
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
public class AssociationRoleSpecification implements IAssociationRoleSpecification {

  /**
   * A flag indicates that if this role is an aggregation or a simple
   * relationship.
   */
  private @SafeText String aggregation;

  /**
   * Default quantity of the association role.
   */
  private Integer defaultQuantity;

  /**
   * The target (root) entity type associated with this role.
   */
  private @SafeText String entityType;

  /**
   * A flag indicating if access from the other end of association is allowed or
   * not.
   */
  private Boolean isNavigable;

  /**
   * A flag indicating if the participant involved in a uni-directional
   * relationship is the source or not. This flag is true If the association is
   * bi-directional.
   */
  private Boolean isSource;

  /**
   * Maximum allowed quantity of the association role.
   */
  private Integer maxQuantity;

  /**
   * Minimum allowed quantity of the association role.
   */
  private Integer minQuantity;

  /**
   * The association role of this relationship participant.
   */
  private @SafeText String role;
}