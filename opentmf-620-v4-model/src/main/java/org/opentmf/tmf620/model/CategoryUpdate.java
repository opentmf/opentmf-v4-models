package org.opentmf.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.CategoryRef;
import org.opentmf.common.model.IntentUpdateBase;
import org.opentmf.common.model.ProductOfferingRef;
import org.opentmf.commons.validation.constraints.SafeId;

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
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CategoryUpdate extends IntentUpdateBase implements ICategoryUpdate {

  /**
   * A URI to a JSON-Schema file that defines additional attributes and
   * relationships.
   */
  @JsonProperty("@schemaLocation")
  private URI atSchemaLocation;

  /**
   * If true, this Boolean indicates that the category is a root of categories.
   */
  private Boolean isRoot;

  /**
   * Unique identifier of the parent category.
   */
  @SafeId
  @Size(max = 100)
  private String parentId;

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
}