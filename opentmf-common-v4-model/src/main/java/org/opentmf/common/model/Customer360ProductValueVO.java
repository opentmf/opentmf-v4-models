package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A product offering procured by a customer or other interested party playing a
 * party role. A product is realized as one or more service(s) and / or
 * resource(s).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-717: Customer360 Management API</li>
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
    defaultImpl = Customer360ProductValueVO.class
)
public class Customer360ProductValueVO extends NamedEntity implements ICustomer360ProductValueVO {

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * Is the description of the product. It could be copied from the description of
   * the Product Offering.
   */
  private @SafeText String description;

  /**
   * If true, the product is a ProductBundle which is an instantiation of a
   * BundledProductOffering. If false, the product is a ProductComponent which is
   * an instantiation of a SimpleProductOffering.
   */
  private Boolean isBundle;

  /**
   * If true, the product is visible by the customer.
   */
  private Boolean isCustomerVisible;

  /**
   * Is the date when the product was ordered.
   */
  private OffsetDateTime orderDate;

  /**
   * List of: A product to be created defined by value or existing defined by
   * reference. The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType
   * are related to the product entity and not the RelatedProductRefOrValue class
   * itself.
   */
  @JsonProperty("product")
  private List<@Valid ProductRefOrValue> products;

  /**
   * ProductOffering reference. A product offering represents entities that are
   * orderable from the provider of the catalog, this resource includes pricing
   * information.
   */
  private @Valid ProductOfferingRef productOffering;

  /**
   * Is the serial number for the product. This is typically applicable to
   * tangible products e.g. Broadband Router.
   */
  private @SafeText String productSerialNumber;

  /**
   * Product specification reference: A ProductSpecification is a detailed
   * description of a tangible or intangible object made available externally in
   * the form of a ProductOffering to customers or other parties playing a party
   * role.
   */
  private @Valid ProductSpecificationRef productSpecification;

  private @SafeText String randomAtt;

  /**
   * Is the date from which the product starts.
   */
  private OffsetDateTime startDate;

  /**
   * Possible values for the status of the product
   * <br/><p>Recommended values: created, pendingActive, cancelled, active,
   * pendingTerminate, terminated, suspended, aborted.
   *
   * @see org.opentmf.common.model.ProductStatusType
   */
  private @SafeText String status;

  /**
   * Is the date when the product was terminated.
   */
  private OffsetDateTime terminationDate;
}