package org.opentmf.tmf662.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityCatalogUpdateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.general.model.EntityCategoryRef;

/**
 * The root entity for entity catalog management. An entity catalog can be
 * defined as a collection of entity catalog items and arranging them in a
 * particular manner based on the need.
 * <br/>In comparison to Product, Service and Resource catalogs, the entity
 * catalog is intended for the purpose of providing any SID entity to consumers
 * via a catalog, with its specification and policy providing governance over
 * its content. Even Entity catalog may have an overlap with Product, Service or
 * Resource catalog, it does not replace them. It is primarily intended to
 * address those SID entities which may not be addressed by any of Product,
 * Service or Resource catalog.
 * <br/>An entity catalog comprises of a list of RootEntities made available
 * through EntityCatalogItems. This API addresses only RootEntity extended items
 * as EntitySpecification. An entity catalog typically includes name,
 * description and time period that it is valid for.
 * <br/>Skipped properties: id,href,lastUpdate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-662: Entity Catalog Management API</li>
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
    defaultImpl = EntityCatalogUpdate.class
)
public class EntityCatalogUpdate extends EntityCatalogUpdateBase implements IEntityCatalogUpdate {

  /**
   * The categories used in this catalog.
   */
  @JsonProperty("category")
  private List<@Valid EntityCategoryRef> categories;

  /**
   * The parties who are involved or have an interest in this catalog.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}