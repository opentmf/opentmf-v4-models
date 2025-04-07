package org.opentmf.v4.service.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Service is a base class for defining the Service hierarchy. All Services are
 * characterized as either being possibly visible and usable by a Customer or
 * not. This gives rise to the two subclasses of Service: CustomerFacingService
 * and ResourceFacingService.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = Service.class
)
public class Service extends ServiceCreate {

  /**
   * Unique identifier of the service.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Reference of the service.
   */
  private URI href;
}