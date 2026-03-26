package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Is a event channel provided by the Event Streaming API.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-688: Event Management API</li>
 *   <li>TMF-915: AI Management API</li>
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
    defaultImpl = Topic.class
)
public class Topic extends NamedEntity implements ITopic {

  /**
   * is the filter that will be applied on the content of the Event.
   */
  private @SafeText String contentQuery;

  /**
   * is the filter that will be applied on the Event header properties.
   */
  private @SafeText String headerQuery;
}