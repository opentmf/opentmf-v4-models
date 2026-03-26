package org.opentmf.tmf674.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class GeographicSiteDeleteEventPayload implements IGeographicSiteDeleteEventPayload {

  private @Valid GeographicSite geographicSite;
}