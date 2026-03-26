package org.opentmf.tmf662.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class AssociationSpecificationDeleteEventPayload implements IAssociationSpecificationDeleteEventPayload {

  /**
   * AssociationSpecification is an association class that describes a type of
   * relationship between two entities. This is a generic construct that may be
   * used to describe relationship types and roles. The role and type of each
   * entity in the relationship is given by an association role specification. Two
   * role specifications are embedded in the association specification.
   */
  private @Valid AssociationSpecification associationSpecification;
}