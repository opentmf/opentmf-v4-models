package org.opentmf.tmf654.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class TransferBalanceCreateEventPayload implements ITransferBalanceCreateEventPayload {

  /**
   * The TransferBalance resource is a detailed description of credit transfer
   * operation requested between two buckets (reference to products owned by
   * customers and consuming credit when using a service).
   */
  private @Valid TransferBalance transferBalance;
}