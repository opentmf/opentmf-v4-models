package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * PerformanceIndicatorSpecification reference: A
 * PerformanceIndicatorSpecification is a detailed description of a tangible or
 * intangible object made available externally in the form of a
 * PerformanceIndicatorSpecification to customers or other parties playing a
 * party role.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-649: Performance Thresholding Management API</li>
 *   <li>TMF-common: common</li>
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
    defaultImpl = PerformanceIndicatorSpecificationRef.class
)
@Required(fields = {"id"})
public class PerformanceIndicatorSpecificationRef extends EntityRef implements IPerformanceIndicatorSpecificationRef {

  /**
   * Version of the performance indicator specification.
   */
  private @SafeText String version;
}