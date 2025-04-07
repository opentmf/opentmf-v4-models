package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.EntityRef;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * A relationship between agreement specifications. Typical relationships are
 * substitution and dependency.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement</li>
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
    defaultImpl = AgreementSpecificationRelationship.class
)
public class AgreementSpecificationRelationship extends EntityRef {

  /**
   * Type of relationship such as, substitution or dependency.
   */
  private @SafeText String relationshipType;

  /**
   * The period for which the relationship is valid.
   */
  private @Valid TimePeriod validFor;
}