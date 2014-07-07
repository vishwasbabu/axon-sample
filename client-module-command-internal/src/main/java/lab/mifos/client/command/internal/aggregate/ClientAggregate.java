/**
 * Copyright 2014 Markus Geiss
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package lab.mifos.client.command.internal.aggregate;

import lab.mifos.client.api.command.ApproveClientCommand;
import lab.mifos.client.api.command.CreateClientCommand;
import lab.mifos.client.api.event.ClientApprovedEvent;
import lab.mifos.client.api.event.ClientCreatedEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.springframework.stereotype.Service;

@Service
public class ClientAggregate extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String uniqueId;

    ClientAggregate() {
        super();
    }

    @CommandHandler
    public ClientAggregate(final CreateClientCommand command) {
        apply(new ClientCreatedEvent(command.getUniqueId(), command.getFirstName(), command.getLastName()));
    }

    @CommandHandler
    public void handle(final ApproveClientCommand command) {
        apply(new ClientApprovedEvent(command.getUniqueId(), command.getApproved(), command.getComment()));
    }

    @EventHandler
    public void on(final ClientCreatedEvent event) {
        uniqueId = event.getUniqueId();
    }
}
