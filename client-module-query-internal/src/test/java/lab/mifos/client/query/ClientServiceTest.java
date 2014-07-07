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
package lab.mifos.client.query;

import lab.mifos.client.query.api.service.ClientService;
import lab.mifos.client.query.api.domain.Client;
import lab.mifos.client.query.internal.repository.ClientRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/etc/spring/client-query-context.xml")
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceTest() {
        super();
    }

    @Test
    public void shouldCreateClient() {
        final Client client = this.createClient("Jane", "Doe");

        this.clientService.createClient(client);

        Assert.assertNotNull(this.clientRepository.findByUniqueId(client.getUniqueId()));
    }

    @Test
    public void shouldApproveClient() {
        final Client client = this.createClient("Jane", "Doe");

        this.clientService.createClient(client);

        this.clientService.approveClient(client.getUniqueId(), Boolean.TRUE, "Approved");

        final Client foundClient = this.clientRepository.findByUniqueId(client.getUniqueId());

        Assert.assertNotNull(foundClient);
        Assert.assertTrue(foundClient.getApproved());
    }

    @Test
    public void shouldFindAll() {
        final Client client = this.createClient("Jane", "Doe");

        this.clientService.createClient(client);

        final List<Client> clients = clientService.fetchAll();

        Assert.assertNotNull(clients);
        Assert.assertTrue(clients.size() >= 1);
    }

    private final Client createClient(final String firstName, final String lastName) {
        final Client client = new Client();
        client.setUniqueId(UUID.randomUUID().toString());
        client.setFirstName(firstName);
        client.setLastName(lastName);

        return client;
    }
}
