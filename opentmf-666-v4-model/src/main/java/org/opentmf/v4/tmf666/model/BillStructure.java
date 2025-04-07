package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.v4.common.model.Extensible;

/**
 * The structure of the bill for party accounts (billing or settlement).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = BillStructure.class
)
public class BillStructure extends Extensible {

  private @Valid BillingCycleSpecificationRefOrValue cycleSpecification;

  private @Valid BillFormatRefOrValue format;

  /**
   * List of: An attachment by value or by reference.
   */
  @JsonProperty("presentationMedia")
  private List<@Valid BillPresentationMediaRefOrValue> presentationMedias;
}