package org.opentmf.tmf696.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * This is a task resource allowing assessment of the risks associated with a
 * product offering. For example, the risk associated with iPhone X will
 * probably be higher than the risk for a battery
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> productOffering<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-696: Risk Management API</li>
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
    defaultImpl = ProductOfferingRiskAssessmentCreate.class
)
@Required(fields = {"productOffering"})
public class ProductOfferingRiskAssessmentCreate extends Extensible implements IProductOfferingRiskAssessmentCreate {

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;
}