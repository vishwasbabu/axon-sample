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
package lab.mifos.client.api.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CreateClientCommand {

    @TargetAggregateIdentifier
    private final String uniqueId;
    private final String firstName;
    private final String lastName;

    public CreateClientCommand(final String uniqueId, final String firstName, final String lastName) {
        super();
        this.uniqueId = uniqueId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
