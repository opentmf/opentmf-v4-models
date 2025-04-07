package org.opentmf.v4.common.model;

import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The base event that has addressable fields.
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
public class AddressableEventBase extends EventBase {

  /**
   * Identifier of the Process flow.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Reference to the ProcessFlow.
   */
  private URI href;
}