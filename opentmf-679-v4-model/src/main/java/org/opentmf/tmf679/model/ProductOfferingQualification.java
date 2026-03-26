package org.opentmf.tmf679.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * ProductOfferingQualification is used to perform a commercial eligibility. It
 * allows to retrieve a list of productOffering that are commercially available
 * in the context of the interaction (defined be place, channel, party,
 * product).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-679: Product Offering Qualification Management API</li>
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
    defaultImpl = ProductOfferingQualification.class
)
public class ProductOfferingQualification extends ProductOfferingQualificationUpdate implements IProductOfferingQualification {

  /**
   * Hyperlink to access the productOfferingQualification.
   */
  private URI href;

  /**
   * Unique identifier of the productOfferingQualification resource.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Date when the productOfferingQualification has been submitted.
   */
  private OffsetDateTime productOfferingQualificationDate;
}