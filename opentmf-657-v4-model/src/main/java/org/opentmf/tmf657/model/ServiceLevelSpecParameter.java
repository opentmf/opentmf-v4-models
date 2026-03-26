package org.opentmf.tmf657.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.RelatedEntity;
import org.opentmf.common.model.TimePeriod;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Service Level Specification parameters can be one of two types. A Key Quality
 * Indicator (KQI) 
 * <br/>provides a measurement of a specific aspect of the performance of a
 * Product (i.e., Product 
 * <br/>Specification, Product Offering, or Product) or a Service (i.e., Service
 * Specification or Service).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-657: Service Quality Management Management API</li>
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
    defaultImpl = ServiceLevelSpecParameter.class
)
public class ServiceLevelSpecParameter extends Extensible implements IServiceLevelSpecParameter {

  /**
   * The name of the parameter.
   */
  private @SafeText String name;

  /**
   * Types of Service Level Specification parameters are KQI or KPI.
   */
  private @SafeText String parameterType;

  /**
   * A list of entities related to this parameter.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  /**
   * A string that specifies whether the Service Level Specification Parameter is
   * technology specific, service specific, or technology/service independent.
   */
  private @SafeText String serviceParmCategory;

  /**
   * A string that specifies whether the Service Level Specification Parameter
   * represents a single user instance parameter or a parameter that represents an
   * aggregation.
   */
  private @SafeText String serviceParmPerspective;

  /**
   * The description of a logical step-by-step procedure used to calculate the
   * value of a KQI.
   */
  private @SafeText String transformationAlgorithmOfKQI;

  /**
   * A period of time, either as a deadline (endDateTime only) a startDateTime
   * only, or both.
   */
  private @Valid TimePeriod validFor;
}