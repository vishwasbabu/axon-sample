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
package lab.mifos.client.command;

import lab.mifos.client.api.command.ApproveClientCommand;
import lab.mifos.client.api.command.CreateClientCommand;
import lab.mifos.client.api.event.ClientApprovedEvent;
import lab.mifos.client.api.event.ClientCreatedEvent;
import lab.mifos.client.command.internal.aggregate.ClientAggregate;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {

    private FixtureConfiguration fixtureConfiguration;

    public ClientTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        this.fixtureConfiguration = Fixtures.newGivenWhenThenFixture(ClientAggregate.class);
    }

    @Test
    public void shouldCreateClient() {
        final String id = "08154711";
        fixtureConfiguration.given()
                .when(new CreateClientCommand(id, "John", "Doe"))
                .expectEvents(new ClientCreatedEvent(id, "John", "Doe"));
    }

    @Test
    public void shouldApproveClient() {
        final String id = "08154711";
        fixtureConfiguration.given(new ClientCreatedEvent(id, "John", "Doe"))
                .when(new ApproveClientCommand(id, Boolean.TRUE, "Approved"))
                .expectEvents(new ClientApprovedEvent(id, Boolean.TRUE, "Approved"));
    }
}
