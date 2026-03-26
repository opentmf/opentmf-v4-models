package org.opentmf.tmf725.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PromotionUpdateBase;

/**
 * An MetadataCatalogItem is an entity that allows any metadata asset or even
 * any object inheriting from RootEntity, to be available to a catalog. The
 * MetadataSpecification and Policy of the catalog governs the content of the
 * MetadataCatalogItem. This API addresses only MetadataSpecification items
 * extended from RootEntity as MetadataCatalogItem.
 * <br/>The MetadataCatalogItem resource (JSON format) represents a set of
 * characteristics that define the values given by the MetadataCatalogItem.
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
public class MetadataCatalogItemUpdate extends PromotionUpdateBase implements IMetadataCatalogItemUpdate {

  /**
   * List of: Reference to Metadata Category object. The metadata category
   * resource is used to group entity catalog items in logical containers.
   * Categories can contain other categories.
   * <br/>Resource IDs for categories are strings and are defined by the catalog
   * application.
   */
  @JsonProperty("category")
  private List<@Valid MetadataCategoryRef> categories;

  /**
   * reference to an MetadataSpecification object.
   */
  private @Valid MetadataSpecificationRef specification;
}