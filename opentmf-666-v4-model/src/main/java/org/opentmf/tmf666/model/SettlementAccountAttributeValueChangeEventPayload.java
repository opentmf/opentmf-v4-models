package org.opentmf.tmf666.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class SettlementAccountAttributeValueChangeEventPayload implements ISettlementAccountAttributeValueChangeEventPayload {

  /**
   * A party account used for settlement purposes. It includes a description of
   * the bill structure (frequency, presentation media, format and so on). It is a
   * specialization of entity PartyAccount.
   */
  private @Valid SettlementAccount settlementAccount;
}