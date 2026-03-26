package org.opentmf.general.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Is a event channel provided by the Event Streaming API
 * <br/>Skipped properties: id,href.
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
    defaultImpl = TopicCreate.class
)
public class TopicCreate extends Extensible implements ITopicCreate {

  /**
   * is the filter that will be applied on the content of the Event.
   */
  private @SafeText String contentQuery;

  /**
   * is the filter that will be applied on the Event header properties.
   */
  private @SafeText String headerQuery;

  /**
   * use to identify grouping of events, per domain, per event types, per access
   * control-right and so on.
   */
  private @SafeText String name;
}