package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.CategoryRef;
import org.opentmf.v4.common.model.ProductOfferingRef;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * The category resource is used to group product offerings, service and
 * resource candidates in logical containers. Categories can contain other
 * categories and/or product offerings, resource or service candidates.
 * <br/>Skipped properties: id,href,lastUpdate,{@literal @}type,{@literal @}baseType.
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
public class CategoryUpdate {

  /**
   * Description of the category.
   */
  private @SafeText String description;

  /**
   * If true, this Boolean indicates that the category is a root of categories.
   */
  private Boolean isRoot;

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the category.
   */
  private @SafeText String name;

  /**
   * Unique identifier of the parent category.
   */
  @SafeId
  @Size(max = 100)
  private String parentId;

  /**
   * Category version.
   */
  private @SafeText String version;

  /**
   * A product offering represents entities that are orderable from the provider
   * of the catalog, this resource includes pricing information.
   */
  @JsonProperty("productOffering")
  private List<@Valid ProductOfferingRef> productOfferings;

  /**
   * The category resource is used to group product offerings, service and
   * resource candidates in logical containers. Categories can contain other
   * (sub-)categories and/or product offerings.
   */
  @JsonProperty("subCategory")
  private List<@Valid CategoryRef> subCategories;

  /**
   * The period for which the category is valid.
   */
  private @Valid TimePeriod validFor;

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;
}