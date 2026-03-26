package org.opentmf.tmf662.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;

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
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
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
    defaultImpl = EntityCatalogCreate.class
)
@Required(fields = {"name"})
public class EntityCatalogCreate extends EntityCatalogUpdate implements IEntityCatalogCreate {

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;
}