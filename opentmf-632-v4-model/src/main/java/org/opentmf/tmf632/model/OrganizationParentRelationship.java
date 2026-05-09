package org.opentmf.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.OrganizationRef;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Parent references of an organization in a structure of organizations.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = OrganizationParentRelationship.class
)
public class OrganizationParentRelationship extends Extensible implements IOrganizationParentRelationship {

  private @Valid OrganizationRef organization;

  /**
   * Type of the relationship. Could be juridical, hierarchical, geographical,
   * functional for example.
   */
  private @SafeText String relationshipType;
}