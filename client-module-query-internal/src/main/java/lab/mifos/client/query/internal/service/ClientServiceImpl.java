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
package lab.mifos.client.query.internal.service;

import lab.mifos.client.api.command.ApproveClientCommand;
import lab.mifos.client.api.command.CreateClientCommand;
import lab.mifos.client.query.api.domain.Client;
import lab.mifos.client.query.api.service.ClientService;
import lab.mifos.client.query.internal.repository.ClientRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final CommandGateway commandGateway;

    private final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(final CommandGateway commandGateway, final ClientRepository repository) {
        super();
        this.commandGateway = commandGateway;
        this.repository = repository;
    }

    @Override
    public String createClient(final Client client) {
        commandGateway.send(new CreateClientCommand(client.getUniqueId(), client.getFirstName(), client.getLastName()));
        return client.getUniqueId();
    }

    @Override
    public void approveClient(final String clientId, final Boolean approved, final String comment) {
        commandGateway.send(new ApproveClientCommand(clientId, approved, comment));
    }

    @Override
    public List<Client> fetchAll() {
        return repository.findAll();
    }
}
