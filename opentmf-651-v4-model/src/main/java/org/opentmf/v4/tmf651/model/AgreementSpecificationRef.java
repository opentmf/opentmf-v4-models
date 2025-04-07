package org.opentmf.v4.tmf651.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.EntityRef;

/**
 * Agreement specification reference. An AgreementSpecification represents a
 * template of an agreement that can be used when establishing partnerships.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
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
    defaultImpl = AgreementSpecificationRef.class
)
@Required(fields = {"id"})
public class AgreementSpecificationRef extends EntityRef {

  /**
   * A narrative that explains in detail what the agreement specification is
   * about.
   */
  private @SafeText String description;
}