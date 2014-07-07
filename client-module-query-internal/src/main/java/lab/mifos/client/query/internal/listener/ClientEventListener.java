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
package lab.mifos.client.query.internal.listener;

import lab.mifos.client.api.event.ClientApprovedEvent;
import lab.mifos.client.api.event.ClientCreatedEvent;
import lab.mifos.client.query.api.domain.Client;
import lab.mifos.client.query.internal.repository.ClientRepository;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ClientEventListener {

    @Resource
    private ClientRepository repository;

    public ClientEventListener() {
        super();
    }

    @EventHandler
    public void on(final ClientCreatedEvent event) {
        final Client client = new Client();
        client.setUniqueId(event.getUniqueId());
        client.setFirstName(event.getFirstName());
        client.setLastName(event.getLastName());

        repository.save(client);
    }

    @EventHandler
    public void on(final ClientApprovedEvent event) {
        final Client client = repository.findByUniqueId(event.getUniqueId());

        client.setApproved(event.getApproved());
        client.setApprovalComment(event.getComment());

        repository.save(client);
    }
}
