package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.NamedEntity;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * The PricingLogicAlgorithm entity represents an instantiation of an interface
 * specification to external rating function (without a modeled behaviour in
 * SID). Some of the parameters of the interface definition may be already set
 * (such as price per unit) and some may be gathered during the rating process
 * from the event (such as call duration) or from ProductCharacteristicValues
 * (such as assigned bandwidth).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = PricingLogicAlgorithm.class
)
public class PricingLogicAlgorithm extends NamedEntity {

  /**
   * Description of the PricingLogicAlgorithm.
   */
  private @SafeText String description;

  /**
   * id of corresponding PricingLogicAlgorithm specification.
   */
  @SafeId
  @Size(max = 100)
  private String plaSpecId;

  /**
   * The period for which the PricingLogicAlgorithm is valid.
   */
  private @Valid TimePeriod validFor;
}