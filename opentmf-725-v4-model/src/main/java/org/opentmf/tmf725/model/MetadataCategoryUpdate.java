package org.opentmf.tmf725.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PromotionUpdateBase;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.general.model.EntityCategoryRef;

/**
 * The category resource is used to group metadata catalog items in logical
 * containers. Categories can contain other categories.
 * <br/>Resource IDs for categories are strings and are defined by the catalog
 * application.
 * <br/>Skipped properties: id,href,lastUpdate,{@literal @}baseType,{@literal @}schemaLocation,{@literal @}type.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-725: Metadata Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class MetadataCategoryUpdate extends PromotionUpdateBase implements IMetadataCategoryUpdate {

  /**
   * The metadata catalog items referred to by this category.
   */
  @JsonProperty("MetadataCatalogItem")
  private List<@Valid MetadataCatalogItemRef> metadataCatalogItems;

  /**
   * The child category(ies) if any, contained in this category.
   */
  @JsonProperty("childCategory")
  private List<@Valid EntityCategoryRef> childCategories;

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
}