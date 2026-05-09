package org.opentmf.tmf662.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ConstraintRef;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * AssociationSpecification is an association class that describes a type of
 * relationship between two entities. This is a generic construct that may be
 * used to describe relationship types and roles. The role and type of each
 * entity in the relationship is given by an association role specification. Two
 * role specifications are embedded in the association specification.
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
    defaultImpl = AssociationSpecification.class
)
public class AssociationSpecification extends NamedEntity implements IAssociationSpecification {

  /**
   * Role specifications for this association.
   */
  @JsonProperty("associationRoleSpec")
  private @Size(min = 2) List<@Valid AssociationRoleSpecification> associationRoleSpecs;

  /**
   * Constraints relating to this association.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Description of the specification.
   */
  private @SafeText String description;

  /**
   * The last modified date of this specification.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Indicates the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;

  /**
   * Version of this association.
   */
  private @SafeText String version;
}