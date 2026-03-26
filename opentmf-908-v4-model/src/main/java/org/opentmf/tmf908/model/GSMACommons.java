package org.opentmf.tmf908.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-908: IoT Agent and Device Management API</li>
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
    defaultImpl = GSMACommons.class
)
public class GSMACommons extends Extensible implements IGSMACommons {

  private @SafeText String alternateName;

  private @SafeText String dataProvider;

  private OffsetDateTime dateCreated;

  private OffsetDateTime dateModified;

  private @SafeText String description;

  private @SafeText String name;

  private @SafeText String source;
}