package org.opentmf.tmf674.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-674: Geographic Site Management API</li>
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
    defaultImpl = GeographicSite.class
)
@JsonTypeName("GeographicSite")
public class GeographicSite extends GeographicSiteUpdate implements IGeographicSite {

  /**
   * Unique reference of the place.
   */
  private URI href;

  /**
   * Unique identifier of the place.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}